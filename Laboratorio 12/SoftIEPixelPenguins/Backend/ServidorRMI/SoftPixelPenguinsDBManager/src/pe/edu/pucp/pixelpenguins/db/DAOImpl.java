package pe.edu.pucp.pixelpenguins.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import java.time.LocalTime;
import java.sql.Time;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected CallableStatement statement;
    protected ResultSet resultSet;
    protected Boolean mostrarSentenciaSQL;
    protected Boolean retornarLlavePrimaria;
    protected Boolean usarTransaccion;
    protected Boolean usarPredicadoParaListado;
    protected Tipo_Operacion tipo_Operacion;

    public DAOImpl(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
        this.mostrarSentenciaSQL = true;
        this.retornarLlavePrimaria = false;
        this.usarPredicadoParaListado = false;
        this.usarTransaccion = true;
        this.tipo_Operacion = null;
    }

    protected void iniciarTransaccion() throws SQLException {
        this.abrirConexion();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected void abrirConexion() {
        this.conexion = DBManager.getInstance().getConnection();
    }

    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
            this.conexion = null;
        }
    }

    protected void colocarSQLenStatement(String sql) throws SQLException {
        if (this.mostrarSentenciaSQL) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.INFO, sql);
        }
        this.statement = this.conexion.prepareCall(sql);
    }

    protected Integer ejecutarModificacionEnBD(String sql) throws SQLException {
        return this.statement.executeUpdate();
    }

    protected void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.resultSet = this.statement.executeQuery();
    }

    private Integer ejecuta_DML(Tipo_Operacion tipo_Operacion) {
        Integer resultado = 0;
        this.tipo_Operacion = tipo_Operacion;
        try {
            if (this.usarTransaccion) {
                this.iniciarTransaccion();
            }
            String sql = null;
            switch (tipo_Operacion) {
                case Tipo_Operacion.INSERTAR ->
                    sql = this.generarSQLParaInsercion();
                case Tipo_Operacion.MODIFICAR ->
                    sql = this.generarSQLParaModificacion();
                case Tipo_Operacion.ELIMINAR ->
                    sql = this.generarSQLParaEliminacion();
            }
            this.colocarSQLenStatement(sql);
            switch (tipo_Operacion) {
                case Tipo_Operacion.INSERTAR ->
                    this.incluirValorDeParametrosParaInsercion();
                case Tipo_Operacion.MODIFICAR ->
                    this.incluirValorDeParametrosParaModificacion();
                case Tipo_Operacion.ELIMINAR ->
                    this.incluirValorDeParametrosParaEliminacion();
            }
            resultado = this.ejecutarModificacionEnBD(sql);
            if (this.retornarLlavePrimaria) {
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            if (this.usarTransaccion) {
                this.comitarTransaccion();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar ejecutar el comando SQL - " + ex);
            if (this.usarTransaccion) {
                try {
                    this.rollbackTransaccion();
                } catch (SQLException ex1) {
                    System.err.println("Error al intentar hacer rollback - " + ex);
                }
            }
        } finally {
            try {
                if (this.usarTransaccion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }

        }
        this.tipo_Operacion = null;
        return resultado;
    }

    protected Integer insertar() {
        return this.ejecuta_DML(Tipo_Operacion.INSERTAR);
    }

    protected String generarSQLParaInsercion() {
        String sql = "insert into ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaDeAtributosParaInsercion());
        sql = sql.concat(") values (");
        sql = sql.concat(this.incluirListaDeParametrosParaInsercion());
        sql = sql.concat(")");
        return sql;
    }

    protected abstract String obtenerListaDeAtributosParaInsercion();

    protected abstract String incluirListaDeParametrosParaInsercion();

    protected abstract void incluirValorDeParametrosParaInsercion() throws SQLException;

    protected Integer modificar() {
        return this.ejecuta_DML(Tipo_Operacion.MODIFICAR);
    }

    protected String generarSQLParaModificacion() {
        String sql = "update ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" set ");
        sql = sql.concat(this.obtenerListaDeValoresYAtributosParaModificacion());
        sql = sql.concat(" ");
        sql = sql.concat("where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract String obtenerListaDeValoresYAtributosParaModificacion();

    protected abstract String obtenerPredicadoParaLlavePrimaria();

    protected abstract void incluirValorDeParametrosParaModificacion() throws SQLException;

    protected Integer eliminar() {
        return this.ejecuta_DML(Tipo_Operacion.ELIMINAR);
    }

    private String generarSQLParaEliminacion() {
        String sql = "delete from ".concat(this.nombre_tabla);
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract void incluirValorDeParametrosParaEliminacion() throws SQLException;

    public List listarTodos(Integer limite) {
        List lista = new ArrayList<>();
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarTodos(limite);
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirValorDeParametrosParaListado();
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(lista, this.resultSet);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return lista;
    }

    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla);
        if(this.usarPredicadoParaListado)
            sql = sql.concat(this.obtenerPredicadoParaListado());
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    protected abstract String obtenerProyeccionParaSelect();

    protected String obtenerPredicadoParaListado() {
        return "";
    }

    protected void incluirValorDeParametrosParaListado() throws SQLException {
    }

    protected abstract void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException;

    public void obtenerPorId() {
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarPorId();
            this.colocarSQLenStatement(sql);
            this.incluirValorDeParametrosParaObtenerPorId();
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
            } else {
                limpiarObjetoDelResultSet();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
    }

    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla);
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract void incluirValorDeParametrosParaObtenerPorId() throws SQLException;

    protected abstract void instanciarObjetoDelResultSet() throws SQLException;

    protected abstract void limpiarObjetoDelResultSet();

    public Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "select @@last_insert_id as id";
            this.colocarSQLenStatement(sql);
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar retornarUltimoAutoGenerado - " + ex);
        }
        return resultado;
    }

    protected void incluirParametroString(Integer numeroParametro, String valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.VARCHAR);
        } else {
            this.statement.setString(numeroParametro, valor);
        }
    }

    protected void incluirParametroInt(Integer numeroParametro, Integer valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.INTEGER);
        } else {
            this.statement.setInt(numeroParametro, valor);
        }
    }
    
    protected void incluirParametroDouble(Integer numeroParametro, Double valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.DOUBLE);
        } else {
            this.statement.setDouble(numeroParametro, valor);
        }
    }
    
    protected void incluirParametroTime(Integer numeroParametro, LocalTime valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.TIME);
        } else {
            this.statement.setTime(numeroParametro, Time.valueOf(valor));
        }
    }

    protected void incluirParametroDate(Integer numeroParametro, Date valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.DATE);
        } else {
            java.sql.Date sqlDate = new java.sql.Date(valor.getTime());
            this.statement.setDate(numeroParametro, sqlDate);
        }
    }

    protected void incluirParametroBoolean(Integer numeroParametro, Boolean valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.BOOLEAN);
        } else {
            this.statement.setBoolean(numeroParametro, valor);
        }
    }

    protected void incluirParametroString(String nombreParametro, String valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.VARCHAR);
        } else {
            this.statement.setString(nombreParametro, valor);
        }
    }
    
    protected void incluirParametroBytes(Integer numeroParametro, byte[] valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.BLOB);
        } else {
            this.statement.setBytes(numeroParametro, valor);
        }
    }

    protected void incluirParametroInt(String nombreParametro, Integer valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.DATE);
        } else {
            this.statement.setInt(nombreParametro, valor);
        }
    }

    protected void incluirParametroDate(String nombreParametro, Date valor) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(valor.getTime());
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.DATE);
        } else {
            this.statement.setDate(nombreParametro, sqlDate);
        }
    }

    protected void incluirParametroBoolean(String nombreParametro, Boolean valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.BOOLEAN);
        } else {
            this.statement.setBoolean(nombreParametro, valor);
        }
    }
}
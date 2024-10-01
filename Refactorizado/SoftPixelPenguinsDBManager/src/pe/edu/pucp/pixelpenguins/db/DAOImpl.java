
    package pe.edu.pucp.pixelpenguins.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected PreparedStatement statement;
    protected ResultSet resultSet; 
    protected Boolean retornarLlavePrimaria;

    public DAOImpl(String nombre_tabla){
        this.nombre_tabla = nombre_tabla;
        this.retornarLlavePrimaria = true;
    }

    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
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

    protected Integer ejecutarModificacionesEnBD(String sql) throws SQLException {
        this.statement = this.conexion.prepareStatement(sql);
        return this.statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
    }

    private void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.statement = this.conexion.prepareStatement(sql);
        this.resultSet = this.statement.executeQuery();
    }

    public Integer insertar() {
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaInsercion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            if (this.retornarLlavePrimaria){
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public Integer modificar(){
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaModificacion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            if (this.retornarLlavePrimaria){
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public Integer eliminar(){
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaEliminacion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            if (this.retornarLlavePrimaria){
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    public Object obtenerPorId(int id){
        Object entidad = null;
        try {
            this.iniciarTransaccion();  // Iniciar la transacción
            String sql = this.generarSQLParaListarUno(id);  // Generar el SQL para seleccionar un registro por id
            this.ejecutarConsultaEnBD(sql);  // Ejecutar la consulta

            if (this.resultSet.next()) {
                entidad = this.mapearEntidadDesdeResultSet(this.resultSet);  // Mapear el resultado a un objeto
            }

            this.comitarTransaccion();  // Confirmar la transacción
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();  // Hacer rollback en caso de error
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();  // Cerrar la conexión
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return entidad;         
    }
    
    private String generarSQLParaListarUno(int id) {
        String sql = "SELECT " + obtenerListaAtributosParaInsertar() + " FROM ";
        sql = sql.concat(this.nombre_tabla);  // Asignar el nombre de la tabla
        sql = sql.concat(" WHERE " + obtenerNombrePrimaryKey() + "  = ");  // Agregar la condición para filtrar por id
        sql = sql.concat(String.valueOf(id));
        return sql;
    }
    
    
    private String generarSQLParaInsercion() {
        String sql = "insert into ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaAtributosParaInsertar());
        sql = sql.concat(" ) values (");
        sql = sql.concat(this.obtenerListaValoresParaInsertar());
        sql = sql.concat(")");      
        return sql;
    }
    
    private String generarSQLParaModificacion() {
        String sql = "update ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" set ");
        sql = sql.concat(this.obtenerListaAtributosYValoresParaModificar()); 
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerIdentificador());
        return sql;
    }
    
    private String generarSQLParaEliminacion() {
        String sql = "delete from ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerIdentificador());
        return sql;
    }
    
    protected abstract String obtenerListaAtributosParaInsertar();

    protected abstract String obtenerListaValoresParaInsertar();
    
    protected abstract String obtenerListaAtributosYValoresParaModificar();

    protected abstract String obtenerIdentificador();
        // copiar los datos en la entidad
    protected abstract Object mapearEntidadDesdeResultSet(ResultSet resultSet);
    
    protected abstract String obtenerNombrePrimaryKey();
    protected Integer retornarUltimoAutoGenerado() throws SQLException {
        Integer resultado = null;
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            resultado = generatedKeys.getInt(1);
        }
        return resultado;
    }
    
}

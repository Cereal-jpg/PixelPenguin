package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.ProfesorDAO;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;
import pe.edu.pucp.softpub.config.Tipo_Operacion;


public class ProfesorDAOImpl extends DAOImpl implements ProfesorDAO {
    
    private Profesor profesor;

    public ProfesorDAOImpl() {
        super("Profesor");
        this.profesor = null;
    }

    @Override
    public Integer insertar(Profesor profesor) {
        this.profesor = profesor;
        Integer idUsuario = null;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        usuario.setDni(profesor.getDni());
        usuario.setNombreCompleto(profesor.getNombreCompleto());
        usuario.setFechaNacimiento(profesor.getFechaNacimiento());
        usuario.setDireccion(profesor.getDireccion());
        usuario.setEmail(profesor.getEmail());
        usuario.setSexo(profesor.getSexo());
        usuario.setUsername(profesor.getUsername());
        usuario.setPassword(profesor.getPassword());
        usuario.setRol(profesor.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeProfesor = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idUsuario = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                profesor.setIdUsuario(idUsuario);
            } else {
                idUsuario = usuario.getIdUsuario();
                profesor.setIdUsuario(idUsuario);
                existeProfesor = this.existeProfesor(profesor, false);
            }
            if (!existeProfesor) {
                super.insertar();
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idUsuario;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idUsuario, codigoProfesor, certificadoHistorialEducativo, especialidad";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, profesor.getIdUsuario());
        this.incluirParametroInt(2, profesor.getCodigoProfesor());
        this.incluirParametroBoolean(3, profesor.isCertificadoHistorialEducativo());
        this.incluirParametroString(4, profesor.getEspecialidad());
    }

    @Override
    public Integer modificar(Profesor profesor) {
        this.profesor = profesor;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        usuario.setIdUsuario(profesor.getIdUsuario());
        usuario.setDni(profesor.getDni());
        usuario.setNombreCompleto(profesor.getNombreCompleto());
        usuario.setFechaNacimiento(profesor.getFechaNacimiento());
        usuario.setDireccion(profesor.getDireccion());
        usuario.setEmail(profesor.getEmail());
        usuario.setSexo(profesor.getSexo());
        usuario.setUsername(profesor.getUsername());
        usuario.setPassword(profesor.getPassword());
        usuario.setRol(profesor.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            usuarioDAO.modificar(usuario, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al modificar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "codigoProfesor=?, certificadoHistorialEducativo=?, especialidad=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, profesor.getCodigoProfesor());
        this.incluirParametroBoolean(2, profesor.isCertificadoHistorialEducativo());
        this.incluirParametroString(3, profesor.getEspecialidad());
        this.incluirParametroInt(4, profesor.getIdUsuario());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "idUsuario=?";
        } else {
            sql = "usu.idUsuario=?";
        }
        return sql;
    }

    @Override
    public Integer eliminar(Profesor profesor) {
        this.profesor = profesor;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        usuario.setIdUsuario(this.profesor.getIdUsuario());
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            usuarioDAO.eliminar(usuario,this.usarTransaccion,this.conexion);
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.profesor.getIdUsuario());
    }

    @Override
    public ArrayList<Profesor> listarTodos() {
        return (ArrayList<Profesor>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pro ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = pro.idProfesor ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "usu.idUsuario, usu.dni, usu.nombreCompleto, usu.fechaNacimiento,"
                + " usu.direccion, usu.email, usu.sexo, usu.username, usu.passsword, usu.fid_rol";
        sql = sql.concat(", pro.idProfesor, pro.codigoProfesor, pro.certificadoHistorialEducativo, pro.especialidad");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.profesor);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.profesor = new Profesor();
        this.profesor.setIdUsuario(resultSet.getInt("idUsuario"));
        this.profesor.setDni(resultSet.getString("dni"));
        this.profesor.setNombreCompleto(resultSet.getString("nombreCompleto"));
        this.profesor.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        this.profesor.setDireccion(resultSet.getString("direccion"));
        this.profesor.setEmail(resultSet.getString("email"));
        this.profesor.setSexo(resultSet.getString("sexo"));
        this.profesor.setUsername(resultSet.getString("username"));
        this.profesor.setPassword(resultSet.getString("passsword"));
        this.profesor.setRol(new Rol(resultSet.getInt("fid_rol")));
        this.profesor.setCodigoProfesor(this.resultSet.getInt("codigoProfesor"));
        this.profesor.setCertificadoHistorialEducativo(this.resultSet.getBoolean("certificadoHistorialEducativo"));
        this.profesor.setEspecialidad(this.resultSet.getString("especialidad"));
    }

    @Override
    public Profesor obtenerPorId(Integer idUsuario) {
        this.profesor = new Profesor();
        this.profesor.setIdUsuario(idUsuario);
        super.obtenerPorId();
        return this.profesor;
    }
    
    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pro ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = pro.idUsuario ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.profesor.getIdUsuario());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.profesor = null;
    }
    
    @Override
    public Boolean existeProfesor(Profesor profesor) {
        Boolean abreConexion = true;
        return existeProfesor(profesor, abreConexion);
    }
    
    @Override
    public Boolean existeProfesor(Profesor profesor, Boolean abreConexion) {
        this.profesor = profesor;
        Integer idUsuario = null;

        try {
            if (abreConexion) this.abrirConexion();
            String sql = "select idUsuario from Profesor where idUsuario=?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, profesor.getIdUsuario());
            this.ejecutarConsultaEnBD(sql);

            if (this.resultSet.next()) {
                idUsuario = this.resultSet.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar existencia de profesor - " + ex);
        } finally {
            try {
                if (abreConexion) this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar conexión - " + ex);
            }
        }
        return idUsuario != null;
    }
    
}

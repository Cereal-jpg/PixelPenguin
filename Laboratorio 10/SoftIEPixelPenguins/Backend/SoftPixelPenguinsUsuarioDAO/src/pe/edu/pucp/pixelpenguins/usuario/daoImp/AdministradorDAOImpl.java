package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.AdministradorDAO;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;
import pe.edu.pucp.softpub.config.Tipo_Operacion;

public class AdministradorDAOImpl extends DAOImpl implements AdministradorDAO {
    
     private Administrador administrador;

    public AdministradorDAOImpl() {
        super("Administrador");
        this.administrador = null;
    }

    @Override
    public Integer insertar(Administrador administrador) {
        this.administrador = administrador;
        Integer idUsuario = null;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        usuario.setDni(administrador.getDni());
        usuario.setNombreCompleto(administrador.getNombreCompleto());
        usuario.setFechaNacimiento(administrador.getFechaNacimiento());
        usuario.setDireccion(administrador.getDireccion());
        usuario.setEmail(administrador.getEmail());
        usuario.setSexo(administrador.getSexo());
        usuario.setUsername(administrador.getUsername());
        usuario.setPassword(administrador.getPassword());
        usuario.setRol(administrador.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeAdministrador = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idUsuario = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                administrador.setIdUsuario(idUsuario);
            } else {
                idUsuario = usuario.getIdUsuario();
                administrador.setIdUsuario(idUsuario);
                existeAdministrador = this.existeAdministrador(administrador, false);
            }
            if (!existeAdministrador) {
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
        return "idUsuario, codigoAdministrador";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, administrador.getIdUsuario());
        this.incluirParametroInt(2, administrador.getCodigoAdministrador());
    }

    @Override
    public Integer modificar(Administrador administrador) {
        this.administrador = administrador;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        usuario.setIdUsuario(administrador.getIdUsuario());
        usuario.setDni(administrador.getDni());
        usuario.setNombreCompleto(administrador.getNombreCompleto());
        usuario.setFechaNacimiento(administrador.getFechaNacimiento());
        usuario.setDireccion(administrador.getDireccion());
        usuario.setEmail(administrador.getEmail());
        usuario.setSexo(administrador.getSexo());
        usuario.setUsername(administrador.getUsername());
        usuario.setPassword(administrador.getPassword());
        usuario.setRol(administrador.getRol());

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
        return "codigoAdministrador=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, administrador.getCodigoAdministrador());
        this.incluirParametroInt(2, administrador.getIdUsuario());
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
    public Integer eliminar(Administrador administrador) {
        this.administrador = administrador;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        usuario.setIdUsuario(this.administrador.getIdUsuario());
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            usuarioDAO.eliminar(usuario, this.usarTransaccion, this.conexion);
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
        this.incluirParametroInt(1, this.administrador.getIdUsuario());
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        return (ArrayList<Administrador>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" a ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = a.idUsuario ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "usu.idUsuario, usu.dni, usu.nombreCompleto, usu.fechaNacimiento,"
                + " usu.direccion, usu.email, usu.sexo, usu.username, usu.password, usu.fid_rol";
        sql = sql.concat(", a.codigoAdministrador");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.administrador);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.administrador = new Administrador();
        this.administrador.setIdUsuario(resultSet.getInt("idUsuario"));
        this.administrador.setDni(resultSet.getString("dni"));
        this.administrador.setNombreCompleto(resultSet.getString("nombreCompleto"));
        this.administrador.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        this.administrador.setDireccion(resultSet.getString("direccion"));
        this.administrador.setEmail(resultSet.getString("email"));
        this.administrador.setSexo(resultSet.getString("sexo"));
        this.administrador.setUsername(resultSet.getString("username"));
        this.administrador.setPassword(resultSet.getString("password"));
        this.administrador.setRol(new Rol(resultSet.getInt("fid_rol")));
        this.administrador.setCodigoAdministrador(resultSet.getInt("codigoAdministrador"));
    }
    
    @Override
    public Administrador obtenerPorId(Integer idUsuario) {
        this.administrador = new Administrador();
        this.administrador.setIdUsuario(idUsuario);
        super.obtenerPorId();
        return this.administrador;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" a ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = a.idUsuario ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.administrador.getIdUsuario());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.administrador = null;
    }
    
    @Override
    public Boolean existeAdministrador(Administrador administrador) {
        Boolean abreConexion = true;
        return existeAdministrador(administrador, abreConexion);
    }
    
    @Override
    public Boolean existeAdministrador(Administrador administrador, Boolean abreConexion) {
        this.administrador = administrador;
        Integer idUsuario = null;

        try {
            if (abreConexion) this.abrirConexion();
            String sql = "select idUsuario from Administrador where idUsuario=?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, administrador.getIdUsuario());
            this.ejecutarConsultaEnBD(sql);

            if (this.resultSet.next()) {
                idUsuario = this.resultSet.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar existencia de administrador - " + ex);
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

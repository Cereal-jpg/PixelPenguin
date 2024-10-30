package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;


public class UsuarioDAOImpl extends DAOImpl implements UsuarioDAO {
    
    private Usuario usuario;
    
    public UsuarioDAOImpl() {
        super("Usuario");
        this.usuario = null;
    }

    @Override
    public Integer insertar(Usuario usuario) {
        this.usuario = usuario;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(usuario);
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, fid_rol";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, usuario.getDni());
        this.incluirParametroString(2, usuario.getNombreCompleto());
        this.incluirParametroDate(3, usuario.getFechaNacimiento());
        this.incluirParametroString(4, usuario.getDireccion());
        this.incluirParametroString(5, usuario.getEmail());
        this.incluirParametroString(6, usuario.getSexo());
        this.incluirParametroString(7, usuario.getUsername());
        this.incluirParametroString(8, usuario.getPassword());
        this.incluirParametroInt(9, usuario.getRol().getIdRol());
    }

    @Override
    public Integer modificar(Usuario usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public Integer modificar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(usuario);
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "dni=?, nombreCompleto=?, fechaNacimiento=?, direccion=?, email=?, sexo=?, username=?, password=?, fid_rol=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idUsuario=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, usuario.getDni());
        this.incluirParametroString(2, usuario.getNombreCompleto());
        this.incluirParametroDate(3, usuario.getFechaNacimiento());
        this.incluirParametroString(4, usuario.getDireccion());
        this.incluirParametroString(5, usuario.getEmail());
        this.incluirParametroString(6, usuario.getSexo());
        this.incluirParametroString(7, usuario.getUsername());
        this.incluirParametroString(8, usuario.getPassword());
        this.incluirParametroInt(9, usuario.getRol().getIdRol());
        this.incluirParametroInt(10, usuario.getIdUsuario());
    }

    @Override
    public Integer eliminar(Usuario usuario) {
        this.usuario = usuario;
        return super.eliminar();
    }
    
    @Override
    public Integer eliminar(Usuario usuario, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.eliminar(usuario);
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, usuario.getIdUsuario());
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return (ArrayList<Usuario>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, fid_rol";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usuario);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        usuario.setIdUsuario(resultSet.getInt("idUsuario"));
        usuario.setDni(resultSet.getString("dni"));
        usuario.setNombreCompleto(resultSet.getString("nombreCompleto"));
        usuario.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        usuario.setDireccion(resultSet.getString("direccion"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setSexo(resultSet.getString("sexo"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setRol(new Rol(resultSet.getInt("fid_rol")));
    }

    @Override
    public Usuario obtenerPorId(Integer idUsuario) {
        this.usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        this.usuario.setIdUsuario(idUsuario);
        super.obtenerPorId();
        return this.usuario;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, usuario.getIdUsuario());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usuario = null;
    }
    
    @Override
    public Boolean existeUsuario(Usuario usuario) {
        this.usuario = usuario;
        Integer idUsuario = null;
        try {
            this.abrirConexion();
            String sql = "select idUsuario from Usuario where ";
            sql = sql.concat("dni=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.usuario.getDni());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idUsuario = this.resultSet.getInt("idUsuario");
                this.usuario.setIdUsuario(idUsuario);
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe usuario - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idUsuario != null;
    }

    @Override
    

    public Integer ValidarDatos(String email, String contra) {
        Integer userId = null;

        try {
            this.abrirConexion();
            String sql = "SELECT idUsuario FROM Usuario WHERE email = ? AND password = ?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, email);
            this.incluirParametroString(2, contra);
            this.ejecutarConsultaEnBD(sql);

            if (this.resultSet.next()) {
                userId = this.resultSet.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe usuario - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }

        return userId;
    }


    
    
    @Override
    protected String obtenerPredicadoParaListado() {
        return " WHERE nombreCompleto LIKE CONCAT('%',?,'%')";
    }
    
    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        this.incluirParametroString(1, usuario.getNombreCompleto());
    }
    
    @Override
    public ArrayList<Usuario>listarUsuariosPorNombre(String nombre){
        this.usarPredicadoParaListado = true;
        this.usuario = new Usuario();
        usuario.setNombreCompleto(nombre);
        ArrayList<Usuario>usuarios = (ArrayList<Usuario>)super.listarTodos(null);
        this.usarPredicadoParaListado = false;
        return usuarios;
    }
    
    @Override 
    public Integer ValidarDatos(String email, String contra) {
        Integer userId = null;
        try {
            this.abrirConexion();
            String sql = "SELECT idUsuario FROM Usuario WHERE email = ? AND password = ?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, email);
            this.incluirParametroString(2, contra);
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                userId = this.resultSet.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe usuario - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return userId;
    }
    
}

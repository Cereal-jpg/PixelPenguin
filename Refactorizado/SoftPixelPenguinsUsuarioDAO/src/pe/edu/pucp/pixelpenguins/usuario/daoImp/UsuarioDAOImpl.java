package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    protected String obtenerListaDeAtributosParaInsercion() {
        return "dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, fid_rol";
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
        this.incluirParametroString(8, usuario.getPasssword());
        this.incluirParametroInt(9, usuario.getRol().getIdRol());
    }

    @Override
    public Integer modificar(Usuario usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "dni=?, nombreCompleto=?, fechaNacimiento=?, direccion=?, email=?, sexo=?, username=?, passsword=?, fid_rol=?";
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
        this.incluirParametroString(8, usuario.getPasssword());
        this.incluirParametroInt(9, usuario.getRol().getIdRol());
        this.incluirParametroInt(10, usuario.getIdUsuario());
    }

    @Override
    public Integer eliminar(Usuario usuario) {
        this.usuario = usuario;
        return super.eliminar();
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
        return "idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, fid_rol";
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
        usuario.setPasssword(resultSet.getString("passsword"));
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
    
}

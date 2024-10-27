package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public Integer insertar(String dni, String nombre, Date fechaNacimiento,
            String direccion, String email, String sexo,
            String username, String password, Rol rol) {
        Usuario usuario = new Usuario(dni, nombre, fechaNacimiento, direccion, email, sexo, username, password, rol) {};
        return this.usuarioDAO.insertar(usuario);
    }

    public Integer modificar(Integer idUsuario, String dni, String nombre, Date fechaNacimiento,
            String direccion, String email, String sexo,
            String username, String password, Rol rol) {
        Usuario usuario = new Usuario(idUsuario, dni, nombre, fechaNacimiento, direccion, email, sexo, username, password, rol) {};
        return this.usuarioDAO.modificar(usuario);
    }

    public Integer eliminar(Integer idUsuario) {
        Usuario usuario = new Usuario() {};
        usuario.setIdUsuario(idUsuario);
        return this.usuarioDAO.eliminar(usuario);
    }

    public ArrayList<Usuario> listarTodos() {
        return this.usuarioDAO.listarTodos();
    }

    public Usuario obtenerPorId(Integer idUsuario) {
        return this.usuarioDAO.obtenerPorId(idUsuario);
    }

}

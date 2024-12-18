package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }
    
    public Integer insertar(Usuario usuario) {
        return this.usuarioDAO.insertar(usuario);
    }
    
    public Integer modificar(Usuario usuario) {
        return this.usuarioDAO.modificar(usuario);
    }
    
    public Integer eliminar(Usuario usuario) {
        return this.usuarioDAO.eliminar(usuario);
    }

    public ArrayList<Usuario> listarTodos() {
        return this.usuarioDAO.listarTodos();
    }

    public Usuario obtenerPorId(Integer idUsuario) {
        return this.usuarioDAO.obtenerPorId(idUsuario);
    }

    public Boolean existeUsuario(Usuario usuario) {
        return this.usuarioDAO.existeUsuario(usuario);
    }
    
    public ArrayList<Usuario> listarUsuariosPorNombre(String nombre) {
        return this.usuarioDAO.listarUsuariosPorNombre(nombre);
    }
    
    public Integer ValidarDatos(String email,String password){
        return this.usuarioDAO.ValidarDatos(email, password);
    }
    
    public Integer ValidarCorreoElectronico(String email){
        return this.usuarioDAO.ValidarCorreoElectronico(email);
    }
    
    public Integer ActualizarContrasena(String email,String newPassword){
        return this.usuarioDAO.ActualizarContrasena(email,newPassword);
    }
    
}

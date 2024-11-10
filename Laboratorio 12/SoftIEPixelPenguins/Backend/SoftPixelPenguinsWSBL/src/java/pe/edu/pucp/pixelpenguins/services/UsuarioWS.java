package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.bo.UsuarioBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

@WebService(serviceName = "UsuarioWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class UsuarioWS {

    private UsuarioBO usuarioBO = new UsuarioBO();

    @WebMethod(operationName = "insertarUsuario")
    public Integer insertarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.insertar(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarUsuario")
    public Integer modificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.modificar(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarUsuario")
    public Integer eliminarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.eliminar(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosUsuarios")
    public ArrayList<Usuario> listarTodosUsuarios() {
        ArrayList<Usuario> usuarios = null;
        try {
            usuarios = usuarioBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    
    @WebMethod(operationName = "obtenerUsuarioPorId")
    public Usuario obtenerUsuarioPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Usuario usuario = null;
        try {
            usuario = usuarioBO.obtenerPorId(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
    
    @WebMethod(operationName = "existeUsuario")
    public Boolean existeUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Boolean resultado = null;
        try {
            resultado = usuarioBO.existeUsuario(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarUsuariosPorNombre")
    public ArrayList<Usuario> listarUsuariosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Usuario> usuarios = null;
        try {
            usuarios = usuarioBO.listarUsuariosPorNombre(nombre);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    
    @WebMethod(operationName = "ValidarDatos")
    public Integer ValidarDatos(@WebParam(name = "email")String email,@WebParam(name = "password")String password) {
        Integer id=null;
        
        try {
            id = usuarioBO.ValidarDatos(email, password);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(id==null) return 0;
        return id;
    }
    
    @WebMethod(operationName = "ValidarCorreoElectronico")
    public Integer ValidarCorreoElectronico(@WebParam(name = "email")String email) {
        Integer id=null;
        
        try {
            id = usuarioBO.ValidarCorreoElectronico(email);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(id==null) return 0;
        return id;
    }
    
    @WebMethod(operationName = "ActualizarContrasena")
    public Integer ActualizarContrasena(@WebParam(name = "email")String email,@WebParam(name = "password")String newPassword) {
        Integer id=null;
        
        try {
            id = usuarioBO.ActualizarContrasena(email,newPassword);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(id == null) return 0;
        return id;
    }
    
    @WebMethod(operationName = "ValidarUsuarioLogin")
    public Integer ValidarUsuarioLogin(@WebParam(name = "username")String username,@WebParam(name = "password")String password) {
        Integer id=null;
        
        try {
            id = usuarioBO.ValidarDatos(username, password);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(id==null) return 0;
        return id;
    }
    
}

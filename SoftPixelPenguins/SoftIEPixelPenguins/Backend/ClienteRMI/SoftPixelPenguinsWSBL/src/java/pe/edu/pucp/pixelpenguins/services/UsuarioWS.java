package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.UsuarioBO;
import pe.edu.pucp.pixelpenguins.rmi.servidor.SoftPixelPenguinsRMI_Servidor;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

@WebService(serviceName = "UsuarioWS", targetNamespace
        = "http://services.pixelpenguins.pucp.edu.pe")
public class UsuarioWS {

    private String IP;
    private Integer puerto;
    private UsuarioBO usuarioBO;
    
    public UsuarioWS() {
        SoftPixelPenguinsRMI_Servidor.cargarConfiguracionServidorRMI();
        try {
            String nombreServicio = SoftPixelPenguinsRMI_Servidor.retornarNombreDelServicio("usuarioBO");
            this.usuarioBO = (UsuarioBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(UsuarioWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "insertarUsuario")
    public Integer insertarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.insertar(usuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarUsuario")
    public Integer modificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.modificar(usuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarUsuario")
    public Integer eliminarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Integer resultado = 0;
        try {
            resultado = usuarioBO.eliminar(usuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosUsuarios")
    public ArrayList<Usuario> listarTodosUsuarios() {
        ArrayList<Usuario> usuarios = null;
        try {
            usuarios = usuarioBO.listarTodos();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    
    @WebMethod(operationName = "obtenerUsuarioPorId")
    public Usuario obtenerUsuarioPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        Usuario usuario = null;
        try {
            usuario = usuarioBO.obtenerPorId(idUsuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
    
    @WebMethod(operationName = "existeUsuario")
    public Boolean existeUsuario(@WebParam(name = "usuario") Usuario usuario) {
        Boolean resultado = null;
        try {
            resultado = usuarioBO.existeUsuario(usuario);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarUsuariosPorNombre")
    public ArrayList<Usuario> listarUsuariosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Usuario> usuarios = null;
        try {
            usuarios = usuarioBO.listarUsuariosPorNombre(nombre);
        } catch (RemoteException ex) {
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
        catch (RemoteException ex) {
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
        catch (RemoteException ex) {
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
        catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        if(id == null) return 0;
        return id;
    }
    
}

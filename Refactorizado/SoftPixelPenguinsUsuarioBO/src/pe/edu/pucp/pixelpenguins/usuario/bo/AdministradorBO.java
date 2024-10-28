package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.AdministradorDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.AdministradorDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class AdministradorBO {
    
    private final AdministradorDAO administradorDAO;

    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

    public Integer insertar(int codigoAdministrador, String dni, String nombre,
                            Date fechaNacimiento, String direccion, String email,
                            String sexo, String username, String password, Rol rol) {
        Administrador administrador = new Administrador(codigoAdministrador, dni, nombre,
                fechaNacimiento, direccion, email, sexo, username, password, rol);
        return this.administradorDAO.insertar(administrador);
    }

    public Integer modificar(int codigoAdministrador, int idUsuario, String dni,
                             String nombreCompleto, Date fechaNacimiento, String direccion,
                             String email, String sexo, String username, String password, Rol rol) {
        Administrador administrador = new Administrador(codigoAdministrador, idUsuario, dni,
                nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, rol);
        return this.administradorDAO.modificar(administrador);
    }

    public Integer eliminar(Integer idUsuario) {
        Administrador administrador = new Administrador();
        administrador.setIdUsuario(idUsuario);
        return this.administradorDAO.eliminar(administrador);
    }
    
    public ArrayList<Administrador> listarTodos() {
        return this.administradorDAO.listarTodos();
    }

    public Administrador obtenerPorId(Integer idUsuario) {
        return this.administradorDAO.obtenerPorId(idUsuario);
    }

    public Boolean existeAdministrador(Integer idUsuario) {
        Administrador administrador = new Administrador();
        administrador.setIdUsuario(idUsuario);
        return this.administradorDAO.existeAdministrador(administrador);
    }
    
}

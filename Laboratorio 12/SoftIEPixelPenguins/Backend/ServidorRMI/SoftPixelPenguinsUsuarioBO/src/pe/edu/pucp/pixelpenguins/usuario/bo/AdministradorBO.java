package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.AdministradorDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.AdministradorDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Administrador;

public class AdministradorBO {
    
    private final AdministradorDAO administradorDAO;

    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
    }

    public Integer insertar(Administrador administrador) {
        return this.administradorDAO.insertar(administrador);
    }
    
    public Integer modificar(Administrador administrador) {
        return this.administradorDAO.modificar(administrador);
    }
    
    public Integer eliminar(Administrador administrador) {
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

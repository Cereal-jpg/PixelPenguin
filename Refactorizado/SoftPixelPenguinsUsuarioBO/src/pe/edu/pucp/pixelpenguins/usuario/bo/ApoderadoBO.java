package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.ApoderadoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.ApoderadoDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

public class ApoderadoBO {
    
    private final ApoderadoDAO apoderadoDAO;

    public ApoderadoBO() {
        this.apoderadoDAO = new ApoderadoDAOImpl();
    }

    public Integer insertar(String dni, String nombreCompleto, String telefono, String relacion) {
        Apoderado apoderado = new Apoderado(dni, nombreCompleto, telefono, relacion);
        return this.apoderadoDAO.insertar(apoderado);
    }

    public Integer modificar(int idApoderado, String dni, String nombreCompleto, String telefono, String relacion) {
        Apoderado apoderado = new Apoderado(idApoderado, dni, nombreCompleto, telefono, relacion);
        return this.apoderadoDAO.modificar(apoderado);
    }

    public Integer eliminar(int idApoderado) {
        Apoderado apoderado = new Apoderado();
        apoderado.setIdApoderado(idApoderado);
        return this.apoderadoDAO.eliminar(apoderado);
    }

    public Apoderado obtenerPorId(int idApoderado) {
        return this.apoderadoDAO.obtenerPorId(idApoderado);
    }

    public ArrayList<Apoderado> listarTodos() {
        return this.apoderadoDAO.listarTodos();
        
    }
}

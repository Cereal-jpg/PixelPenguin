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
    
    public Integer insertar(Apoderado apoderado) {
        return this.apoderadoDAO.insertar(apoderado);
    }
    
    public Integer modificar(Apoderado apoderado) {
        return this.apoderadoDAO.modificar(apoderado);
    }
    
    public Integer eliminar(Apoderado apoderado) {
        return this.apoderadoDAO.eliminar(apoderado);
    }

    public Apoderado obtenerPorId(int idApoderado) {
        return this.apoderadoDAO.obtenerPorId(idApoderado);
    }

    public ArrayList<Apoderado> listarTodos() {
        return this.apoderadoDAO.listarTodos();
        
    }
}

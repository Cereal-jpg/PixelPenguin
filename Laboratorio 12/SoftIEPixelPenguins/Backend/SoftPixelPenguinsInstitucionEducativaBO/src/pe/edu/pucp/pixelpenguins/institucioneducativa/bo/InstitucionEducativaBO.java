package pe.edu.pucp.pixelpenguins.institucioneducativa.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucionEducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.daoImp.InstitucionEducativaDAOImpl;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class InstitucionEducativaBO {

    private InstitucionEducativaDAO institucionDAO;

    public InstitucionEducativaBO() {
        this.institucionDAO = new InstitucionEducativaDAOImpl();
    }
     
    public Integer insertar(InstitucionEducativa institucionEducativa) {
        return this.institucionDAO.insertar(institucionEducativa);
    }
    
    public Integer modificar(InstitucionEducativa institucionEducativa) {
        return this.institucionDAO.modificar(institucionEducativa);
    }
    
    public Integer eliminar(InstitucionEducativa institucionEducativa) {
        return this.institucionDAO.eliminar(institucionEducativa);
    }

    public ArrayList<InstitucionEducativa> listarTodos() {
        return this.institucionDAO.listarTodos();
    }

    public InstitucionEducativa obtenerPorId(Integer idInstitucion) {
        return this.institucionDAO.obtenerPorId(idInstitucion);
    }
    
}

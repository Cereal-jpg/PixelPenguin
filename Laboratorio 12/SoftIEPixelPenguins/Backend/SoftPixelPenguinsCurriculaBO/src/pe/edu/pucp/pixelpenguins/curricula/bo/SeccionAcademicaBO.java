package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.SeccionAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.SeccionAcademicaDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

public class SeccionAcademicaBO {
    
    private SeccionAcademicaDAO seccionAcademicaDAO;

    public SeccionAcademicaBO() {
        this.seccionAcademicaDAO = new SeccionAcademicaDAOImpl();
    }

    public Integer insertar(SeccionAcademica seccionAcademica) {
        return this.seccionAcademicaDAO.insertar(seccionAcademica);
    }

    public Integer modificar(SeccionAcademica seccionAcademica) {
        return this.seccionAcademicaDAO.modificar(seccionAcademica);
    }

    public Integer eliminar(SeccionAcademica seccionAcademica) {
        return this.seccionAcademicaDAO.eliminar(seccionAcademica);
    }

    public ArrayList<SeccionAcademica> listarTodos() {
        return this.seccionAcademicaDAO.listarTodos();
    }

    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) {
        return this.seccionAcademicaDAO.obtenerPorId(idSeccionAcademica);
    }
    
    public ArrayList<SeccionAcademica> listarSeccionesPorGrado(GradoAcademico gradoAcademico){
        return seccionAcademicaDAO.listarSeccionesPorGrado(gradoAcademico);
    } 
    
}

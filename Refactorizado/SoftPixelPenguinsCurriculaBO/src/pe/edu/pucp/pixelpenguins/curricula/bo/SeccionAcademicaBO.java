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

    public Integer insertar(Integer idSeccionAcademica, char seccion, String aula, Integer idGradoAcademico) {
        SeccionAcademica seccionAcademica = this.crearSeccionAcademica(idSeccionAcademica, seccion, aula, idGradoAcademico);
        return this.seccionAcademicaDAO.insertar(seccionAcademica);
    }

    public Integer modificar(Integer idSeccionAcademica, char seccion, String aula, Integer idGradoAcademico) {
        SeccionAcademica seccionAcademica = this.crearSeccionAcademica(idSeccionAcademica, seccion, aula, idGradoAcademico);
        return this.seccionAcademicaDAO.modificar(seccionAcademica);
    }

    public Integer eliminar(Integer idSeccionAcademica) {
        SeccionAcademica seccionAcademica = new SeccionAcademica();
        seccionAcademica.setIdSeccionAcademica(idSeccionAcademica);
        return this.seccionAcademicaDAO.eliminar(seccionAcademica);
    }

    public ArrayList<SeccionAcademica> listarTodos() {
        return this.seccionAcademicaDAO.listarTodos();
    }

    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) {
        return this.seccionAcademicaDAO.obtenerPorId(idSeccionAcademica);
    }

    private SeccionAcademica crearSeccionAcademica(Integer idSeccionAcademica, char seccion, String aula, Integer idGradoAcademico) {
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setIdGradoAcademico(idGradoAcademico);

        SeccionAcademica seccionAcademica = new SeccionAcademica();
        seccionAcademica.setIdSeccionAcademica(idSeccionAcademica);
        seccionAcademica.setSeccion(seccion);
        seccionAcademica.setAula(aula);
        seccionAcademica.setGradoAcademico(gradoAcademico);
        return seccionAcademica;
    }
    
}

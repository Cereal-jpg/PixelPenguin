
package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.GradoAcademicoDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.GradoAcademicoDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;

public class GradoAcademicoBO {
    
    private GradoAcademicoDAO gradoAcademicoDAO;

    public GradoAcademicoBO() {
        this.gradoAcademicoDAO = new GradoAcademicoDAOImpl();
    }

    public Integer insertar(int numeroGrado, NivelEducativo nivel, int cantidadAlumnos, int vacantes, int fidAnioAcademico) {
        GradoAcademico gradoAcademico = this.crearGradoAcademico(null, numeroGrado, nivel, cantidadAlumnos, vacantes, fidAnioAcademico);
        return this.gradoAcademicoDAO.insertar(gradoAcademico);
    }
    
    public Integer insertar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.insertar(gradoAcademico);
    }

    public Integer modificar(int idGradoAcademico, int numeroGrado, NivelEducativo nivel, int cantidadAlumnos, int vacantes, int fidAnioAcademico) {
        GradoAcademico gradoAcademico = this.crearGradoAcademico(idGradoAcademico, numeroGrado, nivel, cantidadAlumnos, vacantes, fidAnioAcademico);
        return this.gradoAcademicoDAO.modificar(gradoAcademico);
    }
    
    public Integer modificar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.modificar(gradoAcademico);
    }

    public Integer eliminar(int idGradoAcademico) {
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setIdGradoAcademico(idGradoAcademico);
        return this.gradoAcademicoDAO.eliminar(gradoAcademico);
    }
    
    public Integer eliminar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.eliminar(gradoAcademico);
    }

    public ArrayList<GradoAcademico> listarTodos() {
        return this.gradoAcademicoDAO.listarTodos();
    }

    public GradoAcademico obtenerPorId(Integer idGradoAcademico) {
        return this.gradoAcademicoDAO.obtenerPorId(idGradoAcademico);
    }

    private GradoAcademico crearGradoAcademico(Integer idGradoAcademico, int numeroGrado, NivelEducativo nivel, int cantidadAlumnos, int vacantes, int fidAnioAcademico) {
        GradoAcademico gradoAcademico = new GradoAcademico();
        //gradoAcademico.setIdGradoAcademico(idGradoAcademico);
        gradoAcademico.setNumeroGrado(numeroGrado);
        gradoAcademico.setNivel(nivel);
        gradoAcademico.setCantidadAlumnos(cantidadAlumnos);
        gradoAcademico.setVacantes(vacantes);
        gradoAcademico.setFid_AnioAcademico(fidAnioAcademico);
        return gradoAcademico;
    }
}

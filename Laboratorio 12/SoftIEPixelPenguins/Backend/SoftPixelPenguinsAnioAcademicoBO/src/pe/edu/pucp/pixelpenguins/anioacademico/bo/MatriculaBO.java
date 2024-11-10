package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.MatriculaDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class MatriculaBO {
    
    private MatriculaDAO matriculaDAO;
    
    public MatriculaBO() {
        this.matriculaDAO = new MatriculaDAOImpl();
    }
    
    public Integer insertar(Matricula matricula) {
        return this.matriculaDAO.insertar(matricula);
    }

    public Integer modificar(Matricula matricula) {
        return this.matriculaDAO.modificar(matricula);
    }

    public Integer eliminar(Matricula matricula) {
        return this.matriculaDAO.eliminar(matricula);
    }
    
    public ArrayList<Matricula> listarTodos() {
        return this.matriculaDAO.listarTodos();
    }
    
    public Matricula obtenerPorId(Integer idMatricula) {
        return this.matriculaDAO.obtenerPorId(idMatricula);
    }

     public Integer obtenerPorIdAlumno(Integer idAlumno){
        return this.matriculaDAO.obtenerPorIdAlumno(idAlumno);
     }
     
    public ArrayList<Matricula>listarMatriculasPorGradoAcademico(GradoAcademico gradoAcademico){
        return this.matriculaDAO.listarMatriculasPorGradoAcademico(gradoAcademico);
    }
}

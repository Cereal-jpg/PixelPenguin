package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.MatriculaDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class MatriculaBO {
    
    private final MatriculaDAO matriculaDAO;
    
    public MatriculaBO() {
        this.matriculaDAO = new MatriculaDAOImpl();
    }
    
    public Integer insertar(Integer idGradoAcademico, Integer idAnioAcademico,
            Integer idAlumno) {
        Matricula matricula = this.crearMatricula(null, idGradoAcademico, 
                idAnioAcademico, idAlumno);
        return this.matriculaDAO.insertar(matricula);
    }
    
    public Integer insertar(Matricula matricula) {
        return this.matriculaDAO.insertar(matricula);
    }
    
    public Integer modificar(Integer idMatricula, Integer idGradoAcademico,
            Integer idAnioAcademico, Integer idAlumno) {
        Matricula matricula = this.crearMatricula(idMatricula, idGradoAcademico,
                idAnioAcademico, idAlumno);
        return this.matriculaDAO.modificar(matricula);
    }
    
    public Integer modificar(Matricula matricula) {
        return this.matriculaDAO.modificar(matricula);
    }
    
    public Integer eliminar(Integer idMatricula) {
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        return this.matriculaDAO.eliminar(matricula);
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
    
    private Matricula crearMatricula(Integer idMatricula, Integer idGradoAcademico,
            Integer idAnioAcademico, Integer idAlumno) {
        
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        matricula.setFidAlumno(idAlumno);
        GradoAcademico grado = new GradoAcademico();
        grado.setIdGradoAcademico(idGradoAcademico);
        matricula.setGradoAcademico(grado);
        
        AnioAcademico anio = new AnioAcademico();
        anio.setIdAnioAcademico(idAnioAcademico);
        matricula.setAnioAcademico(anio);
        
        return matricula;
    }
    
}

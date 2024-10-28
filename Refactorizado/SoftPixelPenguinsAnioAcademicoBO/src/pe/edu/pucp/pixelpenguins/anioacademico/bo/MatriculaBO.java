package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.MatriculaDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDeMatricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class MatriculaBO {
    
    private final MatriculaDAO matriculaDAO;
    
    public MatriculaBO() {
        this.matriculaDAO = new MatriculaDAOImpl();
    }
    
    public Integer insertar(Integer idGradoAcademico, Integer idAnioAcademico,
            Integer idAlumno, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado) {
        Matricula matricula = this.crearMatricula(null, idGradoAcademico, 
                idAnioAcademico, idAlumno, cumpleRequisitos, fechaInicio, fechaFin, estado);
        return this.matriculaDAO.insertar(matricula);
    }
    
    public Integer modificar(Integer idMatricula, Integer idGradoAcademico,
            Integer idAnioAcademico, Integer idAlumno, boolean cumpleRequisitos, Date fechaInicio,
            Date fechaFin, EstadoDeMatricula estado) {
        Matricula matricula = this.crearMatricula(idMatricula, idGradoAcademico,
                idAnioAcademico, idAlumno, cumpleRequisitos, fechaInicio, fechaFin, estado);
        return this.matriculaDAO.modificar(matricula);
    }
    
    public Integer eliminar(Integer idMatricula) {
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        return this.matriculaDAO.eliminar(matricula);
    }
    
    public ArrayList<Matricula> listarTodos() {
        return this.matriculaDAO.listarTodos();
    }
    
    public Matricula obtenerPorId(Integer idMatricula) {
        return this.matriculaDAO.obtenerPorId(idMatricula);
    }
    
    private Matricula crearMatricula(Integer idMatricula, Integer idGradoAcademico,
            Integer idAnioAcademico, Integer idAlumno, boolean cumpleRequisitos, Date fechaInicio,
            Date fechaFin, EstadoDeMatricula estado) {
        
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        matricula.setCumpleRequisitos(cumpleRequisitos);
        matricula.setFechaInicio(fechaInicio);
        matricula.setFechaFin(fechaFin);
        matricula.setEstado(estado);
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

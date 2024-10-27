package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.CompetenciaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.CompetenciaDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public class CompetenciaBO {
    
    private CompetenciaDAO competenciaDAO;
    
    public CompetenciaBO() {
        this.competenciaDAO = new CompetenciaDAOImpl();
    }
    
    public Integer insertar(String descripcion, Integer idCurso) {
        Competencia competencia = this.crearCompetencia(null,descripcion, idCurso);
        return this.competenciaDAO.insertar(competencia);
    }
    
    public Integer modificar(Integer idCompetencia, String descripcion, Integer idCurso) {
        Competencia competencia = this.crearCompetencia(idCompetencia,descripcion, idCurso);
        return this.competenciaDAO.modificar(competencia);
    }
    
    public Integer eliminar(Integer idCompetencia) {
        Competencia competencia = new Competencia();
        competencia.setIdCompetencia(idCompetencia);
        return this.competenciaDAO.eliminar(competencia);
    }
    
    public ArrayList<Competencia> listarTodos() {
        return this.competenciaDAO.listarTodos();
    }
    
    public Competencia obtenerPorId(Integer idCompetencia) {
        return this.competenciaDAO.obtenerPorId(idCompetencia);
    }
    
    private Competencia crearCompetencia(Integer idCompetencia,String descripcion, Integer idCurso) {
        Curso curso = new Curso();
        curso.setIdCurso(idCurso);
        
        Competencia competencia = new Competencia();
        competencia.setIdCompetencia(idCompetencia);
        competencia.setDescripcion(descripcion);
        competencia.setCurso(curso);
        return competencia;
    }
    
}

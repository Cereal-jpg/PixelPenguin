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
    
    public Integer insertar(Competencia competencia) {
        return this.competenciaDAO.insertar(competencia);
    }
    
    public Integer modificar(Competencia competencia) {
        return this.competenciaDAO.modificar(competencia);
    }
    
    public Integer eliminar(Competencia competencia) {
        return this.competenciaDAO.eliminar(competencia);
    }
    
    public ArrayList<Competencia> listarTodos() {
        return this.competenciaDAO.listarTodos();
    }
    
    public Competencia obtenerPorId(Integer idCompetencia) {
        return this.competenciaDAO.obtenerPorId(idCompetencia);
    }
    
    public ArrayList<Competencia> listarCompetenciasPorCurso(Integer idCurso){
        return this.competenciaDAO.listarCompetenciasPorCurso(idCurso);
    }
    
}

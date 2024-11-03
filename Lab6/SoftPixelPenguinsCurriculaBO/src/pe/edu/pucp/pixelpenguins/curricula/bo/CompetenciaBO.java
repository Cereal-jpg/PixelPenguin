
package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.CompetenciaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImpl.CompetenciaDaoImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;

/**
 *
 * @author Admin
 */
public class CompetenciaBO {
    private CompetenciaDAO competenciaDAO;
    
    public CompetenciaBO(){
        this.competenciaDAO = new CompetenciaDaoImpl();
        
    }
    //int idInstitucion, String nombre, int cantidadAlumnos, String direccion, int ruc
    public int insertar(int idCompetencia, String descripcion, String idCurso){
        
        Competencia competencia = new Competencia(idCompetencia,descripcion,idCurso);
        return competenciaDAO.insertar(competencia);
    }
    public int modificar(int idCompetencia, String descripcion, String idCurso){
        Competencia competencia = new Competencia(idCompetencia,descripcion,idCurso);
        return competenciaDAO.modificar(competencia);
    }
    
    public int eliminarint(int idCompetencia, String descripcion, String idCurso){
        Competencia competencia = new Competencia(idCompetencia,descripcion,idCurso);
        return competenciaDAO.eliminar(competencia);
    }
    
    public ArrayList<Competencia> listarTodos(){
        return competenciaDAO.listarTodos();
    }
    
    public Competencia obtenerPorId(int id_competencia){
        return competenciaDAO.obtenerPorId(id_competencia);
    }
}

package pe.edu.pucp.pixelpenguins.añoacademico.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.añoacademico.dao.PlanAcademicoDAO;
import pe.edu.pucp.pixelpenguins.añoacademico.daoimpl.PlanAcademicoDAOImpl;
import pe.edu.pucp.pixelpenguins.añoacademico.model.PlanAcademico;

public class PlanAcademicoBO {
    private PlanAcademicoDAO planAcademicoDAO;
    
    public PlanAcademicoBO(){
        this.planAcademicoDAO = new PlanAcademicoDAOImpl();
        
    }
    
    public int insertar(int idPlanAcademico, int año, Date fechaInicio, Date fechaFin,Integer idInstitucion){
        PlanAcademico planAcademico = new PlanAcademico(idPlanAcademico, año, 
                fechaInicio, fechaFin, idInstitucion);
        return planAcademicoDAO.insertar(planAcademico);
    }
    
    public int modificar(int idPlanAcademico, int año, Date fechaInicio, Date fechaFin,Integer idInstitucion){
        PlanAcademico planAcademico = new PlanAcademico(idPlanAcademico, año, 
                fechaInicio, fechaFin, idInstitucion);
        return planAcademicoDAO.modificar(planAcademico);
    }
    
    public int eliminar(int idPlanAcademico, int año, Date fechaInicio, Date fechaFin,Integer idInstitucion){
        PlanAcademico planAcademico = new PlanAcademico(idPlanAcademico, año, 
                fechaInicio, fechaFin, idInstitucion);
        return planAcademicoDAO.eliminar(planAcademico);
    }
    
    public ArrayList<PlanAcademico> listarTodos(){
        return planAcademicoDAO.listarTodos();
    }
    
    public PlanAcademico obtenerPorId(int idPlanAcademico){
        return planAcademicoDAO.obtenerPorId(idPlanAcademico);
    }
}

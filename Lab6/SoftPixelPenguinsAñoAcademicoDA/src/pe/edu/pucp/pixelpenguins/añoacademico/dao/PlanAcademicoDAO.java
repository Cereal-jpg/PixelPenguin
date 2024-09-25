/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.añoacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.añoacademico.model.PlanAcademico;

/**
 *
 * @author Angel
 */
public interface PlanAcademicoDAO {
    public Integer insertar(PlanAcademico planAcademico);
    
    public Integer modificar(PlanAcademico planAcademico);
    
    public Integer eliminar(PlanAcademico planAcademico);
    
    public ArrayList<PlanAcademico> listarTodos();
    
    public PlanAcademico obtenerPorId(int idPlanAcademico);
}

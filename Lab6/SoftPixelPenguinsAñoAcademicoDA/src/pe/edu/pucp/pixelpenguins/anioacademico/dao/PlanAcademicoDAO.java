/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.PlanAcademico;

/**
 *
 * @author Angel
 */
public interface PlanAcademicoDAO {
    public int insertar(PlanAcademico planAcademico);
    
    public int modificar(PlanAcademico planAcademico);
    
    public int eliminar(PlanAcademico planAcademico);
    
    public ArrayList<PlanAcademico> listarTodos();
    
    public PlanAcademico obtenerPorId(int idPlanAcademico);
}

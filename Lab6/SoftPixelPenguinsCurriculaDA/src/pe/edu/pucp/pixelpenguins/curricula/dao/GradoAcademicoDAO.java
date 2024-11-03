/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;


/**
 *
 * @author Angel
 */
public interface GradoAcademicoDAO {
    public Integer insertar(GradoAcademico gradoAcademico);
    
    public Integer modificar(GradoAcademico gradoAcademico);
    
    public Integer eliminar(GradoAcademico gradoAcademico);
    
    public ArrayList<GradoAcademico> listarTodos();
    
    public GradoAcademico obtenerPorId(String idGradoAcademico);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

/**
 *
 * @author Angel
 */
public interface SeccionAcademicaDAO {
    public Integer insertar(SeccionAcademica seccionAcademica);
    
    public Integer modificar(SeccionAcademica seccionAcademica);
    
    public Integer eliminar(SeccionAcademica seccionAcademica);
    
    public ArrayList<SeccionAcademica> listarTodos();
    
    public SeccionAcademica obtenerPorId(String idSeccionAcademica);
}

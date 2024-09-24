/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package src.pe.edu.pucp.pixelpenguins.institucioneducativa.dao;
import java.util.ArrayList;
import src.pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

/**
 *
 * @author Danicela
 */
public interface InstitucioneducativaDAO {
    public int insertar(InstitucionEducativa institucion);
     
    public int modificar(InstitucionEducativa institucion);
    
    public int eliminar(InstitucionEducativa institucion);
    
    public ArrayList<InstitucionEducativa> listarTodos();
    
}

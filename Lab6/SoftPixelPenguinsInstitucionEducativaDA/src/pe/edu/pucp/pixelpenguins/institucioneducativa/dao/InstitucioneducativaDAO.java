/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.institucioneducativa.dao;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public interface InstitucioneducativaDAO {
    public int insertar(InstitucionEducativa institucion);
     
    public int modificar(InstitucionEducativa institucion);
    
    public int eliminar(InstitucionEducativa institucion);
    
    public ArrayList<InstitucionEducativa> listarTodos();
    
    public InstitucionEducativa obtenerPorId(int id_inst);
    
}

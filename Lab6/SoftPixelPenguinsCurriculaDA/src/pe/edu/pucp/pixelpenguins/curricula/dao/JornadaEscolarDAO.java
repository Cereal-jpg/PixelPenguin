/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;


/**
 *
 * @author Angel
 */
public interface JornadaEscolarDAO {
    public Integer insertar(JornadaEscolar jornadaEscolar);
    
    public Integer modificar(JornadaEscolar jornadaEscolar);
    
    public Integer eliminar(JornadaEscolar jornadaEscolar);
    
    public ArrayList<JornadaEscolar> listarTodos();
    
    public JornadaEscolar obtenerPorId(String idJornadaEscolar);
}

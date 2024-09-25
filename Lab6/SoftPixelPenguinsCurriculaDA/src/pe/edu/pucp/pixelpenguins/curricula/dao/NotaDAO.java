/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

/**
 *
 * @author User
 */
public interface NotaDAO {
    public Integer insertar(Nota nota);
    
    public Integer modificar(Nota nota);
    
    public Integer eliminar(Nota nota);
    
    public ArrayList<Nota> listarTodos();
    
    public Nota obtenerPorId(Integer idNota);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;

/**
 *
 * @author Angel
 */
public interface MatriculaDAO {
    public Integer insertar(Matricula matricula);
    
    public Integer modificar(Matricula matricula);
    
    public Integer eliminar(Matricula matricula);
    
    public ArrayList<Matricula> listarTodos();
    
    public Matricula obtenerPorId(int idMatricula);
}

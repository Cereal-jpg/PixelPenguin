/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.añoacademico.dao;

import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public interface MatriculaDAO {
    public Integer insertar(Matricula matricula);
    
    public Integer modificar(Matricula matricula);
    
    public Integer eliminar(Matricula matricula);
    
    public ArrayList<Matricula> listarTodos();
    
    public Matricula obtenerPorId(String idMatricula);
}

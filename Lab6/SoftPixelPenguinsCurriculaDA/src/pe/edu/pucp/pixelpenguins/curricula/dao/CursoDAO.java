/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;


/**
 *
 * @author Angel
 */
public interface CursoDAO {
    public Integer insertar(Curso curso);
    
    public Integer modificar(Curso curso);
    
    public Integer eliminar(Curso curso);
    
    public ArrayList<Curso> listarTodos();
    
    public Curso obtenerPorId(String idCurso);
}

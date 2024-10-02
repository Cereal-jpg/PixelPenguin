/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public interface CursoDAO {
    public int insertar(Curso curso);
    public int modificar(Curso curso);
    public int eliminar(Curso curso);
    public ArrayList<Curso> listarTodos();
    public Curso obtenerPorId(int id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;


public interface GradoAcademicoDAO {
    public int insertar(GradoAcademico gradoAcademico);
    public int modificar(GradoAcademico gradoAcademico);
    public int eliminar(GradoAcademico gradoAcademico);
    public ArrayList<GradoAcademico> listarTodos();
    public GradoAcademico obtenerPorId(int id);
}

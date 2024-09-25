/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;

/**
 *
 * @author Enzo
 */
public interface AlumnoDAO {
    public int insertar(Alumno equipoAdministrativo);
    public int modificar(Alumno equipoAdministrativo);
    public int eliminar(Alumno equipoAdministrativo);
    public ArrayList<Alumno> listarTodos();
    public Alumno obtenerPorId(int codigo);
}

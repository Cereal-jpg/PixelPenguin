/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

/**
 *
 * @author Angel
 */
public interface HoraAcademicaDAO {
    public int insertar(HoraAcademica horaAcademica);
    
    public int modificar(HoraAcademica horaAcademica);
    
    public int eliminar(HoraAcademica horaAcademica);
    
    public ArrayList<HoraAcademica> listarTodos();
    
    public HoraAcademica obtenerPorId(int idHoraAcademica);
}

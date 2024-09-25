/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;


/**
 *
 * @author Angel
 */
public interface CompetenciaDAO {
    public Integer insertar(Competencia competencia);
    
    public Integer modificar(Competencia competencia);
    
    public Integer eliminar(Competencia competencia);
    
    public ArrayList<Competencia> listarTodos();
    
    public Competencia obtenerPorId(int idCompetencia);
}

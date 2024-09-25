/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

/**
 *
 * @author Angel
 */
public interface PagoDAO {
    public Integer insertar(Pago pago);
    
    public Integer modificar(Pago pago);
    
    public Integer eliminar(Pago pago);
    
    public ArrayList<Pago> listarTodos();
    
    public Pago obtenerPorId(int idPago);
}

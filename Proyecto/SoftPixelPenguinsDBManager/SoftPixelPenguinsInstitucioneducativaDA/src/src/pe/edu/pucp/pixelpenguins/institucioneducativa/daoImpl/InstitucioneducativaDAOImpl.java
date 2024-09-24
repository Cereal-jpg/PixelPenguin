/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.pe.edu.pucp.pixelpenguins.institucioneducativa.daoImpl;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucioneducativaDAO;
import src.pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

/**
 *
 * @author Danicela
 */
public class InstitucioneducativaDAOImpl implements InstitucioneducativaDAO{
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;

    
    
    @Override
    public int insertar(InstitucionEducativa institucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(InstitucionEducativa institucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(InstitucionEducativa institucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<InstitucionEducativa> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

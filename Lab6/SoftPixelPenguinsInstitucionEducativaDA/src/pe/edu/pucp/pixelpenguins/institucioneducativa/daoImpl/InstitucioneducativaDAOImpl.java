/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.institucioneducativa.daoImpl;

import java.util.ArrayList;

import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucioneducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.pucp.pixelpenguins.config.DBManager;
public class InstitucioneducativaDAOImpl implements InstitucioneducativaDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public int insertar(InstitucionEducativa institucion) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_INSTITUCION(?,?,?,?,?)}");
            cs.setInt(1,institucion.getIdInstitucion());
            cs.setString(2,institucion.getNombre());
            cs.setString(3,institucion.getDireccion());
            cs.setInt(4,institucion.getCantidadAlumnos());
            cs.setInt(5,institucion.getRuc());      
            resultado = cs.executeUpdate();
                    
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(InstitucionEducativa institucion) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_INSTITUCION(?,?,?,?,?)}");
            cs.setInt(1,institucion.getIdInstitucion());
            cs.setString(2,institucion.getNombre());
            cs.setString(3,institucion.getDireccion());
            cs.setInt(4,institucion.getCantidadAlumnos());
            cs.setInt(5,institucion.getRuc());      
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int eliminar(InstitucionEducativa institucion) {
    int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_INSTITUCION(?)}");
            cs.setInt(1,institucion.getIdInstitucion());     
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;       
    }

    @Override
    public ArrayList<InstitucionEducativa> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

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
        ArrayList<InstitucionEducativa> institutosE = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_INSTITUCION()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                InstitucionEducativa instituto = new InstitucionEducativa();
                instituto.setIdInstitucion(rs.getInt("idInstitucion"));
                instituto.setNombre(rs.getString("nombre"));
                instituto.setDireccion(rs.getString("direccion")); // Asegúrate de que tu modelo tenga este campo
                instituto.setCantidadAlumnos(rs.getInt("cantidadAlumnos")); // Asegúrate de tener este campo también
                instituto.setRuc(rs.getInt("ruc"));
                
                institutosE.add(instituto);
            }
                
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return institutosE;
    }
    
    @Override
    public InstitucionEducativa obtenerPorId(int id_inst){
        InstitucionEducativa instituto = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_INSTITUCION(?)}");
            cs.setInt(1,id_inst);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                instituto = new InstitucionEducativa();
                instituto.setIdInstitucion(rs.getInt("idInstitucion"));
                instituto.setNombre(rs.getString("nombre"));
                instituto.setDireccion(rs.getString("direccion")); // Asegúrate de que tu modelo tenga este campo
                instituto.setCantidadAlumnos(rs.getInt("cantidadAlumnos")); // Asegúrate de tener este campo también
                instituto.setRuc(rs.getInt("ruc"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return instituto;
    }
}

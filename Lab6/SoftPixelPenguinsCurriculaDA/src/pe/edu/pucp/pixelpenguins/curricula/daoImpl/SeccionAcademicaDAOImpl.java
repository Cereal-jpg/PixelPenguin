/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.SeccionAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

/**
 *
 * @author User
 */
public class SeccionAcademicaDAOImpl implements SeccionAcademicaDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    
    
    @Override
    public Integer insertar(SeccionAcademica seccionAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_NOTA(?,?,?,?)}");
            cs.setInt(1,seccionAcademica.getIdSeccionAcademica());
            //cs.setString(2,seccionAcademica.getSeccion());
            cs.setString(3,seccionAcademica.getAula());
            //cs.setInt(4,seccionAcademica.getIdGrado(seccionAcademica.getGrado()));      
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
    public Integer modificar(SeccionAcademica seccionAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_SECCION_ACADEMICA(?,?,?,?)}");
            cs.setInt(1,seccionAcademica.getIdSeccionAcademica());
            //cs.setString(2,seccionAcademica.getSeccion());
            cs.setString(3,seccionAcademica.getAula());
            //cs.setInt(4,seccionAcademica.getIdGrado(seccionAcademica.getGrado()));      
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
    public Integer eliminar(SeccionAcademica seccionAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_SECCION_ACADEMICA(?)}");
            cs.setInt(1,seccionAcademica.getIdSeccionAcademica());     
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
    public ArrayList<SeccionAcademica> listarTodos() {
        ArrayList<SeccionAcademica> seccionesAcademicas = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_NOTA()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                SeccionAcademica seccionAcademica = new SeccionAcademica();
                seccionAcademica.setIdSeccionAcademica(rs.getInt("idSeccionAcademica"));
                //seccionAcademica.setSeccion(rs.getString("seccion"));
                seccionAcademica.setAula(rs.getString("bimestre")); 
                //seccionAcademica.setIdGrado(rs.getString("idGrado")); 
                
                seccionesAcademicas.add(seccionAcademica);
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
        return seccionesAcademicas;
    }

    @Override
    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) {
        SeccionAcademica seccionAcademica = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_NOTA_POR_ID(?)}");
            cs.setInt(1,idSeccionAcademica);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                seccionAcademica = new SeccionAcademica();
                seccionAcademica.setIdSeccionAcademica(rs.getInt("idSeccionAcademica"));
                //seccionAcademica.setSeccion(rs.getString("seccion"));
                seccionAcademica.setAula(rs.getString("bimestre")); 
                //seccionAcademica.setIdGrado(rs.getString("idGrado"));  
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
        return seccionAcademica;
    }
    
}

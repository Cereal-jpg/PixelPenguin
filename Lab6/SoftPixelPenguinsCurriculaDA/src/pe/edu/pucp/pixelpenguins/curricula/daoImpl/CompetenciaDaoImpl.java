/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.curricula.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.CompetenciaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.pucp.pixelpenguins.config.DBManager;
/**
 *
 * @author Admin
 */
public class CompetenciaDaoImpl implements CompetenciaDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public Integer insertar(Competencia competencia) {
          int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_COMPETENCIA(?,?,?)}");
            cs.setInt(1,competencia.getIdCompetencia());
            cs.setString(2,competencia.getDescripcion());
            cs.setString(3,competencia.getIdCurso());    
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
    public Integer modificar(Competencia competencia) {
          int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_COMPETENCIA(?,?,?)}");
            cs.setInt(1,competencia.getIdCompetencia());
            cs.setString(2,competencia.getDescripcion());
            cs.setString(3,competencia.getIdCurso());    
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
    public Integer eliminar(Competencia competencia) {
          int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_COMPETENCIA(?)}");
            cs.setInt(1,competencia.getIdCompetencia());
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
    public ArrayList<Competencia> listarTodos() {
         ArrayList<Competencia> competencias = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_COMPETENCIA()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                Competencia competencia = new Competencia();
                
                competencia.setIdCompetencia(rs.getInt("idCompetencia"));
                competencia.setDescripcion(rs.getString("descripcion"));
                competencia.setIdCurso(rs.getString("idCurso")); // Asegúrate de que tu modelo tenga este campo
                
                competencias.add(competencia);
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
        return competencias;
    }

    @Override
    public Competencia obtenerPorId(int idCompetencia) {
                Competencia competencia = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_COMPETENCIA_POR_ID(?)}");
            cs.setInt(1,idCompetencia);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                competencia = new Competencia();
                competencia.setIdCompetencia(rs.getInt("idCompetencia"));
                competencia.setDescripcion(rs.getString("descripcion"));
                competencia.setIdCurso(rs.getString("idCurso")); // Asegúrate de que tu modelo tenga este campo
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
        return competencia;
    }
    
}

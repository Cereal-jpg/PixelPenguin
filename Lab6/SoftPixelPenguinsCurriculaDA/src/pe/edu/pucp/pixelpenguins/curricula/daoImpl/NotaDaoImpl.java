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
import pe.edu.pucp.pixelpenguins.curricula.dao.NotaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

/**
 *
 * @author User
 */
public class NotaDaoImpl implements NotaDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public Integer insertar(Nota nota) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_NOTA(?,?,?,?,?)}");
            cs.setInt(1,nota.getIdNota());
            cs.setString(2,nota.getNota());
            cs.setInt(3,nota.getBimestre());
            cs.setString(4,nota.getIdCurso());
            cs.setInt(5,nota.getIdCompetencia());      
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
    public Integer modificar(Nota nota) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_NOTA(?,?,?,?,?)}");
            cs.setInt(1,nota.getIdNota());
            cs.setString(2,nota.getNota());
            cs.setInt(3,nota.getBimestre());
            cs.setString(4,nota.getIdCurso());
            cs.setInt(5,nota.getIdCompetencia());      
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
    public Integer eliminar(Nota nota) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_nota(?)}");
            cs.setInt(1,nota.getIdNota());     
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
    public ArrayList<Nota> listarTodos() {
        ArrayList<Nota> notas = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_NOTA()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                Nota nota = new Nota();
                nota.setIdNota(rs.getInt("idNota"));
                nota.setNota(rs.getString("nota"));
                nota.setBimestre(rs.getInt("bimestre")); 
                nota.setIdCurso(rs.getString("idCurso")); 
                nota.setIdCompetencia(rs.getInt("idCompetencia"));
                
                notas.add(nota);
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
        return notas;
    }

    @Override
    public Nota obtenerPorId(Integer idNota) {
        Nota nota = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_NOTA_POR_ID(?)}");
            cs.setInt(1,idNota);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                nota = new Nota();
                nota.setIdNota(rs.getInt("idNota"));
                nota.setNota(rs.getString("nota"));
                nota.setBimestre(rs.getInt("bimestre")); 
                nota.setIdCurso(rs.getString("idCurso")); 
                nota.setIdCompetencia(rs.getInt("idCompetencia"));
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
        return nota;
    }

}

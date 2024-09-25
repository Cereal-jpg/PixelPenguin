/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.añoacademico.daoimpl;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.añoacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.añoacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public class MatriculaDAOImpl implements MatriculaDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public Integer insertar(Matricula matricula) {
        int resultado =0;
          try {
            cs = con.prepareCall("{call INSERTAR_MATRICULA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1,matricula.getIdMatricula());
            cs.setBoolean(2,matricula.isCumpleRequisitos());
            cs.setDate(3,new java.sql.Date(matricula.getFechaInicio().getTime()));
            cs.setDate(4,new java.sql.Date(matricula.getFechaFin().getTime()));
            cs.setString(5,matricula.getEstado().toString());  
            cs.setInt(6,matricula.getIdGradoAcademico());
            cs.setInt(7,matricula.getCodigoAlumno());
            cs.setInt(8,matricula.getIdPlanAcademico());
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
    public Integer modificar(Matricula matricula) {
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
    public Integer eliminar(Matricula matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Matricula> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Matricula obtenerPorId(String idMatricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

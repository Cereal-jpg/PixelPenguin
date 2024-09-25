/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.anioacademico.daoimpl;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDeMatricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public class MatriculaDAOImpl implements MatriculaDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public Integer insertar(Matricula matricula) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MATRICULA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1,matricula.getIdMatricula());
            cs.setBoolean(2,matricula.isCumpleRequisitos());
            cs.setDate(3,new java.sql.Date(matricula.getFechaInicio().getTime()));
            cs.setDate(4,new java.sql.Date(matricula.getFechaFin().getTime()));
            cs.setString(5,matricula.getEstado().toString());  
            if (matricula.getIdGradoAcademico() != null) {
                cs.setInt(6, matricula.getIdGradoAcademico());
            } else {
                cs.setNull(6, java.sql.Types.INTEGER);
            }

            if (matricula.getCodigoAlumno() != null) {
                cs.setInt(7, matricula.getCodigoAlumno());
            } else {
                cs.setNull(7, java.sql.Types.INTEGER);
            }

            if (matricula.getIdPlanAcademico() != null) {
                cs.setInt(8, matricula.getIdPlanAcademico());
            } else {
                cs.setNull(8, java.sql.Types.INTEGER);
            }
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
            cs = con.prepareCall("{call MODIFICAR_MATRICULA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1,matricula.getIdMatricula());
            cs.setBoolean(2,matricula.isCumpleRequisitos());
            if (matricula.getFechaInicio() != null) {
                cs.setDate(3, new java.sql.Date(matricula.getFechaInicio().getTime()));
            } else {
                cs.setNull(3, java.sql.Types.DATE);
            }

            if (matricula.getFechaFin() != null) {
                cs.setDate(4, new java.sql.Date(matricula.getFechaFin().getTime()));
            } else {
                cs.setNull(4, java.sql.Types.DATE);
            }
            cs.setString(5,matricula.getEstado().toString());  
            if (matricula.getIdGradoAcademico() != null) {
                cs.setInt(6, matricula.getIdGradoAcademico());
            } else {
                cs.setNull(6, java.sql.Types.INTEGER);
            }

            if (matricula.getCodigoAlumno() != null) {
                cs.setInt(7, matricula.getCodigoAlumno());
            } else {
                cs.setNull(7, java.sql.Types.INTEGER);
            }

            if (matricula.getIdPlanAcademico() != null) {
                cs.setInt(8, matricula.getIdPlanAcademico());
            } else {
                cs.setNull(8, java.sql.Types.INTEGER);
            }
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
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_MATRICULA(?)}");
            cs.setInt(1,matricula.getIdMatricula());     
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
    public ArrayList<Matricula> listarTodos() {
        ArrayList<Matricula> matriculasE = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_MATRICULA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Matricula matricula = new Matricula();
                matricula.setIdMatricula(rs.getInt("idMatricula"));
                matricula.setCumpleRequisitos(rs.getBoolean("cumpleRequisitos"));
                matricula.setFechaInicio(rs.getDate("fechaInicio"));
                matricula.setFechaFin(rs.getDate("fechaFin"));
                matricula.setEstado(EstadoDeMatricula.valueOf(rs.getString("estado")));
                matricula.setIdGradoAcademico(rs.getInt("idGradoAcademico"));
                matricula.setCodigoAlumno(rs.getInt("codigoAlumno"));
                matricula.setIdPlanAcademico(rs.getInt("idPlanAcademico"));
                matriculasE.add(matricula);
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
        return matriculasE;
    }

    @Override
    public Matricula obtenerPorId(int idMatricula) {
        Matricula matricula = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MATRICULA_POR_ID(?)}");
            cs.setInt(1,idMatricula);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                matricula = new Matricula();
                matricula.setIdMatricula(rs.getInt("idMatricula"));
                matricula.setCumpleRequisitos(rs.getBoolean("cumpleRequisitos"));
                matricula.setFechaInicio(rs.getDate("fechaInicio"));
                matricula.setFechaFin(rs.getDate("fechaFin"));
                matricula.setEstado(EstadoDeMatricula.valueOf(rs.getString("estado")));
                matricula.setIdGradoAcademico(rs.getInt("idGradoAcademico"));
                matricula.setCodigoAlumno(rs.getInt("codigoAlumno"));
                matricula.setIdPlanAcademico(rs.getInt("idPlanAcademico"));
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
        return matricula;
    }
    
}

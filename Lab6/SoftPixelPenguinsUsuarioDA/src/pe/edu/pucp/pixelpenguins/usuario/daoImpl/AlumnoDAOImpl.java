
package pe.edu.pucp.pixelpenguins.usuario.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;

import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Alumno alumno) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_ALUMNO(?,?,?,?,?,?,?)}");
            cs.setInt(1,alumno.getCodigoAlumno());
            cs.setBoolean(2,alumno.isCertificadoDeEstudios());
            cs.setBoolean(3,alumno.isCertificadoDeSalud());
            cs.setBoolean(4,alumno.isDeuda());
            cs.setInt(5,alumno.getDni());
            cs.setInt(6, alumno.getApoderado().getDni());
            cs.setInt(7, alumno.getSeccion().getIdSeccionAcademica());
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
    public int modificar(Alumno alumno) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ALUMNO(?,?,?,?,?,?,?)}");
            cs.setInt(1,alumno.getCodigoAlumno());
            cs.setBoolean(2,alumno.isCertificadoDeEstudios());
            cs.setBoolean(3,alumno.isCertificadoDeSalud());
            cs.setBoolean(4,alumno.isDeuda());
            cs.setInt(5,alumno.getDni());
            cs.setInt(6, alumno.getDniApoderado());
            cs.setInt(7, alumno.getIDSeccion());
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
    public int eliminar(Alumno alumno) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_ALUMNO(?)}");
            cs.setInt(1,alumno.getCodigoAlumno());     
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
    public ArrayList<Alumno> listarTodos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_ALUMNO()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setCodigoAlumno(rs.getInt("codigoAlumno"));
                alumno.setCertificadoDeEstudios(rs.getBoolean("certificadoEstudios"));
                alumno.setCertificadoDeSalud(rs.getBoolean("certificadoSalud"));
                alumno.setDeuda(rs.getBoolean("deuda"));
                alumno.setApoderado(rs.getInt("apoderado"));
                alumno.setSeccion(rs.getInt("idSeccionAcademica"));
                alumnos.add(alumno);
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
        return alumnos;
    }

    @Override
    public Alumno obtenerPorId(int codigoAlumno) {
        Alumno alumno = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ALUMNOS_POR_ID(?)}");
            cs.setInt(1,codigoAlumno);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setCodigoAlumno(rs.getInt("codigoAlumno"));
                alumno.setCertificadoDeEstudios(rs.getBoolean("certificadoEstudios"));
                alumno.setCertificadoDeSalud(rs.getBoolean("certificadoSalud"));
                alumno.setDeuda(rs.getBoolean("deuda"));
                alumno.setApoderado(rs.getInt("apoderado"));
                alumno.setSeccion(rs.getInt("idSeccionAcademica"));
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
        return alumno;
    } 
}

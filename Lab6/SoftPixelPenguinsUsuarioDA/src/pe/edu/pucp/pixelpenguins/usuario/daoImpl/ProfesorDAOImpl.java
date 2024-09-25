
package pe.edu.pucp.pixelpenguins.usuario.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.ProfesorDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public class ProfesorDAOImpl implements ProfesorDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Profesor profesor){
        int resultado =0;
        
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PROFESOR(?,?,?,?)}");
            cs.setInt(1,profesor.getCodigoProfesor());
            cs.setBoolean(2,profesor.isCertificadoHistorialEducativo());
            cs.setString(3,profesor.getEspecialidad());
            cs.setInt(4,profesor.getDni());
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
    public int modificar(Profesor profesor) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PROFESOR(?,?,?,?)}");
            cs.setInt(1,profesor.getCodigoProfesor());
            cs.setBoolean(2,profesor.isCertificadoHistorialEducativo());
            cs.setString(3,profesor.getEspecialidad());
            cs.setInt(4,profesor.getDni());
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
    public int eliminar(Profesor profesor) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_PROFESOR(?)}");
            cs.setInt(1,profesor.getCodigoProfesor());     
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
    public ArrayList<Profesor> listarTodos() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_ALUMNO()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Profesor profesor = new Profesor();
                profesor.setCodigoProfesor(rs.getInt("codigoProfesor"));
                profesor.setCertificadoHistorialEducativo(rs.getBoolean("certificadoHistorialEducativo"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setDni(rs.getInt("dni"));
                profesores.add(profesor);
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
        return profesores;
    }

    @Override
    public Profesor obtenerPorId(int codigo) {
        Profesor profesor = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ALUMNOS_POR_ID(?)}");
            cs.setInt(1,codigo);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                profesor = new Profesor();
                profesor.setCodigoProfesor(rs.getInt("codigoProfesor"));
                profesor.setCertificadoHistorialEducativo(rs.getBoolean("certificadoHistorialEducativo"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setDni(rs.getInt("dni"));
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
        return profesor;
    }
}

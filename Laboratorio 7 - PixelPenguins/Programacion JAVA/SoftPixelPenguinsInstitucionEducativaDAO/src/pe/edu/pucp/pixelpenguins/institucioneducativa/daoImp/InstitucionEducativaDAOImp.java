
package pe.edu.pucp.pixelpenguins.institucioneducativa.daoImp;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucionEducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class InstitucionEducativaDAOImp implements InstitucionEducativaDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(InstitucionEducativa ie) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_INSTITUCIONEDUCATIVA (?,?,?,?,?)}");
            cs.registerOutParameter("p_idInstitucion", java.sql.Types.INTEGER);
            cs.setString("p_nombre", ie.getNombre());
            cs.setInt("p_cantidadAlumnos", ie.getCantidadAlumnos());
            cs.setString("p_direccion", ie.getDireccion());
            cs.setString("p_ruc", ie.getRuc());
            cs.executeUpdate();
            ie.setIdInstitucion(cs.getInt("p_idInstitucion"));
            resultado=1;
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(InstitucionEducativa ie) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_INSTITUCIONEDUCATIVA (?,?,?,?,?)}");
            cs.setInt("p_idInstitucion", ie.getIdInstitucion());
            cs.setString("p_nombre", ie.getNombre());
            cs.setInt("p_cantidadAlumnos", ie.getCantidadAlumnos());
            cs.setString("p_direccion", ie.getDireccion());
            cs.setString("p_ruc", ie.getRuc());
            cs.executeUpdate();
            resultado=1;
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(InstitucionEducativa ie) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_INSTITUCIONEDUCATIVA (?)}");
            cs.setInt("p_idInstitucion", ie.getIdInstitucion());
            cs.executeUpdate();
            resultado=1;
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<InstitucionEducativa> listarTodos() {
        ArrayList<InstitucionEducativa> instituciones= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_INSTITUCIONEDUCATIVA ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                InstitucionEducativa ie = new InstitucionEducativa();
                ie.setIdInstitucion(rs.getInt("idInstitucion"));
                ie.setNombre(rs.getString("nombre"));
                ie.setCantidadAlumnos(rs.getInt("cantidadAlumnos"));
                ie.setDireccion(rs.getString("direccion"));
                ie.setRuc(rs.getString("ruc"));
                instituciones.add(ie);
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return instituciones;
    }

    @Override
    public InstitucionEducativa obtenerPorId(int idInstitucionEducativa) {
        InstitucionEducativa ie=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_INSTITUCIONEDUCATIVA (?)}");
            cs.setInt("p_idInstitucion", idInstitucionEducativa);
            rs=cs.executeQuery();
            if(rs.next()){
                ie = new InstitucionEducativa();
                ie.setIdInstitucion(rs.getInt("idInstitucion"));
                ie.setNombre(rs.getString("nombre"));
                ie.setCantidadAlumnos(rs.getInt("cantidadAlumnos"));
                ie.setDireccion(rs.getString("direccion"));
                ie.setRuc(rs.getString("ruc"));
            }
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {
                if(rs!=null) rs.close();
                if(cs!=null) cs.close();
                if(con!=null) con.close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return ie;
    }
    
}

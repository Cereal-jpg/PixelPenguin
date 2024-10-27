
package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.AnioAcademicoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public class AnioAcademicoDAOImp implements AnioAcademicoDAO {
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(AnioAcademico anioAcademico) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_ANIOACADEMICO (?,?,?,?)}");
            cs.registerOutParameter("p_id", java.sql.Types.INTEGER);
            cs.setInt("p_anio", anioAcademico.getAnio());
            cs.setDate("p_fechaInicio", new java.sql.Date(anioAcademico.getFechaInicio().getTime()));
            cs.setDate("p_fechaFin", new java.sql.Date(anioAcademico.getFechaFin().getTime()));
            cs.executeUpdate();
            anioAcademico.setIdAnioAcademico(cs.getInt("p_id"));
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
    public int modificar(AnioAcademico anioAcademico) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_ANIOACADEMICO (?,?,?,?)}");
            cs.setInt("p_id", anioAcademico.getIdAnioAcademico());
            cs.setInt("p_anio", anioAcademico.getAnio());
            cs.setDate("p_fechaInicio", new java.sql.Date(anioAcademico.getFechaInicio().getTime()));
            cs.setDate("p_fechaFin", new java.sql.Date(anioAcademico.getFechaFin().getTime()));
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
    public int eliminar(AnioAcademico anioAcademico) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_ANIOACADEMICO (?)}");
            cs.setInt("p_id", anioAcademico.getIdAnioAcademico());
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
    public ArrayList<AnioAcademico> listarTodos() {
        ArrayList<AnioAcademico> aniosAcademicos= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_ANIOACADEMICO ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                AnioAcademico auxAnio = new AnioAcademico();
                auxAnio.setIdAnioAcademico(rs.getInt("idAnioAcademico"));
                auxAnio.setAnio(rs.getInt("anio"));
                auxAnio.setFechaInicio(rs.getDate("fechaInicio"));
                auxAnio.setFechaFin(rs.getDate("fechaFin"));
                aniosAcademicos.add(auxAnio);
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return aniosAcademicos;
    }

    @Override
    public AnioAcademico obtenerPorId(int id) {
        AnioAcademico auxAnio=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_ANIOACADEMICO (?)}");
            cs.setInt("p_id", id);
            rs=cs.executeQuery();
            if(rs.next()){
                auxAnio=new AnioAcademico();
                auxAnio.setIdAnioAcademico(rs.getInt("idAnioAcademico"));
                auxAnio.setAnio(rs.getInt("anio"));
                auxAnio.setFechaInicio(rs.getDate("fechaInicio"));
                auxAnio.setFechaFin(rs.getDate("fechaFin"));
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
        return auxAnio;
    }
    
}


// en los BO, se debe enlazar con el paquete DAO y el Model de su clase

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
// import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
// import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolDAOImp implements RolDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Clase clase) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_CLASE (?)}");
            cs.registerOutParameter("p_id", java.sql.Types.INTEGER);
            // cs.setString("p_nombre", rol.getNombre());
            cs.executeUpdate();
            // rol.setIdRol(cs.getInt("p_id"));
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
    public int modificar(Clase clase) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_CLASE (?,?)}");
            cs.setInt("p_id", clase.getId);
            // cs.setString("p_nombre", rol.getNombre());
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
    public int eliminar(Clase clase) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_CLASE (?)}");
            cs.setInt("p_id", clase.getId());
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
    public ArrayList<Clase> listarTodos() {
        ArrayList<Clase> clases= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_CLASE ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                /* Rol rol = new Rol();
				(se setean todos los atributos sacándolos de 
				las columnas de las tablas en la BD)
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombre"));
                roles.add(rol); */
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return clases;
    }

    @Override
    public Clase obtenerPorId(int id) {
        Clase clase=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_CLASE (?)}");
            cs.setInt("p_id", id);
            rs=cs.executeQuery();
            if(rs.next()){
                /*rol = new Rol();
				(Lo mismo que en listar)
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombre"));*/ 
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
        return clase;
    }
    
}
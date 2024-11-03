package pe.edu.pucp.lp2soft.rrhh.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
public class AreaMySQL implements AreaDAO {

    Connection con;
    ResultSet rs;
    CallableStatement cs;
    
    @Override
    public ArrayList<Area> listar() {
        ArrayList<Area> areas = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_AREAS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
                areas.add(area);
            }
            rs.close();
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }

    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_AREA(?,?)}");
            cs.registerOutParameter("_id_area", java.sql.Types.INTEGER);
            cs.setString("_nombre", area.getNombre());
            cs.executeUpdate();
            area.setIdArea(cs.getInt("_id_area"));
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Area area) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MODIFICAR_AREA(?,?)}");
            cs.setInt("_id_area", area.getIdArea());
            cs.setString("_nombre", area.getNombre());
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idArea) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_AREA(?)}");
            cs.setInt("_id_area", idArea);
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
}
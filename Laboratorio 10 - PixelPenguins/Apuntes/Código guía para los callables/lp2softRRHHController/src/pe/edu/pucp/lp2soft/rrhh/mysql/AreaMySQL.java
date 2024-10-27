package pe.edu.pucp.lp2soft.rrhh.mysql;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
public class AreaMySQL implements AreaDAO{
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    @Override
    public ArrayList<Area> listar() {
        ArrayList<Area> areas = new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            st=con.createStatement();
            String sql="SELECT * FROM area WHERE activo=1";
            rs=st.executeQuery(sql);
            while(rs.next()){
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                areas.add(area);
            }
            rs.close();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return areas;
    }

    @Override
    public int insertar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idArea) {
        int resultado=0;
        try{
            con=DBManager.getInstance().getConnection();
            st=con.createStatement();
            String sql="UPDATE area SET activo = 0 where id_area= "+idArea;
            resultado=st.executeUpdate(sql);
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}

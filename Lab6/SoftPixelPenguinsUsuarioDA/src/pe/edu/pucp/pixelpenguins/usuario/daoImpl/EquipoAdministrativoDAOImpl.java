
package pe.edu.pucp.pixelpenguins.usuario.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.EquipoAdministrativoDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.EquipoAdministrativo;

public class EquipoAdministrativoDAOImpl implements EquipoAdministrativoDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(EquipoAdministrativo equipo){
        int resultado =0;
        
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EQUIPOADMINISTRATIVO(?,?)}");
            cs.setInt(1,equipo.getIdEquipoAdministrativo());
            cs.setInt(2,equipo.getCodigoAdministrador());
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
    public int modificar(EquipoAdministrativo equipo) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_EQUIPOADMINISTRATIVO(?,?,?,?,?,?,?)}");
            cs.setInt(1,equipo.getIdEquipoAdministrativo());
            cs.setInt(2,equipo.getCodigoAdministrador());
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
    public int eliminar(EquipoAdministrativo equipoAdministrativo) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_EQUIPOADMINISTRATIVO(?)}");
            cs.setInt(1,equipoAdministrativo.getIdEquipoAdministrativo());     
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
    public ArrayList<EquipoAdministrativo> listarTodos() {
        ArrayList<EquipoAdministrativo> equipos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_EQUIPOSADMINISTRATIVOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                EquipoAdministrativo equipo = new EquipoAdministrativo();
                equipo.setIdEquipoAdministrativo(rs.getInt("idEquipoAdministrativo"));
                equipo.setCodigoAdministrador(rs.getInt("codigoAdministrador"));
                equipos.add(equipo);
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
        return equipos;
    }

    @Override
    public EquipoAdministrativo obtenerPorId(int id) {
        EquipoAdministrativo equipo = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EQUIPOS_POR_ID(?)}");
            cs.setInt(1,id);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                equipo = new EquipoAdministrativo();
                equipo.setIdEquipoAdministrativo(rs.getInt("idEquipoAdministrativo"));
                equipo.setCodigoAdministrador(rs.getInt("codigoAdministrador"));
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
        return equipo;
    }
    
    
}

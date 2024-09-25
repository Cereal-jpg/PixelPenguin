package pe.edu.pucp.pixelpenguins.curricula.daoImpl;

import java.sql.Connection;
import java.sql.Time;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public class JornadaEscolarDAOImpl implements JornadaEscolarDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(JornadaEscolar jornadaEscolar) {
        int resultado =0;
          try {
            Connection con = DBManager.getInstance().getConnection();
            CallableStatement cs = con.prepareCall("{call INSERTAR_JORNADAESCOLAR(?,?,?,?,?)}");
            cs.setInt(1, jornadaEscolar.getIdJornadaEscolar());
            cs.setTime(2, Time.valueOf(jornadaEscolar.getHoraInicio()));
            cs.setTime(3, Time.valueOf(jornadaEscolar.getHoraFin()));
            cs.setInt(4, jornadaEscolar.getHorasDeEstudio());
            cs.setString(5, jornadaEscolar.getDia().toString());     
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
    public int modificar(JornadaEscolar jornadaEscolar) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_JORNADAESCOLAR(?,?,?,?,?)}");
            cs.setInt(1, jornadaEscolar.getIdJornadaEscolar());
            cs.setTime(2, Time.valueOf(jornadaEscolar.getHoraInicio()));
            cs.setTime(3, Time.valueOf(jornadaEscolar.getHoraFin()));
            cs.setInt(4, jornadaEscolar.getHorasDeEstudio());
            cs.setString(5, jornadaEscolar.getDia().toString());     
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
    public int eliminar(JornadaEscolar jornadaEscolar) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_JORNADAESCOLAR(?)}");
            cs.setInt(1,jornadaEscolar.getIdJornadaEscolar());     
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
    public ArrayList<JornadaEscolar> listarTodos() {
        ArrayList<JornadaEscolar> jornadaEscolarE = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_JORNADAESCOLAR()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                JornadaEscolar jornadaEscolar = new JornadaEscolar();
                jornadaEscolar.setIdJornadaEscolar(rs.getInt("idJornadaEscolar"));
                jornadaEscolar.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                jornadaEscolar.setHoraFin(rs.getTime("horaFin").toLocalTime()); 
                jornadaEscolar.setHorasDeEstudio(rs.getInt("horasDeEstudio")); 
                jornadaEscolar.setDia(DiaSemana.valueOf(rs.getString("dia")));
                
                jornadaEscolarE.add(jornadaEscolar);
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
        return jornadaEscolarE;
    }
    
    @Override
    public JornadaEscolar obtenerPorId(int idJornadaEscolar){
        JornadaEscolar jornadaEscolar = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_JORNADAESCOLAR_POR_ID(?)}");
            cs.setInt(1,idJornadaEscolar);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                jornadaEscolar = new JornadaEscolar();
                jornadaEscolar.setIdJornadaEscolar(rs.getInt("idJornadaEscolar"));
                jornadaEscolar.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                jornadaEscolar.setHoraFin(rs.getTime("horaFin").toLocalTime()); 
                jornadaEscolar.setHorasDeEstudio(rs.getInt("horasDeEstudio")); 
                jornadaEscolar.setDia(DiaSemana.valueOf(rs.getString("dia")));
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
        return jornadaEscolar;
    }

}
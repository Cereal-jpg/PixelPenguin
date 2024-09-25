package pe.edu.pucp.pixelpenguins.curricula.daoImpl;
import java.sql.Connection;
import java.sql.Time;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.HoraAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

public class HoraAcademicaDAOImpl implements HoraAcademicaDAO{
    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(HoraAcademica horaAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_HORAACADEMICA(?,?,?,?,?)}");
            cs.setInt(1,horaAcademica.getIdHoraAcademica());
            cs.setTime(2,Time.valueOf(horaAcademica.getHoraInicio()));
            cs.setTime(3,Time.valueOf(horaAcademica.getHoraFin()));
            cs.setInt(4,horaAcademica.getIdCurso());
            cs.setInt(5,horaAcademica.getCodigoProfesor());      
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
    public int modificar(HoraAcademica horaAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_HORAACADEMICA(?,?,?,?,?)}");
            cs.setInt(1,horaAcademica.getIdHoraAcademica());
            cs.setTime(2,Time.valueOf(horaAcademica.getHoraInicio()));
            cs.setTime(3,Time.valueOf(horaAcademica.getHoraFin()));
            cs.setInt(4,horaAcademica.getIdCurso());
            cs.setInt(5,horaAcademica.getCodigoProfesor());      
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
    public int eliminar(HoraAcademica horaAcademica) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_HORAACADEMICA(?)}");
            cs.setInt(1,horaAcademica.getIdHoraAcademica());     
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
    public ArrayList<HoraAcademica> listarTodos() {
        ArrayList<HoraAcademica> horaAcademicaE = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_HORAACADEMICA()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                HoraAcademica horaAcademica = new HoraAcademica();
                horaAcademica.setIdHoraAcademica(rs.getInt("idHoraAcademica"));
                horaAcademica.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                horaAcademica.setHoraFin(rs.getTime("horaFin").toLocalTime()); 
                horaAcademica.setIdCurso(rs.getInt("idCurso")); 
                horaAcademica.setCodigoProfesor(rs.getInt("codigoProfesor"));
                
                horaAcademicaE.add(horaAcademica);
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
        return horaAcademicaE;
    }
    
    @Override
    public HoraAcademica obtenerPorId(int id_horaAc){
        HoraAcademica horaAcademica = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_HORAACADEMICA_POR_ID(?)}");
            cs.setInt(1,id_horaAc);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                horaAcademica = new HoraAcademica();
                horaAcademica.setIdHoraAcademica(rs.getInt("idHoraAcademica"));
                horaAcademica.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                horaAcademica.setHoraFin(rs.getTime("horaFin").toLocalTime()); 
                horaAcademica.setIdCurso(rs.getInt("idCurso")); 
                horaAcademica.setCodigoProfesor(rs.getInt("codigoProfesor"));
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
        return horaAcademica;
    }
}
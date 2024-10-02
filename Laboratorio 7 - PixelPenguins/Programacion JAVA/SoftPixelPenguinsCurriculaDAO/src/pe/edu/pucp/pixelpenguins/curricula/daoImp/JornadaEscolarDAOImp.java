
package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.Connection;
import java.sql.Time;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public class JornadaEscolarDAOImp implements JornadaEscolarDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(JornadaEscolar jornada) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_JORNADAESCOLAR (?,?,?,?,?,?)}");
            cs.registerOutParameter("p_id", java.sql.Types.INTEGER);
            cs.setInt("p_fid_GradoAcademico", jornada.getGradoRelacionado().getIdGradoAcademico());
            cs.setInt("p_horasDeEstudio", jornada.getHorasDeEstudio());
            cs.setTime("p_horaInicio", Time.valueOf(jornada.getHoraInicio()));
            cs.setTime("p_horaFin", Time.valueOf(jornada.getHoraFin()));
            cs.setString("p_dia", jornada.getDia().toString());
            cs.executeUpdate();
            jornada.setIdJornadaEscolar(cs.getInt("p_id"));
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
    public int modificar(JornadaEscolar jornada) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_JORNADAESCOLAR (?,?,?,?,?,?)}");
            cs.setInt("p_id", jornada.getIdJornadaEscolar());
            cs.setInt("p_fid_GradoAcademico", jornada.getGradoRelacionado().getIdGradoAcademico());
            cs.setInt("p_horasDeEstudio", jornada.getHorasDeEstudio());
            cs.setTime("p_horaInicio", Time.valueOf(jornada.getHoraInicio()));
            cs.setTime("p_horaFin", Time.valueOf(jornada.getHoraFin()));
            cs.setString("p_dia", jornada.getDia().toString());
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
    public int eliminar(JornadaEscolar jornada) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_JORNADAESCOLAR (?)}");
            cs.setInt("p_id", jornada.getIdJornadaEscolar());
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
    public ArrayList<JornadaEscolar> listarTodos() {
        ArrayList<JornadaEscolar> jornadas= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_JORNADAESCOLAR ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                JornadaEscolar jornada=new JornadaEscolar();
                jornada.setIdJornadaEscolar(rs.getInt("idJornadaEscolar"));
                jornada.setGradoRelacionado(new GradoAcademico());
                jornada.getGradoRelacionado().setIdGradoAcademico(rs.getInt("fid_GradoAcademico"));
                /*faltarían pasar los otros atributos de grado para que esté completo*/
                jornada.setHorasDeEstudio(rs.getInt("horasDeEstudio"));
                jornada.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                jornada.setHoraFin(rs.getTime("horaFin").toLocalTime());
                jornada.setDia(DiaSemana.valueOf(rs.getString("dia")));
                jornadas.add(jornada);
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return jornadas;
    }

    @Override
    public JornadaEscolar obtenerPorId(int id) {
        JornadaEscolar jornada=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_JORNADAESCOLAR (?)}");
            cs.setInt("p_id", id);
            rs=cs.executeQuery();
            if(rs.next()){
                jornada=new JornadaEscolar();
                jornada.setIdJornadaEscolar(rs.getInt("idJornadaEscolar"));
                jornada.setGradoRelacionado(new GradoAcademico());
                jornada.getGradoRelacionado().setIdGradoAcademico(rs.getInt("fid_GradoAcademico"));
                /*faltarían pasar los otros atributos de grado para que esté completo*/
                jornada.setHorasDeEstudio(rs.getInt("horasDeEstudio"));
                jornada.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                jornada.setHoraFin(rs.getTime("horaFin").toLocalTime());
                jornada.setDia(DiaSemana.valueOf(rs.getString("dia"))); 
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
        return jornada;
    }
}

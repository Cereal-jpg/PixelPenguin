

package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.CursoDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public class CursoDAOImp implements CursoDAO{
    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Curso curso) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_CURSO (?,?,?,?,?)}");
            cs.registerOutParameter("p_id", java.sql.Types.INTEGER);
            cs.setString("p_codigoCurso", curso.getCodigoCurso());
            cs.setString("p_nombre", curso.getNombre());
            cs.setInt("p_horasPorSemana", curso.getHorasPorSemana());
            cs.setInt("p_horasTotales", curso.getHorasTotales());
            cs.executeUpdate();
            curso.setIdCurso(cs.getInt("p_id"));
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
    public int modificar(Curso curso) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_CURSO (?,?,?,?,?)}");
            cs.setInt("p_id", curso.getIdCurso());
            cs.setString("p_codigoCurso", curso.getCodigoCurso());
            cs.setString("p_nombre", curso.getNombre());
            cs.setInt("p_horasPorSemana", curso.getHorasPorSemana());
            cs.setInt("p_horasTotales", curso.getHorasTotales());
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
    public int eliminar(Curso curso) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_CURSO (?)}");
            cs.setInt("p_id", curso.getIdCurso());
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
    public ArrayList<Curso> listarTodos() {
        ArrayList<Curso> cursos= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_CURSO ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigoCurso(rs.getString("codigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setHorasPorSemana(rs.getInt("horasPorSemana"));
                curso.setHorasTotales(rs.getInt("horasTotales"));
                cursos.add(curso);
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return cursos;
    }

    @Override
    public Curso obtenerPorId(int id) {
        Curso curso=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_CURSO (?)}");
            cs.setInt("p_id", id);
            rs=cs.executeQuery();
            if(rs.next()){
                curso=new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigoCurso(rs.getString("codigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setHorasPorSemana(rs.getInt("horasPorSemana"));
                curso.setHorasTotales(rs.getInt("horasTotales"));
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
        return curso;
    }
    
}

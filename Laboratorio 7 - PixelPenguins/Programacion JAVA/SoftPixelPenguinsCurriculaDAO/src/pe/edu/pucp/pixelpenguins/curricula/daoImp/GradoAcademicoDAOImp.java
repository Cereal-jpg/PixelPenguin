
package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.dao.GradoAcademicoDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;

public class GradoAcademicoDAOImp implements GradoAcademicoDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(GradoAcademico gradoAcademico) {
        int resultado=0;
        Connection con = null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_GRADOACADEMICO (?,?,?,?,?,?)}");
            cs.registerOutParameter("p_id", java.sql.Types.INTEGER);
            cs.setInt("p_idAnioAcademicoRelacionado", gradoAcademico.getIdAnioAcademicoRelacionado());
            cs.setInt("p_numeroGrado", gradoAcademico.getNumeroGrado());
            cs.setString("p_nivel", gradoAcademico.getNivel().toString());
            cs.setInt("p_cantidadAlumnos", gradoAcademico.getCantidadAlumnos());
            cs.setInt("p_vacantes", gradoAcademico.getVacantes());
            cs.executeUpdate();
            gradoAcademico.setIdGradoAcademico(cs.getInt("p_id"));
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
    public int modificar(GradoAcademico gradoAcademico) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call MODIFICAR_GRADOACADEMICO (?,?,?,?,?,?)}");
            cs.setInt("p_id", gradoAcademico.getIdGradoAcademico());
            cs.setInt("p_idAnioAcademicoRelacionado", gradoAcademico.getIdAnioAcademicoRelacionado());
            cs.setInt("p_numeroGrado", gradoAcademico.getNumeroGrado());
            cs.setString("p_nivel", gradoAcademico.getNivel().toString());
            cs.setInt("p_cantidadAlumnos", gradoAcademico.getCantidadAlumnos());
            cs.setInt("p_vacantes", gradoAcademico.getVacantes());
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
    public int eliminar(GradoAcademico gradoAcademico) {
        int resultado=0;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call ELIMINAR_GRADOACADEMICO (?)}");
            cs.setInt("p_id", gradoAcademico.getIdGradoAcademico());
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
    public ArrayList<GradoAcademico> listarTodos() {
        ArrayList<GradoAcademico> grados= new ArrayList<>();
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call LISTAR_TODOS_GRADOACADEMICO ()}");
            rs=cs.executeQuery();
            while(rs.next()){
                GradoAcademico gradoAcademico=new GradoAcademico();
                gradoAcademico.setIdGradoAcademico(rs.getInt("idGradoAcademico"));
                gradoAcademico.setIdAnioAcademicoRelacionado(rs.getInt("idAnioAcademicoRelacionado"));
                gradoAcademico.setNumeroGrado(rs.getInt("numeroGrado"));
                gradoAcademico.setNivel(NivelEducativo.valueOf(rs.getString("nivel")));
                gradoAcademico.setCantidadAlumnos(rs.getInt("cantidadAlumnos"));
                gradoAcademico.setVacantes(rs.getInt("vacantes"));
                grados.add(gradoAcademico);
            }
            rs.close();
            cs.close();
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        } 
        finally{
            try {con.close();} catch (SQLException ex) {System.out.println(ex.getMessage());}
        }
        return grados;
    }

    @Override
    public GradoAcademico obtenerPorId(int id) {
        GradoAcademico gradoAcademico=null;
        try {
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call OBTENER_POR_ID_GRADOACADEMICO (?)}");
            cs.setInt("p_id", id);
            rs=cs.executeQuery();
            if(rs.next()){
                gradoAcademico=new GradoAcademico();
                gradoAcademico.setIdGradoAcademico(rs.getInt("idGradoAcademico"));
                gradoAcademico.setIdAnioAcademicoRelacionado(rs.getInt("idAnioAcademicoRelacionado"));
                gradoAcademico.setNumeroGrado(rs.getInt("numeroGrado"));
                gradoAcademico.setNivel(NivelEducativo.valueOf(rs.getString("nivel")));
                gradoAcademico.setCantidadAlumnos(rs.getInt("cantidadAlumnos"));
                gradoAcademico.setVacantes(rs.getInt("vacantes"));
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
        return gradoAcademico;
    }
}

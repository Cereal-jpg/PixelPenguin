package pe.edu.pucp.pixelpenguins.anioacademico.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PlanAcademicoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.PlanAcademico;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public class PlanAcademicoDAOImpl implements PlanAcademicoDAO {

    private Connection con; 
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(PlanAcademico planAcademico) {
        int resultado = 0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PLAN_ACADEMICO(?,?,?,?,?)}");
            cs.setInt(1, planAcademico.getIdPlanAcademico());
            cs.setInt(2, planAcademico.getAño());
            cs.setDate(3, new java.sql.Date(planAcademico.getFechaInicio().getTime()));
            cs.setDate(4, new java.sql.Date(planAcademico.getFechaFin().getTime()));
            cs.setObject(5, planAcademico.getIdInstitucion()); 
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
    public int modificar(PlanAcademico planAcademico) {
        int resultado = 0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PLAN_ACADEMICO(?,?,?,?,?)}");
            cs.setInt(1, planAcademico.getIdPlanAcademico());
            cs.setInt(2, planAcademico.getAño());
            if (planAcademico.getFechaInicio() != null) {
                cs.setDate(3, new java.sql.Date(planAcademico.getFechaInicio().getTime()));
            } else {
                cs.setNull(3, java.sql.Types.DATE);
            }
            if (planAcademico.getFechaFin() != null) {
                cs.setDate(4, new java.sql.Date(planAcademico.getFechaFin().getTime()));
            } else {
                cs.setNull(4, java.sql.Types.DATE);
            }
            cs.setObject(5, planAcademico.getIdInstitucion());
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
    public int eliminar(PlanAcademico planAcademico) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_PLAN_ACADEMICO(?)}");
            cs.setInt(1,planAcademico.getIdPlanAcademico());
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
    public ArrayList<PlanAcademico> listarTodos() {
    ArrayList<PlanAcademico> planesE = new ArrayList<>();
        try {
               
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_PLANES_ACADEMICOS()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                PlanAcademico plan = new PlanAcademico();
                plan.setIdPlanAcademico(rs.getInt("idPlanAcademico"));
                plan.setAño(rs.getInt("año"));
                plan.setFechaInicio(rs.getDate("fechaInicio"));
                plan.setFechaFin(rs.getDate("fechaFin"));
                plan.setIdInstitucion(rs.getInt("idInstitucion"));

                planesE.add(plan);
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
        return planesE;
    }

    @Override
    public PlanAcademico obtenerPorId(int idPlanAcademico) {
        PlanAcademico plan = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PLAN_POR_ID(?)}");
            cs.setInt(1,idPlanAcademico);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                plan = new PlanAcademico();
                plan.setIdPlanAcademico(rs.getInt("idPlanAcademico"));
                plan.setAño(rs.getInt("año"));
                plan.setFechaInicio(rs.getDate("fechaInicio"));
                plan.setFechaFin(rs.getDate("fechaFin"));
                plan.setIdInstitucion(rs.getInt("idInstitucion"));
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
        return plan;
    }
    
}

package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class PlanAcademico implements IConsultable{
    private int idPlanAcademico;
    private int año;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer idInstitucion;
    private ArrayList<Matricula> matriculas;
    private ArrayList<Curso> cursos;

    public PlanAcademico(int idPlanAcademico, int año, Date fechaInicio, Date fechaFin,Integer idInstitucion) {
        this.idPlanAcademico = idPlanAcademico;
        this.año = año;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idInstitucion = idInstitucion;
        this.matriculas=new ArrayList<Matricula>();
        this.cursos=new ArrayList<Curso>();
    }

    public PlanAcademico() {}
    

    public int getIdPlanAcademico() {
        return idPlanAcademico;
    }

    public void setIdPlanAcademico(int idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
    

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

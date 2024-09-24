package pe.edu.pucp.pixelpenguins.añoacademico.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class PlanAcademico implements IConsultable{
    private int idPlanAcademico;
    private int anio;
    private Date fechaInicio;
    private Date fechaFin;
    private GradoAcademico gradoAcademico;
    private ArrayList<Matricula> matriculas;
    private ArrayList<Curso> cursos;

    public PlanAcademico(int idPlanAcademico, int anio, Date fechaInicio, Date fechaFin) {
        this.idPlanAcademico = idPlanAcademico;
        this.anio = anio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.matriculas=new ArrayList<Matricula>();
        this.cursos=new ArrayList<Curso>();
    }

    public int getIdPlanAcademico() {
        return idPlanAcademico;
    }

    public void setIdPlanAcademico(int idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

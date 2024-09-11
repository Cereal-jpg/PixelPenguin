package pe.edu.pucp.pixelpenguins.añoacademico;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.PixelPenguins.Curricula.Curso;
import pe.edu.pucp.PixelPenguins.Curricula.GradoAcademico;
import pe.edu.pucp.pixelpenguins.IConsultable;

public class PlanAcademico implements IConsultable{
    private int idPlanAcademico;
    private int anio;
    private Date fechaInicio;
    private Date fechaFin;
    private Matricula matricula;
    private GradoAcademico gradoAcademico;
    private ArrayList<Curso> cursos;

    public PlanAcademico(int idPlanAcademico, int anio, Date fechaInicio, Date fechaFin, Matricula matricula) {
        this.idPlanAcademico = idPlanAcademico;
        this.anio = anio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.matricula=matricula;
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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

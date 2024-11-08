package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class AnioAcademico {
    private Integer idAnioAcademico;
    private int anio;
    private Date fechaInicio;
    private Date fechaFin;
    // una AnioAcademico tiene varias matrículas de diferente alumnos
    private ArrayList<Matricula> matriculas;
    private ArrayList<GradoAcademico> gradosAcademicos;

    public AnioAcademico(){}
    
    public AnioAcademico(Integer idAnioAcademico,int anio, Date fechaInicio, Date fechaFin) {
        this.idAnioAcademico=idAnioAcademico;
        this.anio= anio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.matriculas=new ArrayList<>();
        this.gradosAcademicos=new ArrayList<>();
    }

    public Integer getIdAnioAcademico() {
        return idAnioAcademico;
    }

    public void setIdAnioAcademico(Integer idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
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
    
}

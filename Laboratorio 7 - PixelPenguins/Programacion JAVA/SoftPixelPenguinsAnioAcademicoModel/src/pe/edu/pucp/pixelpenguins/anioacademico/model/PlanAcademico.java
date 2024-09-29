
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import java.util.Date;
// faltan enlazar bien
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;
// import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class PlanAcademico implements IConsultable{
    private int idPlanAcademico;
    private int año;
    private Date fechaInicio;
    private Date fechaFin;
    // NO ES NECESARIO ESTE ATRIBUTO
    // private InstitucionEducativa institucionEducativa;
    private ArrayList<Matricula> matriculas;
    private ArrayList<Curso> cursos;

    public PlanAcademico(){}
    
    public PlanAcademico(int idPlanAcademico, int año, Date fechaInicio, Date fechaFin) {
        this.idPlanAcademico = idPlanAcademico;
        this.año = año;
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
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

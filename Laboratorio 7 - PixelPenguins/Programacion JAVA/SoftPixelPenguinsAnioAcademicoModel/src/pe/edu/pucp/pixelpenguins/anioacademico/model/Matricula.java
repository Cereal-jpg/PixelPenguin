
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import java.util.Date;

// falta enlazar bien
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class Matricula implements IConsultable{
    private int idMatricula;
    private boolean cumpleRequisitos;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoDeMatricula estado;
    private GradoAcademico gradoAcademico; // tendrá un FK fid_gradoAcademico en la BD
    private Alumno alumno; // tendrá un FK fid_alumno en la BD
    private PlanAcademico planAcademico; // tendrá un FK fid_planAcademico en la BD
    private ArrayList <Pago> pagos;

    public Matricula(){}
    
    public Matricula(int idMatricula, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin, EstadoDeMatricula estado, GradoAcademico gradoAcademico, Alumno alumno, PlanAcademico planAcademico) {
        this.idMatricula = idMatricula;
        this.cumpleRequisitos = cumpleRequisitos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.gradoAcademico = gradoAcademico;
        this.alumno = alumno;
        this.planAcademico = planAcademico;
        this.pagos=new ArrayList<Pago>();
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public boolean isCumpleRequisitos() {
        return cumpleRequisitos;
    }

    public void setCumpleRequisitos(boolean cumpleRequisitos) {
        this.cumpleRequisitos = cumpleRequisitos;
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

    public EstadoDeMatricula getEstado() {
        return estado;
    }

    public void setEstado(EstadoDeMatricula estado) {
        this.estado = estado;
    }

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PlanAcademico getPlanAcademico() {
        return planAcademico;
    }

    public void setPlanAcademico(PlanAcademico planAcademico) {
        this.planAcademico = planAcademico;
    }
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

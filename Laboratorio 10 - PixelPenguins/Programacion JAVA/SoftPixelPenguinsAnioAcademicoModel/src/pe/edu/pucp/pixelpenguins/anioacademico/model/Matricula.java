
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class Matricula implements IConsultable{
    private int idMatricula;
    private boolean cumpleRequisitos;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoDeMatricula estado;
    private GradoAcademico gradoAcademico; // tendrá un FK fid_GradoAcademico en la BD
    private AnioAcademico anioAcademico; // tendrá un FK fid_AnioAcademico en la BD
    private int fidAlumno;              // para que se relacione con el alumno
    private ArrayList <Pago> pagos;

    public Matricula(){}
    
    public Matricula(boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado, GradoAcademico gradoAcademico, AnioAcademico anioAcademico,
            int fidAlumno) {
        //this.idMatricula = idMatricula;
        this.cumpleRequisitos = cumpleRequisitos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.gradoAcademico = gradoAcademico;
        this.anioAcademico = anioAcademico;
        this.fidAlumno=fidAlumno;
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

    public AnioAcademico getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
    }
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

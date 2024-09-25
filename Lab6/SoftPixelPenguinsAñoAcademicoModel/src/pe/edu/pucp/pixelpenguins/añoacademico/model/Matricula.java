
package pe.edu.pucp.pixelpenguins.añoacademico.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class Matricula implements IConsultable{
    private int idMatricula;
    private boolean cumpleRequisitos;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoDeMatricula estado;
    private ArrayList <Pago> pagos;
    private Integer idGradoAcademico; 
    private Integer codigoAlumno;
    private Integer idPlanAcademico;
    
    public Matricula(int idMatricula, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado) {
        this.idMatricula = idMatricula;
        this.cumpleRequisitos = cumpleRequisitos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado=estado;
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

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(Integer idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public Integer getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(Integer codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Integer getIdPlanAcademico() {
        return idPlanAcademico;
    }

    public void setIdPlanAcademico(Integer idPlanAcademico) {
        this.idPlanAcademico = idPlanAcademico;
    }
    
    
}


package pe.edu.pucp.pixelpenguins.curricula.model;

import java.io.Serializable;

public class HoraAcademica implements Serializable {
    private Integer idHoraAcademica;
    private String horaInicio;
    private String horaFin;
    private Curso curso;
    private DiaSemana dia;
    private SeccionAcademica seccionAcademica;
    
    public HoraAcademica(){}

    public HoraAcademica(String horaInicio, String horaFin, Curso curso, DiaSemana dia, SeccionAcademica seccionAcademica) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.curso = curso;
        this.dia = dia;
        this.seccionAcademica = seccionAcademica;
    }

    public Integer getIdHoraAcademica() {
        return idHoraAcademica;
    }

    public void setIdHoraAcademica(Integer idHoraAcademica) {
        this.idHoraAcademica = idHoraAcademica;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public SeccionAcademica getSeccionAcademica() {
        return seccionAcademica;
    }

    public void setSeccionAcademica(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
    }

}

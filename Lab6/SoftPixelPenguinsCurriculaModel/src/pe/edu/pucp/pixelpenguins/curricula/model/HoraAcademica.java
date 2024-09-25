package pe.edu.pucp.pixelpenguins.curricula.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class HoraAcademica {
    private int idHoraAcademica;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer idCurso;
    private Integer codigoProfesor;

    public HoraAcademica(int idHoraAcademica, LocalTime horaInicio, LocalTime horaFin) {
        this.idHoraAcademica = idHoraAcademica;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        idCurso = null;
        codigoProfesor = null;
    }

    public HoraAcademica() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(Integer codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public int getIdHoraAcademica() {
        return idHoraAcademica;
    }

    public void setIdHoraAcademica(int idHoraAcademica) {
        this.idHoraAcademica = idHoraAcademica;
    }


    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
}

package pe.edu.pucp.pixelpenguins.curricula.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class HoraAcademica {
    private int idHoraAcademica;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Curso curso;

    public HoraAcademica(int idHoraAcademica, LocalTime horaInicio, LocalTime horaFin) {
        this.idHoraAcademica = idHoraAcademica;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdHoraAcademica() {
        return idHoraAcademica;
    }

    public void setIdHoraAcademica(int idHoraAcademica) {
        this.idHoraAcademica = idHoraAcademica;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

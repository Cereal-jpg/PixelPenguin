
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.time.LocalTime;

public class HoraAcademica {
    private int idHoraAcademica;
    private int idProfesorRelacionado;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Curso curso; //tendrá asignada una FK fid_curso en la BD
    
    public HoraAcademica(){}
    
    public HoraAcademica(int idHoraAcademica, int idProfesorRelacionado,
            LocalTime horaInicio, LocalTime horaFin, Curso curso) {
        this.idHoraAcademica = idHoraAcademica;
        this.idProfesorRelacionado = idProfesorRelacionado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.curso = curso;
    }

    public int getIdHoraAcademica() {
        return idHoraAcademica;
    }

    public void setIdHoraAcademica(int idHoraAcademica) {
        this.idHoraAcademica = idHoraAcademica;
    }

    public int getIdProfesorRelacionado() {
        return idProfesorRelacionado;
    }

    public void setIdProfesorRelacionado(int idProfesorRelacionado) {
        this.idProfesorRelacionado = idProfesorRelacionado;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}

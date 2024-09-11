package pe.edu.pucp.PixelPenguins.Curricula;

import java.time.LocalTime;
import java.util.ArrayList;

public class ClaseAcademica {
    private int idClaseAcademica;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Curso curso;

    public ClaseAcademica(int idClaseAcademica, LocalTime horaInicio, LocalTime horaFin) {
        this.idClaseAcademica = idClaseAcademica;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdClaseAcademica() {
        return idClaseAcademica;
    }

    public void setIdClaseAcademica(int idClaseAcademica) {
        this.idClaseAcademica = idClaseAcademica;
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

package pe.edu.pucp.PixelPenguins.Curricula;

import java.time.LocalTime;
import java.util.ArrayList;

public class JornadaEscolar {
    private int idJornadaEscolar;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int horasDeEstudio;
    private DiaSemana dia;
    private ArrayList<ClaseAcademica> clasesAcademicas;

    public JornadaEscolar(int idJornadaEscolar, LocalTime horaInicio, LocalTime horaFin, int horasDeEstudio, DiaSemana dia) {
        this.idJornadaEscolar = idJornadaEscolar;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.horasDeEstudio = horasDeEstudio;
        this.dia = dia;
        clasesAcademicas = new ArrayList<ClaseAcademica>();
    }

    public int getIdJornadaEscolar() {
        return idJornadaEscolar;
    }

    public void setIdJornadaEscolar(int idJornadaEscolar) {
        this.idJornadaEscolar = idJornadaEscolar;
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

    public int getHorasDeEstudio() {
        return horasDeEstudio;
    }

    public void setHorasDeEstudio(int horasDeEstudio) {
        this.horasDeEstudio = horasDeEstudio;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }
    
}

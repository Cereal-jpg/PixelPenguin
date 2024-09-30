
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class JornadaEscolar {
    private int idJornadaEscolar;
    private int horasDeEstudio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private DiaSemana dia;
    private ArrayList<HoraAcademica> horasAcademicas;
    
    public JornadaEscolar(){}
    
    public JornadaEscolar(int horasDeEstudio, LocalTime horaInicio,
            LocalTime horaFin, DiaSemana dia) {
        //this.idJornadaEscolar = idJornadaEscolar;
        this.horasDeEstudio = horasDeEstudio;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
        this.horasAcademicas = new ArrayList<HoraAcademica>();
    }

    public int getIdJornadaEscolar() {
        return idJornadaEscolar;
    }

    public void setIdJornadaEscolar(int idJornadaEscolar) {
        this.idJornadaEscolar = idJornadaEscolar;
    }

    public int getHorasDeEstudio() {
        return horasDeEstudio;
    }

    public void setHorasDeEstudio(int horasDeEstudio) {
        this.horasDeEstudio = horasDeEstudio;
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

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }
    
}

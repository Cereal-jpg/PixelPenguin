
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class JornadaEscolar {
    private int idJornadaEscolar;
    private int horasDeEstudio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private DiaSemana dia;
    private ArrayList<HoraAcademica> clasesAcademicas;
    private ArrayList<GradoAcademico> gradosAcademicos;
    
    public JornadaEscolar(){}
    
    public JornadaEscolar(int idJornadaEscolar, int horasDeEstudio, LocalTime horaInicio, LocalTime horaFin, DiaSemana dia, ArrayList<HoraAcademica> clasesAcademicas, ArrayList<GradoAcademico> gradosAcademicos) {
        this.idJornadaEscolar = idJornadaEscolar;
        this.horasDeEstudio = horasDeEstudio;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
        this.clasesAcademicas = clasesAcademicas;
        this.gradosAcademicos = gradosAcademicos;
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

    public ArrayList<HoraAcademica> getClasesAcademicas() {
        return clasesAcademicas;
    }

    public void setClasesAcademicas(ArrayList<HoraAcademica> clasesAcademicas) {
        this.clasesAcademicas = clasesAcademicas;
    }

    public ArrayList<GradoAcademico> getGradosAcademicos() {
        return gradosAcademicos;
    }

    public void setGradosAcademicos(ArrayList<GradoAcademico> gradosAcademicos) {
        this.gradosAcademicos = gradosAcademicos;
    }
    
}

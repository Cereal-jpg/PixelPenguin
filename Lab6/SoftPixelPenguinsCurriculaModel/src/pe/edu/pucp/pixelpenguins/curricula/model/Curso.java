package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.IConsultable;

public class Curso implements IConsultable{
    private String idCurso;
    private String nombre;
    private int horasPorSemana;
    private int horasTotales;
    private ArrayList<Competencia> competencias;
    private ArrayList<Nota> notas;
    private ArrayList<HoraAcademica> horasAcademicas;

    public Curso(String idCurso, String nombre, int horasPorSemana, int horasTotales) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.horasPorSemana = horasPorSemana;
        this.horasTotales = horasTotales;
        competencias = new ArrayList<Competencia>();
        notas = new ArrayList<Nota>();
        horasAcademicas = new ArrayList<HoraAcademica>();
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasPorSemana() {
        return horasPorSemana;
    }

    public void setHorasPorSemana(int horasPorSemana) {
        this.horasPorSemana = horasPorSemana;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

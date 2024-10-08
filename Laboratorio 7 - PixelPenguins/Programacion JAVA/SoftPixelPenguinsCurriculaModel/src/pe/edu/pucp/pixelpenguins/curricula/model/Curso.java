
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;

public class Curso implements IConsultable{
    private int idCurso;
    private String codigoCurso;
    private String nombre;
    private int horasPorSemana;
    private int horasTotales;
    private ArrayList<Competencia> competencias;
    private ArrayList<Nota> notas;
    private ArrayList<HoraAcademica> horasAcademicas;
    
    public Curso(){}
    
    public Curso(String codigoCurso, String nombre, int horasPorSemana, int horasTotales) {
        this.codigoCurso=codigoCurso;
        this.nombre = nombre;
        this.horasPorSemana = horasPorSemana;
        this.horasTotales = horasTotales;
        competencias = new ArrayList<Competencia>();
        notas = new ArrayList<Nota>();
        horasAcademicas = new ArrayList<HoraAcademica>();
    }

    public Curso(int idCurso, String codigoCurso, String nombre, int horasPorSemana, int horasTotales) {
        this.idCurso = idCurso;
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.horasPorSemana = horasPorSemana;
        this.horasTotales = horasTotales;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
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
        return "";
    }
}

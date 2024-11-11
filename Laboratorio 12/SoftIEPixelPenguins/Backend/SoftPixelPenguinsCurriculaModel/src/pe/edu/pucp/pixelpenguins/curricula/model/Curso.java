
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;

public class Curso {
    private Integer idCurso;
    private int fid_Profesor;
    private String codigoCurso;
    private String nombre;
    private int horasPorSemana;
    private int horasTotales;
    private GradoAcademico gradoAcademico;
    private ArrayList<Competencia> competencias;
    private ArrayList<Nota> notas;
    private ArrayList<HoraAcademica> horasAcademicas;
    
    public Curso(){}
    
    public Curso(Integer idCurso,int fid_Profesor,String codigoCurso, String nombre,
            int horasPorSemana, int horasTotales,GradoAcademico gradoAcademico) {
        this.idCurso=idCurso;
        this.fid_Profesor=fid_Profesor;
        this.codigoCurso=codigoCurso;
        this.nombre = nombre;
        this.horasPorSemana = horasPorSemana;
        this.horasTotales = horasTotales;
        this.gradoAcademico=gradoAcademico;
        competencias = new ArrayList<Competencia>();
        notas = new ArrayList<Nota>();
        horasAcademicas = new ArrayList<HoraAcademica>();
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public int getFid_Profesor() {
        return fid_Profesor;
    }

    public void setFid_Profesor(int fid_Profesor) {
        this.fid_Profesor = fid_Profesor;
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

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
}

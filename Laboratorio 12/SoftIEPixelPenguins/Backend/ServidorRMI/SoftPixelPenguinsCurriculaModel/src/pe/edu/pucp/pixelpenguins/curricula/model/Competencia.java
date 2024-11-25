package pe.edu.pucp.pixelpenguins.curricula.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Competencia implements Serializable {
    private Integer idCompetencia;
    private String descripcion;
    private Curso curso;
    private ArrayList<Nota> notas;
    
    public Competencia(){}
    
    public Competencia(Integer idCompetencia,String descripcion, Curso curso) {
        this.idCompetencia=idCompetencia;
        this.descripcion = descripcion;
        this.curso = curso;
        this.notas=new ArrayList<Nota>();
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}


package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;

public class Competencia {
    private int idCompetencia;
    private String descripcion;
    private Curso curso;
    private ArrayList<Nota> notas;
    
    public Competencia(){}
    
    public Competencia(String descripcion, Curso curso) {
        //this.idCompetencia = idCompetencia;
        this.descripcion = descripcion;
        this.curso = curso;
        this.notas=new ArrayList<Nota>();
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
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

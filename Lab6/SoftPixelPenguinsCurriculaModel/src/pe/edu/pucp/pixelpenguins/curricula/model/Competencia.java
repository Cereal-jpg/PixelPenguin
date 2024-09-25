package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;

public class Competencia {
    private int idCompetencia;
    private String descripcion;
    private ArrayList<Nota> notas;
    private String idCurso;

    public Competencia(int idCompetencia, String descripcion, String idCurso) {
        this.idCompetencia = idCompetencia;
        this.descripcion = descripcion;
        this.idCurso = idCurso;
    }

    public Competencia() {
        
    }
    
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public  int getIdCompetencia() {
        return idCompetencia;
    }

    public  void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

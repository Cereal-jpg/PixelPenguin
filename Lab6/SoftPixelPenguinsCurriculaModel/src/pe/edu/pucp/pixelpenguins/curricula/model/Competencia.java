package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;

public class Competencia {
    private static int idCompetencia;
    private String descripcion;
    private ArrayList<Nota> notas;

    public Competencia(String descripcion) {
        this.descripcion = descripcion;
        this.notas=new ArrayList<>();
    }

    public static int getIdCompetencia() {
        return idCompetencia;
    }

    public static void setIdCompetencia(int idCompetencia) {
        Competencia.idCompetencia = idCompetencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

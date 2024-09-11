package pe.edu.pucp.PixelPenguins.Curricula;

public class Competencia {
    private static int idCompetencia;
    private String descripcion;

    public Competencia(String descripcion) {
        this.descripcion = descripcion;
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

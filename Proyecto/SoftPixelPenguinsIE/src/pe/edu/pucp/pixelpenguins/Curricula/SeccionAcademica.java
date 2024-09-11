package pe.edu.pucp.PixelPenguins.Curricula;

public class SeccionAcademica {
    private int idSeccionAcademica;
    private char seccion;
    private String aula;
    private GradoAcademico grado;

    public SeccionAcademica(int idSeccionAcademica, char seccion, String aula) {
        this.idSeccionAcademica = idSeccionAcademica;
        this.seccion = seccion;
        this.aula = aula;
    }

    public int getIdSeccionAcademica() {
        return idSeccionAcademica;
    }

    public void setIdSeccionAcademica(int idSeccionAcademica) {
        this.idSeccionAcademica = idSeccionAcademica;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
}

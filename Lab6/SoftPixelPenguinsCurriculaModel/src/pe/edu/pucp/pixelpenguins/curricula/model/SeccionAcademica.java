package pe.edu.pucp.pixelpenguins.curricula.model;

public class SeccionAcademica {
    private int idSeccionAcademica;
    private char seccion;
    private String aula;
    private GradoAcademico grado;
    
    public SeccionAcademica(){
        
    }

    public SeccionAcademica(int idSeccionAcademica, char seccion, String aula, GradoAcademico grado) {
        this.idSeccionAcademica = idSeccionAcademica;
        this.seccion = seccion;
        this.aula = aula;
        this.grado = grado;
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

    public GradoAcademico getGrado() {
        return grado;
    }

    public void setGrado(GradoAcademico grado) {
        this.grado = grado;
    }
    
    public int getIdGrado(){
        return grado.getIdGradoAcademico();
    }
    

    
}

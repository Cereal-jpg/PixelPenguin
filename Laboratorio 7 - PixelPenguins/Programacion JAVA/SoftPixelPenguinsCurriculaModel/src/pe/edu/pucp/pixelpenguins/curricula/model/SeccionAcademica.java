
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;
// falta enlazar bien
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;

public class SeccionAcademica {
    private int idSeccionAcademica;
    private char seccion;
    private String aula;
    private GradoAcademico gradoAcademico; // tendrá un FK fid_gradoAcademico
    private ArrayList<Alumno> alumnosPorSeccion; // según el UML estaba así, aunque está complicado

    public SeccionAcademica(){}
    
    public SeccionAcademica(int idSeccionAcademica, char seccion, String aula, GradoAcademico gradoAcademico) {
        this.idSeccionAcademica = idSeccionAcademica;
        this.seccion = seccion;
        this.aula = aula;
        this.gradoAcademico = gradoAcademico;
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

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
}

package pe.edu.pucp.pixelpenguins.usuario;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.PixelPenguins.Curricula.GradoAcademico;
import pe.edu.pucp.PixelPenguins.Curricula.SeccionAcademica;

public class Profesor extends Persona {
    
    private int codigoProfesor;
    private boolean certificadoHistorialEducativo;
    private String especialidad;
    private SeccionAcademica seccionAsignada;
    private ArrayList<GradoAcademico> gradosDeDictado;

    public Profesor(int codigoProfesor, boolean certificadoHistorialEducativo,
            String especialidad, SeccionAcademica seccionAsignada, int dni,
            String nombre, Date fechaNacimiento, String direccion, String email,
            String sexo) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo);
        this.codigoProfesor = codigoProfesor;
        this.certificadoHistorialEducativo = certificadoHistorialEducativo;
        this.especialidad = especialidad;
        this.seccionAsignada = seccionAsignada;
        this.gradosDeDictado = new ArrayList<>();
    }
    
    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public boolean isCertificadoHistorialEducativo() {
        return certificadoHistorialEducativo;
    }

    public void setCertificadoHistorialEducativo(boolean certificadoHistorialEducativo) {
        this.certificadoHistorialEducativo = certificadoHistorialEducativo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String verHorario(){
        
    }
    
    @Override
    public String consultarInformacion(){
        
    }
    
}

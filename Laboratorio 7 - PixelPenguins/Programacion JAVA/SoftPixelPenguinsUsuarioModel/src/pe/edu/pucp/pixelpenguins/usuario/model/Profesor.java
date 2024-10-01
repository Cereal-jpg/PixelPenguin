
package pe.edu.pucp.pixelpenguins.usuario.model;

import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Usuario {
    // solo en la BD
    // private int idProfesor;
    private int codigoProfesor;
    private boolean certificadoHistorialEducativo;
    private String especialidad;
    // profesor tiene un listado de horasAcademicas en gradosAcademicos distintos
    private ArrayList<HoraAcademica> horasAcademicas;
    private ArrayList<GradoAcademico> gradosDeDictado;

    public Profesor(){
        //super();
    }
    
    public Profesor(int codigoProfesor, boolean certificadoHistorialEducativo,
            String especialidad, String dni, String nombre, Date fechaNacimiento, 
            String direccion, String email, String sexo,String username,String password,Rol rol) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo,username,password,rol);
        this.codigoProfesor = codigoProfesor;
        this.certificadoHistorialEducativo = certificadoHistorialEducativo;
        this.especialidad = especialidad;
        this.horasAcademicas=new ArrayList<>();
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
        return "";
    }
    
    @Override
    public String consultarInformacion(){
        return "";
    }
}
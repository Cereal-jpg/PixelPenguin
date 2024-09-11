package pe.edu.pucp.PixelPenguins.Curricula;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.IConsultable;
import pe.edu.pucp.pixelpenguins.usuario.Alumno;

public class GradoAcademico implements IConsultable{
    private int idGradoAcademico;
    private int numeroGrado;
    private NivelEducativo nivel;
    private int cantidadAlumnos;
    private int vacantes;
    private ArrayList<SeccionAcademica> secciones;
    private ArrayList<Alumno> alumnos;
    
    public GradoAcademico(int idGradoAcademico, int numeroGrado, NivelEducativo nivel, int cantidadAlumnos, int vacantes) {
        this.idGradoAcademico = idGradoAcademico;
        this.numeroGrado = numeroGrado;
        this.nivel = nivel;
        this.cantidadAlumnos = cantidadAlumnos;
        this.vacantes = vacantes;
        secciones = new ArrayList<SeccionAcademica>();
        alumnos = new ArrayList<Alumno>();
    }

    public int getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public int getNumeroGrado() {
        return numeroGrado;
    }

    public NivelEducativo getNivel() {
        return nivel;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setIdGradoAcademico(int idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public void setNumeroGrado(int numeroGrado) {
        this.numeroGrado = numeroGrado;
    }

    public void setNivel(NivelEducativo nivel) {
        this.nivel = nivel;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
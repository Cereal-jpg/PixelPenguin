
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GradoAcademico implements Serializable {
    private Integer idGradoAcademico;
    private int numeroGrado;
    private NivelEducativo nivel;
    private int cantidadAlumnos;
    private int vacantes;
    private int fid_AnioAcademico;
    private ArrayList<SeccionAcademica> seccionesAcademicas;
    private ArrayList<Curso> cursosGrado;
    
    public GradoAcademico(){}
    
    public GradoAcademico(Integer idGradoAcademico,int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, int fid_AnioAcademico) {
        this.idGradoAcademico=idGradoAcademico;
        this.numeroGrado = numeroGrado;
        this.nivel = nivel;
        this.cantidadAlumnos = cantidadAlumnos;
        this.vacantes = vacantes;
        this.fid_AnioAcademico=fid_AnioAcademico;
        this.cursosGrado=new ArrayList<>();
        this.seccionesAcademicas=new ArrayList<>();
    }

    public Integer getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(Integer idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public int getNumeroGrado() {
        return numeroGrado;
    }

    public void setNumeroGrado(int numeroGrado) {
        this.numeroGrado = numeroGrado;
    }

    public NivelEducativo getNivel() {
        return nivel;
    }

    public void setNivel(NivelEducativo nivel) {
        this.nivel = nivel;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public int getFid_AnioAcademico() {
        return fid_AnioAcademico;
    }

    public void setFid_AnioAcademico(int idAnioAcademicoRelacionado) {
        this.fid_AnioAcademico = idAnioAcademicoRelacionado;
    }
    
}

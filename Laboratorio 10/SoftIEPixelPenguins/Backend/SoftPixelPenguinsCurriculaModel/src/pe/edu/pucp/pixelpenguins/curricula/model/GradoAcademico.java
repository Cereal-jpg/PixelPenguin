
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;

public class GradoAcademico implements IConsultable{
    private int idGradoAcademico;
    private int numeroGrado;
    private NivelEducativo nivel;
    private int cantidadAlumnos;
    private int vacantes;
    private int fid_AnioAcademico;
    private ArrayList<SeccionAcademica> seccionesAcademicas;
    private ArrayList<Curso> cursosGrado;
    private ArrayList<JornadaEscolar> jornadasPorDia;
    
    public GradoAcademico(){}
    
    public GradoAcademico(int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, int idAnio) {
        this.numeroGrado = numeroGrado;
        this.nivel = nivel;
        this.cantidadAlumnos = cantidadAlumnos;
        this.vacantes = vacantes;
        this.fid_AnioAcademico=idAnio;
        this.cursosGrado=new ArrayList<>();
        this.jornadasPorDia=new ArrayList<>();
        this.seccionesAcademicas=new ArrayList<>();
    }

    public GradoAcademico(int idGradoAcademico, int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, int fid_AnioAcademico) {
        this.idGradoAcademico = idGradoAcademico;
        this.numeroGrado = numeroGrado;
        this.nivel = nivel;
        this.cantidadAlumnos = cantidadAlumnos;
        this.vacantes = vacantes;
        this.fid_AnioAcademico = fid_AnioAcademico;
    }

    public int getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(int idGradoAcademico) {
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

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

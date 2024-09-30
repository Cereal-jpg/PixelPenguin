
package pe.edu.pucp.pixelpenguins.curricula.model;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;

public class GradoAcademico implements IConsultable{
    private int idGradoAcademico;
    private int numeroGrado;
    private NivelEducativo nivel;
    private int cantidadAlumnos;
    private int vacantes;
    private JornadaEscolar jornadaEscolar;
    private int idAnioAcademicoRelacionado;
    private ArrayList<SeccionAcademica> seccionesAcademicas;
    private ArrayList<Curso> cursosGrado;
    private ArrayList<JornadaEscolar> jornadasPorDia;
    
    public GradoAcademico(){}
    
    public GradoAcademico(int idGradoAcademico, int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, JornadaEscolar jornadaEscolar,int idAnio) {
        this.idGradoAcademico = idGradoAcademico;
        this.numeroGrado = numeroGrado;
        this.nivel = nivel;
        this.cantidadAlumnos = cantidadAlumnos;
        this.vacantes = vacantes;
        this.jornadaEscolar = jornadaEscolar;
        this.idAnioAcademicoRelacionado=idAnio;
        this.cursosGrado=new ArrayList<>();
        this.jornadasPorDia=new ArrayList<>();
        this.seccionesAcademicas=new ArrayList<>();
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

    public JornadaEscolar getJornadaEscolar() {
        return jornadaEscolar;
    }

    public void setJornadaEscolar(JornadaEscolar jornadaEscolar) {
        this.jornadaEscolar = jornadaEscolar;
    }

    public int getIdAnioAcademicoRelacionado() {
        return idAnioAcademicoRelacionado;
    }

    public void setIdAnioAcademicoRelacionado(int idAnioAcademicoRelacionado) {
        this.idAnioAcademicoRelacionado = idAnioAcademicoRelacionado;
    }

    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

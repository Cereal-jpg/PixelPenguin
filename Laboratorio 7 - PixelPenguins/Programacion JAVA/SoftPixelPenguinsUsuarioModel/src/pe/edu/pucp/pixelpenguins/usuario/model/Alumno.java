
package pe.edu.pucp.pixelpenguins.usuario.model;

import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import java.util.ArrayList;
import java.util.Date;

public class Alumno extends Usuario {
    
    private int codigoAlumno;
    private boolean conCertificadoDeEstudios;
    private boolean conCertificadoDeSalud;
    private boolean conDeuda;
    private Apoderado apoderado; //necesita un FK fid_apoderado
    private Matricula matricula; // fid_matricula
    private SeccionAcademica seccionAcademica; //fis_seccionAcademica
    private GradoAcademico gradoAcademico; // fid_gradoAcademico
    private ArrayList<Curso> cursosMatriculado;

    public Alumno(){
        //super();
    }

    public Alumno(int codigoAlumno, boolean conCertificadoDeEstudios, boolean conCertificadoDeSalud,
            boolean conDeuda, Apoderado apoderado, Matricula matricula, SeccionAcademica seccionAcademica,
            GradoAcademico gradoAcademico, int dni, String nombre, Date fechaNacimiento, String direccion,
            String email, String sexo, String username, String passsword) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo, username, passsword);
        this.codigoAlumno = codigoAlumno;
        this.conCertificadoDeEstudios = conCertificadoDeEstudios;
        this.conCertificadoDeSalud = conCertificadoDeSalud;
        this.conDeuda = conDeuda;
        this.apoderado = apoderado;
        this.matricula = matricula;
        this.seccionAcademica = seccionAcademica;
        this.gradoAcademico = gradoAcademico;
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public boolean isConCertificadoDeEstudios() {
        return conCertificadoDeEstudios;
    }

    public void setConCertificadoDeEstudios(boolean conCertificadoDeEstudios) {
        this.conCertificadoDeEstudios = conCertificadoDeEstudios;
    }

    public boolean isConCertificadoDeSalud() {
        return conCertificadoDeSalud;
    }

    public void setConCertificadoDeSalud(boolean conCertificadoDeSalud) {
        this.conCertificadoDeSalud = conCertificadoDeSalud;
    }

    public boolean isConDeuda() {
        return conDeuda;
    }

    public void setConDeuda(boolean conDeuda) {
        this.conDeuda = conDeuda;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public SeccionAcademica getSeccionAcademica() {
        return seccionAcademica;
    }

    public void setSeccionAcademica(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
    }

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
    public int matricularse(){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public String consultarEstadoMatricula(){
        return "";
    }
    
    @Override
    public String consultarInformacion(){
        return "";
    }
}

package pe.edu.pucp.pixelpenguins.usuario;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.curricula.Curso;
import pe.edu.pucp.pixelpenguins.curricula.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.añoacademico.Matricula;

public class Alumno extends Usuario {
    
    private int codigoAlumno;
    private boolean certificadoDeEstudios;
    private boolean certificadoDeSalud;
    private boolean deuda;
    private Apoderado apoderado;
    private Matricula matricula;
    private SeccionAcademica seccion;
    private GradoAcademico grado;
    private ArrayList<Curso> cursosMatriculado;

    public Alumno(int codigoAlumno, boolean certificadoDeEstudios, 
            boolean certificadoDeSalud, boolean deuda, Apoderado apoderado, 
            Matricula matricula, SeccionAcademica seccion, GradoAcademico grado, 
            int dni, String nombre, Date fechaNacimiento, String direccion, 
            String email, String sexo,String username,String password) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo,username,password);
        this.codigoAlumno = codigoAlumno;
        this.certificadoDeEstudios = certificadoDeEstudios;
        this.certificadoDeSalud = certificadoDeSalud;
        this.deuda = deuda;
        this.apoderado = apoderado;
        this.matricula = matricula;
        this.seccion = seccion;
        this.grado = grado;
        this.cursosMatriculado=new ArrayList<>();
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public boolean isCertificadoDeEstudios() {
        return certificadoDeEstudios;
    }

    public void setCertificadoDeEstudios(boolean certificadoDeEstudios) {
        this.certificadoDeEstudios = certificadoDeEstudios;
    }

    public boolean isCertificadoDeSalud() {
        return certificadoDeSalud;
    }

    public void setCertificadoDeSalud(boolean certificadoDeSalud) {
        this.certificadoDeSalud = certificadoDeSalud;
    }

    public boolean isDeuda() {
        return deuda;
    }

    public void setDeuda(boolean deuda) {
        this.deuda = deuda;
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

    public SeccionAcademica getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionAcademica seccion) {
        this.seccion = seccion;
    }

    public GradoAcademico getGrado() {
        return grado;
    }

    public void setGrado(GradoAcademico grado) {
        this.grado = grado;
    }
    
    public void matricularse(){
        
    }
    
    public String verEstadoMatricula(){
        return "";
    }
    
    @Override
    public String consultarInformacion(){
        return "";
    }
    
}
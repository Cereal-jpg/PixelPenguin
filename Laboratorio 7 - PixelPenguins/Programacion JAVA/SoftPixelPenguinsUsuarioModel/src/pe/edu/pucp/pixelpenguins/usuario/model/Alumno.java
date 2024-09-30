
package pe.edu.pucp.pixelpenguins.usuario.model;

import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

import java.util.ArrayList;
import java.util.Date;


public class Alumno extends Usuario {
    private int idAlumno;
    private int codigoAlumno;
    private boolean conCertificadoDeEstudios;
    private boolean conCertificadoDeSalud;
    private boolean conDeuda;
    private Apoderado apoderado; //necesita un FK fid_apoderado
    private GradoAcademico gradoAcademico; // fid_gradoAcademico
    // array de matriculas para almacenar un registro por años
    private ArrayList<Matricula> matriculas; 
    private ArrayList<Curso> cursosMatriculado;

    public Alumno(){
        //super();
    }

    public Alumno(int idAlumno, int codigoAlumno, boolean conCertificadoDeEstudios, boolean conCertificadoDeSalud,
            boolean conDeuda, Apoderado apoderado,GradoAcademico gradoAcademico,
            int idUsuario, String dni, String nombre, Date fechaNacimiento, String direccion,
            String email, String sexo, String username, String passsword, Rol rol) {
        super(idUsuario,dni, nombre, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
        this.idAlumno = idAlumno;
        this.codigoAlumno = codigoAlumno;
        this.conCertificadoDeEstudios = conCertificadoDeEstudios;
        this.conCertificadoDeSalud = conCertificadoDeSalud;
        this.conDeuda = conDeuda;
        this.apoderado = apoderado;
        this.gradoAcademico = gradoAcademico;
        this.matriculas=new ArrayList<Matricula>();
        this.cursosMatriculado=new ArrayList<Curso>();
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

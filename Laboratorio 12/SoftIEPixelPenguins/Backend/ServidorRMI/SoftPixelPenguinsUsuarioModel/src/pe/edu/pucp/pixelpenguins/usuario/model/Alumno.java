
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.io.Serializable;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

import java.util.ArrayList;
import java.util.Date;


public class Alumno extends Usuario implements Serializable {
    // solo tiene este dato en la BD, se hereda del idUsuario
    // private int idAlumno; 
    private int codigoAlumno;
    private byte[] certificadoDeEstudios;
    private byte[] certificadoDeSalud;
    private boolean conDeuda;
    private Apoderado apoderado; //necesita un FK fid_apoderado
    private GradoAcademico gradoAcademico; // fid_gradoAcademico
    private EstadoAlumno estado;
    // array de matriculas para almacenar un registro por años
    private ArrayList<Matricula> matriculas; 
    private ArrayList<Curso> cursosMatriculado;

    public Alumno(){
        super();
    }
    
    public Alumno(Integer idUsuario, String dni, String nombreCompleto, Date fechaNacimiento,
            String direccion, String email, String sexo, String username, String passsword, Rol rol,
            int codigoAlumno, byte[] certificadoDeEstudios, byte[] certificadoDeSalud,
            boolean conDeuda, Apoderado apoderado, GradoAcademico gradoAcademico) {
        super(idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
        this.codigoAlumno = codigoAlumno;
        this.certificadoDeEstudios = certificadoDeEstudios;
        this.certificadoDeSalud = certificadoDeSalud;
        this.conDeuda = conDeuda;
        this.apoderado = apoderado;
        this.gradoAcademico = gradoAcademico;
        this.matriculas=new ArrayList<Matricula>();
        this.cursosMatriculado=new ArrayList<Curso>();
    }
    
    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public byte[] getCertificadoDeEstudios() {
        return certificadoDeEstudios;
    }

    public void setCertificadoDeEstudios(byte[] certificadoDeEstudios) {
        this.certificadoDeEstudios = certificadoDeEstudios;
    }

    public byte[] getCertificadoDeSalud() {
        return certificadoDeSalud;
    }

    public void setCertificadoDeSalud(byte[] certificadoDeSalud) {
        this.certificadoDeSalud = certificadoDeSalud;
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
    
    public EstadoAlumno getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlumno estado) {
        this.estado = estado;
    }
    
}

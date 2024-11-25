
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.io.Serializable;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Usuario implements Serializable {
    // solo en la BD
    // private int idProfesor;
    private int codigoProfesor;
    private byte[] certificadoHistorialEducativo;
    private String especialidad;
    // profesor tiene un listado de horasAcademicas en gradosAcademicos distintos
    private ArrayList<HoraAcademica> horasAcademicas;
    private ArrayList<GradoAcademico> gradosDeDictado;
    
    public Profesor() {
        super();
    }

    public Profesor(Integer idUsuario, String dni, String nombreCompleto, Date fechaNacimiento,
            String direccion, String email, String sexo, String username, String passsword, Rol rol,
            int codigoProfesor, byte[] certificadoHistorialEducativo, String especialidad ) {
        super(idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
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

    public byte[] isCertificadoHistorialEducativo() {
        return certificadoHistorialEducativo;
    }

    public void setCertificadoHistorialEducativo(byte[] certificadoHistorialEducativo) {
        this.certificadoHistorialEducativo = certificadoHistorialEducativo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}

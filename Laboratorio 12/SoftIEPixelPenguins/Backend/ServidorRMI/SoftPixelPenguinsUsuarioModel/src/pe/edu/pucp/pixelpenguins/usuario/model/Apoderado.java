
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.io.Serializable;

public class Apoderado implements Serializable {
    private int idApoderado;
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private String relacion; //padre,madre,etc.
    public Apoderado(){}
    
    public Apoderado(String dni, String nombreCompleto, String telefono,String relacion) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.relacion=relacion;
    }
    
    public Apoderado(int idApoderado, String dni, String nombreCompleto, String telefono,
            String relacion) {
        this.idApoderado = idApoderado;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.relacion=relacion;
    }

    public int getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(int idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

}

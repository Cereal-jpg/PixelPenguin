package pe.edu.pucp.lp2soft.rrhh.model;

import java.util.Date;

public class Persona {
    private int idPersona;
    private String nombreCompleto;
    private String DNI;
    private Date fechaNacimiento;
    private int edad;
    private char genero;
    public Persona(){}

    public Persona(String nombreCompleto, String DNI, Date fechaNacimiento, int edad, char genero) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    
    
}
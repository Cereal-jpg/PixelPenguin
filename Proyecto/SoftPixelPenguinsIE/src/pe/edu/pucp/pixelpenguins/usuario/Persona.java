package pe.edu.pucp.pixelpenguins.usuario;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.IConsultable;

public abstract class Persona implements IConsultable {
    
    private int dni;
    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private String email;
    private String sexo;

    public Persona(int dni, String nombre, Date fechaNacimiento, String direccion,
            String email, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public abstract String consultarInformacion();
    
}

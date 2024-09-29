
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;

public abstract class Usuario implements IConsultable{
    private int idUsuario;
    private String dni;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String direccion;
    private String email;
    private String sexo;
    private String username;
    private String passsword;
    
    public Usuario(){}
    
    public Usuario(int idUsuario,String dni, String nombre, Date fechaNacimiento, String direccion, String email, String sexo, String username, String passsword) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombreCompleto = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
        this.username = username;
        this.passsword = passsword;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public void setNombreCompleto(String nombre) {
        this.nombreCompleto = nombre;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
    
    @Override
    public abstract String consultarInformacion();
}

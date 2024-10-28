
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;

public abstract class Usuario implements IConsultable {
    protected int idUsuario;
    protected String dni;
    protected String nombreCompleto;
    protected Date fechaNacimiento;
    protected String direccion;
    protected String email;
    protected String sexo;
    protected String username;
    protected String password;
    protected Rol rol;
    
    public Usuario(){}
    
    public Usuario(String dni, String nombre, Date fechaNacimiento,
            String direccion, String email, String sexo, String username, 
            String password, Rol rol) {
        //this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombreCompleto = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
        this.username = username;
        this.password = password;
        this.rol=rol;
    }

    public Usuario(int idUsuario, String dni, String nombreCompleto, Date fechaNacimiento,
            String direccion, String email, String sexo, String username, 
            String password, Rol rol) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
        this.username = username;
        this.password = password;
        this.rol = rol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Override
    public abstract String consultarInformacion();
    
}

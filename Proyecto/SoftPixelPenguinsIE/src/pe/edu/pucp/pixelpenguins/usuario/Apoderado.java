package pe.edu.pucp.pixelpenguins.usuario;

import java.util.Date;

public class Apoderado extends Persona {
    
    private String telefono;

    public Apoderado(String telefono, int dni, String nombre,
            Date fechaNacimiento, String direccion, String email, String sexo) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String consultarInformacion(){
        
    }
    
}

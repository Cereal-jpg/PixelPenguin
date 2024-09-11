package pe.edu.pucp.pixelpenguins.usuario;

import java.util.Date;

public class Administrador extends Persona {
    
    private int codigoAdministrador;

    public Administrador(int codigoAdministrador, int dni, String nombre,
            Date fechaNacimiento, String direccion, String email, String sexo) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo);
        this.codigoAdministrador = codigoAdministrador;
    }

    public int getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(int codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
    
    @Override
    public String consultarInformacion(){
        
    }
    
}

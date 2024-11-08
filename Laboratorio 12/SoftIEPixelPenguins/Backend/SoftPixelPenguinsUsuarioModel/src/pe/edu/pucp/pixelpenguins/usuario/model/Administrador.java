
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;

public class Administrador extends Usuario {
    // Solo en la BD, se hereda del idUsuario
    // private int idAdministrador;
    private int codigoAdministrador;
    
    public Administrador(){
        super();
    }
    
    public Administrador(int codigoAdministrador, Integer idUsuario, String dni,
            String nombreCompleto, Date fechaNacimiento, String direccion, String email,
            String sexo, String username, String passsword, Rol rol) {
        super(idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
        this.codigoAdministrador = codigoAdministrador;
    }
    
    public int getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(int codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
    
}

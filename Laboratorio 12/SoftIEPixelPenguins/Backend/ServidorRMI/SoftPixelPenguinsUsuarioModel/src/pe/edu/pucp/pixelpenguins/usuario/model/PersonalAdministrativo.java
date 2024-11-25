
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.io.Serializable;
import java.util.Date;

// es un miembro del EquipoAdministrativo
public class PersonalAdministrativo extends Usuario implements Serializable {
    // solo en la BD, lo hereda de idUsuario
    // private int idPersonalAdministrativo;
    private int codigoPersonalAdministrativo;
    
    public PersonalAdministrativo() {
        super();
    }

    public PersonalAdministrativo(int codigoPersonalAdministrativo, int idUsuario,
            String dni, String nombreCompleto, Date fechaNacimiento, String direccion,
            String email, String sexo, String username, String passsword, Rol rol) {
        super(idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
        this.codigoPersonalAdministrativo = codigoPersonalAdministrativo;
    }

    public int getCodigoPersonalAdministrativo() {
        return codigoPersonalAdministrativo;
    }

    public void setCodigoPersonalAdministrativo(int codigoPersonalAdministrativo) {
        this.codigoPersonalAdministrativo = codigoPersonalAdministrativo;
    }
    
}

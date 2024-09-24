package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;

public class Administrador extends Usuario{
    
    private int codigoAdministrador;

    public Administrador(int idEquipoAdministrativo, int dni, String nombre, Date fechaNacimiento, 
            String direccion, String email, String sexo, String username, String password)  {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo,username,password);
        this.codigoAdministrador = codigoAdministrador;
    }

    public int getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(int codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
    
    public boolean insertarUsuario(Usuario usuario){
        return true;
    }
    
    @Override
    public String consultarInformacion(){
        return "";
    }
    
}

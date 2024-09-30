
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;

public class Administrador extends Usuario {
    private int idAdministrador;
    private int codigoAdministrador;
    
    public Administrador(){
        //super();
    }
    
    public Administrador(int idAdministrador,int codigoAdministrador, int idUsuario,
            String dni, String nombre, Date fechaNacimiento,String direccion, 
            String email, String sexo, String username, String passsword, Rol rol) {
        super(idUsuario, dni, nombre, fechaNacimiento, direccion, email, sexo, username, passsword, rol);
        this.idAdministrador = idAdministrador;
        this.codigoAdministrador = codigoAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    
    public int getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(int codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }
    
    public int insertarAlumno(Alumno alumno){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public int insertarProfesor(Profesor profesor){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public int insertarPersonal(PersonalAdministrativo personal){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    @Override
    public String consultarInformacion(){
        return "";
    }
    
}

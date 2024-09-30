
package pe.edu.pucp.pixelpenguins.usuario.model;

import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import java.util.Date;

// es un miembro del EquipoAdministrativo
public class PersonalAdministrativo extends Usuario{
    // solo en la BD, lo hereda de idUsuario
    // private int idPersonalAdministrativo;
    private int codigoPersonalAdministrativo;
    
    public PersonalAdministrativo() {
        super();
    }

    public PersonalAdministrativo(int codigoPersonalAdministrativo,
            String dni, String nombre, Date fechaNacimiento, String direccion,
            String email, String sexo, String username, String passsword, Rol rol) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo, username, passsword,rol);
        this.codigoPersonalAdministrativo=codigoPersonalAdministrativo;
    }

    public int getCodigoPersonalAdministrativo() {
        return codigoPersonalAdministrativo;
    }

    public void setCodigoPersonalAdministrativo(int codigoPersonalAdministrativo) {
        this.codigoPersonalAdministrativo = codigoPersonalAdministrativo;
    }
    
    public int insertarAlumno(){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public void listarAlumnos(){
        
    }
    
    public int eliminarAlumno(){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public Usuario buscarUsuario(int dni){
        Usuario user=null;
        
        return user;
    }
    
    public String consultarReporteDeNotasPorAlumno(){
        return "";
    }
    
    public String consultarReporteDeMatriculasPorGrado(){
        return "";
    }
    
    public String consultarReporteDePagosPorAlumno(){
        return "";
    }
    
    public int agregarAnioAcademico(AnioAcademico anioAcademico){
        int resultado=0;
        /*codigo*/
        return resultado;
    }
    
    public void generarOrdenesDePago(){
        
    }
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

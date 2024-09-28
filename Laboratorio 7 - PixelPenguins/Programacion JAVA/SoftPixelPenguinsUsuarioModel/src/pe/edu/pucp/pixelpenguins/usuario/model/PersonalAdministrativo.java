
package pe.edu.pucp.pixelpenguins.usuario.model;

import java.util.Date;

// es un miembro del EquipoAdministrativo
public class PersonalAdministrativo extends Usuario{
    private int idPersonalAdministrativo;

    public PersonalAdministrativo() {
        super();
    }

    public PersonalAdministrativo(int dni, String nombre, Date fechaNacimiento, String direccion, String email, String sexo, String username, String passsword) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo, username, passsword);
    }

    public int getIdPersonalAdministrativo() {
        return idPersonalAdministrativo;
    }

    public void setIdPersonalAdministrativo(int idPersonalAdministrativo) {
        this.idPersonalAdministrativo = idPersonalAdministrativo;
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
    
    public int agregarPlanAcademico(PlanAcademico plan){
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

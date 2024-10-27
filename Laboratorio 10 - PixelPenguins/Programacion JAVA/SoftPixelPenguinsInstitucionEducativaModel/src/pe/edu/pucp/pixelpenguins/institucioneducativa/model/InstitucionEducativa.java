
package pe.edu.pucp.pixelpenguins.institucioneducativa.model;

import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public class InstitucionEducativa {
    private int idInstitucion;
    private String nombre;
    private int cantidadAlumnos;
    private String direccion;
    private String ruc;
    
    public InstitucionEducativa(){}
    
     // es autoincremental el ID
    public InstitucionEducativa(String nombre, int cantidadAlumnos, String direccion, String ruc) {
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
        this.direccion = direccion;
        this.ruc = ruc;
    }
    
    public InstitucionEducativa(int idInstitucion, String nombre, int cantidadAlumnos, String direccion, String ruc) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
        this.direccion = direccion;
        this.ruc = ruc;
    }
     
   
    
    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public void listarUsuarios(){
        
    }
    
//    public Usuario buscarUsuario(int codigo){
//        Usuario user=new Alumno();
//        Usuario user2=new Profesor();
//        Usuario user3=new PersonalAdministrativo();
//        return user;
//    }
//    
//    public int agregarUsuario(Usuario usuario){
//        int resultado=0;
//        
//        return resultado;
//    }
//    
//    public int agregarAnioAcademico(AnioAcademico anioAcademico){
//        int resultado=0;
//        
//        return resultado;
//    }
    
    public int eliminarUsuario(){
        int resultado=0;
        
        return resultado;
    }
    
    public String reporteDeNotasPorAlumno(){
        return "";
    }
    
    public String reporteDeNotasPorGrado(){
        return "";
    }
    
    public String reporteDePagosPorAlumno(){
        return "";
    }
}

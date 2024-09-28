
package pe.edu.pucp.pixelpenguins.institucioneducativa.model;


public class InstitucionEducativa {
    private int idInstitucion;
    private String nombre;
    private int cantidadAlumnos;
    private String direccion;
    private int ruc;

    public InstitucionEducativa(int idInstitucion, String nombre, int cantidadAlumnos, String direccion, int ruc) {
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

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    
    public void listarUsuarios(){
        
    }
    
    public Usuario buscarUsuario(int codigo){
        Usuario user;
        return user;
    }
    
    public int agregarUsuario(){
        int resultado=0;
        
        return resultado;
    }
    
    public int agregarPlanAcademico(){
        int resultado=0;
        
        return resultado;
    }
    
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

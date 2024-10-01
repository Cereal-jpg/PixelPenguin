
package pe.edu.pucp.pixelpenguins.usuario.model;

public class Rol {
    private int idRol;
    private String nombre;
    private boolean activo;
    
    public Rol(){}
    
    // para casos de INSERT, se deberían hacer sin asignar una id
    // en específico, ya que esta se genera automáticamente
    public Rol(String nombre) {
        this.nombre = nombre;
        this.activo = true;
    }
    
    // aún así, se está dejando su constructor normal para 
    // casos como MODIFICAR, ELIMINAR, etc que requieran otro con la misma id
    public Rol(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Rol(int id) {
        this.idRol = id;
    }
    
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}

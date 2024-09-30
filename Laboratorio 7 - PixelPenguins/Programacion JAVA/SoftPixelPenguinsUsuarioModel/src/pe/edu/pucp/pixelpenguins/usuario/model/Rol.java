
package pe.edu.pucp.pixelpenguins.usuario.model;

public class Rol {
    private int idRol;
    private String nombre;
    
    public Rol(){}
    
    // los constructores al estar con AUTO_INCREMENT para su id, 
    // deberían ser omitidos (solo nombre)
    public Rol(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
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
    
    
}

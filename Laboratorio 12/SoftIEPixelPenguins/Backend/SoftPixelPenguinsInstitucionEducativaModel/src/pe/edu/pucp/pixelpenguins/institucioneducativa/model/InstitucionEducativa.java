
package pe.edu.pucp.pixelpenguins.institucioneducativa.model;

public class InstitucionEducativa {
    private Integer idInstitucion;
    private String nombre;
    private int cantidadAlumnos;
    private String direccion;
    private String ruc;
    
    public InstitucionEducativa(){}
    
    public InstitucionEducativa(Integer idInstitucion, String nombre, int cantidadAlumnos, String direccion, String ruc) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
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
  
}

package pe.edu.pucp.pixelpenguins.usuario.model;


public class Apoderado {
    
    private int dni;
    private String telefono;
    
    public Apoderado(int dni, String telefono) {
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

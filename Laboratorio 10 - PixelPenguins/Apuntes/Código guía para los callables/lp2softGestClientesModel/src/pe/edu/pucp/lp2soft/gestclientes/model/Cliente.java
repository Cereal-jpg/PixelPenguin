package pe.edu.pucp.lp2soft.gestclientes.model;
import java.util.Date;
import pe.edu.pucp.lp2soft.rrhh.model.Persona;
public class Cliente extends Persona{
    private Categoria categoria;

    public Cliente(String nombreCompleto, String DNI, Date fechaNacimiento,int edad,
            char genero, Categoria categoria) {
        super(nombreCompleto, DNI, fechaNacimiento, edad,genero);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
package pe.edu.pucp.lp2soft.rrhh.model;
import java.util.ArrayList;

public class Area {
    private int idArea;
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Area(int idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }
    
    public Area(){
        
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
}

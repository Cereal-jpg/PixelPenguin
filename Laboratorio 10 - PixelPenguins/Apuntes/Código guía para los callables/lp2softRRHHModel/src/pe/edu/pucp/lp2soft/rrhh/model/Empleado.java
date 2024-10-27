package pe.edu.pucp.lp2soft.rrhh.model;

import java.util.Date;

public class Empleado extends Persona{
    private String cargo;
    private double sueldo;
    private Area area;

    public Empleado(String nombreCompleto, String DNI, Date fechaNacimiento,
            int edad, char genero, String cargo, double sueldo, Area area) {
        super(nombreCompleto, DNI, fechaNacimiento, edad, genero);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.area = area;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
}

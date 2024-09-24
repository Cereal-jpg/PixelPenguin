/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.usuario;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.añoacademico.PlanAcademico;

/**
 *
 * @author Enzo
 */
public class EquipoAdministrativo extends Usuario {
    private int idEquipoAdministrativo;

    public EquipoAdministrativo(int idEquipoAdministrativo, int dni, String nombre, Date fechaNacimiento, 
            String direccion, String email, String sexo, String username, String password) {
        super(dni, nombre, fechaNacimiento, direccion, email, sexo,username,password);
        this.idEquipoAdministrativo = idEquipoAdministrativo;
    }

    public int getIdEquipoAdministrativo() {
        return idEquipoAdministrativo;
    }

    public void setIdEquipoAdministrativo(int idEquipoAdministrativo) {
        this.idEquipoAdministrativo = idEquipoAdministrativo;
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
    
    public String buscarPersona(int dni){
        return "";
    }
    
    public boolean agregarPlanAcademico(PlanAcademico planAcademico){
        
        return true;
    }
    
    public boolean generarOrdenesDePago(){
        
        return true;
    }
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

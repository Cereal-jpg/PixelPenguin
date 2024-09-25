/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.institucioneducativa.model;

import java.util.ArrayList;

import pe.edu.pucp.pixelpenguins.añoacademico.model.PlanAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

/**
 *
 * @author User
 */
public class InstitucionEducativa {

    private int idInstitucion;
    private String nombre;
    private int cantidadAlumnos;
    private String direccion;
    private int ruc;
    private ArrayList<Usuario> usuarios;
    private ArrayList<GradoAcademico> gradosAcademicos;
    private ArrayList<PlanAcademico> planesAcademicos;
    
    public InstitucionEducativa(int idInstitucion, String nombre, int cantidadAlumnos, String direccion, int ruc) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public InstitucionEducativa() {
        
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

    public ArrayList<Usuario> getPersonas() {
        return usuarios;
    }

    public void setPersonas(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<GradoAcademico> getGradosAcademicos() {
        return gradosAcademicos;
    }

    public void setGradosAcademicos(ArrayList<GradoAcademico> gradosAcademicos) {
        this.gradosAcademicos = gradosAcademicos;
    }

    public ArrayList<PlanAcademico> getPlanesAcademicos() {
        return planesAcademicos;
    }

    public void setPlanesAcademicos(ArrayList<PlanAcademico> planesAcademicos) {
        this.planesAcademicos = planesAcademicos;
    }
    
    
    public String buscarPersona(int id){
        return "";
    }
    
    public void agregarPersona(Usuario persona){
        
    }
    
    public void agregarPlanAcademico(PlanAcademico pa){
        
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

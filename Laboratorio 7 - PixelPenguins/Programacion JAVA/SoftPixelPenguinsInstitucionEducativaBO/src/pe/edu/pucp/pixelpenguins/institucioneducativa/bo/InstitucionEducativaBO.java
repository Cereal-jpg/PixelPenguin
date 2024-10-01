
package pe.edu.pucp.pixelpenguins.institucioneducativa.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucionEducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.daoImp.InstitucionEducativaDAOImp;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;


public class InstitucionEducativaBO {
    private InstitucionEducativaDAO ieDAO;
    
    public InstitucionEducativaBO(){
        this.ieDAO=new InstitucionEducativaDAOImp();
    }
    
    public int insertar(String nombre, int cantidadAlumnos, String direccion, String ruc){
        InstitucionEducativa ie = new InstitucionEducativa(nombre, cantidadAlumnos, direccion, ruc);
        return ieDAO.insertar(ie);
    }
    
    public int modificar(int idInstitucion, String nombre, int cantidadAlumnos, String direccion, String ruc){
        InstitucionEducativa ie = new InstitucionEducativa(idInstitucion, nombre, cantidadAlumnos, direccion, ruc);
        return ieDAO.modificar(ie);
    }
    
    public int eliminar(int idInstitucion, String nombre, int cantidadAlumnos, String direccion, String ruc){
        InstitucionEducativa ie = new InstitucionEducativa(idInstitucion, nombre, cantidadAlumnos, direccion, ruc);
        return ieDAO.eliminar(ie);
    }
    
    public ArrayList<InstitucionEducativa> listarTodos(){
        return ieDAO.listarTodos();
    }
    
    public InstitucionEducativa obtenerPorId(int id){
        return ieDAO.obtenerPorId(id);
    }
}

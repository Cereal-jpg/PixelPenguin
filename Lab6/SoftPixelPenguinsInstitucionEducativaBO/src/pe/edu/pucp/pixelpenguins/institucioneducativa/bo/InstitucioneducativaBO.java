/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.institucioneducativa.bo;

import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucioneducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.daoImpl.InstitucioneducativaDAOImpl;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

/**
 *
 * @author Danicela
 */
public class InstitucioneducativaBO {
    private InstitucioneducativaDAO institucionEducativaDAO;
    
    public InstitucioneducativaBO(){
        this.institucionEducativaDAO = new InstitucioneducativaDAOImpl();
        
    }
    //int idInstitucion, String nombre, int cantidadAlumnos, String direccion, int ruc
    public int insertar(int idInstitucion,String nombre,int cantidadAlumnos,
                String direccion,int ruc){
        
        InstitucionEducativa institucion = new InstitucionEducativa(idInstitucion, 
                                        nombre, cantidadAlumnos, direccion, ruc);
        return institucionEducativaDAO.insertar(institucion);
    }
    public int modificar(int idInstitucion,String nombre,int cantidadAlumnos,
                String direccion,int ruc){
        InstitucionEducativa institucion = new InstitucionEducativa(idInstitucion, 
                                        nombre, cantidadAlumnos, direccion, ruc);
        return institucionEducativaDAO.modificar(institucion);
    }
}

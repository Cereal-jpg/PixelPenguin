/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.pe.edu.pucp.pixelpenguins.institucioneducativa.bo;

import src.pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucioneducativaDAO;
import src.pe.edu.pucp.pixelpenguins.institucioneducativa.daoImpl.InstitucioneducativaDAOImpl;
import src.pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

/**
 *
 * @author Danicela
 */
public class InstitucioneducativaBO {
    private InstitucioneducativaDAO instituionDAO;
    
    public InstitucioneducativaBO(){
        this.instituionDAO = new InstitucioneducativaDAOImpl();
        
    }
    //int idInstitucion, String nombre, int cantidadAlumnos, String direccion, int ruc
    public int insertar(int idInstitucion,String nombre,int cantidadAlumnos,
                String direccion,int ruc){
        
        InstitucionEducativa institucion = new InstitucionEducativa(idInstitucion, 
                                        nombre, cantidadAlumnos, direccion, ruc);
        return instituionDAO.insertar(institucion);
    }
    public int modificar(int idInstitucion,String nombre,int cantidadAlumnos,
                String direccion,int ruc){
        InstitucionEducativa institucion = new InstitucionEducativa(idInstitucion, 
                                        nombre, cantidadAlumnos, direccion, ruc);
        return instituionDAO.modificar(institucion);
    }
}

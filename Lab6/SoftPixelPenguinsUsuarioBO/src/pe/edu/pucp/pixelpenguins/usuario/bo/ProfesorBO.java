
package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.ProfesorDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImpl.ProfesorDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public class ProfesorBO {
    private ProfesorDAO profesorDAO;
    
    public ProfesorBO(){
        this.profesorDAO=new ProfesorDAOImpl();
    }
    
    public int insertar(int codigoProfesor,boolean certificadoHistorialEducativo,
            String especialdad, int dni, String nombre, Date fechaNacimiento, 
            String direccion, String email, String sexo, String username, String password){
        Profesor profesor=new Profesor(codigoProfesor, certificadoHistorialEducativo, 
                especialdad, dni, nombre, fechaNacimiento, direccion, email, 
                sexo, username, password);
        return this.profesorDAO.insertar(profesor);
    }
}

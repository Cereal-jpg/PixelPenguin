package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.ProfesorDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.ProfesorDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public class ProfesorBO {
    
    private final ProfesorDAO profesorDAO;

    public ProfesorBO() {
        this.profesorDAO = new ProfesorDAOImpl();
    }

    public Integer insertar(Profesor profesor) {
        return this.profesorDAO.insertar(profesor);
    }

    public Integer modificar(Profesor profesor) {
        return this.profesorDAO.modificar(profesor);
    }
    
    public Integer eliminar(Profesor profesor) {
        return this.profesorDAO.eliminar(profesor);
    }

    public ArrayList<Profesor> listarTodos() {
        return this.profesorDAO.listarTodos();
    }

    public Profesor obtenerPorId(Integer idUsuario) {
        return this.profesorDAO.obtenerPorId(idUsuario);
    }

    public Boolean existeProfesor(Integer idUsuario) {
        Profesor profesor = new Profesor();
        profesor.setIdUsuario(idUsuario);
        return this.profesorDAO.existeProfesor(profesor);
    }
    
    public ArrayList<Profesor>listarProfesoresPorNombre(String nombre){
        return this.profesorDAO.listarProfesoresPorNombre(nombre);
    }
    
}

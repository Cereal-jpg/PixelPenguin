package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.ProfesorDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.ProfesorDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class ProfesorBO {
    
    private final ProfesorDAO profesorDAO;

    public ProfesorBO() {
        this.profesorDAO = new ProfesorDAOImpl();
    }

    public Integer insertar(int codigoProfesor, boolean certificadoHistorialEducativo, String especialidad, String dni, String nombreCompleto, Date fechaNacimiento, String direccion, String email, String sexo, String username, String password, Rol rol) {
        Profesor profesor = new Profesor(codigoProfesor, certificadoHistorialEducativo, especialidad, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, rol);
        return this.profesorDAO.insertar(profesor);
    }

    public Integer modificar(int codigoProfesor, Integer idUsuario, String dni, String nombreCompleto, Date fechaNacimiento, String direccion, String email, String sexo, String username, String password, Rol rol) {
        Profesor profesor = new Profesor(codigoProfesor, false, null, idUsuario, dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, rol);
        return this.profesorDAO.modificar(profesor);
    }

    public Integer eliminar(Integer idUsuario) {
        Profesor profesor = new Profesor();
        profesor.setIdUsuario(idUsuario);
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
    
}

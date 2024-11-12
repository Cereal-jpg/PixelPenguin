package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.AlumnoDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

public class AlumnoBO {
    
    private final AlumnoDAO alumnoDAO;

    public AlumnoBO() {
        this.alumnoDAO = new AlumnoDAOImpl();
    }
    
    public Integer insertar(Alumno alumno) {
        return this.alumnoDAO.insertar(alumno);
    }

    public Integer modificar(Alumno alumno) {
        return this.alumnoDAO.modificar(alumno);
    }
    
    public Integer eliminar(Alumno alumno) {
        return this.alumnoDAO.eliminar(alumno);
    }

    public ArrayList<Alumno> listarTodos() {
        return this.alumnoDAO.listarTodos();
    }

    public Alumno obtenerPorId(Integer idUsuario) {
        return this.alumnoDAO.obtenerPorId(idUsuario);
    }
    
    public ArrayList<Alumno>listarAlumnosPorNombreYEstado(String nombre, EstadoAlumno estado) {
        return this.alumnoDAO.listarAlumnosPorNombreYEstado(nombre,estado);
    }
    
    public ArrayList<Alumno>listarAlumnosPorNombre(String nombre) {
        return this.alumnoDAO.listarAlumnosPorNombre(nombre);
    }

    public Boolean existeAlumno(Integer idUsuario) {
        Alumno alumno = new Alumno();
        alumno.setIdUsuario(idUsuario);
        return this.alumnoDAO.existeAlumno(alumno);
    }
    
}

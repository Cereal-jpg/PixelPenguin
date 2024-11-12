package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.EstadoAlumno;

public interface AlumnoDAO {
    public Integer insertar(Alumno alumno);
    public Integer modificar(Alumno alumno);
    public Integer eliminar(Alumno alumno);
    public ArrayList<Alumno> listarTodos();
    public Alumno obtenerPorId (Integer idAlumno);
    public ArrayList<Alumno>listarAlumnosPorNombreYEstado(String nombre, EstadoAlumno estado);
    public ArrayList<Alumno> listarAlumnosPorNombre(String nombre);
    public Boolean existeAlumno(Alumno alumno);
    public Boolean existeAlumno(Alumno alumno, Boolean abreConexion);
}

package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;

public interface AlumnoDAO {
    public Integer insertar(Alumno alumno);
    public Integer modificar(Alumno alumno);
    public Integer eliminar(Alumno alumno);
    public ArrayList<Alumno> listarTodos();
    public Alumno obtenerPorId (Integer idAlumno);
    public Boolean existeAlumno(Alumno alumno);
    public Boolean existeAlumno(Alumno alumno, Boolean abreConexion);
}

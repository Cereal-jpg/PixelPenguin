package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Profesor;

public interface ProfesorDAO {
    public Integer insertar(Profesor profesor);
    public Integer modificar(Profesor profesor);
    public Integer eliminar(Profesor profesor);
    public ArrayList<Profesor> listarTodos();
    public Profesor obtenerPorId (Integer idProfesor);
    public Boolean existeProfesor(Profesor profesor);
    public Boolean existeProfesor(Profesor profesor, Boolean abreConexion);
}

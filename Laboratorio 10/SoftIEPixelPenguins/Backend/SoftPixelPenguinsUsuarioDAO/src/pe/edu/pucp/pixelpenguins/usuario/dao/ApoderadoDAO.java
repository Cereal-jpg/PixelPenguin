package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

public interface ApoderadoDAO {
    public Integer insertar(Apoderado apoderado);
    public Integer modificar(Apoderado apoderado);
    public Integer eliminar(Apoderado apoderado);
    public ArrayList<Apoderado> listarTodos();
    public Apoderado obtenerPorId (Integer idApoderado);
}

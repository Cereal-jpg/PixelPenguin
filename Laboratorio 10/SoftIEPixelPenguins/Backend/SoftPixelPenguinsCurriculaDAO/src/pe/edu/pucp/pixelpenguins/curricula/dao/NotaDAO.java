package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

public interface NotaDAO {
    public Integer insertar(Nota nota);
    public Integer modificar(Nota nota);
    public Integer eliminar(Nota nota);
    public ArrayList<Nota> listarTodos();
    public Nota obtenerPorId(Integer idNota);
}

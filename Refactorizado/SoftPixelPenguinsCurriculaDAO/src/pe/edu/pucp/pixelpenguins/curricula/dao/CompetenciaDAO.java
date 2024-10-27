package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;

public interface CompetenciaDAO {
    public Integer insertar(Competencia competencia);
    public Integer modificar(Competencia competencia);
    public Integer eliminar(Competencia competencia);
    public ArrayList<Competencia> listarTodos();
    public Competencia obtenerPorId(Integer idCompencia);
}

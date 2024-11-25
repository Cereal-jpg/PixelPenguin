package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;


public interface GradoAcademicoDAO {
    public Integer insertar(GradoAcademico gradoAcademico);
    public Integer modificar(GradoAcademico gradoAcademico);
    public Integer eliminar(GradoAcademico gradoAcademico);
    public ArrayList<GradoAcademico> listarTodos();
    public GradoAcademico obtenerPorId(Integer id);
}

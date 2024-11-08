package pe.edu.pucp.pixelpenguins.curricula.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

public interface HoraAcademicaDAO {
    public Integer insertar(HoraAcademica horaAcademica);
    public Integer modificar(HoraAcademica horaAcademica);
    public Integer eliminar(HoraAcademica horaAcademica);
    public ArrayList<HoraAcademica> listarTodos();
    public HoraAcademica obtenerPorId(Integer idHoraAcademica);
}

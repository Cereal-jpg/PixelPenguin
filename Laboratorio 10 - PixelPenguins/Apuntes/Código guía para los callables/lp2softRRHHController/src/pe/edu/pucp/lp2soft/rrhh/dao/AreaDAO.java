package pe.edu.pucp.lp2soft.rrhh.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
public interface AreaDAO {
    public ArrayList<Area> listar();
    public int insertar(Area area);
    public int modificar(Area area);
    public int eliminar(int idArea);
}
package pe.edu.pucp.lp2soft.rrhh.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
public interface EmpleadoDAO {
    public ArrayList<Empleado> listar();
    public int insertar(Empleado empleado);
    public int modificar(Empleado empleado);
    public int eliminar(int idEmpleado);
}
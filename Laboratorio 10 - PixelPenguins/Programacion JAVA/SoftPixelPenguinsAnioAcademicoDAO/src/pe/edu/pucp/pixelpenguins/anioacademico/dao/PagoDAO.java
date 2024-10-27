
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

public interface PagoDAO {
    public int insertar(Pago pago);
    public int modificar(Pago pago);
    public int eliminar(Pago pago);
    public ArrayList<Pago> listarTodos();
    public int obtenerPorId(int idPago);
}

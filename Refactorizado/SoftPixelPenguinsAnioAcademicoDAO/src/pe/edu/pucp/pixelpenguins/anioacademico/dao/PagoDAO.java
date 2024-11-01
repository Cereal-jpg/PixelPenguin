
package pe.edu.pucp.pixelpenguins.anioacademico.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;

public interface PagoDAO {
    public Integer insertar(Pago pago);
    public Integer modificar(Pago pago);
    public Integer eliminar(Pago pago);
    public ArrayList<Pago> listarTodos();
    public Pago obtenerPorId(Integer idPago);
}

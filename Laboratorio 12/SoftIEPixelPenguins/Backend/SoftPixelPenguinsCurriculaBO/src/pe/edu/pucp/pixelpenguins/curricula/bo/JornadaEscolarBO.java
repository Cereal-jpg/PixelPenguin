package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.JornadaEscolarDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public class JornadaEscolarBO {
    
    private JornadaEscolarDAO jornadaEscolarDAO;

    public JornadaEscolarBO() {
        this.jornadaEscolarDAO = new JornadaEscolarDAOImpl();
    }
    
    public Integer insertar(JornadaEscolar jornadaEscolar) {
        return this.jornadaEscolarDAO.insertar(jornadaEscolar);
    }
    
    public Integer modificar(JornadaEscolar jornadaEscolar) {
        return this.jornadaEscolarDAO.modificar(jornadaEscolar);
    }
    
    public Integer eliminar(JornadaEscolar jornadaEscolar) {
        return this.jornadaEscolarDAO.eliminar(jornadaEscolar);
    }

    public ArrayList<JornadaEscolar> listarTodos() {
        return this.jornadaEscolarDAO.listarTodos();
    }

    public JornadaEscolar obtenerPorId(Integer idJornadaEscolar) {
        return this.jornadaEscolarDAO.obtenerPorId(idJornadaEscolar);
    }

}

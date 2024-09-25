package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImpl.JornadaEscolarDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public class JornadaEscolarBO {
    private JornadaEscolarDAO jornadaEscolarDAO;
    
    public JornadaEscolarBO(){
        this.jornadaEscolarDAO = new JornadaEscolarDAOImpl();
    }
    
    public int insertar(int idJornadaEscolar, LocalTime horaInicio, LocalTime horaFin, 
            int horasDeEstudio, DiaSemana dia){
        
        JornadaEscolar jornadaEscolar = new JornadaEscolar(idJornadaEscolar, horaInicio, 
                horaFin, horasDeEstudio, dia);
        return jornadaEscolarDAO.insertar(jornadaEscolar);
    }
    public int modificar(int idJornadaEscolar, LocalTime horaInicio, LocalTime horaFin, 
            int horasDeEstudio, DiaSemana dia){
        JornadaEscolar jornadaEscolar = new JornadaEscolar(idJornadaEscolar, horaInicio, 
                horaFin, horasDeEstudio, dia);
        return jornadaEscolarDAO.modificar(jornadaEscolar);
    }
    
    public int eliminar(int idJornadaEscolar, LocalTime horaInicio, LocalTime horaFin, 
            int horasDeEstudio, DiaSemana dia){
        JornadaEscolar jornadaEscolar = new JornadaEscolar(idJornadaEscolar, horaInicio, 
                horaFin, horasDeEstudio, dia);
        return jornadaEscolarDAO.eliminar(jornadaEscolar);
    }
    
    public ArrayList<JornadaEscolar> listarTodos(){
        return jornadaEscolarDAO.listarTodos();
    }
    
    public JornadaEscolar obtenerPorId(int idJornada){
        return jornadaEscolarDAO.obtenerPorId(idJornada);
    }
}
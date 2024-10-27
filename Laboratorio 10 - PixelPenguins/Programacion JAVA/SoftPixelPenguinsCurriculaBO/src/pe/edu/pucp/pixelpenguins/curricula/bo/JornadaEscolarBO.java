
package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.JornadaEscolarDAOImp;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;

public class JornadaEscolarBO {
    private JornadaEscolarDAO jornadaDAO;
    
    public JornadaEscolarBO(){
        this.jornadaDAO=new JornadaEscolarDAOImp();
    }
    
    public int insertar(int horasDeEstudio, LocalTime horaInicio, LocalTime horaFin,
            DiaSemana dia, GradoAcademico gradoRelacionado){
        JornadaEscolar jornada=new JornadaEscolar(horasDeEstudio, horaInicio, horaFin, dia, gradoRelacionado);
        return jornadaDAO.insertar(jornada);
    }
    
    public int modificar(int idJornadaEscolar, int horasDeEstudio, LocalTime horaInicio, LocalTime horaFin,
            DiaSemana dia, GradoAcademico gradoRelacionado){
        JornadaEscolar jornada=new JornadaEscolar(idJornadaEscolar, horasDeEstudio, horaInicio, horaFin, dia, gradoRelacionado);
        return jornadaDAO.modificar(jornada);
    }
    
    public int eliminar(int idJornadaEscolar, int horasDeEstudio, LocalTime horaInicio, LocalTime horaFin,
            DiaSemana dia, GradoAcademico gradoRelacionado){
        JornadaEscolar jornada=new JornadaEscolar(idJornadaEscolar, horasDeEstudio, horaInicio, horaFin, dia, gradoRelacionado);
        return jornadaDAO.eliminar(jornada);
    }
    
    public ArrayList<JornadaEscolar> listarTodos(){
        return jornadaDAO.listarTodos();
    }
    
    public JornadaEscolar obtenerPorId(int id){
        return jornadaDAO.obtenerPorId(id);
    }
}

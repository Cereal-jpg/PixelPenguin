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

    public Integer insertar(Integer horasDeEstudio, LocalTime horaInicio, LocalTime horaFin, DiaSemana dia, Integer idGradoAcademico) {
        JornadaEscolar jornadaEscolar = this.crearJornadaEscolar(horasDeEstudio, horaInicio, horaFin, dia, idGradoAcademico);
        return this.jornadaEscolarDAO.insertar(jornadaEscolar);
    }
    
    public Integer insertar(JornadaEscolar jornadaEscolar) {
        return this.jornadaEscolarDAO.insertar(jornadaEscolar);
    }

    public Integer modificar(Integer idJornadaEscolar, Integer horasDeEstudio, LocalTime horaInicio, LocalTime horaFin, DiaSemana dia, Integer idGradoAcademico) {
        JornadaEscolar jornadaEscolar = this.crearJornadaEscolar(horasDeEstudio, horaInicio, horaFin, dia, idGradoAcademico);
        jornadaEscolar.setIdJornadaEscolar(idJornadaEscolar);
        return this.jornadaEscolarDAO.modificar(jornadaEscolar);
    }
    
    public Integer modificar(JornadaEscolar jornadaEscolar) {
        return this.jornadaEscolarDAO.modificar(jornadaEscolar);
    }

    public Integer eliminar(Integer idJornadaEscolar) {
        JornadaEscolar jornadaEscolar = new JornadaEscolar();
        jornadaEscolar.setIdJornadaEscolar(idJornadaEscolar);
        return this.jornadaEscolarDAO.eliminar(jornadaEscolar);
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

    private JornadaEscolar crearJornadaEscolar(Integer horasDeEstudio, LocalTime horaInicio, LocalTime horaFin, DiaSemana dia, Integer idGradoAcademico) {
        GradoAcademico grado = new GradoAcademico();
        grado.setIdGradoAcademico(idGradoAcademico);

        JornadaEscolar jornadaEscolar = new JornadaEscolar();
        jornadaEscolar.setHorasDeEstudio(horasDeEstudio);
        jornadaEscolar.setHoraInicio(horaInicio);
        jornadaEscolar.setHoraFin(horaFin);
        jornadaEscolar.setDia(dia);
        jornadaEscolar.setGradoRelacionado(grado);
        
        return jornadaEscolar;
    }
    
}

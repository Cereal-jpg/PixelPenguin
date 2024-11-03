package pe.edu.pucp.pixelpenguins.curricula.bo;

import pe.edu.pucp.pixelpenguins.curricula.dao.HoraAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;
import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.daoImpl.HoraAcademicaDAOImpl;

public class HoraAcademicaBO {
    private HoraAcademicaDAO horaAcademicaDAO;

    public HoraAcademicaBO(){
        this.horaAcademicaDAO = new HoraAcademicaDAOImpl();
    }

    public int insertar(int idHoraAcademica, LocalTime horaInicio, LocalTime horaFin){

        HoraAcademica horaAcademica = new HoraAcademica(idHoraAcademica, horaInicio, horaFin);
        return horaAcademicaDAO.insertar(horaAcademica);
    }
    public int modificar(int idHoraAcademica, LocalTime horaInicio, LocalTime horaFin){
        HoraAcademica horaAcademica = new HoraAcademica(idHoraAcademica, horaInicio, horaFin);
        return horaAcademicaDAO.modificar(horaAcademica);
    }

    public int eliminar(int idHoraAcademica, LocalTime horaInicio, LocalTime horaFin){
        HoraAcademica horaAcademica = new HoraAcademica(idHoraAcademica, horaInicio, horaFin);
        return horaAcademicaDAO.eliminar(horaAcademica);
    }

    public ArrayList<HoraAcademica> listarTodos(){
        return horaAcademicaDAO.listarTodos();
    }

    public HoraAcademica obtenerPorId(int idHoraAcademica){
        return horaAcademicaDAO.obtenerPorId(idHoraAcademica);
    }
}
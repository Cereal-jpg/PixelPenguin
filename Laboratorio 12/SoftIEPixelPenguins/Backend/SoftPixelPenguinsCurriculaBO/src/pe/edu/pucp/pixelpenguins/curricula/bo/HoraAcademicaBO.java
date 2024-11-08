package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.HoraAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.HoraAcademicaDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;

public class HoraAcademicaBO {
    
    private HoraAcademicaDAO horaAcademicaDAO;

    public HoraAcademicaBO() {
        this.horaAcademicaDAO = new HoraAcademicaDAOImpl();
    }
    
    public Integer insertar(HoraAcademica horaAcademica) {
        return this.horaAcademicaDAO.insertar(horaAcademica);
    }
    
    public Integer modificar(HoraAcademica horaAcademica) {
        return this.horaAcademicaDAO.modificar(horaAcademica);
    }
    
    public Integer eliminar(HoraAcademica horaAcademica) {
        return this.horaAcademicaDAO.eliminar(horaAcademica);
    }

    public ArrayList<HoraAcademica> listarTodos() {
        return this.horaAcademicaDAO.listarTodos();
    }

    public HoraAcademica obtenerPorId(Integer idHoraAcademica) {
        return this.horaAcademicaDAO.obtenerPorId(idHoraAcademica);
    }
    
}

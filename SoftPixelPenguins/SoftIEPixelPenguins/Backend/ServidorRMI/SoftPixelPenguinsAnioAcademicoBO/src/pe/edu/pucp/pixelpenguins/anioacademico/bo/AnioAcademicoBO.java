package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.AnioAcademicoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.AnioAcademicoDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public class AnioAcademicoBO {
    private AnioAcademicoDAO anioDAO;
    
    public AnioAcademicoBO(){
        this.anioDAO = new AnioAcademicoDAOImpl();
    }
    
    public Integer insertar(AnioAcademico anioAcademico){
        return anioDAO.insertar(anioAcademico);
    }
    
    public Integer modificar(AnioAcademico anioAcademico){
        return anioDAO.modificar(anioAcademico);
    }
    
    public Integer eliminar(AnioAcademico anioAcademico){
        return anioDAO.eliminar(anioAcademico);
    }
    
    public ArrayList<AnioAcademico> listarTodos(){
        return anioDAO.listarTodos();
    }
    
    public AnioAcademico obtenerPorId(Integer idAnioAcademico){
        return anioDAO.obtenerPorId(idAnioAcademico);
    }
}

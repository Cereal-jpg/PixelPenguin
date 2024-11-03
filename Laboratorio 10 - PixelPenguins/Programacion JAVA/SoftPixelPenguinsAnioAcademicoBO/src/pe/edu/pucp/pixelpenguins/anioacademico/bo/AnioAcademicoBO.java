
package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.AnioAcademicoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.AnioAcademicoDAOImp;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

public class AnioAcademicoBO {
    private AnioAcademicoDAO anioDAO;
    
    public AnioAcademicoBO(){
        this.anioDAO=new AnioAcademicoDAOImp();
    }
    
    public int insertar(int anio, Date fechaInicio, Date fechaFin){
        AnioAcademico anioAux= new AnioAcademico(anio, fechaInicio, fechaFin);
        return anioDAO.insertar(anioAux);
    }
    
    public int modificar(int idAnioAcademico, int anio, Date fechaInicio, Date fechaFin){
        AnioAcademico anioAux= new AnioAcademico(idAnioAcademico, anio, fechaInicio, fechaFin);
        return anioDAO.modificar(anioAux);
    }
    
    public int eliminar(int idAnioAcademico, int anio, Date fechaInicio, Date fechaFin){
        AnioAcademico anioAux= new AnioAcademico(idAnioAcademico, anio, fechaInicio, fechaFin);
        return anioDAO.eliminar(anioAux);
    }
    
    public ArrayList<AnioAcademico> listarTodos(){
        return anioDAO.listarTodos();
    }
    
    public AnioAcademico obtenerPorId(int id){
        return anioDAO.obtenerPorId(id);
    }
}


package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.GradoAcademicoDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.GradoAcademicoDAOImp;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;

public class GradoAcademicoBO {
    private GradoAcademicoDAO gradoDAO;
    
    public GradoAcademicoBO(){
        this.gradoDAO=new GradoAcademicoDAOImp();
    }
    
    public int insertar(int numeroGrado, NivelEducativo nivel,int cantidadAlumnos,
            int vacantes, int idAnioAcademicoRelacionado){
        GradoAcademico grado=new GradoAcademico(numeroGrado, nivel, cantidadAlumnos, vacantes, idAnioAcademicoRelacionado);
        return gradoDAO.insertar(grado);
    }
    
    public int modificar(int idGradoAcademico, int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, int idAnioAcademicoRelacionado){
        GradoAcademico grado=new GradoAcademico(idGradoAcademico, numeroGrado, nivel, 
                cantidadAlumnos, vacantes, idAnioAcademicoRelacionado);
        return gradoDAO.modificar(grado);
    }
    
    public int eliminar(int idGradoAcademico, int numeroGrado, NivelEducativo nivel,
            int cantidadAlumnos, int vacantes, int idAnioAcademicoRelacionado){
        GradoAcademico grado=new GradoAcademico(idGradoAcademico, numeroGrado, nivel, 
                cantidadAlumnos, vacantes, idAnioAcademicoRelacionado);
        return gradoDAO.eliminar(grado);
    }
    
    public ArrayList<GradoAcademico> listarTodos(){
        return gradoDAO.listarTodos();
    }
    
    public GradoAcademico obtenerPorId(int id){
        return gradoDAO.obtenerPorId(id);
    }
}

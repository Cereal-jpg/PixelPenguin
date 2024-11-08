
package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.GradoAcademicoDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.GradoAcademicoDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;

public class GradoAcademicoBO {
    
    private GradoAcademicoDAO gradoAcademicoDAO;

    public GradoAcademicoBO() {
        this.gradoAcademicoDAO = new GradoAcademicoDAOImpl();
    }
    
    public Integer insertar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.insertar(gradoAcademico);
    }
    
    public Integer modificar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.modificar(gradoAcademico);
    }
    
    public Integer eliminar(GradoAcademico gradoAcademico) {
        return this.gradoAcademicoDAO.eliminar(gradoAcademico);
    }

    public ArrayList<GradoAcademico> listarTodos() {
        return this.gradoAcademicoDAO.listarTodos();
    }

    public GradoAcademico obtenerPorId(Integer idGradoAcademico) {
        return this.gradoAcademicoDAO.obtenerPorId(idGradoAcademico);
    }

}

package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.PersonalAdministrativoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.PersonalAdministrativoDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class PersonalAdministrativoBO {

    private final PersonalAdministrativoDAO personalAdministrativoDAO;

    public PersonalAdministrativoBO() {
        this.personalAdministrativoDAO = new PersonalAdministrativoDAOImpl();
    }
    
    public Integer insertar(PersonalAdministrativo personalAdministrativo) {
        return this.personalAdministrativoDAO.insertar(personalAdministrativo);
    }
    
    public Integer modificar(PersonalAdministrativo personalAdministrativo) {
        return this.personalAdministrativoDAO.modificar(personalAdministrativo);
    }
    
    public Integer eliminar(PersonalAdministrativo personalAdministrativo) {
        return this.personalAdministrativoDAO.eliminar(personalAdministrativo);
    }

    public ArrayList<PersonalAdministrativo> listarTodos() {
        return this.personalAdministrativoDAO.listarTodos();
    }

    public PersonalAdministrativo obtenerPorId(Integer idUsuario) {
        return this.personalAdministrativoDAO.obtenerPorId(idUsuario);
    }

    public Boolean existePersonalAdministrativo(Integer idUsuario) {
        PersonalAdministrativo personalAdministrativo = new PersonalAdministrativo();
        personalAdministrativo.setIdUsuario(idUsuario);
        return this.personalAdministrativoDAO.existePersonal(personalAdministrativo);
    }
    
}

package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;

public interface PersonalAdministrativoDAO {
    public Integer insertar(PersonalAdministrativo personalAdministrativo);
    public Integer modificar(PersonalAdministrativo personalAdministrativo);
    public Integer eliminar(PersonalAdministrativo personalAdministrativo);
    public ArrayList<PersonalAdministrativo> listarTodos();
    public PersonalAdministrativo obtenerPorId (Integer idPersonalAdministrativo);
    public Boolean existePersonal(PersonalAdministrativo personalAdministrativo);
    public Boolean existePersonal(PersonalAdministrativo personalAdministrativo, Boolean abreConexion);
}

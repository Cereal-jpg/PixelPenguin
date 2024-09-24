
package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.usuario.dao.EquipoAdministrativoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImpl.EquipoAdministrativoDAOImpl;

import pe.edu.pucp.pixelpenguins.usuario.model.EquipoAdministrativo;

public class EquipoAdministrativoBO {
    private EquipoAdministrativoDAO equipoAdministrativoDAO;

    public EquipoAdministrativoBO() {
        this.equipoAdministrativoDAO=new EquipoAdministrativoDAOImpl();
    }
    
    public int insertar(int idEquipoAdministrativo, int dni, String nombre, Date fechaNacimiento, 
            String direccion, String email, String sexo, String username, String password){
        EquipoAdministrativo equipoAdministrativo=new EquipoAdministrativo(idEquipoAdministrativo,
                dni, nombre, fechaNacimiento, direccion, email,sexo, username, password);
        return this.equipoAdministrativoDAO.insertar(equipoAdministrativo);
    }
}

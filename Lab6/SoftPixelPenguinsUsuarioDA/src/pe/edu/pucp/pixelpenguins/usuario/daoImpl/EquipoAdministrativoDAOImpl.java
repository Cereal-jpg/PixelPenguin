
package pe.edu.pucp.pixelpenguins.usuario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.EquipoAdministrativoDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.EquipoAdministrativo;

public class EquipoAdministrativoDAOImpl extends DAOImpl 
        implements EquipoAdministrativoDAO{
    
    private EquipoAdministrativo equipoAdministrativo;

    public EquipoAdministrativoDAOImpl(){
        //Nombre de la tabla
        super("EquipoAdministrativo");
        this.equipoAdministrativo=null;
    }
    
    @Override
    public int insertar(EquipoAdministrativo equipoAdministrativo){
        this.equipoAdministrativo=equipoAdministrativo;
        return this.insertar();
    }

    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "idEquipoAdministrativo, dni, nombre, fechaNacimiento," +
        " direccion, email, sexo, username, password";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql=""+equipoAdministrativo.getIdEquipoAdministrativo()+", "+
                equipoAdministrativo.getDni()+", '"+equipoAdministrativo.getNombre()+
                "', "+equipoAdministrativo.getFechaNacimiento()+", '"+
                equipoAdministrativo.getDireccion()+"', '"+equipoAdministrativo.getEmail()
                +"', '"+equipoAdministrativo.getSexo()+"', '"+
                equipoAdministrativo.getUsername()+"', '"+
                equipoAdministrativo.getPasssword()+"'";
        return sql;
    }

    @Override
    public int modificar(EquipoAdministrativo equipoAdministrativo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(EquipoAdministrativo equipoAdministrativo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EquipoAdministrativo> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EquipoAdministrativo obtenerPorId(String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

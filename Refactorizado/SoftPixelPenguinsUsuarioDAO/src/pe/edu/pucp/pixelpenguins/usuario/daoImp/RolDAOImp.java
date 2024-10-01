
package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolDAOImp extends DAOImpl implements RolDAO{
    
    private Rol rol;

    public RolDAOImp() {
        super("Rol");
        this.rol = null;
    }
    
    @Override
    public Integer insertar(Rol rol) {
        this.rol = rol;
        return this.insertar();
    }

    @Override
    public Integer modificar(Rol rol) {
        this.rol = rol;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Rol> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Rol obtenerPorId(int idRol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "nombre, activo";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.rol.getNombre() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + (this.rol.isActivo()? 1 : 0) + "'");
        return sql;
    }

    @Override
    protected String obtenerListaAtributosYValoresParaModificar() {
        return "nombre = '" + rol.getNombre() + "' , activo = '" + (this.rol.isActivo()? 1 : 0) + "'";
    }

    @Override
    protected String obtenerCondicionesParaModificar() {
        return "idRol = " + rol.getIdRol();
    }
    
}


package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolDAOImp extends DAOImpl<Rol> implements RolDAO{
    
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
        this.rol = rol;
        return this.eliminar();
    }
    
    @Override
    public Rol obtenerPorId(int idRol) {
        this.rol = new Rol(idRol);
        return this.obtenerPorId();
    }

    @Override
    public ArrayList<Rol> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    protected Rol mapearEntidadDesdeResultSet(ResultSet rs) {
        Rol aux = null;
        try {
            aux = new Rol();
            aux.setIdRol(rs.getInt("idRol"));
            aux.setNombre(rs.getString("nombre"));
            aux.setActivo(rs.getBoolean("activo"));
        } catch (SQLException ex) {
            Logger.getLogger(RolDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    
    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "nombre, activo";
    }
    
    @Override
    protected String obtenerListaAtributosParaListar() {
        return "idRol, nombre, activo";
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
    protected String obtenerIdentificador() {
        return "idRol = " + rol.getIdRol();
    }
    
}

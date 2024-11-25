
package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.RolDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class RolDAOImpl extends DAOImpl implements RolDAO {
    
    private Rol rol;

    public RolDAOImpl() {
        super("Rol");
        this.rol = null;
    }

    @Override
    public Integer insertar(Rol rol) {
        this.rol = rol;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.rol.getNombre());
    }

    @Override
    public Integer modificar(Rol rol) {
        this.rol = rol;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idRol=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.rol.getNombre());
        this.incluirParametroInt(2, this.rol.getIdRol());
    }

    @Override
    public Integer eliminar(Rol rol) {
        this.rol = rol;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.rol.getIdRol());
    }

    @Override
    public ArrayList<Rol> listarTodos() {
        return (ArrayList<Rol>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idRol, nombre";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.rol = new Rol();
        this.rol.setIdRol(resultSet.getInt("idRol"));
        this.rol.setNombre(resultSet.getString("nombre"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.rol);
    }

    @Override
    public Rol obtenerPorId(Integer idRol) {
        this.rol = new Rol();
        this.rol.setIdRol(idRol);
        super.obtenerPorId();
        return this.rol;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.rol.getIdRol());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.rol = null;
    }
    
}

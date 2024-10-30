package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.ApoderadoDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

public class ApoderadoDAOImpl extends DAOImpl implements ApoderadoDAO {
    
    private Apoderado apoderado;

    public ApoderadoDAOImpl() {
        super("Apoderado");
        this.apoderado = null;
    }

    @Override
    public Integer insertar(Apoderado apoderado) {
        this.apoderado = apoderado;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "dni, nombreCompleto, telefono, relacion";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.apoderado.getDni());
        this.incluirParametroString(2, this.apoderado.getNombreCompleto());
        this.incluirParametroString(3, this.apoderado.getTelefono());
        this.incluirParametroString(4, this.apoderado.getRelacion());
    }

    @Override
    public Integer modificar(Apoderado apoderado) {
        this.apoderado = apoderado;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "dni=?, nombreCompleto=?, telefono=?, relacion=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idApoderado=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.apoderado.getDni());
        this.incluirParametroString(2, this.apoderado.getNombreCompleto());
        this.incluirParametroString(3, this.apoderado.getTelefono());
        this.incluirParametroString(4, this.apoderado.getRelacion());
        this.incluirParametroInt(5, this.apoderado.getIdApoderado());
    }

    @Override
    public Integer eliminar(Apoderado apoderado) {
        this.apoderado = apoderado;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.apoderado.getIdApoderado());
    }

    @Override
    public ArrayList<Apoderado> listarTodos() {
        return (ArrayList<Apoderado>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idApoderado, dni, nombreCompleto, telefono, relacion";
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.apoderado = new Apoderado();
        this.apoderado.setIdApoderado(resultSet.getInt("idApoderado"));
        this.apoderado.setDni(resultSet.getString("dni"));
        this.apoderado.setNombreCompleto(resultSet.getString("nombreCompleto"));
        this.apoderado.setTelefono(resultSet.getString("telefono"));
        this.apoderado.setRelacion(resultSet.getString("relacion"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.apoderado);
    }

    @Override
    public Apoderado obtenerPorId(Integer idApoderado) {
        this.apoderado = new Apoderado();
        this.apoderado.setIdApoderado(idApoderado);
        super.obtenerPorId();
        return this.apoderado;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.apoderado.getIdApoderado());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.apoderado = null;
    }
    
}

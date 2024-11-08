
package pe.edu.pucp.pixelpenguins.institucioneducativa.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucionEducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class InstitucionEducativaDAOImpl extends DAOImpl implements InstitucionEducativaDAO {
    
    private InstitucionEducativa institucion;

    public InstitucionEducativaDAOImpl() {
        super("InstitucionEducativa");
        this.institucion = null;
    }

    @Override
    public Integer insertar(InstitucionEducativa institucion) {
        this.institucion = institucion;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre, cantidadAlumnos, direccion, ruc";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, institucion.getNombre());
        this.incluirParametroInt(2, institucion.getCantidadAlumnos());
        this.incluirParametroString(3, institucion.getDireccion());
        this.incluirParametroString(4, institucion.getRuc());
    }

    @Override
    public Integer modificar(InstitucionEducativa institucion) {
        this.institucion = institucion;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nombre=?, cantidadAlumnos=?, direccion=?, ruc=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idInstitucion=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, institucion.getNombre());
        this.incluirParametroInt(2, institucion.getCantidadAlumnos());
        this.incluirParametroString(3, institucion.getDireccion());
        this.incluirParametroString(4, institucion.getRuc());
        this.incluirParametroInt(5, institucion.getIdInstitucion());
    }

    @Override
    public Integer eliminar(InstitucionEducativa institucion) {
        this.institucion = institucion;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, institucion.getIdInstitucion());
    }

    @Override
    public ArrayList<InstitucionEducativa> listarTodos() {
        return (ArrayList<InstitucionEducativa>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idInstitucion, nombre, cantidadAlumnos, direccion, ruc";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.institucion);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.institucion = new InstitucionEducativa(
            resultSet.getInt("idInstitucion"),
            resultSet.getString("nombre"),
            resultSet.getInt("cantidadAlumnos"),
            resultSet.getString("direccion"),
            resultSet.getString("ruc")
        );
    }

    @Override
    public InstitucionEducativa obtenerPorId(Integer idInstitucion) {
        this.institucion = new InstitucionEducativa();
        this.institucion.setIdInstitucion(idInstitucion);
        super.obtenerPorId();
        return this.institucion;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, institucion.getIdInstitucion());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.institucion = null;
    }
    
}

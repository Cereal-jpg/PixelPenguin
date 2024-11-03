
package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.AnioAcademicoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class AnioAcademicoDAOImpl extends DAOImpl implements AnioAcademicoDAO {
    
    private AnioAcademico anioAcademico;

    public AnioAcademicoDAOImpl() {
        super("AnioAcademico");
        this.anioAcademico = null;
    }

    @Override
    public Integer insertar(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "anio, fechaInicio, fechaFin";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.anioAcademico.getAnio());
        this.incluirParametroDate(2, this.anioAcademico.getFechaInicio());
        this.incluirParametroDate(3, this.anioAcademico.getFechaFin());
    }

    @Override
    public Integer modificar(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "anio=?, fechaInicio=?, fechaFin=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idAnioAcademico=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.anioAcademico.getAnio());
        this.incluirParametroDate(2, this.anioAcademico.getFechaInicio());
        this.incluirParametroDate(3, this.anioAcademico.getFechaFin());
        this.incluirParametroInt(4, this.anioAcademico.getIdAnioAcademico());
    }

    @Override
    public Integer eliminar(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.anioAcademico.getIdAnioAcademico());
    }

    @Override
    public ArrayList<AnioAcademico> listarTodos() {
        this.anioAcademico = new AnioAcademico();
        return (ArrayList<AnioAcademico>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idAnioAcademico, anio, fechaInicio, fechaFin";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.anioAcademico);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.anioAcademico = new AnioAcademico(
            resultSet.getInt("idAnioAcademico"),
            resultSet.getInt("anio"),
            resultSet.getDate("fechaInicio"),
            resultSet.getDate("fechaFin")
        );
    }

    @Override
    public AnioAcademico obtenerPorId(Integer idAnioAcademico) {
        this.anioAcademico = new AnioAcademico();
        this.anioAcademico.setIdAnioAcademico(idAnioAcademico);
        super.obtenerPorId();
        return this.anioAcademico;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.anioAcademico.getIdAnioAcademico());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.anioAcademico = null;
    }
    
}

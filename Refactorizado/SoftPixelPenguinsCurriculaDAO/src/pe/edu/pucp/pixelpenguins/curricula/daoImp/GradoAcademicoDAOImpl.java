
package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.GradoAcademicoDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class GradoAcademicoDAOImpl extends DAOImpl implements GradoAcademicoDAO{

    private GradoAcademico gradoAcademico;

    public GradoAcademicoDAOImpl() {
        super("GradoAcademico");
        this.gradoAcademico = null;
    }

    @Override
    public Integer insertar(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "numeroGrado, nivel, cantidadAlumnos, vacantes, fid_AnioAcademico";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.gradoAcademico.getNumeroGrado());
        this.incluirParametroString(2, this.gradoAcademico.getNivel().toString());
        this.incluirParametroInt(3, this.gradoAcademico.getCantidadAlumnos());
        this.incluirParametroInt(4, this.gradoAcademico.getVacantes());
        this.incluirParametroInt(5, this.gradoAcademico.getFid_AnioAcademico());
    }

    @Override
    public Integer modificar(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "numeroGrado=?, nivel=?, cantidadAlumnos=?, vacantes=?, fid_AnioAcademico=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idGradoAcademico=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6, this.gradoAcademico.getIdGradoAcademico());
        this.incluirParametroInt(1, this.gradoAcademico.getNumeroGrado());
        this.incluirParametroInt(2, this.gradoAcademico.getNivel().ordinal());
        this.incluirParametroInt(3, this.gradoAcademico.getCantidadAlumnos());
        this.incluirParametroInt(4, this.gradoAcademico.getVacantes());
        this.incluirParametroInt(5, this.gradoAcademico.getFid_AnioAcademico());
    }

    @Override
    public Integer eliminar(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.gradoAcademico.getIdGradoAcademico());
    }

    @Override
    public ArrayList<GradoAcademico> listarTodos() {
        return (ArrayList<GradoAcademico>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idGradoAcademico, numeroGrado, nivel, cantidadAlumnos, vacantes, fid_AnioAcademico";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.gradoAcademico);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.gradoAcademico = new GradoAcademico();
        this.gradoAcademico.setIdGradoAcademico(resultSet.getInt("idGradoAcademico"));
        this.gradoAcademico.setNumeroGrado(resultSet.getInt("numeroGrado"));
        this.gradoAcademico.setNivel(NivelEducativo.values()[resultSet.getInt("nivel")]);
        this.gradoAcademico.setCantidadAlumnos(resultSet.getInt("cantidadAlumnos"));
        this.gradoAcademico.setVacantes(resultSet.getInt("vacantes"));
        this.gradoAcademico.setFid_AnioAcademico(resultSet.getInt("fid_AnioAcademico"));
    }

    @Override
    public GradoAcademico obtenerPorId(Integer idGradoAcademico) {
        this.gradoAcademico = new GradoAcademico();
        this.gradoAcademico.setIdGradoAcademico(idGradoAcademico);
        super.obtenerPorId();
        return this.gradoAcademico;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.gradoAcademico.getIdGradoAcademico());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.gradoAcademico = null;
    }
    
}

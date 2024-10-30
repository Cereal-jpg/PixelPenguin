package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.CursoDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class CursoDAOImpl extends DAOImpl implements CursoDAO{

    private Curso curso;

    public CursoDAOImpl() {
        super("Curso");
        this.curso = null;
    }

    @Override
    public Integer insertar(Curso curso) {
        this.curso = curso;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "codigoCurso, nombre, horasPorSemana, horasTotales";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.curso.getCodigoCurso());
        this.incluirParametroString(2, this.curso.getNombre());
        this.incluirParametroInt(3, this.curso.getHorasPorSemana());
        this.incluirParametroInt(4, this.curso.getHorasTotales());
    }

    @Override
    public Integer modificar(Curso curso) {
        this.curso = curso;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "codigoCurso=?, nombre=?, horasPorSemana=?, horasTotales=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCurso=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(5, this.curso.getIdCurso());
        this.incluirParametroString(1, this.curso.getCodigoCurso());
        this.incluirParametroString(2, this.curso.getNombre());
        this.incluirParametroInt(3, this.curso.getHorasPorSemana());
        this.incluirParametroInt(4, this.curso.getHorasTotales());
    }

    @Override
    public Integer eliminar(Curso curso) {
        this.curso = curso;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.curso.getIdCurso());
    }

    @Override
    public ArrayList<Curso> listarTodos() {
        return (ArrayList<Curso>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idCurso, codigoCurso, nombre, horasPorSemana, horasTotales";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.curso);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.curso = new Curso();
        curso.setIdCurso(this.resultSet.getInt("idCurso"));
        curso.setCodigoCurso(this.resultSet.getString("codigoCurso"));
        curso.setNombre(this.resultSet.getString("nombre"));
        curso.setHorasPorSemana(this.resultSet.getInt("horasPorSemana"));
        curso.setHorasTotales(this.resultSet.getInt("horasTotales"));
    }

    @Override
    public Curso obtenerPorId(Integer idCurso) {
        this.curso = new Curso();
        this.curso.setIdCurso(idCurso);
        super.obtenerPorId();
        return this.curso;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.curso.getIdCurso());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.curso = null;
    }
    
}

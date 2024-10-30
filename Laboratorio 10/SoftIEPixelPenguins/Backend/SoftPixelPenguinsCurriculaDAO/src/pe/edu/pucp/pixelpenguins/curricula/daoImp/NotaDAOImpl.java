package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.NotaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class NotaDAOImpl extends DAOImpl implements NotaDAO {
    
    private Nota nota;

    public NotaDAOImpl() {
        super("Nota");
        this.nota = null;
    }

    @Override
    public Integer insertar(Nota nota) {
        this.nota = nota;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nota, bimestre, fid_Curso, fid_Competencia";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.nota.getNota());
        this.incluirParametroInt(2, this.nota.getBimestre());
        this.incluirParametroInt(3, this.nota.getCurso().getIdCurso());
        this.incluirParametroInt(4, this.nota.getCompetencia().getIdCompetencia());
    }

    @Override
    public Integer modificar(Nota nota) {
        this.nota = nota;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nota=?, bimestre=?, fid_Curso=?, fid_Competencia=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idNota=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.nota.getIdNota());
        this.incluirParametroString(2, this.nota.getNota());
        this.incluirParametroInt(3, this.nota.getBimestre());
        this.incluirParametroInt(4, this.nota.getCurso().getIdCurso());
        this.incluirParametroInt(5, this.nota.getCompetencia().getIdCompetencia());
    }

    @Override
    public Integer eliminar(Nota nota) {
        this.nota = nota;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.nota.getIdNota());
    }

    @Override
    public ArrayList<Nota> listarTodos() {
        return (ArrayList<Nota>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idNota, nota, bimestre, fid_Curso, fid_Competencia";
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        return " WHERE fid_Curso=? ";
    }

    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        this.incluirParametroInt(1, this.nota.getCurso().getIdCurso());
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.nota);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.nota = new Nota();
        this.nota.setIdNota(this.resultSet.getInt("idNota"));
        this.nota.setNota(this.resultSet.getString("nota"));
        this.nota.setBimestre(this.resultSet.getInt("bimestre"));
        
        Curso curso = new Curso();
        curso.setIdCurso(this.resultSet.getInt("fid_Curso"));
        this.nota.setCurso(curso);

        Competencia competencia = new Competencia();
        competencia.setIdCompetencia(this.resultSet.getInt("fid_Competencia"));
        this.nota.setCompetencia(competencia);
    }

    @Override
    public Nota obtenerPorId(Integer idNota) {
        this.nota = new Nota();
        this.nota.setIdNota(idNota);
        super.obtenerPorId();
        return this.nota;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.nota.getIdNota());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.nota = null;
    }
    
}

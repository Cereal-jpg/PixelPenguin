package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.CompetenciaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class CompetenciaDAOImpl extends DAOImpl implements CompetenciaDAO {
    
    private Competencia competencia;

    public CompetenciaDAOImpl() {
        super("Competencia");
        this.competencia = null;
    }

    @Override
    public Integer insertar(Competencia competencia) {
        this.competencia = competencia;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "descripcion, fid_Curso";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.competencia.getDescripcion());
        this.incluirParametroInt(2, this.competencia.getCurso().getIdCurso());
    }

    @Override
    public Integer modificar(Competencia competencia) {
        this.competencia = competencia;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "descripcion=?, fid_Curso=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCompetencia=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(3, this.competencia.getIdCompetencia());
        this.incluirParametroString(1, this.competencia.getDescripcion());
        this.incluirParametroInt(2, this.competencia.getCurso().getIdCurso());
    }

    @Override
    public Integer eliminar(Competencia competencia) {
        this.competencia = competencia;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.competencia.getIdCompetencia());
    }

    @Override
    public ArrayList<Competencia> listarTodos() {
        return (ArrayList<Competencia>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idCompetencia, descripcion, fid_Curso";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.competencia);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.competencia = new Competencia();
        competencia.setIdCompetencia(this.resultSet.getInt("idCompetencia"));
        competencia.setDescripcion(this.resultSet.getString("descripcion"));
        
        Curso curso = new Curso();
        curso.setIdCurso(this.resultSet.getInt("fid_Curso"));
        competencia.setCurso(curso);
    }

    @Override
    public Competencia obtenerPorId(Integer idCompetencia) {
        this.competencia = new Competencia();
        this.competencia.setIdCompetencia(idCompetencia);
        super.obtenerPorId();
        return this.competencia;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.competencia.getIdCompetencia());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.competencia = null;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        return " where fid_Curso = ?";
    }
    
    @Override
    public ArrayList<Competencia> listarCompetenciasPorCurso(Integer idCurso) {
        ArrayList<Competencia> competencias = new ArrayList<Competencia>();
        this.usarPredicadoParaListado = true;
        
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarTodos(null);
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idCurso);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(competencias, this.resultSet);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarPredicadoParaListado = false;
        
        return competencias;
    }
    
}

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
        return "nota, bimestre, fid_Curso, fid_Competencia, fid_Matricula, fid_Alumno";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.nota.getNota());
        this.incluirParametroInt(2, this.nota.getBimestre());
        this.incluirParametroInt(3, this.nota.getCurso().getIdCurso());
        this.incluirParametroInt(4, this.nota.getCompetencia().getIdCompetencia());
        this.incluirParametroInt(5, this.nota.getFid_Matricula());
        this.incluirParametroInt(6, this.nota.getFid_Alumno());
    }

    @Override
    public Integer modificar(Nota nota) {
        this.nota = nota;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "nota=?, bimestre=?, fid_Curso=?, fid_Competencia=?, fid_Matricula=?, fid_Alumno=?";
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
        this.incluirParametroInt(6, this.nota.getFid_Matricula());
        this.incluirParametroInt(7, this.nota.getFid_Alumno());
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
        return "idNota, nota, bimestre, fid_Curso, fid_Competencia, fid_Matricula, fid_Alumno";
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
        this.nota.setFid_Matricula(this.resultSet.getInt("fid_Matricula"));
        this.nota.setFid_Alumno(this.resultSet.getInt("fid_Alumno"));
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
    
    @Override
    protected String obtenerPredicadoParaListado() {
        return " WHERE fid_Alumno=? AND fid_Curso=? ";
    }

    @Override
    public ArrayList<Nota> listarPorAlumnoYCurso(Integer idAlumno,Integer idCurso) {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        this.usarPredicadoParaListado = true;
        try {
            this.abrirConexion();
            String sql = "SELECT "+this.obtenerProyeccionParaSelect()+" FROM "+this.nombre_tabla;
            sql=sql.concat(this.obtenerPredicadoParaListado());
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado){
                this.incluirParametroInt(1, idAlumno);
                this.incluirParametroInt(2, idCurso);
            }
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(notas, this.resultSet);
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
        
        return notas;
    }
    
    @Override
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(Integer idAlumno, Integer idCurso, Integer bimestre) {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        this.usarPredicadoParaListado = true;
        try {
            this.abrirConexion();
            String sql = "SELECT n.idNota, n.fid_Matricula, n.fid_Alumno, n.fid_Curso,"
                    + " n.fid_Competencia, n.nota, n.bimestre, comp.descripcion AS desc_Competencia FROM "+
                    this.nombre_tabla+" n JOIN Competencia comp ON n.fid_Competencia=comp.idCompetencia "
                    + "WHERE n.fid_Alumno=? AND n.fid_Curso=? AND n.bimestre=?";
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado){
                this.incluirParametroInt(1, idAlumno);
                this.incluirParametroInt(2, idCurso);
                this.incluirParametroInt(3, bimestre);
            }
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
                this.nota.getCompetencia().setDescripcion(this.resultSet.getString("desc_Competencia"));
                notas.add(this.nota);
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
        
        return notas;
    }
}

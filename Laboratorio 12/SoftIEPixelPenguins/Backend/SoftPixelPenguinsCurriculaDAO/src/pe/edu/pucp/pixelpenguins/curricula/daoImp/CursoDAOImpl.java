package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.CursoDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
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
        return "codigoCurso, nombre, horasPorSemana, horasTotales, fid_GradoAcademico, fid_Profesor";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.curso.getCodigoCurso());
        this.incluirParametroString(2, this.curso.getNombre());
        this.incluirParametroInt(3, this.curso.getHorasPorSemana());
        this.incluirParametroInt(4, this.curso.getHorasTotales());
        this.incluirParametroInt(5, this.curso.getGradoAcademico().getIdGradoAcademico());
        this.incluirParametroInt(6, this.curso.getFid_Profesor());
    }

    @Override
    public Integer modificar(Curso curso) {
        this.curso = curso;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "codigoCurso=?, nombre=?, horasPorSemana=?, horasTotales=?,"
                + " fid_GradoAcademico=?, fid_Profesor=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCurso=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(7, this.curso.getIdCurso());
        this.incluirParametroString(1, this.curso.getCodigoCurso());
        this.incluirParametroString(2, this.curso.getNombre());
        this.incluirParametroInt(3, this.curso.getHorasPorSemana());
        this.incluirParametroInt(4, this.curso.getHorasTotales());
        this.incluirParametroInt(5, this.curso.getGradoAcademico().getIdGradoAcademico());
        this.incluirParametroInt(6, this.curso.getFid_Profesor());
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
        return "idCurso, codigoCurso, nombre, horasPorSemana, horasTotales, "
                + "fid_GradoAcademico, fid_Profesor";
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
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setIdGradoAcademico(this.resultSet.getInt("fid_GradoAcademico"));
        this.curso.setGradoAcademico(gradoAcademico);
        curso.setFid_Profesor(this.resultSet.getInt("fid_Profesor"));
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
    
    @Override
    protected String obtenerPredicadoParaListado() {
        return " where fid_GradoAcademico = ?";
    }
    
    
    @Override
    public ArrayList<Curso> listarCursosPorGrado(Integer idGradoAcademico){
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        this.usarPredicadoParaListado = true;
        
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarTodos(null);
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idGradoAcademico);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(cursos, this.resultSet);
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
        
        return cursos;
    }
    
    @Override
    public ArrayList<Curso> listarCursosPorProfesor(Integer idProfesor){
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        this.usarPredicadoParaListado = true;
        
        try {
            this.abrirConexion();
            String sql = "select ";
            sql=sql.concat(this.obtenerProyeccionParaSelect());
            sql=sql.concat(" from ").concat(this.nombre_tabla);
            sql=sql.concat(" WHERE fid_Profesor = ?");
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idProfesor);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(cursos, this.resultSet);
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
        
        return cursos;
    }
    
}

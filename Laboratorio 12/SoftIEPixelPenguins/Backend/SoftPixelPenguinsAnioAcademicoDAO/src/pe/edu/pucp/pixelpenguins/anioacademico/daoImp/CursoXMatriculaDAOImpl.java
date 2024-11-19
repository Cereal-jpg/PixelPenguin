
package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.CursoXMatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class CursoXMatriculaDAOImpl extends DAOImpl implements CursoXMatriculaDAO {
    
    private CursoXMatricula cursoXMatricula;

    public CursoXMatriculaDAOImpl() {
        super("CursoXMatricula");
        this.cursoXMatricula=null;
    }

    @Override
    public Integer insertar(CursoXMatricula cursoXMatricula) {
        this.cursoXMatricula=cursoXMatricula;
        Integer id = super.insertar();
        return id;
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idCurso, idMatricula, fid_Alumno, notaBimestre1, notaBimestre2,"
                + " notaBimestre3, notaBimestre4, notaFinal";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.cursoXMatricula.getCurso().getIdCurso());
        this.incluirParametroInt(2, this.cursoXMatricula.getMatricula().getIdMatricula());
        this.incluirParametroInt(3, this.cursoXMatricula.getFid_Alumno());
        this.incluirParametroString(4, this.cursoXMatricula.getNotaBimestre1());
        this.incluirParametroString(5, this.cursoXMatricula.getNotaBimestre2());
        this.incluirParametroString(6, this.cursoXMatricula.getNotaBimestre3());
        this.incluirParametroString(7, this.cursoXMatricula.getNotaBimestre4());
        this.incluirParametroString(8, this.cursoXMatricula.getNotaFinal());
    }

    @Override
    public Integer modificar(CursoXMatricula cursoXMatricula) {
        this.cursoXMatricula=cursoXMatricula;
        return super.modificar();
    }
    
    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fid_Alumno=?, notaBimestre1=?, notaBimestre2=?,"
                + " notaBimestre3=?, notaBimestre4=?, notaFinal=?,";
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idCurso=? AND idMatricula=?";
    }    
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.cursoXMatricula.getFid_Alumno());
        this.incluirParametroString(2, this.cursoXMatricula.getNotaBimestre1());
        this.incluirParametroString(3, this.cursoXMatricula.getNotaBimestre2());
        this.incluirParametroString(4, this.cursoXMatricula.getNotaBimestre3());
        this.incluirParametroString(5, this.cursoXMatricula.getNotaBimestre4());
        this.incluirParametroString(6, this.cursoXMatricula.getNotaFinal());
        this.incluirParametroInt(7, this.cursoXMatricula.getCurso().getIdCurso());
        this.incluirParametroInt(8, this.cursoXMatricula.getMatricula().getIdMatricula());
    }
    
    
    @Override
    public Integer eliminar(CursoXMatricula cursoXMatricula) {
        this.cursoXMatricula=cursoXMatricula;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.cursoXMatricula.getCurso().getIdCurso());
        this.incluirParametroInt(2, this.cursoXMatricula.getMatricula().getIdMatricula());
    }

    @Override
    public ArrayList<CursoXMatricula> listarTodos() {
        return (ArrayList<CursoXMatricula>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return this.obtenerListaDeAtributosParaInsercion();
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.cursoXMatricula);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cursoXMatricula=new CursoXMatricula();
        Curso curso = new Curso();
        curso.setIdCurso(this.resultSet.getInt("idCurso"));
        this.cursoXMatricula.setCurso(curso);
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(this.resultSet.getInt("idMatricula"));
        this.cursoXMatricula.setMatricula(matricula);
        this.cursoXMatricula.setFid_Alumno(this.resultSet.getInt("fid_Alumno"));
        this.cursoXMatricula.setNotaBimestre1(this.resultSet.getString("notaBimestre1"));
        this.cursoXMatricula.setNotaBimestre2(this.resultSet.getString("notaBimestre2"));
        this.cursoXMatricula.setNotaBimestre3(this.resultSet.getString("notaBimestre3"));
        this.cursoXMatricula.setNotaBimestre4(this.resultSet.getString("notaBimestre4"));        
        this.cursoXMatricula.setNotaFinal(this.resultSet.getString("notaFinal"));        
    }
    
    @Override
    public CursoXMatricula obtenerPorCursoYMatricula(Integer idCurso, Integer idMatricula) {
        this.cursoXMatricula=new CursoXMatricula();
        Curso curso = new Curso();
        curso.setIdCurso(idCurso);
        this.cursoXMatricula.setCurso(curso);
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        this.cursoXMatricula.setMatricula(matricula);
        super.obtenerPorId();
        return this.cursoXMatricula;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.cursoXMatricula.getCurso().getIdCurso());
        this.incluirParametroInt(2, this.cursoXMatricula.getMatricula().getIdMatricula());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cursoXMatricula=null;
    }
    
    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula(Integer idMatricula) {
        ArrayList<CursoXMatricula> notasFinales=new ArrayList<CursoXMatricula>();
        this.usarPredicadoParaListado=true;
        try {
            this.abrirConexion();
            String sql = "SELECT n.idCurso, n.idMatricula, n.fid_Alumno,"
                    + " n.notaBimestre1, n.notaBimestre2, n.notaBimestre3,"
                    + " n.notaBimestre4, n.notaFinal, c.nombre AS nombreCurso ";
            sql=sql.concat(" from ").concat(this.nombre_tabla);
            sql=sql.concat(" n JOIN Curso c ON n.idCurso = c.idCurso");
            sql=sql.concat(" WHERE n.idMatricula = ? ");
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idMatricula);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
                this.cursoXMatricula.getCurso().setNombre(this.resultSet.getString("nombreCurso"));
                notasFinales.add(this.cursoXMatricula);
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
        
        return notasFinales;
    }

    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno(Integer idAlumno) {
        ArrayList<CursoXMatricula> notasFinales=new ArrayList<CursoXMatricula>();
        this.usarPredicadoParaListado=true;
        try {
            this.abrirConexion();
            String sql = "SELECT n.idCurso, n.idMatricula, n.fid_Alumno,"
                    + " n.notaBimestre1, n.notaBimestre2, n.notaBimestre3,"
                    + " n.notaBimestre4, n.notaFinal, c.nombre AS nombreCurso ";
            sql=sql.concat(" from ").concat(this.nombre_tabla);
            sql=sql.concat(" n JOIN Curso c ON n.idCurso = c.idCurso");
            sql=sql.concat(" WHERE n.fid_Alumno = ? ");
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idAlumno);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
                this.cursoXMatricula.getCurso().setNombre(this.resultSet.getString("nombreCurso"));
                notasFinales.add(this.cursoXMatricula);
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
        
        return notasFinales;
    }

    @Override
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso(Integer idCurso) {
        ArrayList<CursoXMatricula> notasFinales=new ArrayList<CursoXMatricula>();
        this.usarPredicadoParaListado=true;
        try {
            this.abrirConexion();
            String sql = "SELECT n.idCurso, n.idMatricula, n.fid_Alumno,"
                    + " n.notaBimestre1, n.notaBimestre2, n.notaBimestre3,"
                    + " n.notaBimestre4, n.notaFinal, c.nombre AS nombreCurso ";
            sql=sql.concat(" from ").concat(this.nombre_tabla);
            sql=sql.concat(" n JOIN Curso c ON n.idCurso = c.idCurso");
            sql=sql.concat(" WHERE n.idCurso = ? ");
            this.colocarSQLenStatement(sql);
            if(this.usarPredicadoParaListado)
                this.incluirParametroInt(1, idCurso);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
                this.cursoXMatricula.getCurso().setNombre(this.resultSet.getString("nombreCurso"));
                notasFinales.add(this.cursoXMatricula);
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
        
        return notasFinales;
    }
}

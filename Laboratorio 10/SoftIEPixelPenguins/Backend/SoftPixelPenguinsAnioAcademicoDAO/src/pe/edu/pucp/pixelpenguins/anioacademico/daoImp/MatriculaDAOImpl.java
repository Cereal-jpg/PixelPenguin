package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class MatriculaDAOImpl extends DAOImpl implements MatriculaDAO {
    
    private Matricula matricula;

    public MatriculaDAOImpl() {
        super("Matricula");
        this.matricula = null;
    }

    @Override
    public Integer insertar(Matricula matricula) {
        this.matricula = matricula;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "fid_Alumno, fid_GradoAcademico, fid_AnioAcademico, fid_SeccionAcademica";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.matricula.getFidAlumno());
        this.incluirParametroInt(2, this.matricula.getGradoAcademico().getIdGradoAcademico());
        this.incluirParametroInt(3, this.matricula.getAnioAcademico().getIdAnioAcademico());
        this.incluirParametroInt(4, this.matricula.getSeccionAcademica().getIdSeccionAcademica());
    }

    @Override
    public Integer modificar(Matricula matricula) {
        this.matricula = matricula;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fid_Alumno=?, fid_GradoAcademico=?, fid_AnioAcademico=?, fid_SeccionAcademica=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idMatricula=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        incluirValorDeParametrosParaInsercion();
        this.incluirParametroInt(5, this.matricula.getIdMatricula());
    }

    @Override
    public Integer eliminar(Matricula matricula) {
        this.matricula = matricula;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.matricula.getIdMatricula());
    }

    @Override
    public ArrayList<Matricula> listarTodos() {
        return (ArrayList<Matricula>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idMatricula, fid_Alumno, fid_GradoAcademico, fid_AnioAcademico, fid_SeccionAcademica";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.matricula);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.matricula = new Matricula();
        this.matricula.setIdMatricula(this.resultSet.getInt("idMatricula"));
        this.matricula.setFidAlumno(this.resultSet.getInt("fid_Alumno"));
        GradoAcademico grado = new GradoAcademico();
        grado.setIdGradoAcademico(this.resultSet.getInt("fid_GradoAcademico"));
        this.matricula.setGradoAcademico(grado);

        AnioAcademico anio = new AnioAcademico();
        anio.setIdAnioAcademico(this.resultSet.getInt("fid_AnioAcademico"));
        this.matricula.setAnioAcademico(anio);
        
        SeccionAcademica seccion = new SeccionAcademica();
        seccion.setIdSeccionAcademica(this.resultSet.getInt("fid_SeccionAcademica"));
        this.matricula.setSeccionAcademica(seccion);
    }

    @Override
    public Matricula obtenerPorId(Integer idMatricula) {
        this.matricula = new Matricula();
        matricula.setIdMatricula(idMatricula);
        super.obtenerPorId();
        return this.matricula;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.matricula.getIdMatricula());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.matricula = null;
    }
    
    
}

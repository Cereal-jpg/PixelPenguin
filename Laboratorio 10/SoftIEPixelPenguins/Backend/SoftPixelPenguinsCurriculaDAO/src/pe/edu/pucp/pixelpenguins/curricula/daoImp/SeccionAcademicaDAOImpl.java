package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.SeccionAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;


public class SeccionAcademicaDAOImpl extends DAOImpl implements SeccionAcademicaDAO {
    
    private SeccionAcademica seccionAcademica;

    public SeccionAcademicaDAOImpl() {
        super("SeccionAcademica");
        this.seccionAcademica = null;
    }

    @Override
    public Integer insertar(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "seccion, aula, cantidadAlumnos, vacantes, fid_GradoAcademico";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, String.valueOf(this.seccionAcademica.getSeccion()));
        this.incluirParametroString(2, this.seccionAcademica.getAula());
        this.incluirParametroInt(3, this.seccionAcademica.getCantidadAlumnos());
        this.incluirParametroInt(4, this.seccionAcademica.getVacantes());
        this.incluirParametroInt(5, this.seccionAcademica.getGradoAcademico().getIdGradoAcademico());
    }

    @Override
    public Integer modificar(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "seccion=?, aula=?, cantidadAlumnos=?, vacantes=?, fid_GradoAcademico=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idSeccionAcademica=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, String.valueOf(this.seccionAcademica.getSeccion()));
        this.incluirParametroString(2, this.seccionAcademica.getAula());
        this.incluirParametroInt(3, this.seccionAcademica.getCantidadAlumnos());
        this.incluirParametroInt(4, this.seccionAcademica.getVacantes());
        this.incluirParametroInt(5, this.seccionAcademica.getGradoAcademico().getIdGradoAcademico());
        this.incluirParametroInt(6, this.seccionAcademica.getIdSeccionAcademica());
    }

    @Override
    public Integer eliminar(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.seccionAcademica.getIdSeccionAcademica());
    }

    @Override
    public ArrayList<SeccionAcademica> listarTodos() {
        return (ArrayList<SeccionAcademica>) super.listarTodos(null);
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idSeccionAcademica, seccion, aula, cantidadAlumnos, vacantes, fid_GradoAcademico";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.seccionAcademica);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.seccionAcademica = new SeccionAcademica();
        this.seccionAcademica.setIdSeccionAcademica(this.resultSet.getInt("idSeccionAcademica"));
        this.seccionAcademica.setSeccion(this.resultSet.getString("seccion").charAt(0));
        this.seccionAcademica.setAula(this.resultSet.getString("aula"));
        this.seccionAcademica.setCantidadAlumnos(this.resultSet.getInt("cantidadAlumnos"));
        this.seccionAcademica.setVacantes(this.resultSet.getInt("vacantes"));
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setIdGradoAcademico(this.resultSet.getInt("fid_GradoAcademico"));
        this.seccionAcademica.setGradoAcademico(gradoAcademico);
    }

    @Override
    public SeccionAcademica obtenerPorId(Integer idSeccionAcademica) {
        this.seccionAcademica = new SeccionAcademica();
        this.seccionAcademica.setIdSeccionAcademica(idSeccionAcademica);
        super.obtenerPorId();
        return this.seccionAcademica;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.seccionAcademica.getIdSeccionAcademica());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.seccionAcademica = null;
    }
    
}

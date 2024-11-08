
package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.JornadaEscolarDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class JornadaEscolarDAOImpl extends DAOImpl implements JornadaEscolarDAO{
    
    private JornadaEscolar jornadaEscolar;

    public JornadaEscolarDAOImpl() {
        super("JornadaEscolar");
        this.jornadaEscolar = null;
    }

    @Override
    public Integer insertar(JornadaEscolar jornadaEscolar) {
        this.jornadaEscolar = jornadaEscolar;
        return super.insertar();
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "horasDeEstudio, horaInicio, horaFin, dia, fid_GradoAcademico";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.jornadaEscolar.getHorasDeEstudio());
        this.incluirParametroTime(2, this.jornadaEscolar.getHoraInicio());
        this.incluirParametroTime(3, this.jornadaEscolar.getHoraFin());
        this.incluirParametroString(4, this.jornadaEscolar.getDia().toString()); 
        this.incluirParametroInt(5, this.jornadaEscolar.getGradoRelacionado().getIdGradoAcademico());
    }

    @Override
    public Integer modificar(JornadaEscolar jornadaEscolar) {
        this.jornadaEscolar = jornadaEscolar;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "horasDeEstudio=?, horaInicio=?, horaFin=?, dia=?, fid_GradoAcademico=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idJornadaEscolar=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.jornadaEscolar.getHorasDeEstudio());
        this.incluirParametroTime(2, this.jornadaEscolar.getHoraInicio());
        this.incluirParametroTime(3, this.jornadaEscolar.getHoraFin());
        this.incluirParametroString(4, this.jornadaEscolar.getDia().toString());
        this.incluirParametroInt(5, this.jornadaEscolar.getGradoRelacionado().getIdGradoAcademico());
        this.incluirParametroInt(6, this.jornadaEscolar.getIdJornadaEscolar());
    }

    @Override
    public Integer eliminar(JornadaEscolar jornadaEscolar) {
        this.jornadaEscolar = jornadaEscolar;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.jornadaEscolar.getIdJornadaEscolar());
    }

    @Override
    public ArrayList<JornadaEscolar> listarTodos() {
        return (ArrayList<JornadaEscolar>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idJornadaEscolar, horasDeEstudio, horaInicio, horaFin, dia, fid_GradoAcademico";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.jornadaEscolar);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.jornadaEscolar = new JornadaEscolar();
        this.jornadaEscolar.setIdJornadaEscolar(resultSet.getInt("idJornadaEscolar"));
        this.jornadaEscolar.setHorasDeEstudio(resultSet.getInt("horasDeEstudio"));
        this.jornadaEscolar.setHoraInicio(resultSet.getObject("horaInicio", LocalTime.class));
        this.jornadaEscolar.setHoraFin(resultSet.getObject("horaFin", LocalTime.class));
        this.jornadaEscolar.setDia(DiaSemana.valueOf(resultSet.getString("dia")));
        GradoAcademico grado = new GradoAcademico();
        grado.setIdGradoAcademico(resultSet.getInt("fid_GradoAcademico"));
        this.jornadaEscolar.setGradoRelacionado(grado);
    }

    @Override
    public JornadaEscolar obtenerPorId(Integer idJornadaEscolar) {
        this.jornadaEscolar = new JornadaEscolar();
        this.jornadaEscolar.setIdJornadaEscolar(idJornadaEscolar);
        super.obtenerPorId();
        return this.jornadaEscolar;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.jornadaEscolar.getIdJornadaEscolar());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.jornadaEscolar = null;
    }
    
}

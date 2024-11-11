package pe.edu.pucp.pixelpenguins.curricula.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.dao.HoraAcademicaDAO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.HoraAcademica;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;


public class HoraAcademicaDAOImpl extends DAOImpl implements HoraAcademicaDAO {
    
    private HoraAcademica horaAcademica;

    public HoraAcademicaDAOImpl() {
        super("HoraAcademica");
        this.horaAcademica = null;
    }

    @Override
    public Integer insertar(HoraAcademica horaAcademica) {
        this.horaAcademica = horaAcademica;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "fid_Curso, horaInicio, horaFin, dia, fid_seccionAcademica"; 
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.horaAcademica.getCurso().getIdCurso());
        this.incluirParametroTime(2, LocalTime.parse(this.horaAcademica.getHoraInicio()));
        this.incluirParametroTime(3, LocalTime.parse(this.horaAcademica.getHoraFin()));
        this.incluirParametroString(4, this.horaAcademica.getDia().toString());
        this.incluirParametroInt(5, this.horaAcademica.getSeccionAcademica().getIdSeccionAcademica());
    }

    @Override
    public Integer modificar(HoraAcademica horaAcademica) {
        this.horaAcademica = horaAcademica;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fid_Curso=?, horaInicio=?, horaFin=?, dia=?, fid_seccionAcademica=?"; 
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idHoraAcademica=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, this.horaAcademica.getCurso().getIdCurso());
        this.incluirParametroTime(2, LocalTime.parse(this.horaAcademica.getHoraInicio()));
        this.incluirParametroTime(3, LocalTime.parse(this.horaAcademica.getHoraFin()));
        this.incluirParametroString(4, this.horaAcademica.getDia().toString());
        this.incluirParametroInt(5, this.horaAcademica.getSeccionAcademica().getIdSeccionAcademica());
        this.incluirParametroInt(6, this.horaAcademica.getIdHoraAcademica());
    }

    @Override
    public Integer eliminar(HoraAcademica horaAcademica) {
        this.horaAcademica = horaAcademica;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.horaAcademica.getIdHoraAcademica());
    }

    @Override
    public ArrayList<HoraAcademica> listarTodos() {
        return (ArrayList<HoraAcademica>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idHoraAcademica, fid_Curso, horaInicio, horaFin, dia, fid_seccionAcademica"; 
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.horaAcademica);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.horaAcademica = new HoraAcademica();
        this.horaAcademica.setIdHoraAcademica(this.resultSet.getInt("idHoraAcademica"));
        this.horaAcademica.setHoraInicio(this.resultSet.getTime("horaInicio").toString());
        this.horaAcademica.setHoraFin(this.resultSet.getTime("horaFin").toString());
        this.horaAcademica.setDia(DiaSemana.valueOf(resultSet.getString("dia")));
        
        SeccionAcademica seccion = new SeccionAcademica();
        seccion.setIdSeccionAcademica(this.resultSet.getInt("fid_seccionAcademica"));
        this.horaAcademica.setSeccionAcademica(seccion);
        
        Curso curso = new Curso();
        curso.setIdCurso(this.resultSet.getInt("fid_Curso"));
        this.horaAcademica.setCurso(curso);
    }

    @Override
    public HoraAcademica obtenerPorId(Integer idHoraAcademica) {
        this.horaAcademica = new HoraAcademica();
        this.horaAcademica.setIdHoraAcademica(idHoraAcademica);
        super.obtenerPorId();
        return this.horaAcademica;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.horaAcademica.getIdHoraAcademica());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.horaAcademica = null;
    }
    
    @Override
    protected String obtenerPredicadoParaListado() {
        return " WHERE fid_Curso=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        this.incluirParametroInt(1, horaAcademica.getCurso().getIdCurso());
    }
    
    @Override
    public ArrayList<HoraAcademica>listarHorasAcademicasPorCurso(Curso curso){
        this.usarPredicadoParaListado = true;
        this.horaAcademica = new HoraAcademica();
        horaAcademica.setCurso(curso);
        ArrayList<HoraAcademica>usuarios = (ArrayList<HoraAcademica>)super.listarTodos(null);
        this.usarPredicadoParaListado = false;
        return usuarios;
    }
    
}

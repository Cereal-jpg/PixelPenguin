package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PagoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDePago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDeComprobante;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDePago;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;

public class PagoDAOImpl extends DAOImpl implements PagoDAO {
    
    private Pago pago;

    public PagoDAOImpl() {
        super("Pago");
        this.pago = null;
    }

    @Override
    public Integer insertar(Pago pago) {
        this.pago = pago;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, fid_matricula";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.pago.getFechaCreacion());
        this.incluirParametroDate(2, this.pago.getFechaPago());
        this.incluirParametroDouble(3, this.pago.getMonto());
        this.incluirParametroString(4, this.pago.getTipoPago().toString()); 
        this.incluirParametroString(5, this.pago.getEstado().toString());
        this.incluirParametroString(6, this.pago.getTipoDeComprobante().toString());
        this.incluirParametroInt(7, this.pago.getMatricula().getIdMatricula());
    }

    @Override
    public Integer modificar(Pago pago) {
        this.pago = pago;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fechaCreacion=?, fechaPago=?, monto=?, tipoPago=?, estado=?, tipoDeComprobante=?, fid_matricula=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPago=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        incluirValorDeParametrosParaInsercion();
        this.incluirParametroInt(8, this.pago.getIdPago()); 
    }

    @Override
    public Integer eliminar(Pago pago) {
        this.pago = pago;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.pago.getIdPago());
    }

    @Override
    public ArrayList<Pago> listarTodos() {
        return (ArrayList<Pago>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        return "idPago, fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, fid_matricula";
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.pago);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.pago = new Pago();
        this.pago.setIdPago(this.resultSet.getInt("idPago"));
        this.pago.setFechaCreacion(this.resultSet.getDate("fechaCreacion"));
        this.pago.setFechaPago(this.resultSet.getDate("fechaPago"));
        this.pago.setMonto(this.resultSet.getDouble("monto"));
        this.pago.setTipoPago(TipoDePago.valueOf(this.resultSet.getString("tipoPago")));
        this.pago.setEstado(EstadoDePago.valueOf(this.resultSet.getString("estado")));
        this.pago.setTipoDeComprobante(TipoDeComprobante.valueOf(this.resultSet.getString("tipoDeComprobante")));

        Matricula matricula = new Matricula();
        matricula.setIdMatricula(this.resultSet.getInt("fid_matricula"));
        this.pago.setMatricula(matricula);
    }

    @Override
    public Pago obtenerPorId(Integer idPago) {
        this.pago = new Pago();
        pago.setIdPago(idPago);
        super.obtenerPorId();
        return this.pago;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.pago.getIdPago());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.pago = null;
    }
    
}

package pe.edu.pucp.pixelpenguins.anioacademico.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        return "fechaCreacion, fechaPago, monto, tipoPago, estado, tipoDeComprobante, fid_matricula, comprobanteDePago";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.pago.getFechaCreacion());
        this.incluirParametroDate(2, this.pago.getFechaPago());
        this.incluirParametroDouble(3, this.pago.getMonto());
        this.incluirParametroString(4,(this.pago.getTipoPago() != null) ? this.pago.getTipoPago().toString() : null); 
        this.incluirParametroString(5, this.pago.getEstado().toString());
        this.incluirParametroString(6, (this.pago.getTipoDeComprobante()!= null) ? this.pago.getTipoDeComprobante().toString() : null);
        this.incluirParametroInt(7, this.pago.getMatricula().getIdMatricula());
        this.incluirParametroBytes(8, this.pago.getComprobanteDePago());
    }

    @Override
    public Integer modificar(Pago pago) {
        this.pago = pago;
        return super.modificar();
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "fechaCreacion=?, fechaPago=?, monto=?, tipoPago=?, estado=?, "
                + "tipoDeComprobante=?, fid_matricula=?, comprobanteDePago=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPago=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        incluirValorDeParametrosParaInsercion();
        this.incluirParametroInt(9, this.pago.getIdPago()); 
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
        return "idPago, fechaCreacion, fechaPago, monto, tipoPago, estado, "
                + "tipoDeComprobante, fid_matricula, comprobanteDePago";
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
        String tipoPagoStr = this.resultSet.getString("tipoPago");
        this.pago.setTipoPago(tipoPagoStr != null ? TipoDePago.valueOf(tipoPagoStr) : null);
        this.pago.setEstado(EstadoDePago.valueOf(this.resultSet.getString("estado")));
         String tipoComprobanteStr = this.resultSet.getString("tipoDeComprobante");
        this.pago.setTipoDeComprobante(tipoComprobanteStr != null ? TipoDeComprobante.valueOf(tipoComprobanteStr) : null);
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(this.resultSet.getInt("fid_matricula"));
        this.pago.setMatricula(matricula);
        this.pago.setComprobanteDePago(this.resultSet.getBytes("comprobanteDePago"));
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

    @Override
    protected String obtenerPredicadoParaListado() {
        return " WHERE fid_Matricula=? AND (estado='PENDIENTE' OR estado='ATRASADO')";
    }
    protected  String obtenerPredicadoParaListadoPoridMatricula(){
        return " WHERE fid_Matricula=?";
    }  
        
    @Override
    public  ArrayList<Pago> PagoXAlumnos(int idMatricula) {
        ArrayList<Pago> pagos = new ArrayList<Pago>();
        try {
            this.abrirConexion();
            String sql="SELECT "+this.obtenerProyeccionParaSelect()+" FROM "+this.nombre_tabla;
            sql=sql.concat(this.obtenerPredicadoParaListado());
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, idMatricula);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(pagos, this.resultSet);
            }
           
        } catch (SQLException ex) {
            System.err.println("Error");
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return pagos;
    }
    @Override
    public ArrayList<Pago> listarTodosXIdMatricula(int idMatricula) {
        ArrayList<Pago> pagos = new ArrayList<Pago>();

        try {
            this.abrirConexion();
            String sql = "SELECT " + this.obtenerProyeccionParaSelect() + " FROM " + this.nombre_tabla;
            sql += this.obtenerPredicadoParaListadoPoridMatricula();
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, idMatricula);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(pagos, this.resultSet);
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
        return pagos;
    }

    @Override
    public ArrayList<Pago> listarTodosPorGrado(int idGrado) {
        ArrayList<Pago> pagos = new ArrayList<Pago>();

        try {
            this.abrirConexion();
            String sql = "SELECT a.idPago,a.estado, a.fid_Matricula,a.fechaCreacion,a.fechaPago "
                    + "FROM Pago a, Matricula b WHERE b.idMatricula = a.fid_Matricula "
                    + "AND b.fid_GradoAcademico = ?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, idGrado);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                Pago pago = new Pago();
                pago.setIdPago(this.resultSet.getInt("idPago"));
                pago.setEstado(EstadoDePago.valueOf(this.resultSet.getString("estado")));
                pago.setFechaCreacion(this.resultSet.getDate("fechaCreacion"));
                pago.setFechaPago(this.resultSet.getDate("fechaPago"));

                Matricula matricula = new Matricula();
                matricula.setIdMatricula(this.resultSet.getInt("fid_Matricula"));
                pago.setMatricula(matricula);

                pagos.add(pago);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } 
        finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }

        return pagos;
    }
}


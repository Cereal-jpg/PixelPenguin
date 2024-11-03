/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.anioacademico.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.PagoDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDePago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDeComprobante;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDePago;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public class PagoDAOImpl implements PagoDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public Integer insertar(Pago pago) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PAGO(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, pago.getIdPago());
            cs.setDate(2, new java.sql.Date(pago.getFechaCreacion().getTime()));
            cs.setDate(3, new java.sql.Date(pago.getFechaPago().getTime()));
            cs.setDouble(4, pago.getMonto());
            cs.setString(5, pago.getTipoPago().toString());
            cs.setString(6, pago.getEstado().toString());
            cs.setString(7, pago.getTipoDeComprobante().toString());
            cs.setInt(8, pago.getIdMatricula());
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public Integer modificar(Pago pago) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PAGO(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, pago.getIdPago());
            cs.setDate(2, new java.sql.Date(pago.getFechaCreacion().getTime()));
            cs.setDate(3, new java.sql.Date(pago.getFechaPago().getTime()));
            cs.setDouble(4, pago.getMonto());
            cs.setString(5, pago.getTipoPago().toString());
            cs.setString(6, pago.getEstado().toString());
            cs.setString(7, pago.getTipoDeComprobante().toString());
            cs.setInt(8, pago.getIdMatricula());
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;    }

    @Override
    public Integer eliminar(Pago pago) {
        int resultado =0;
          try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_PAGO(?)}");
            cs.setInt(1,pago.getIdPago());     
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Pago> listarTodos() {
        ArrayList<Pago> pagosE = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODOS_PAGO()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setFechaCreacion(rs.getDate("fechaCreacion"));
                pago.setFechaPago(rs.getDate("fechaPago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setTipoPago(TipoDePago.valueOf(rs.getString("tipoPago"))); 
                pago.setEstado(EstadoDePago.valueOf(rs.getString("estado"))); 
                pago.setTipoDeComprobante(TipoDeComprobante.valueOf(rs.getString("tipoDeComprobante")));
                pago.setIdMatricula(rs.getInt("idMatricula"));
                pagosE.add(pago);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return pagosE;
    }

    @Override
    public Pago obtenerPorId(int idPago) {
        Pago pago = null;
         try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PAGO_POR_ID(?)}");
            cs.setInt(1,idPago);    
            rs = cs.executeQuery();
            
            if(rs.next()){
                pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setFechaCreacion(rs.getDate("fechaCreacion"));
                pago.setFechaPago(rs.getDate("fechaPago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setTipoPago(TipoDePago.valueOf(rs.getString("tipoPago"))); 
                pago.setEstado(EstadoDePago.valueOf(rs.getString("estado"))); 
                pago.setTipoDeComprobante(TipoDeComprobante.valueOf(rs.getString("tipoDeComprobante")));
                pago.setIdMatricula(rs.getInt("idMatricula"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return pago;
    }
    
}

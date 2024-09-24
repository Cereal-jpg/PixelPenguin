/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected Statement statement;
    protected ResultSet resultSet;    

    public DAOImpl(String nombre_tabla){
        this.nombre_tabla = nombre_tabla;
    }
    
    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
        }
    }

    protected void iniciarTransaccion() throws SQLException {
        this.conexion = DBManager.getInstance().getConnection();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected Integer ejecutarModificacionesEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        return this.statement.executeUpdate(sql);
    }
    
    protected void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.statement = this.conexion.createStatement();
        this.resultSet = this.statement.executeQuery(sql);
    }

    public int insertar() {
        Integer resultado = 0;
        try {
            this.iniciarTransaccion();
            String sql = this.generarSQLParaInsercion();
            resultado = this.ejecutarModificacionesEnBD(sql);
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    private String generarSQLParaInsercion() {
        String sql = "insert into "+nombre_tabla+" (";
        sql += this.obtenerListaAtributosParaInsertar();
        sql += " ) values (";
        sql += this.obtenerListaValoresParaInsertar();
        sql += ")";      
        return sql;
    }

    protected abstract String obtenerListaAtributosParaInsertar();
    
    protected abstract String obtenerListaValoresParaInsertar();

}
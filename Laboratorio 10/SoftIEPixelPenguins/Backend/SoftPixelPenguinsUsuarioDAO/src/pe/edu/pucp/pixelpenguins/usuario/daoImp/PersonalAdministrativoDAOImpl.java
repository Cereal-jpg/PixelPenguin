package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.PersonalAdministrativoDAO;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;
import pe.edu.pucp.softpub.config.Tipo_Operacion;

public class PersonalAdministrativoDAOImpl extends DAOImpl implements PersonalAdministrativoDAO {
    
    private PersonalAdministrativo personalAdministrativo;

    public PersonalAdministrativoDAOImpl() {
        super("PersonalAdministrativo");
        this.personalAdministrativo = null;
    }

    @Override
    public Integer insertar(PersonalAdministrativo personalAdministrativo) {
        this.personalAdministrativo = personalAdministrativo;
        Integer idUsuario = null;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        usuario.setDni(personalAdministrativo.getDni());
        usuario.setNombreCompleto(personalAdministrativo.getNombreCompleto());
        usuario.setFechaNacimiento(personalAdministrativo.getFechaNacimiento());
        usuario.setDireccion(personalAdministrativo.getDireccion());
        usuario.setEmail(personalAdministrativo.getEmail());
        usuario.setSexo(personalAdministrativo.getSexo());
        usuario.setUsername(personalAdministrativo.getUsername());
        usuario.setPassword(personalAdministrativo.getPassword());
        usuario.setRol(personalAdministrativo.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existePersonal = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idUsuario = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                personalAdministrativo.setIdUsuario(idUsuario);
            } else {
                idUsuario = usuario.getIdUsuario();
                personalAdministrativo.setIdUsuario(idUsuario);
                existePersonal = this.existePersonal(personalAdministrativo, false);
            }
            if (!existePersonal) {
                super.insertar();
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idUsuario;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idPersonalAdministrativo, codigoPersonalAdministrativo";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, personalAdministrativo.getIdUsuario());
        this.incluirParametroInt(2, personalAdministrativo.getCodigoPersonalAdministrativo());
    }

    @Override
    public Integer modificar(PersonalAdministrativo personalAdministrativo) {
        this.personalAdministrativo = personalAdministrativo;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        usuario.setIdUsuario(personalAdministrativo.getIdUsuario());
        usuario.setDni(personalAdministrativo.getDni());
        usuario.setNombreCompleto(personalAdministrativo.getNombreCompleto());
        usuario.setFechaNacimiento(personalAdministrativo.getFechaNacimiento());
        usuario.setDireccion(personalAdministrativo.getDireccion());
        usuario.setEmail(personalAdministrativo.getEmail());
        usuario.setSexo(personalAdministrativo.getSexo());
        usuario.setUsername(personalAdministrativo.getUsername());
        usuario.setPassword(personalAdministrativo.getPassword());
        usuario.setRol(personalAdministrativo.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            usuarioDAO.modificar(usuario, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al modificar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "codigoPersonalAdministrativo=?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(1, personalAdministrativo.getCodigoPersonalAdministrativo());
        this.incluirParametroInt(2, personalAdministrativo.getIdUsuario());
    }
    
    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idPersonalAdministrativo=?";
    }

    @Override
    public Integer eliminar(PersonalAdministrativo personalAdministrativo) {
        this.personalAdministrativo = personalAdministrativo;
        Integer retorno = 0;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        usuario.setIdUsuario(this.personalAdministrativo.getIdUsuario());
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            usuarioDAO.eliminar(usuario, this.usarTransaccion, this.conexion);
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.personalAdministrativo.getIdUsuario());
    }

    @Override
    public ArrayList<PersonalAdministrativo> listarTodos() {
        return (ArrayList<PersonalAdministrativo>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pa ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = pa.idPersonalAdministrativo ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }
    
    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "usu.idUsuario, usu.dni, usu.nombreCompleto, usu.fechaNacimiento,"
                + " usu.direccion, usu.email, usu.sexo, usu.username, usu.password, usu.fid_rol";
        sql = sql.concat(", pa.codigoPersonalAdministrativo");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.personalAdministrativo);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.personalAdministrativo = new PersonalAdministrativo();
        this.personalAdministrativo.setIdUsuario(resultSet.getInt("idUsuario"));
        this.personalAdministrativo.setDni(resultSet.getString("dni"));
        this.personalAdministrativo.setNombreCompleto(resultSet.getString("nombreCompleto"));
        this.personalAdministrativo.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        this.personalAdministrativo.setDireccion(resultSet.getString("direccion"));
        this.personalAdministrativo.setEmail(resultSet.getString("email"));
        this.personalAdministrativo.setSexo(resultSet.getString("sexo"));
        this.personalAdministrativo.setUsername(resultSet.getString("username"));
        this.personalAdministrativo.setPassword(resultSet.getString("password"));
        this.personalAdministrativo.setRol(new Rol(resultSet.getInt("fid_rol")));
        this.personalAdministrativo.setCodigoPersonalAdministrativo(resultSet.getInt("codigoPersonalAdministrativo"));
    }
    
    @Override
    public PersonalAdministrativo obtenerPorId(Integer idUsuario) {
        this.personalAdministrativo = new PersonalAdministrativo();
        this.personalAdministrativo.setIdUsuario(idUsuario);
        super.obtenerPorId();
        return this.personalAdministrativo;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" pa ");
        sql = sql.concat("join Usuario usu on usu.idUsuario = pa.idPersonalAdministrativo ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.personalAdministrativo.getIdUsuario());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.personalAdministrativo = null;
    }
    
    @Override
    public Boolean existePersonal(PersonalAdministrativo personalAdministrativo) {
        Boolean abreConexion = true;
        return existePersonal(personalAdministrativo, abreConexion);
    }
    
    @Override
    public Boolean existePersonal(PersonalAdministrativo personalAdministrativo, Boolean abreConexion) {
        this.personalAdministrativo = personalAdministrativo;
        Integer idUsuario = null;

        try {
            if (abreConexion) this.abrirConexion();
            String sql = "select idPersonalAdministrativo from PersonalAdministrativo where idPersonalAdministrativo=?";
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, personalAdministrativo.getIdUsuario());
            this.ejecutarConsultaEnBD(sql);

            if (this.resultSet.next()) {
                idUsuario = this.resultSet.getInt("idPersonalAdministrativo");
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar existencia de personal - " + ex);
        } finally {
            try {
                if (abreConexion) this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar conexión - " + ex);
            }
        }
        return idUsuario != null;
    }
    
}

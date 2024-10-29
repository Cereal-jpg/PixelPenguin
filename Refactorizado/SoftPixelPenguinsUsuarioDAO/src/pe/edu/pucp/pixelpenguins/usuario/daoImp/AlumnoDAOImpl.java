package pe.edu.pucp.pixelpenguins.usuario.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.dao.UsuarioDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public class AlumnoDAOImpl extends DAOImpl implements AlumnoDAO {
    
    private Alumno alumno;

    public AlumnoDAOImpl() {
        super("Alumno");
        this.alumno = null;
    }

    @Override
    public Integer insertar(Alumno alumno) {
        this.alumno = alumno;
        Integer idUsuario = null;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        usuario.setDni(this.alumno.getDni());
        usuario.setNombreCompleto(this.alumno.getNombreCompleto());
        usuario.setFechaNacimiento(this.alumno.getFechaNacimiento());
        usuario.setDireccion(this.alumno.getDireccion());
        usuario.setEmail(this.alumno.getEmail());
        usuario.setSexo(this.alumno.getSexo());
        usuario.setUsername(this.alumno.getUsername());
        usuario.setPassword(this.alumno.getPassword());
        usuario.setRol(this.alumno.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeAlumno = false;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idUsuario = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                this.alumno.setIdUsuario(idUsuario);
            } else {
                idUsuario = usuario.getIdUsuario();
                this.alumno.setIdUsuario(idUsuario);
                existeAlumno = this.existeAlumno(this.alumno, false);
            }
            if (!existeAlumno) {
                super.insertar();
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idUsuario;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "idAlumno, codigoAlumno, conCertificadoDeEstudios, conCertificadoDeSalud, conDeuda, fid_Apoderado, fid_GradoAcademico";        
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.alumno.getIdUsuario());
        this.incluirParametroInt(2, this.alumno.getCodigoAlumno());
        this.incluirParametroBoolean(3, this.alumno.isConCertificadoDeEstudios());
        this.incluirParametroBoolean(4, this.alumno.isConCertificadoDeSalud());
        this.incluirParametroBoolean(5, this.alumno.isConDeuda());
        this.incluirParametroInt(6, this.alumno.getApoderado().getIdApoderado());
        this.incluirParametroInt(7, this.alumno.getGradoAcademico().getIdGradoAcademico()); 
    }

    @Override
    public Integer modificar(Alumno alumno) {
        Integer retorno = 0;
        this.alumno = alumno;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        usuario.setIdUsuario(this.alumno.getIdUsuario());
        usuario.setDni(this.alumno.getDni());
        usuario.setNombreCompleto(this.alumno.getNombreCompleto());
        usuario.setFechaNacimiento(this.alumno.getFechaNacimiento());
        usuario.setDireccion(this.alumno.getDireccion());
        usuario.setEmail(this.alumno.getEmail());
        usuario.setSexo(this.alumno.getSexo());
        usuario.setUsername(this.alumno.getUsername());
        usuario.setPassword(this.alumno.getPassword());
        usuario.setRol(this.alumno.getRol());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            usuarioDAO.modificar(usuario, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "codigoAlumno=?, conCertificadoDeEstudios=?, conCertificadoDeSalud=?, conDeuda=?, fid_Apoderado=?, fid_GradoAcademico=?"; 
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroInt(6, this.alumno.getIdUsuario());
        this.incluirParametroInt(1, this.alumno.getCodigoAlumno());
        this.incluirParametroBoolean(2, this.alumno.isConCertificadoDeEstudios());
        this.incluirParametroBoolean(3, this.alumno.isConCertificadoDeSalud());
        this.incluirParametroBoolean(4, this.alumno.isConDeuda());
        this.incluirParametroInt(5, this.alumno.getApoderado().getIdApoderado());
        this.incluirParametroInt(6, this.alumno.getGradoAcademico().getIdGradoAcademico());
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "idAlumno=?";
    }

    @Override
    public Integer eliminar(Alumno alumno) {
        Integer retorno = 0;
        this.alumno = alumno;
        Usuario usuario = new Usuario() {
            @Override
            public String consultarInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        usuario.setIdUsuario(this.alumno.getIdUsuario());        

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            usuarioDAO.eliminar(usuario, this.usarTransaccion, this.conexion);            
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return retorno;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.alumno.getIdUsuario());
    }

    @Override
    public ArrayList<Alumno> listarTodos() {
        return (ArrayList<Alumno>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" alu ");
        sql = sql.concat("join usuario usr on usr.idUsuario = alu.idUsuario ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "usr.idUsuario, usr.dni, usr.nombre, usr.fechaNacimiento, ";
        sql = sql.concat("usr.direccion, usr.email, usr.sexo, usr.username, ");
        sql = sql.concat("alu.codigoAlumno, alu.conCertificadoDeEstudios, alu.conCertificadoDeSalud, alu.conDeuda, ");
        sql = sql.concat("alu.fid_Apoderado, alu.fid_GradoAcademico");
        return sql;
    }
    
     @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.alumno);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.alumno = new Alumno();
        this.alumno.setIdUsuario(resultSet.getInt("idUsuario"));
        this.alumno.setDni(resultSet.getString("dni"));
        this.alumno.setNombreCompleto(resultSet.getString("nombreCompleto"));
        this.alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        this.alumno.setDireccion(resultSet.getString("direccion"));
        this.alumno.setEmail(resultSet.getString("email"));
        this.alumno.setSexo(resultSet.getString("sexo"));
        this.alumno.setUsername(resultSet.getString("username"));
        this.alumno.setPassword(resultSet.getString("passsword"));
        this.alumno.setRol(new Rol(resultSet.getInt("fid_rol")));
        this.alumno.setCodigoAlumno(resultSet.getInt("codigoAlumno"));
        this.alumno.setConCertificadoDeEstudios(resultSet.getBoolean("conCertificadoDeEstudios"));
        this.alumno.setConCertificadoDeSalud(resultSet.getBoolean("conCertificadoDeSalud"));
        this.alumno.setConDeuda(resultSet.getBoolean("conDeuda"));
        
        Apoderado apoderado = new Apoderado();
        apoderado.setIdApoderado(resultSet.getInt("fid_Apoderado"));
        this.alumno.setApoderado(apoderado);
        
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setIdGradoAcademico(resultSet.getInt("fid_GradoAcademico"));
        this.alumno.setGradoAcademico(gradoAcademico);
    }
    
    @Override
    public Alumno obtenerPorId(Integer idUsuario) {
        this.alumno = new Alumno();
        this.alumno.setIdUsuario(idUsuario);
        super.obtenerPorId();
        return this.alumno;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" alu ");
        sql = sql.concat("join Usuario usr on usr.idUsuario = alu.idAlumno ");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.alumno.getIdUsuario());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.alumno = null;
    }
    
    @Override
    public Boolean existeAlumno(Alumno alumno) {
        Boolean abreConexion = true;
        return existeAlumno(alumno, abreConexion);
    }
    
    @Override
    public Boolean existeAlumno(Alumno alumno, Boolean abreConexion) {
        this.alumno = alumno;
        Integer idPersona = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select idAlumno from Alumno where ";
            sql = sql.concat("idUsuario=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.alumno.getIdUsuario());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("idAlumno");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idPersona != null;
    }
    
}

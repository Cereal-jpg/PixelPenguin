package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public interface UsuarioDAO {
    public Integer insertar(Usuario usuario);
    public Integer insertar(Usuario usuario, Boolean usarTransaccion, Connection conexion);
    public Integer modificar(Usuario usuario);
    public Integer modificar(Usuario usuario, Boolean usarTransaccion, Connection conexion);
    public Integer eliminar(Usuario usuario);
    public Integer eliminar(Usuario usuario, Boolean usarTransaccion, Connection conexion);
    public ArrayList<Usuario> listarTodos();
    public Usuario obtenerPorId (Integer idUsuario);
    public Boolean existeUsuario(Usuario usuario);
    public ArrayList<Usuario>listarUsuariosPorNombre(String nombre); 
    public Integer ValidarDatos(String correo,String contra);
}

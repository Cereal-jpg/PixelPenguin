package pe.edu.pucp.pixelpenguins.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;

public interface UsuarioDAO {
    public Integer insertar(Usuario usuario);
    public Integer modificar(Usuario usuario);
    public Integer eliminar(Usuario usuario);
    public ArrayList<Usuario> listarTodos();
    public Usuario obtenerPorId (Integer idUsuario);
}

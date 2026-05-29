package org.joaquinsanchez.model.dao;

import java.util.List;
import org.joaquinsanchez.model.Usuario;

public interface UsuarioDAO {
    boolean agregar(Usuario u);
    List<Usuario> listar();
    Usuario buscar(int id);
    boolean actualizar(Usuario u);
    boolean eliminar(int id);
}
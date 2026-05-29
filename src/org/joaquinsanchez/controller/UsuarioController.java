package org.joaquinsanchez.controller;

import java.util.List;
import org.joaquinsanchez.model.Usuario;
import org.joaquinsanchez.model.dao.UsuarioDAO;
import org.joaquinsanchez.model.dao.UsuarioDAOImpl;
import org.joaquinsanchez.view.UsuarioView;

public class UsuarioController {
    private final UsuarioDAO dao = new UsuarioDAOImpl();
    private final UsuarioView view = new UsuarioView();

    public void ejecutar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    eliminar();
                    break;
                case 6:
                    view.mostrarMensaje("Regresando al menu principal...");
                    break;
                default:
                    view.mostrarMensaje("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        Usuario u = new Usuario();
        u.setIdUsuario(view.solicitarID());
        u.setUsername(view.solicitarUsername());
        u.setCorreo(view.solicitarCorreo());
        u.setContrasena(view.solicitarContrasena());
        if (dao.agregar(u)) {
            view.mostrarMensaje("Usuario registrado con exito.");
        } else {
            view.mostrarMensaje("Error al registrar el usuario.");
        }
    }

    private void listar() {
        List<Usuario> lista = dao.listar();
        if (lista.isEmpty()) {
            view.mostrarMensaje("No hay usuarios registrados.");
        } else {
            view.mostrarTodos(lista);
        }
    }

    private void buscar() {
        int id = view.solicitarID();
        Usuario u = dao.buscar(id);
        if (u != null) {
            view.mostrarUsuario(u);
        } else {
            view.mostrarMensaje("Usuario no encontrado.");
        }
    }

    private void actualizar() {
        int id = view.solicitarID();
        Usuario u = dao.buscar(id);
        if (u != null) {
            u.setUsername(view.solicitarUsername());
            u.setCorreo(view.solicitarCorreo());
            u.setContrasena(view.solicitarContrasena());
            if (dao.actualizar(u)) {
                view.mostrarMensaje("Usuario actualizado con exito.");
            } else {
                view.mostrarMensaje("Error al actualizar el usuario.");
            }
        } else {
            view.mostrarMensaje("Usuario no encontrado.");
        }
    }

    private void eliminar() {
        int id = view.solicitarID();
        if (dao.buscar(id) != null) {
            if (dao.eliminar(id)) {
                view.mostrarMensaje("Usuario eliminado con exito.");
            } else {
                view.mostrarMensaje("Error al eliminar el usuario.");
            }
        } else {
            view.mostrarMensaje("Usuario no encontrado.");
        }
    }
}
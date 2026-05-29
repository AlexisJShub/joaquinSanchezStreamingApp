package org.joaquinsanchez.controller;

import java.util.List;
import org.joaquinsanchez.model.EstudioCine;
import org.joaquinsanchez.model.dao.EstudioCineDAO;
import org.joaquinsanchez.model.dao.EstudioCineDAOImpl;
import org.joaquinsanchez.view.EstudioCineView;

public class EstudioCineController {
    private final EstudioCineDAO dao = new EstudioCineDAOImpl();
    private final EstudioCineView view = new EstudioCineView();

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
        EstudioCine e = new EstudioCine();
        e.setIdEstudio(view.solicitarID());
        e.setNombreEstudio(view.solicitarNombre());
        e.setPais(view.solicitarPais());
        e.setSedeCentral(view.solicitarSedeCentral());
        if (dao.agregar(e)) {
            view.mostrarMensaje("Estudio registrado con exito.");
        } else {
            view.mostrarMensaje("Error al registrar el estudio.");
        }
    }

    private void listar() {
        List<EstudioCine> lista = dao.listar();
        if (lista.isEmpty()) {
            view.mostrarMensaje("No hay estudios registrados.");
        } else {
            view.mostrarTodos(lista);
        }
    }

    private void buscar() {
        int id = view.solicitarID();
        EstudioCine e = dao.buscar(id);
        if (e != null) {
            view.mostrarEstudio(e);
        } else {
            view.mostrarMensaje("Estudio no encontrado.");
        }
    }

    private void actualizar() {
        int id = view.solicitarID();
        EstudioCine e = dao.buscar(id);
        if (e != null) {
            e.setNombreEstudio(view.solicitarNombre());
            e.setPais(view.solicitarPais());
            e.setSedeCentral(view.solicitarSedeCentral());
            if (dao.actualizar(e)) {
                view.mostrarMensaje("Estudio actualizado con exito.");
            } else {
                view.mostrarMensaje("Error al actualizar el estudio.");
            }
        } else {
            view.mostrarMensaje("Estudio no encontrado.");
        }
    }

    private void eliminar() {
        int id = view.solicitarID();
        if (dao.buscar(id) != null) {
            if (dao.eliminar(id)) {
                view.mostrarMensaje("Estudio eliminado con exito.");
            } else {
                view.mostrarMensaje("Error al eliminar el estudio.");
            }
        } else {
            view.mostrarMensaje("Estudio no encontrado.");
        }
    }
}
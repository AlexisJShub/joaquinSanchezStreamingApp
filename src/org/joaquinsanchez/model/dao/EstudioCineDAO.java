package org.joaquinsanchez.model.dao;

import java.util.List;
import org.joaquinsanchez.model.EstudioCine;

public interface EstudioCineDAO {
    boolean agregar(EstudioCine estudio);
    List<EstudioCine> listar();
    EstudioCine buscar(int id);
    boolean actualizar(EstudioCine estudio);
    boolean eliminar(int id);
}
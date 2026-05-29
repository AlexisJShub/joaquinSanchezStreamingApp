package org.joaquinsanchez.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joaquinsanchez.model.EstudioCine;
import org.joaquinsanchez.model.conexion.Conexion;

public class EstudioCineDAO {
    private final Conexion con = new Conexion();

    public boolean agregar(EstudioCine estudio) {
        Connection connection = con.conectar();
        PreparedStatement ps = null;
        String sql = "INSERT INTO estudio_cine (id_estudio, nombre_estudio, pais, sede_central) VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, estudio.getIdEstudio());
            ps.setString(2, estudio.getNombreEstudio());
            ps.setString(3, estudio.getPais());
            ps.setString(4, estudio.getSedeCentral());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }

    public List<EstudioCine> listar() {
        List<EstudioCine> lista = new ArrayList<EstudioCine>();
        Connection connection = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id_estudio, nombre_estudio, pais, sede_central FROM estudio_cine";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EstudioCine e = new EstudioCine();
                e.setIdEstudio(rs.getInt("id_estudio"));
                e.setNombreEstudio(rs.getString("nombre_estudio"));
                e.setPais(rs.getString("pais"));
                e.setSedeCentral(rs.getString("sede_central"));
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            con.desconectar();
        }
        return lista;
    }

    public EstudioCine buscar(int id) {
        EstudioCine e = null;
        Connection connection = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id_estudio, nombre_estudio, pais, sede_central FROM estudio_cine WHERE id_estudio = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                e = new EstudioCine();
                e.setIdEstudio(rs.getInt("id_estudio"));
                e.setNombreEstudio(rs.getString("nombre_estudio"));
                e.setPais(rs.getString("pais"));
                e.setSedeCentral(rs.getString("sede_central"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            con.desconectar();
        }
        return e;
    }

    public boolean actualizar(EstudioCine estudio) {
        Connection connection = con.conectar();
        PreparedStatement ps = null;
        String sql = "UPDATE estudio_cine SET nombre_estudio = ?, pais = ?, sede_central = ? WHERE id_estudio = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, estudio.getNombreEstudio());
            ps.setString(2, estudio.getPais());
            ps.setString(3, estudio.getSedeCentral());
            ps.setInt(4, estudio.getIdEstudio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }

    public boolean eliminar(int id) {
        Connection connection = con.conectar();
        PreparedStatement ps = null;
        String sql = "DELETE FROM estudio_cine WHERE id_estudio = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }
}
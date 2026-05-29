package org.joaquinsanchez.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joaquinsanchez.model.Usuario;
import org.joaquinsanchez.model.conexion.Conexion;

public class UsuarioDAO {
    private final Conexion con = new Conexion();

    // CREATE - sp_crear_usuario
    public boolean agregar(Usuario usuario, String contrasena) {
        Connection connection = con.conectar();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call sp_crear_usuario(?, ?, ?, ?)}");
            cs.setInt(1, usuario.getIdUsuario());
            cs.setString(2, usuario.getUsername());
            cs.setString(3, usuario.getCorreo());
            cs.setString(4, contrasena);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }

    // READ ALL - sp_listar_usuarios (Usa alias ID, USUARIO, CORREO)
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        Connection connection = con.conectar();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{call sp_listar_usuarios()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("ID"));
                u.setUsername(rs.getString("USUARIO"));
                u.setCorreo(rs.getString("CORREO"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (cs != null) cs.close(); } catch (SQLException e) {}
            con.desconectar();
        }
        return lista;
    }

    // READ ONE - sp_buscar_usuario
    public Usuario buscar(int id) {
        Usuario u = null;
        Connection connection = con.conectar();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{call sp_buscar_usuario(?)}");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (cs != null) cs.close(); } catch (SQLException e) {}
            con.desconectar();
        }
        return u;
    }

    // UPDATE - sp_actualizar_usuario
    public boolean actualizar(Usuario usuario, String contrasena) {
        Connection connection = con.conectar();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call sp_actualizar_usuario(?, ?, ?, ?)}");
            cs.setInt(1, usuario.getIdUsuario());
            cs.setString(2, usuario.getUsername());
            cs.setString(3, usuario.getCorreo());
            cs.setString(4, contrasena);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }

    // DELETE - sp_eliminar_usuario
    public boolean eliminar(int id) {
        Connection connection = con.conectar();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call sp_eliminar_usuario(?)}");
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException e) {}
            con.desconectar();
        }
    }
}
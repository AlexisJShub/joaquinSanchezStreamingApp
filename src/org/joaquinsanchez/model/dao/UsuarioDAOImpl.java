package org.joaquinsanchez.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joaquinsanchez.model.Usuario;
import org.joaquinsanchez.model.conexion.Conexion;

public class UsuarioDAOImpl implements UsuarioDAO {
    private final Conexion con = new Conexion();

    public boolean agregar(Usuario u) {
        Connection connection = null;
        CallableStatement cs = null;
        try {
            connection = con.conectar();
            cs = connection.prepareCall("{call sp_crear_usuario(?, ?, ?, ?)}");
            cs.setInt(1, u.getIdUsuario());
            cs.setString(2, u.getUsername());
            cs.setString(3, u.getCorreo());
            cs.setString(4, u.getContrasena());
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException ex) {}
            con.desconectar();
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        Connection connection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            connection = con.conectar();
            cs = connection.prepareCall("{call sp_listar_usuarios()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("ID"));
                u.setUsername(rs.getString("USUARIO"));
                u.setCorreo(rs.getString("CORREO"));
                lista.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (cs != null) cs.close(); } catch (SQLException ex) {}
            con.desconectar();
        }
        return lista;
    }

    public Usuario buscar(int id) {
        Usuario u = null;
        Connection connection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            connection = con.conectar();
            cs = connection.prepareCall("{call sp_buscar_usuario(?)}");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (cs != null) cs.close(); } catch (SQLException ex) {}
            con.desconectar();
        }
        return u;
    }

    public boolean actualizar(Usuario u) {
        Connection connection = null;
        CallableStatement cs = null;
        try {
            connection = con.conectar();
            cs = connection.prepareCall("{call sp_actualizar_usuario(?, ?, ?, ?)}");
            cs.setInt(1, u.getIdUsuario());
            cs.setString(2, u.getUsername());
            cs.setString(3, u.getCorreo());
            cs.setString(4, u.getContrasena());
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException ex) {}
            con.desconectar();
        }
    }

    public boolean eliminar(int id) {
        Connection connection = null;
        CallableStatement cs = null;
        try {
            connection = con.conectar();
            cs = connection.prepareCall("{call sp_eliminar_usuario(?)}");
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try { if (cs != null) cs.close(); } catch (SQLException ex) {}
            con.desconectar();
        }
    }
}
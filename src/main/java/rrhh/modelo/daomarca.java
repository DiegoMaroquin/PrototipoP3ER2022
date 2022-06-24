/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clsmarca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daomarca {

    private static final String SQL_SELECT = "SELECT deparid, deparnombre, deparestado FROM tbl_departamentos";
    private static final String SQL_INSERT = "INSERT INTO tbl_departamentos(deparnombre, deparestado) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_departamentos SET deparnombre=?, deparestado=? WHERE deparid= ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_departamentos WHERE deparid=?";
    private static final String SQL_QUERY = "SELECT  deparid,  deparnombre, deparestado FROM tbl_departamentos WHERE deparid= ?";

    public List<clsmarca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsmarca usuario = null;
        List<clsmarca> usuarios = new ArrayList<clsmarca>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("deparid");
                String nombre = rs.getString("deparnombre");
                String estatus = rs.getString("deparestado");

                usuario = new clsmarca();
                usuario.setdeparid(codigo);
                usuario.setdeparnombre(nombre);
                usuario.setdeparestado(estatus);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsmarca perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getdeparnombre());
            stmt.setString(2, perfil.getdeparestado());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsmarca perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, perfil.getdeparnombre());
            stmt.setString(2, perfil.getdeparestado());
            stmt.setInt(3, perfil.getdeparid());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsmarca perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getdeparid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsmarca query(clsmarca perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, perfil.getdeparid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("deparid");
                String nombre = rs.getString("deparnombre");
                String estatus = rs.getString("deparestado");

                perfil = new clsmarca();
                perfil.setdeparid(codigo);
                perfil.setdeparnombre(nombre);
                perfil.setdeparestado(estatus);
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}

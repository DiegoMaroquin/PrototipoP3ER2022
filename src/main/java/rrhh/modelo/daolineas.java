/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clslineas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daolineas {

    private static final String SQL_SELECT = "SELECT codigo_linea, nombre_linea, estatus_linea FROM lineas";
    private static final String SQL_INSERT = "INSERT INTO lineas(nombre_linea,estatus_linea) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE lineas SET nombre_linea=?, estatus_linea=? WHERE codigo_linea = ?";
    private static final String SQL_DELETE = "DELETE FROM lineas WHERE codigo_linea=?";
    private static final String SQL_QUERY = "SELECT  codigo_linea, nombre_linea, estatus_linea FROM lineas WHERE codigo_linea = ?";

    public List<clslineas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clslineas cargo = null;
        List<clslineas> cargos = new ArrayList<clslineas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_linea");
                String nombre = rs.getString("nombre_linea");
                String estatus = rs.getString("estatus_linea");

                cargo = new clslineas();
                cargo.setcodigo_linea(id);
                cargo.setnombre_linea(nombre);
                cargo.setestatus_linea(estatus);

                cargos.add(cargo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cargos;
    }

    public int insert(clslineas cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cargo.getnombre_linea());
            stmt.setString(2, cargo.getestatus_linea());

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

    public int update(clslineas cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
         
            stmt.setString(1, cargo.getnombre_linea());
            stmt.setString(2, cargo.getestatus_linea());
            stmt.setInt(3, cargo.getcodigo_linea());
            
            
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

    public int delete(clslineas cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cargo.getcodigo_linea());
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

    public clslineas query(clslineas cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cargo.getcodigo_linea());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_linea");
                String nombre = rs.getString("nombre_linea");
                String estatus = rs.getString("estatus_linea");

                cargo = new clslineas();
                cargo.setcodigo_linea(id);
                cargo.setnombre_linea(nombre);
                cargo.setestatus_linea(estatus);
                
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
        return cargo;
    }
}

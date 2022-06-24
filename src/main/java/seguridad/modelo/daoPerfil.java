/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author visitante
 */
public class daoPerfil {

    private static final String SQL_SELECT = "SELECT perid, pernombre, perestatus FROM tbl_perfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfil(pernombre, perestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfil SET pernombre=?, perestatus=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfil WHERE perid=?";
    private static final String SQL_QUERY = "SELECT perid, pernombre, perestatus FROM tbl_perfil WHERE perid = ?";

 public List<clsPerfil> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfil perfil = null;
        List<clsPerfil> perfiles = new ArrayList<clsPerfil>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_perfil = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estado = rs.getString("perestatus");
                
                perfil = new clsPerfil();
                perfil.setId_Perfil(id_perfil);
                perfil.setNombrePerfil(nombre);
                perfil.setEstadoPerfil(estado);
                
                perfiles.add(perfil);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return perfiles;
    }

    public int insert(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstadoPerfil());


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

    public int update(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstadoPerfil());
            stmt.setInt(3, perfil.getId_Perfil());

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

    public int delete(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getId_Perfil());
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

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsPerfil query(clsPerfil perfil) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPerfil> perfiles = new ArrayList<clsPerfil>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil.getId_Perfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_perfil = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estado = rs.getString("perestatus");
                
                perfil = new clsPerfil();
                perfil.setId_Perfil(id_perfil);
                perfil.setNombrePerfil(nombre);
                perfil.setEstadoPerfil(estado);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return perfil;
    }
        
}

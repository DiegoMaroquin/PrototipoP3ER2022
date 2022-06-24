/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfilUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author visitante
 */
public class daoPerfilUsuario {

    private static final String SQL_SELECT = "SELECT perusuid, pernombre, usunombre FROM tbl_perfilusuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfilusuario(pernombre, usunombre) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfilusuario SET pernombre=?, usunombre=? WHERE perusuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfilusuario WHERE perusuid=?";
    private static final String SQL_QUERY = "SELECT perusuid, pernombre, usunombre FROM tbl_perfilusuario WHERE perusuid = ?";

    
   public List<clsPerfilUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilUsuario perfilusuario = null;
        List<clsPerfilUsuario> perfilusuarios = new ArrayList<clsPerfilUsuario>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_perfilusuario = rs.getInt("perusuid");
                String nombreperfil = rs.getString("pernombre");
                String nombreusuario = rs.getString("usunombre");
                
                perfilusuario = new clsPerfilUsuario();
                perfilusuario.setId_PerfilUsuario(id_perfilusuario);
                perfilusuario.setNombrePerfil(nombreperfil);
                perfilusuario.setNombreUsuario(nombreusuario);
                
                perfilusuarios.add(perfilusuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return perfilusuarios;
    }

    public int insert(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfilusuario.getNombrePerfil());
            stmt.setString(2, perfilusuario.getNombreUsuario());


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

    public int update(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfilusuario.getNombrePerfil());
            stmt.setString(2, perfilusuario.getNombreUsuario());
            stmt.setInt(3, perfilusuario.getId_PerfilUsuario());

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

    public int delete(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfilusuario.getId_PerfilUsuario());
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
    public clsPerfilUsuario query(clsPerfilUsuario perfilusuario) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPerfilUsuario> aplicaciones = new ArrayList<clsPerfilUsuario>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfilusuario.getId_PerfilUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_perfilusuario = rs.getInt("perusuid");
                String nombreperfil = rs.getString("pernombre");
                String nombreusuario = rs.getString("usunombre");
                
                perfilusuario = new clsPerfilUsuario();
                perfilusuario.setId_PerfilUsuario(id_perfilusuario);
                perfilusuario.setNombrePerfil(nombreperfil);
                perfilusuario.setNombreUsuario(nombreusuario);
                
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
        return perfilusuario;
    }
        
}

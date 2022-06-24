/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport
import rrhh.controlador.clsConcepto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoConcepto {
    
    private static final String SQL_SELECT = "SELECT concepid, concepnombre, concepefecto, concepestado, concepvalor  FROM tbl_concepto";
    private static final String SQL_INSERT = "INSERT INTO tbl_concepto(concepnombre, concepefecto, concepestado, concepvalor) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_concepto SET concepnombre=?, concepefecto=?, concepestado=?, concepvalor=? WHERE concepid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_concepto WHERE concepid=?";
    private static final String SQL_QUERY = "SELECT concepid, concepnombre, concepefecto, concepestado,concepvalor FROM tbl_concepto WHERE concepid=?";
    private static final String SQL_QUERY2 = "SELECT concepid, concepnombre, concepefecto, concepestado,concepvalor FROM tbl_concepto WHERE concepnombre=?";
  

    public List<clsConcepto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsConcepto concepto = null;
        List<clsConcepto> conceptos = new ArrayList<clsConcepto>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concepid");
                String nombre = rs.getString("concepnombre");
                String efecto = rs.getString("concepefecto");
                String estado = rs.getString("concepestado");
                String valor = rs.getString("concepvalor");
         
               

                concepto = new clsConcepto();
                concepto.setconcepid(id);
                concepto.setconcepnombre(nombre);
                concepto.setconcepefecto(efecto);
                concepto.setconcepestado(estado);
                concepto.setconcepvalor(valor);
                
               
                conceptos.add(concepto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return conceptos;
    }

    public int insert(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getconcepnombre());
            stmt.setString(2, concepto.getconcepefecto());
            stmt.setString(3, concepto.getconcepestado());
              stmt.setString(4, concepto.getconcepvalor());
           
                  
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

    public int update(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getconcepnombre());
            stmt.setString(2, concepto.getconcepefecto());
            stmt.setString(3, concepto.getconcepestado());
            stmt.setString(4, concepto.getconcepvalor());
            stmt.setInt(5, concepto.getconcepid());

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

    public int delete(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getconcepid());
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

    public clsConcepto query(clsConcepto concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getconcepid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concepid");
                String nombre = rs.getString("concepnombre");
                String efecto = rs.getString("concepefecto");
                String estado = rs.getString("concepestado");
                String valor = rs.getString("concepvalor");
               
                

                concepto = new clsConcepto();
                concepto.setconcepid(id);
                concepto.setconcepnombre(nombre);
                concepto.setconcepefecto(efecto);
                concepto.setconcepestado(estado);
                concepto.setconcepvalor(valor);
                 
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
        return concepto;
    }
    
    public clsConcepto query2(clsConcepto concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, concepto.getconcepnombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concepid");
                String nombre = rs.getString("concepnombre");
                String efecto = rs.getString("concepefecto");
                String estado = rs.getString("concepestado");
                String valor = rs.getString("concepvalor");
               
                

                concepto = new clsConcepto();
                concepto.setconcepid(id);
                concepto.setconcepnombre(nombre);
                concepto.setconcepefecto(efecto);
                concepto.setconcepestado(estado);
                concepto.setconcepvalor(valor);
                 
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
        return concepto;
    }
    
}

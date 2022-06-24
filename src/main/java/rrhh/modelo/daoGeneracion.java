/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport

import rrhh.controlador.clsGeneracion;
import rrhh.controlador.clsGeneracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoGeneracion {
    
    private static final String SQL_SELECT = "SELECT geid, geinicial, gefinal, genombre, geconcepto, geigss, geisr, geotros, gevalor  FROM tbl_generacion";
    private static final String SQL_INSERT = "INSERT INTO tbl_generacion(geinicial, gefinal, genombre, geconcepto, geigss, geisr, geotros, gevalor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_generacion SET geinicial =?,gefinal =?, genombre =?, geconcepto =?, geigss =?, geisr =?, geotros=?, gevalor=? WHERE geid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_generacion WHERE geid=?";
    private static final String SQL_QUERY = "SELECT geid,geinicial,gefinal, genombre, geconcepto, geigss, geisr, geotros, gevalor FROM tbl_generacion WHERE geid=?";
  

    public List<clsGeneracion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsGeneracion genera = null;
        List<clsGeneracion> generas = new ArrayList<clsGeneracion>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("geid");
                String geinicial = rs.getString("geinicial");
                String gefinal = rs.getString("gefinal");
                String genombre = rs.getString("genombre");
                String geconcepto = rs.getString("geconcepto");
                String geigss = rs.getString("geigss");
                String geisr = rs.getString("geisr");
                String geotros = rs.getString("geotros");
                String gevalor = rs.getString("gevalor");
               
         
               

                genera = new clsGeneracion();
                genera.setgeid(id);
                genera.setgeinicial(geinicial);
                genera.setgefinal(gefinal);
                genera.setgenombre(genombre);
                genera.setgeconcepto(geconcepto);
                genera.setgeigss(geigss);
                genera.setgeisr(geisr);
                genera.setgeotros(geotros);
                genera.setgevalor(gevalor);
           
                
               
                generas.add(genera);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return generas;
    }

    public int insert(clsGeneracion generas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, generas.getgeinicial());
            stmt.setString(2, generas.getgefinal());
            stmt.setString(3, generas.getgenombre());  
            stmt.setString(4, generas.getgeconcepto());
            stmt.setString(5, generas.getgeigss());
            stmt.setString(6, generas.getgeisr());
            stmt.setString(7, generas.getgeotros());
            stmt.setString(8, generas.getgevalor());

                  
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

    public int update(clsGeneracion genera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, genera.getgeinicial());
            stmt.setString(2, genera.getgefinal());            
            stmt.setString(3, genera.getgenombre());
            stmt.setString(4, genera.getgeconcepto());
            stmt.setString(5, genera.getgeigss());
            stmt.setString(6, genera.getgeisr());
            stmt.setString(7, genera.getgeotros());
            stmt.setString(8, genera.getgevalor());
            stmt.setInt(9, genera.getgeid());

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

    public int delete(clsGeneracion genera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, genera.getgeid());
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

    public clsGeneracion query(clsGeneracion genera) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, genera.getgeid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("geid");
                String geinicial = rs.getString("geinicial");
                String gefinal = rs.getString("gefinal");
                String genombre = rs.getString("genombre");
                String geconcepto = rs.getString("geconcepto");
                String geigss = rs.getString("geigss");
                String geisr = rs.getString("geisr");
                String geotros = rs.getString("geotros");
                String gevalor = rs.getString("gevalor");
                
                              
               
                

                genera = new clsGeneracion();
                genera.setgeid(id);
                genera.setgeinicial(geinicial);
                genera.setgefinal(gefinal);
                genera.setgenombre(genombre);
                genera.setgeconcepto(geconcepto);
                genera.setgeigss(geigss);
                genera.setgeisr(geisr);
                genera.setgeotros(geotros);
                genera.setgevalor(gevalor);
              
                 
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
        return genera;
    }
}

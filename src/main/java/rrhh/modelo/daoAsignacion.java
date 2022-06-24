/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport

import rrhh.controlador.clsAsignacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoAsignacion {
    
    private static final String SQL_SELECT = "SELECT aid, anombre, aconcepto, avigss, avisr, avotros, avalor  FROM tbl_asignacion";
    private static final String SQL_INSERT = "INSERT INTO tbl_asignacion(anombre, aconcepto, avigss, avisr, avotros, avalor) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_asignacion SET anombre=?, aconcepto=?, avigss=?, avisr=?, avotros=?, avalor=? WHERE  aid =?";
    private static final String SQL_DELETE = "DELETE FROM tbl_asignacion WHERE aid=?";
    private static final String SQL_QUERY = "SELECT aid, anombre, aconcepto, avigss, avisr, avotros, avalor FROM tbl_asignacion WHERE aid =?";
  

    public List<clsAsignacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAsignacion asigna = null;
        List<clsAsignacion> asignas = new ArrayList<clsAsignacion>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aid");
                String nombre = rs.getString("anombre");
                String concepto = rs.getString("aconcepto");
                String vigss = rs.getString("avigss");
                String visr = rs.getString("avisr");
                String votros = rs.getString("avotros");
                String valor = rs.getString("avalor");
               
         
               

                asigna = new clsAsignacion();
                asigna.setaid(id);
                asigna.setanombre(nombre);
                asigna.setaconcepto(concepto);
                asigna.setavigss(vigss);
                asigna.setavisr(visr);
                asigna.setavotros(votros);
                asigna.setavalor(valor);
           
                
               
                asignas.add(asigna);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return asignas;
    }

    public int insert(clsAsignacion asignas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignas.getanombre());
            stmt.setString(2, asignas.getaconcepto());
            stmt.setString(3, asignas.getavigss());
            stmt.setString(4, asignas.getavisr());
            stmt.setString(5, asignas.getavotros());
            stmt.setString(6, asignas.getavalor());
           
           
                  
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

    public int update(clsAsignacion asigna) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asigna.getanombre());
            stmt.setString(2, asigna.getaconcepto());
            stmt.setString(3, asigna.getavigss());
            stmt.setString(4, asigna.getavisr());
            stmt.setString(5, asigna.getavotros());
            stmt.setString(6, asigna.getavalor());
            stmt.setInt(7, asigna.getaid());

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

    public int delete(clsAsignacion asigna) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, asigna.getaid());
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

    public clsAsignacion query(clsAsignacion asigna) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, asigna.getaid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aid");
                String nombre = rs.getString("anombre");
                String concepto = rs.getString("aconcepto");
                String vigss = rs.getString("avigss");
                String visr = rs.getString("avisr");
                String votros = rs.getString("avotros");
                String valor = rs.getString("avalor");
               
               
                

                asigna = new clsAsignacion();
                asigna.setaid(id);
                asigna.setanombre(nombre);
                asigna.setaconcepto(concepto);
                asigna.setavigss(vigss);
                asigna.setavisr(visr);
                asigna.setavotros(votros);
                asigna.setavalor(valor);
              
                 
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
        return asigna;
    }
}

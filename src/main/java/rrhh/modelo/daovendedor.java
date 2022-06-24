/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport
import rrhh.controlador.clsvendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daovendedor {
    
    private static final String SQL_SELECT = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, estatus_vendedor, nit_vendedor , telefono_vendedor  FROM vendedores";
    private static final String SQL_INSERT = "INSERT INTO vendedores( nombre_vendedor, direccion_vendedor, estatus_vendedor, nit_vendedor , telefono_vendedor) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE vededores SET nombre_vendedor=?, direccion_vendedor=?, status_vendedor=?, nit_vendedorr=?, telefono_vendedror=? WHERE codigo_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedores WHERE codigo_vendedor=?";
    private static final String SQL_QUERY = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, status_vendedor, nit_vendedor , telefono_vendedor FROM vendedores WHERE codigo_vendedor=?";
    private static final String SQL_QUERY2 = "SELECT codigo_vendedor, nombre_vendedor, direccion_vendedor, status_vendedro, nit_vendedor , telefono_vendedor FROM vendedores WHERE nombre_vendedor=?";
  

    public List<clsvendedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsvendedor concepto = null;
        List<clsvendedor> conceptos = new ArrayList<clsvendedor>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String efecto = rs.getString("direccion_vendedor");
                String estado = rs.getString("status_vendedor");
                String valor = rs.getString("nit_vendedor");
                String tel = rs.getString("telefono_vendedor");
         
               

                concepto = new clsvendedor();
                concepto.setcodigo_vendedor(id);
                concepto.setnombre_vendedor(nombre);
                concepto.setdireccion_vendedor(efecto);
                concepto.setstatus_vendedor(estado);
                concepto.setnit_vendedor(valor);
                concepto.settelefono_vendedor(valor);
                
               
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

    public int insert(clsvendedor concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getnombre_vendedor());
            stmt.setString(2, concepto.getdireccion_vendedor());
            stmt.setString(3, concepto.getstatus_vendedor());
              stmt.setString(4, concepto.getnit_vendedor());
              stmt.setString(4, concepto.gettelefono_vendedor());
           
                  
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

    public int update(clsvendedor concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getnombre_vendedor());
            stmt.setString(2, concepto.getdireccion_vendedor());
            stmt.setString(3, concepto.getstatus_vendedor());
              stmt.setString(4, concepto.getnit_vendedor());
              stmt.setString(4, concepto.gettelefono_vendedor());
            stmt.setInt(5, concepto.getcodigo_vendedor());

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

    public int delete(clsvendedor concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getcodigo_vendedor());
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

    public clsvendedor query(clsvendedor concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getcodigo_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String efecto = rs.getString("direccion_vendedor");
                String estado = rs.getString("status_vendedor");
                String valor = rs.getString("nit_vendedor");
                String tel = rs.getString("telefono_vendedor");
                
               
                

                concepto = new clsvendedor();
                concepto.setcodigo_vendedor(id);
                concepto.setnombre_vendedor(nombre);
                concepto.setdireccion_vendedor(efecto);
                concepto.setstatus_vendedor(estado);
                concepto.setnit_vendedor(valor);
                concepto.settelefono_vendedor(valor);
                 
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
    
    public clsvendedor query2(clsvendedor concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, concepto.getnombre_vendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_vendedor");
               String nombre = rs.getString("nombre_vendedor");
                String efecto = rs.getString("direccion_vendedor");
                String estado = rs.getString("status_vendedor");
                String valor = rs.getString("nit_vendedor");
                String tel = rs.getString("telefono_vendedor");
               
                

                concepto = new clsvendedor();
                concepto.setcodigo_vendedor(id);
                concepto.setnombre_vendedor(nombre);
                concepto.setdireccion_vendedor(efecto);
                concepto.setstatus_vendedor(estado);
                concepto.setnit_vendedor(valor);
                concepto.settelefono_vendedor(valor);
                 
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

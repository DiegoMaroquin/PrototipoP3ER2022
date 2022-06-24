/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clscliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daocliente {

    private static final String SQL_SELECT = "SELECT codigo_cliente, codigo_vendedor, direccion_cliente, estatus_cliente, nit_cliente, nombre_cliente, telefono_cliente  FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(codigo_vendedor, direccion_cliente, estatus_cliente, nit_cliente, nombre_cliente, telefono_cliente) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET codigo_vendedor=?, direccion_cliente=?, estatus_cliente=?, nit_cliente=?, nombre_cliente=?, telefono_cliente=? WHERE Codigo_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE Codigo_cliente=?";
    private static final String SQL_QUERY = "SELECT Codigo_cliente, codigo_vendedor, direccion_cliente, estatus_cliente, nit_cliente, nombre_cliente, telefono_cliente FROM clientes WHERE Codigo_cliente=?";
    private static final String SQL_QUERY2 = "SELECT Codigo_cliente, codigo_vendedor, direccion_cliente, estatus_cliente, nit_cliente, nombre_cliente, telefono_cliente WHERE nombre_cliente=?";

    public List<clscliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clscliente empleado = null;
        List<clscliente> empleados = new ArrayList<clscliente>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("codigo_cliente");
                String nombre = rs.getString("nombre_cliente");
                String sueldo = rs.getString("direccion_cliente");
                String estado = rs.getString("estatus_cliente");
                String dias = rs.getString("nit_cliente");
                String cargo = rs.getString("telefono_cliente");
                String depart = rs.getString("codigo_vendedor");

                empleado = new clscliente();
                empleado.setCodigo_cliente(id);
                empleado.setnombre_cliente(nombre);
                empleado.setdireccion_cliente(sueldo);
                empleado.setestatus_cliente(estado);
                empleado.setnit_cliente(dias);
                empleado.setnit_cliente(cargo);
                empleado.setcodigo_vendedor(depart);
                
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return empleados;
    }

    public int insert(clscliente empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getnombre_cliente());
            stmt.setString(2, empleado.getdireccion_cliente());
            stmt.setString(3, empleado.getestatus_cliente());
            stmt.setString(4, empleado.getnit_cliente());
            stmt.setString(5, empleado.gettelefono_cliente());
            stmt.setString(6, empleado.getcodigo_vendedor());
            
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

    public int update(clscliente empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getnombre_cliente());
            stmt.setString(2, empleado.getdireccion_cliente());
            stmt.setString(3, empleado.getestatus_cliente());
            stmt.setString(4, empleado.getnit_cliente());
            stmt.setString(5, empleado.gettelefono_cliente());
            stmt.setString(6, empleado.getcodigo_vendedor());
            stmt.setInt(7, empleado.getCodigo_cliente());

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

    public int delete(clscliente empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getCodigo_cliente());
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

    public clscliente query(clscliente empleado) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, empleado.getCodigo_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_cliente");
                String nombre = rs.getString("nombre_cliente");
                String sueldo = rs.getString("direccion_cliente");
                String estado = rs.getString("estatus_cliente");
                String dias = rs.getString("nit_cliente");
                String cargo = rs.getString("telefono_cliente");
                String depart = rs.getString("codigo_vendedor");

                empleado = new clscliente();
                empleado.setCodigo_cliente(id);
                empleado.setnombre_cliente(nombre);
                empleado.setdireccion_cliente(sueldo);
                empleado.setestatus_cliente(estado);
                empleado.setnit_cliente(dias);
                empleado.setnit_cliente(cargo);
                empleado.setcodigo_vendedor(depart);;  
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
        return empleado;
    }
    
    public clscliente query2(clscliente empleado) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, empleado.getnombre_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_cliente");
                String nombre = rs.getString("nombre_cliente");
                String sueldo = rs.getString("direccion_cliente");
                String estado = rs.getString("estatus_cliente");
                String dias = rs.getString("nit_cliente");
                String cargo = rs.getString("telefono_cliente");
                String depart = rs.getString("codigo_vendedor");
                empleado = new clscliente();
                empleado.setCodigo_cliente(id);
                empleado.setnombre_cliente(nombre);
                empleado.setdireccion_cliente(sueldo);
                empleado.setestatus_cliente(estado);
                empleado.setnit_cliente(dias);
                empleado.setnit_cliente(cargo);
                empleado.setcodigo_vendedor(depart);;   
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
        return empleado;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clsEmpleados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoEmpleados {

    private static final String SQL_SELECT = "SELECT empid, empnombre, empsueldo, empestado, empdias, empcargo, empdepart  FROM tbl_empleados";
    private static final String SQL_INSERT = "INSERT INTO tbl_empleados(empnombre, empsueldo, empestado, empdias, empcargo, empdepart) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_empleados SET empnombre=?, empsueldo=?, empestado=?, empdias=?, empcargo=?, empdepart=? WHERE empid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_empleados WHERE empid=?";
    private static final String SQL_QUERY = "SELECT empid, empnombre, empsueldo, empestado, empdias, empcargo, empdepart FROM tbl_empleados WHERE empid=?";
    private static final String SQL_QUERY2 = "SELECT empid, empnombre, empsueldo, empestado, empdias, empcargo, empdepart FROM tbl_empleados WHERE empnombre=?";

    public List<clsEmpleados> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsEmpleados empleado = null;
        List<clsEmpleados> empleados = new ArrayList<clsEmpleados>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("empid");
                String nombre = rs.getString("empnombre");
                String sueldo = rs.getString("empsueldo");
                String estado = rs.getString("empestado");
                String dias = rs.getString("empdias");
                String cargo = rs.getString("empcargo");
                String depart = rs.getString("empdepart");

                empleado = new clsEmpleados();
                empleado.setempid(id);
                empleado.setempnombre(nombre);
                empleado.setempsueldo(sueldo);
                empleado.setempestado(estado);
                empleado.setempdias(dias);
                empleado.setempcargo(cargo);
                empleado.setempdepart(depart);
                
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

    public int insert(clsEmpleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getempnombre());
            stmt.setString(2, empleado.getempsueldo());
            stmt.setString(3, empleado.getempestado());
            stmt.setString(4, empleado.getempdias());
            stmt.setString(5, empleado.getempcargo());
            stmt.setString(6, empleado.getempdepart());
            
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

    public int update(clsEmpleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getempnombre());
            stmt.setString(2, empleado.getempsueldo());
            stmt.setString(3, empleado.getempestado());
            stmt.setString(4, empleado.getempdias());
            stmt.setString(5, empleado.getempcargo());
            stmt.setString(6, empleado.getempdepart());
            stmt.setInt(7, empleado.getempid());

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

    public int delete(clsEmpleados empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getempid());
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

    public clsEmpleados query(clsEmpleados empleado) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, empleado.getempid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("empid");
                String nombre = rs.getString("empnombre");
                String sueldo = rs.getString("empsueldo");
                String estado = rs.getString("empestado");
                String dias = rs.getString("empdias");
                String cargo = rs.getString("empcargo");
                String depart = rs.getString("empdepart");

                empleado = new clsEmpleados();
                empleado.setempid(id);
                empleado.setempnombre(nombre);
                empleado.setempsueldo(sueldo);
                empleado.setempestado(estado);
                empleado.setempdias(dias);   
                empleado.setempcargo(cargo);
                empleado.setempdepart(depart);  
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
    
    public clsEmpleados query2(clsEmpleados empleado) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, empleado.getempnombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("empid");
                String nombre = rs.getString("empnombre");
                String sueldo = rs.getString("empsueldo");
                String estado = rs.getString("empestado");
                String dias = rs.getString("empdias");
                String cargo = rs.getString("empcargo");
                String depart = rs.getString("empdepart");

                empleado = new clsEmpleados();
                empleado.setempid(id);
                empleado.setempnombre(nombre);
                empleado.setempsueldo(sueldo);
                empleado.setempestado(estado);
                empleado.setempdias(dias);   
                empleado.setempcargo(cargo);
                empleado.setempdepart(depart);  
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

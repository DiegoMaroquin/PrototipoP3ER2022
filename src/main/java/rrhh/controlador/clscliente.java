package rrhh.controlador;

import seguridad.controlador.*;

public class clscliente {
    
    private int codigo_cliente;
    private String nombre_cliente;
    private String direccion_cliente; 
    private String estatus_cliente;
    private String nit_cliente;
    private String telefono_cliente;
    private String codigo_vendedor;
   
    public clscliente() {
    }

    public clscliente(int p_empid) {
        this.codigo_cliente = p_empid;
    }
    
    public clscliente(String empnombre, String empsueldo, String empestado, String empdias, String empcargo, String empdepart) {
        this.nombre_cliente = empnombre;
        this.direccion_cliente = empsueldo;
        this.estatus_cliente = empestado;
         this.nit_cliente = empcargo;
        this.telefono_cliente = empdias;
        this.codigo_vendedor=empdepart;
    }
    
    public clscliente(int empid, String empnombre, String empsueldo, String empestado, String empdias,String empcargo, String empdepart) {
        this.codigo_cliente = empid;
        this.direccion_cliente = empsueldo;
        this.estatus_cliente = empestado;
        this.nit_cliente = empcargo;
        this.telefono_cliente = empdias;
        this.codigo_vendedor=empdepart;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int empid) {
        this.codigo_cliente = empid;
    }

    public String getnombre_cliente() {
        return nombre_cliente;
    }

    public void setnombre_cliente(String empnombre) {
        this.nombre_cliente = empnombre;
    }

    public String getdireccion_cliente() {
        return direccion_cliente;
    }

    public void setdireccion_cliente(String empsueldo) {
        this.direccion_cliente = empsueldo;
    }

    public String getestatus_cliente() {
        return estatus_cliente;
    }

    public void setestatus_cliente(String empestado) {
        this.estatus_cliente = empestado;
    }

    public String gettelefono_cliente() {
        return telefono_cliente;
    }

    public void settelefono_cliente(String empdias) {
        this.telefono_cliente = empdias;
    }
    
     public String getnit_cliente() {
        return nit_cliente;
    }

    public void setnit_cliente(String empcargo) {
        this.nit_cliente = empcargo;
    }

    public String getcodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setcodigo_vendedor(String empdepart) {
        this.codigo_vendedor = empdepart;
    }

    public int setcodigo_vendedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

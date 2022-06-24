/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.controlador;


/**
 *
 * @author visitante
 */

public class clsvendedor {
    private int codigo_vendedor;
    private String nombre_vendedor;
    private String direccion_vendedor; 
    private String status_vendedor;
    private String nit_vendedor; 
     private String telefono_vendedor; 
    

    public clsvendedor() {
    }

    public clsvendedor(int id_Concepto) {
        this.codigo_vendedor= id_Concepto;
    }

    public clsvendedor(String nombre, String estado) {
        this. nombre_vendedor = nombre;
        this.status_vendedor = estado;
        
    }
     public clsvendedor(String nombre, String estado, String efecto, String valor,String tel) {
        this. nombre_vendedor = nombre;
        this.status_vendedor = estado;
        this. direccion_vendedor = nombre;
        this.nit_vendedor = valor;
        this.telefono_vendedor = tel;
    }

    public int getcodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setcodigo_vendedor(int id_Concepto) {
        this.codigo_vendedor = id_Concepto;
    }

    public String getnombre_vendedor() {
        return nombre_vendedor;
    }

    public void setnombre_vendedor(String nombre) {
        this.nombre_vendedor = nombre;
    }

    public String getstatus_vendedor() {
        return status_vendedor;
    }

    public void setstatus_vendedor(String estado) {
        this.status_vendedor = estado;
    }
    public String getdireccion_vendedor() {
        return direccion_vendedor;
    }
     public void setdireccion_vendedor(String efecto) {
        this.direccion_vendedor = efecto;
     }
       public String getnit_vendedor() {
        return nit_vendedor;
    }
     public void setnit_vendedor(String valor) {
        this.nit_vendedor = valor;
     }
     public String gettelefono_vendedor() {
        return telefono_vendedor;
    }
     public void settelefono_vendedor(String valor) {
        this.telefono_vendedor = valor;
     }
     

    @Override
    public String toString() {
        return "vendedoreso{" + "codigo_vendedor=" + codigo_vendedor + ", .nombre_vendedor=" + nombre_vendedor + ", status_vendedor=" + status_vendedor + ",cdireccion_vendedor="+ direccion_vendedor+ ", nit_vendedor "+ nit_vendedor + ",telefono_vendedor" + '}';
    }
    
     }


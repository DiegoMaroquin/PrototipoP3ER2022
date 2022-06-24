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
public class clsConcepto {
    private int Concepid;
    private String Concepnombre;
    private String Concepefecto; 
    private String Concepestado;
    private String Concepvalor; 
    

    public clsConcepto() {
    }

    public clsConcepto(int id_Concepto) {
        this.Concepid= id_Concepto;
    }

    public clsConcepto(String nombre, String estado) {
        this. Concepnombre = nombre;
        this.Concepestado = estado;
        
    }
     public clsConcepto(String nombre, String estado, String efecto, String valor) {
        this. Concepnombre = nombre;
        this.Concepestado = estado;
        this. Concepefecto = nombre;
        this.Concepvalor = valor;
    }

    public int getconcepid() {
        return Concepid;
    }

    public void setconcepid(int id_Concepto) {
        this.Concepid = id_Concepto;
    }

    public String getconcepnombre() {
        return Concepnombre;
    }

    public void setconcepnombre(String nombre) {
        this.Concepnombre = nombre;
    }

    public String getconcepestado() {
        return Concepestado;
    }

    public void setconcepestado(String estado) {
        this.Concepestado = estado;
    }
    public String getconcepefecto() {
        return Concepefecto;
    }
     public void setconcepefecto(String efecto) {
        this.Concepefecto = efecto;
     }
       public String getconcepvalor() {
        return Concepvalor;
    }
     public void setconcepvalor(String valor) {
        this.Concepvalor = valor;
     }
     

    @Override
    public String toString() {
        return "tbl_concepto{" + "concepid=" + Concepid + ", concepnombre=" + Concepnombre + ", concepestado=" + Concepestado + ",concepefecto="+ Concepefecto+ ", concepvalor "+ Concepvalor +'}';
    }
    
     }


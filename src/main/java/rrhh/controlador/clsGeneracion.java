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
public class clsGeneracion {
    private int geid;
    private String geinicial;
    private String gefinal;
    private String genombre;
    private String geconcepto; 
    private String geigss;
    private String geisr;
    private String geotros; 
    private String gevalor; 
    

    public clsGeneracion() {
    }

    public clsGeneracion(int id) {
        this.geid= id;
    }

    public clsGeneracion(String geinicial,String gefinal, String nombre,String concepto, String igss, String isr, String otros, String valor) {
        this.geinicial = geinicial;
        this.gefinal = gefinal;
        this.genombre = nombre;
        this.geconcepto = concepto;
        this.geigss = igss;
        this.geisr = isr;
        this.geotros = otros;
        this.gevalor = valor;
        
    }
     public clsGeneracion(int id,String geinicial,String gefinal, String nombre,String concepto,  String igss, String isr, String otros, String valor) {
        this.geid= id;
        this.geinicial = geinicial;
        this.gefinal = gefinal;
        this.genombre = nombre;
        this.geconcepto = concepto;
        this.geigss = igss;
        this.geisr = isr;
        this.geotros = otros;
        this.gevalor = valor;
    }

    public int getgeid() {
        return geid;
    }

    public void setgeid(int id) {
        this.geid = id;
    }

    public String getgeinicial() {
        return geinicial;
    }

    public void setgeinicial(String geinicial) {
        this.geinicial = geinicial;
    }

    public String getgefinal() {
        return gefinal;
    }

    public void setgefinal(String gefinal) {
        this.gefinal = gefinal;
    }
    
    
    public String getgenombre() {
        return genombre;
    }

    public void setgenombre(String nombre) {
        this.genombre = nombre;
    }

    public String getgeconcepto() {
        return geconcepto;
    }

    public void setgeconcepto(String concepto) {
        this.geconcepto = concepto;
    }
    public String getgeigss() {
        return geigss;
    }
    public void setgeigss(String igss) {
        this.geigss = igss;
     }
    public String getgeisr() {
        return geisr;
    }
    public void setgeisr(String isr) {
        this.geisr = isr;
     }
    public String getgeotros() {
        return geotros;
    }
     public void setgeotros(String otros) {
        this.geotros = otros;
     }
     
    public String getgevalor() {
        return gevalor;
    }
     public void setgevalor(String valor) {
        this.gevalor = valor;
     }
      
     

    @Override
    public String toString() {
        return "tbl_generacion{" + "geid=" + geid +"geinicial="+ geinicial+", gefinal="+gefinal+", genombre=" + genombre + ", geconcepto=" + geconcepto + ", geigss="+ geigss +", geisr="+ geisr + ", geotros=" + geotros +", gevalor ="+ gevalor +"}";
    }
    
     }


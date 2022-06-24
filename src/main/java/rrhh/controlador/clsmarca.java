package rrhh.controlador;

public class clsmarca {
    private int deparid;
    private String deparnombre;
    private String deparestado;

    public clsmarca() {
    }

    public clsmarca(int codigodepa) {
        this.deparid = codigodepa;
    }
    
    public clsmarca(String snombre, String sestado) {
        this.deparnombre = snombre;
        this.deparestado = sestado;
    }
    
    public clsmarca(int codigodepa, String snombre, String sestado) {
        this.deparid = codigodepa;
        this.deparnombre = snombre;
        this.deparestado = sestado;
    }
    

    public int getdeparid() {
        return deparid;
    }

    public void setdeparid(int codigodepa) {
        this.deparid = codigodepa;
    }

    public String getdeparnombre() {
        return deparnombre;
    }

    public void setdeparnombre(String snombre) {
        this.deparnombre = snombre;
    }

    public String getdeparestado() {
        return deparestado;
    }

    public void setdeparestado(String sestado) {
        this.deparestado = sestado;
    }
    @Override
    public String toString() {
        return "tbl_departamento{" + "codigo_departamento=" + deparid + ", nombre_departamento="  +  deparnombre +", estatus=" + deparestado+  "}";
    }
    
    
}

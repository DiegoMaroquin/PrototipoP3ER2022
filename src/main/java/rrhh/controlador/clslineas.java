package rrhh.controlador;

public class clslineas {
    private int codigo_linea;
    private String nombre_linea;
    private String estatus_linea;

    public clslineas() {
    }

    public clslineas(int codigo_linea) {
        this.codigo_linea = codigo_linea;
    }
    
    public clslineas(String snombre, String sestado) {
        this.nombre_linea = snombre;
        this.estatus_linea = sestado;
    }
    
    public clslineas(int codigo_linea, String snombre, String sestado) {
        this.codigo_linea = codigo_linea;
        this.nombre_linea = snombre;
        this.estatus_linea = sestado;
    }
    

    public int getcodigo_linea() {
        return codigo_linea;
    }

    public void setcodigo_linea(int codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public String getnombre_linea() {
        return nombre_linea;
    }

    public void setnombre_linea(String snombre) {
        this.nombre_linea = snombre;
    }

    public String getestatus_linea() {
        return estatus_linea;
    }

    public void setestatus_linea(String sestado) {
        this.estatus_linea = sestado;
    }
    @Override
    public String toString() {
        return "lineas{" + "codigo_linea=" + codigo_linea + ", nombre_linea="  +  nombre_linea +", estatus_linea=" + estatus_linea +  "}";
    }
    
    
}

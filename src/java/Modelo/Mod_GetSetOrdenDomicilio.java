
package Modelo;

public class Mod_GetSetOrdenDomicilio {
    private int or_id;
    private int or_dom_id;
    private int or_cli_id;
    private int or_pre_id;
    private int or_total;
    private int or_unid;
    private String or_descripcion;
    private String or_estado;
    private String pre_marca;
    private String pre_descripcion;
    private String pre_precio;
    private String pre_foto;
    private String prove_direccion;

    public Mod_GetSetOrdenDomicilio(int or_id, int or_dom_id, int or_cli_id, int or_pre_id, int or_total, int or_unid, String or_descripcion, String or_estado, String pre_marca, String pre_descripcion, String pre_precio, String pre_foto, String prove_direccion) {
        this.or_id = or_id;
        this.or_dom_id = or_dom_id;
        this.or_cli_id = or_cli_id;
        this.or_pre_id = or_pre_id;
        this.or_total = or_total;
        this.or_unid = or_unid;
        this.or_descripcion = or_descripcion;
        this.or_estado = or_estado;
        this.pre_marca = pre_marca;
        this.pre_descripcion = pre_descripcion;
        this.pre_precio = pre_precio;
        this.pre_foto = pre_foto;
        this.prove_direccion = prove_direccion;
    }

    public Mod_GetSetOrdenDomicilio(int or_id, int or_total, int or_unid, String or_descripcion, String or_estado, String pre_marca, String pre_descripcion, String pre_precio, String pre_foto, String prove_direccion) {
        this.or_id = or_id;
        this.or_total = or_total;
        this.or_unid = or_unid;
        this.or_descripcion = or_descripcion;
        this.or_estado = or_estado;
        this.pre_marca = pre_marca;
        this.pre_descripcion = pre_descripcion;
        this.pre_precio = pre_precio;
        this.pre_foto = pre_foto;
        this.prove_direccion = prove_direccion;
    }
    
    public Mod_GetSetOrdenDomicilio() {
    }

    public int getOr_id() {
        return or_id;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }

    public int getOr_dom_id() {
        return or_dom_id;
    }

    public void setOr_dom_id(int or_dom_id) {
        this.or_dom_id = or_dom_id;
    }

    public int getOr_cli_id() {
        return or_cli_id;
    }

    public void setOr_cli_id(int or_cli_id) {
        this.or_cli_id = or_cli_id;
    }

    public int getOr_pre_id() {
        return or_pre_id;
    }

    public void setOr_pre_id(int or_pre_id) {
        this.or_pre_id = or_pre_id;
    }

    public int getOr_total() {
        return or_total;
    }

    public void setOr_total(int or_total) {
        this.or_total = or_total;
    }

    public int getOr_unid() {
        return or_unid;
    }

    public void setOr_unid(int or_unid) {
        this.or_unid = or_unid;
    }

    public String getOr_descripcion() {
        return or_descripcion;
    }

    public void setOr_descripcion(String or_descripcion) {
        this.or_descripcion = or_descripcion;
    }

    public String getOr_estado() {
        return or_estado;
    }

    public void setOr_estado(String or_estado) {
        this.or_estado = or_estado;
    }

    public String getPre_marca() {
        return pre_marca;
    }

    public void setPre_marca(String pre_marca) {
        this.pre_marca = pre_marca;
    }

    public String getPre_descripcion() {
        return pre_descripcion;
    }

    public void setPre_descripcion(String pre_descripcion) {
        this.pre_descripcion = pre_descripcion;
    }

    public String getPre_precio() {
        return pre_precio;
    }

    public void setPre_precio(String pre_precio) {
        this.pre_precio = pre_precio;
    }

    public String getPre_foto() {
        return pre_foto;
    }

    public void setPre_foto(String pre_foto) {
        this.pre_foto = pre_foto;
    }

    public String getProve_direccion() {
        return prove_direccion;
    }

    public void setProve_direccion(String prove_direccion) {
        this.prove_direccion = prove_direccion;
    }
    
    
    
}

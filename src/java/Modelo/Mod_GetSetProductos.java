
package Modelo;

public class Mod_GetSetProductos {
    private String pro_codigo;
    private String pro_nombre;
    private String pro_descripcion;
    private String pro_foto;
    private String pro_prove_nit;
    private String pro_cate_codigo;

    public Mod_GetSetProductos(String pro_codigo, String pro_nombre, String pro_descripcion, String pro_foto, String pro_prove_nit, String pro_cate_codigo) {
        this.pro_codigo = pro_codigo;
        this.pro_nombre = pro_nombre;
        this.pro_descripcion = pro_descripcion;
        this.pro_foto = pro_foto;
        this.pro_prove_nit = pro_prove_nit;
        this.pro_cate_codigo = pro_cate_codigo;
    }

    public Mod_GetSetProductos() {
    }

    public Mod_GetSetProductos(String pro_nombre, String pro_foto, String pro_codigo) {
        this.pro_nombre = pro_nombre;
        this.pro_foto = pro_foto;
        this.pro_codigo = pro_codigo;
    }
    
    public Mod_GetSetProductos(String pro_nombre, String pro_foto) {
        this.pro_nombre = pro_nombre;
        this.pro_foto = pro_foto;
    }
    
    public String getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public String getPro_foto() {
        return pro_foto;
    }

    public void setPro_foto(String pro_foto) {
        this.pro_foto = pro_foto;
    }

    public String getPro_prove_nit() {
        return pro_prove_nit;
    }

    public void setPro_prove_nit(String pro_prove_nit) {
        this.pro_prove_nit = pro_prove_nit;
    }

    public String getPro_cate_codigo() {
        return pro_cate_codigo;
    }

    public void setPro_cate_codigo(String pro_cate_codigo) {
        this.pro_cate_codigo = pro_cate_codigo;
    }
    
    
}

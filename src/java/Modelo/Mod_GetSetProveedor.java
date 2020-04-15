
package Modelo;

public class Mod_GetSetProveedor {
    
    private String prove_nit;
    private String prove_nombre;
    private String prove_telefono;
    private String prove_email;
    private String prove_horario;
    private String prove_direccion;
    private int prove_usu_id;
    private int prove_tipo_codigo;
    private String prove_foto;

    public Mod_GetSetProveedor(String prove_nit, String prove_nombre, String prove_telefono, String prove_email, String prove_horario, String prove_direccion, int prove_usu_id, int prove_tipo_codigo, String prove_foto) {
        this.prove_nit = prove_nit;
        this.prove_nombre = prove_nombre;
        this.prove_telefono = prove_telefono;
        this.prove_email = prove_email;
        this.prove_horario = prove_horario;
        this.prove_direccion = prove_direccion;
        this.prove_usu_id = prove_usu_id;
        this.prove_tipo_codigo = prove_tipo_codigo;
        this.prove_foto = prove_foto;
    }

    public Mod_GetSetProveedor() {
    }

    public String getProve_nit() {
        return prove_nit;
    }

    public void setProve_nit(String prove_nit) {
        this.prove_nit = prove_nit;
    }

    public String getProve_nombre() {
        return prove_nombre;
    }

    public void setProve_nombre(String prove_nombre) {
        this.prove_nombre = prove_nombre;
    }

    public String getProve_telefono() {
        return prove_telefono;
    }

    public void setProve_telefono(String prove_telefono) {
        this.prove_telefono = prove_telefono;
    }

    public String getProve_email() {
        return prove_email;
    }

    public void setProve_email(String prove_email) {
        this.prove_email = prove_email;
    }

    public String getProve_horario() {
        return prove_horario;
    }

    public void setProve_horario(String prove_horario) {
        this.prove_horario = prove_horario;
    }

    public String getProve_direccion() {
        return prove_direccion;
    }

    public void setProve_direccion(String prove_direccion) {
        this.prove_direccion = prove_direccion;
    }

    public int getProve_usu_id() {
        return prove_usu_id;
    }

    public void setProve_usu_id(int prove_usu_id) {
        this.prove_usu_id = prove_usu_id;
    }

    public int getProve_tipo_codigo() {
        return prove_tipo_codigo;
    }

    public void setProve_tipo_codigo(int prove_tipo_codigo) {
        this.prove_tipo_codigo = prove_tipo_codigo;
    }

    public String getProve_foto() {
        return prove_foto;
    }

    public void setProve_foto(String prove_foto) {
        this.prove_foto = prove_foto;
    }
}

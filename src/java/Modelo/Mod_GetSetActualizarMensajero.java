
package Modelo;

public class Mod_GetSetActualizarMensajero {
    private int men_id;
    private String men_cedula;
    private String men_nombre;
    private String men_direccion_1;
    private String men_barrio_1;
    private String men_descripcion_1;
    private String men_telefono;
    private String men_email;
    private String usu_nombre;
    private String usu_password;
    private String usu_foto;

    public Mod_GetSetActualizarMensajero(int men_id, String men_cedula, String men_nombre, String men_direccion_1, String men_barrio_1, String men_descripcion_1, String men_telefono, String men_email, String usu_nombre, String usu_password, String usu_foto) {
        this.men_id = men_id;
        this.men_cedula = men_cedula;
        this.men_nombre = men_nombre;
        this.men_direccion_1 = men_direccion_1;
        this.men_barrio_1 = men_barrio_1;
        this.men_descripcion_1 = men_descripcion_1;
        this.men_telefono = men_telefono;
        this.men_email = men_email;
        this.usu_nombre = usu_nombre;
        this.usu_password = usu_password;
        this.usu_foto = usu_foto;
    }

    public Mod_GetSetActualizarMensajero(int men_id, String men_direccion_1, String men_barrio_1, String men_descripcion_1, String men_telefono, String men_email, String usu_nombre, String usu_password) {
        this.men_id = men_id;
        this.men_direccion_1 = men_direccion_1;
        this.men_barrio_1 = men_barrio_1;
        this.men_descripcion_1 = men_descripcion_1;
        this.men_telefono = men_telefono;
        this.men_email = men_email;
        this.usu_nombre = usu_nombre;
        this.usu_password = usu_password;
    }

    public Mod_GetSetActualizarMensajero(int men_id, String usu_foto) {
        this.men_id = men_id;
        this.usu_foto = usu_foto;
    }
    
    public Mod_GetSetActualizarMensajero() {
    }

    public int getMen_id() {
        return men_id;
    }

    public void setMen_id(int men_id) {
        this.men_id = men_id;
    }

    public String getMen_cedula() {
        return men_cedula;
    }

    public void setMen_cedula(String men_cedula) {
        this.men_cedula = men_cedula;
    }

    public String getMen_nombre() {
        return men_nombre;
    }

    public void setMen_nombre(String men_nombre) {
        this.men_nombre = men_nombre;
    }

    public String getMen_direccion_1() {
        return men_direccion_1;
    }

    public void setMen_direccion_1(String men_direccion_1) {
        this.men_direccion_1 = men_direccion_1;
    }

    public String getMen_barrio_1() {
        return men_barrio_1;
    }

    public void setMen_barrio_1(String men_barrio_1) {
        this.men_barrio_1 = men_barrio_1;
    }

    public String getMen_descripcion_1() {
        return men_descripcion_1;
    }

    public void setMen_descripcion_1(String men_descripcion_1) {
        this.men_descripcion_1 = men_descripcion_1;
    }

    public String getMen_telefono() {
        return men_telefono;
    }

    public void setMen_telefono(String men_telefono) {
        this.men_telefono = men_telefono;
    }

    public String getMen_email() {
        return men_email;
    }

    public void setMen_email(String men_email) {
        this.men_email = men_email;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public String getUsu_foto() {
        return usu_foto;
    }

    public void setUsu_foto(String usu_foto) {
        this.usu_foto = usu_foto;
    }
    
    
}

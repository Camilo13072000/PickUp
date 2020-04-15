
package Modelo;

public class Mod_GetSetMensajero {
    private int men_id; 
    private int men_cedula;
    private String men_nombre;
    private String men_direccion;
    private String men_barrio;
    private String men_descripcion;
    private String men_telefono;
    private String men_email;
    private int men_usu_id;

    public Mod_GetSetMensajero(int men_id, int men_cedula, String men_nombre, String men_direccion, String men_barrio, String men_descripcion, String men_telefono, String men_email, int men_usu_id) {
        this.men_id = men_id;
        this.men_cedula = men_cedula;
        this.men_nombre = men_nombre;
        this.men_direccion = men_direccion;
        this.men_barrio = men_barrio;
        this.men_descripcion = men_descripcion;
        this.men_telefono = men_telefono;
        this.men_email = men_email;
        this.men_usu_id = men_usu_id;
    }

    public Mod_GetSetMensajero(int men_id, int men_cedula, String men_nombre, String men_direccion, String men_barrio, String men_descripcion, String men_telefono, String men_email) {
        this.men_id = men_id;
        this.men_cedula = men_cedula;
        this.men_nombre = men_nombre;
        this.men_direccion = men_direccion;
        this.men_barrio = men_barrio;
        this.men_descripcion = men_descripcion;
        this.men_telefono = men_telefono;
        this.men_email = men_email;
    }

    public Mod_GetSetMensajero() {
    }

    public int getMen_id() {
        return men_id;
    }

    public void setMen_id(int men_id) {
        this.men_id = men_id;
    }

    public int getMen_cedula() {
        return men_cedula;
    }

    public void setMen_cedula(int men_cedula) {
        this.men_cedula = men_cedula;
    }

    public String getMen_nombre() {
        return men_nombre;
    }

    public void setMen_nombre(String men_nombre) {
        this.men_nombre = men_nombre;
    }

    public String getMen_direccion() {
        return men_direccion;
    }

    public void setMen_direccion(String men_direccion) {
        this.men_direccion = men_direccion;
    }

    public String getMen_barrio() {
        return men_barrio;
    }

    public void setMen_barrio(String men_barrio) {
        this.men_barrio = men_barrio;
    }

    public String getMen_descripcion() {
        return men_descripcion;
    }

    public void setMen_descripcion(String men_descripcion) {
        this.men_descripcion = men_descripcion;
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

    public int getMen_usu_id() {
        return men_usu_id;
    }

    public void setMen_usu_id(int men_usu_id) {
        this.men_usu_id = men_usu_id;
    }
    
    
}

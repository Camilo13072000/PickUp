
package Modelo;

public class Mod_GetSetOrden {
    private int or_id;
    private int or_dom_id;
    private int or_cli_id;
    private int or_pre_id;
    private int or_total;
    private int or_unid;

    public Mod_GetSetOrden(int or_dom_id, int or_cli_id, int or_pre_id, int or_total, int or_unid) {
        this.or_dom_id = or_dom_id;
        this.or_cli_id = or_cli_id;
        this.or_pre_id = or_pre_id;
        this.or_total = or_total;
        this.or_unid = or_unid;
    }

    public Mod_GetSetOrden() {
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
    
    
}

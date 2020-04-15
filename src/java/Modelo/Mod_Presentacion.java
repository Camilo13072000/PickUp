
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Mod_Presentacion {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps;
    ResultSet rs;
    
    public Mod_GetSetPresentacion ConsultarPresentacioncod(int codipre){
        //Modelo Para el carrito
            Mod_GetSetPresentacion Presentacion=new Mod_GetSetPresentacion();
        try {
            ps=cnn.prepareStatement("Select *from tb_Presentacion where pre_codigo='"+codipre+"'");
            rs=ps.executeQuery();
            while (rs.next()) {
                Presentacion.setPre_codigo(rs.getInt(1));
                Presentacion.setPre_marca(rs.getString(2));
                Presentacion.setPre_descripcion(rs.getString(3));
                Presentacion.setPre_unidades(rs.getInt(4));
                Presentacion.setPre_precio(rs.getInt(5));
                Presentacion.setPre_foto(rs.getString(6));
                Presentacion.setPre_pro_codigo(rs.getString(7));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo presentacion");
        }
        return Presentacion;
    }
    
    public ArrayList<Mod_GetSetPresentacion>ConsultarPresentacionProveedor(String prov_nit){
        ArrayList<Mod_GetSetPresentacion> presentacion=new ArrayList<>();
        
        try {
            ps=cnn.prepareStatement("call ConsultarPresentacionProveedor('"+prov_nit+"')");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetPresentacion gspre=new Mod_GetSetPresentacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getString(8));
                presentacion.add(gspre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo presentacion");
        }
        return presentacion;
    }
    
    public ArrayList<Mod_GetSetPresentacion> ConsultarPresentacion(String prese){
        ArrayList<Mod_GetSetPresentacion> Presentacion=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_Presentacion where pre_pro_codigo='"+prese+"'");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetPresentacion pres=new Mod_GetSetPresentacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getString(8));
                Presentacion.add(pres);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo presentacion");
        }
        return Presentacion;
    }
    public ArrayList<Mod_GetSetPresentacion> ConsultarPresentaciones(){
        ArrayList<Mod_GetSetPresentacion> Presentacion=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_Presentacion");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetPresentacion pres=new Mod_GetSetPresentacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7),rs.getString(8));
                Presentacion.add(pres);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo presentacion");
        }
        return Presentacion;
    }
}

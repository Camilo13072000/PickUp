
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Orden {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public boolean InsertarOrden(Mod_GetSetOrden gsor){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("call InsertarOrden (?,?,?,?,?)");
            ps.setInt(1, gsor.getOr_dom_id());
            ps.setInt(2, gsor.getOr_cli_id());
            ps.setInt(3, gsor.getOr_pre_id());
            ps.setInt(4, gsor.getOr_total());
            ps.setInt(5, gsor.getOr_unid());
            dat=ps.executeUpdate();
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    
    public ArrayList<Mod_GetSetOrdenDomicilio>OrdenDomicilio(int or_dom_id){
        ArrayList<Mod_GetSetOrdenDomicilio> Orden = new ArrayList<>();
        try {
            ps=cnn.prepareStatement("call ConsultarOrdenDomicilio('"+or_dom_id+"')");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetOrdenDomicilio Or=new Mod_GetSetOrdenDomicilio(rs.getInt(1), rs.getInt(8), rs.getInt(5), rs.getString(7), rs.getString(9), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(10));
                Orden.add(Or);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Orden;
    }
    public boolean ActualizarEstadoOrden(int Or_Id,String Or_Estado){
        boolean reg=false;
        int dat;
        
        try {
            ps=cnn.prepareStatement("Call ActualizarEstadoOrden('"+Or_Id+"','"+Or_Estado+"')");
            dat=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el estado correctamente");
            if(dat>0){
                reg=true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return reg;
    }
}

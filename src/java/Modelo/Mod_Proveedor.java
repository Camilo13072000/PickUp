
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Proveedor {
    
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Mod_GetSetProveedor>ConsultarProveedor(int prove_tipo_codigo){
        ArrayList<Mod_GetSetProveedor> Proveedor=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("call consultarproveedorportipo('"+prove_tipo_codigo+"')");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetProveedor conprov=new Mod_GetSetProveedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                Proveedor.add(conprov);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo proveedor");
        }
        return Proveedor;
    }
    
    public ArrayList<Mod_GetSetProveedor>ConsultarProductosNombreProveedor(String prove_nombre){
        ArrayList<Mod_GetSetProveedor> productoNomProve=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_proveedor where prove_nombre='"+prove_nombre+"'");
            rs=ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Datos Consultados");
            while(rs.next()){
                Mod_GetSetProveedor prove=new Mod_GetSetProveedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                productoNomProve.add(prove);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo proveedor");
        }
        return productoNomProve;
    }
    
}

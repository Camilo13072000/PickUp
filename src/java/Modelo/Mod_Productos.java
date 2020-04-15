
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Productos {
    
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Mod_GetSetProductos>ConsultarProductos(String prove_nit){
        ArrayList<Mod_GetSetProductos> produccli=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_productos where pro_prove_nit='"+prove_nit+"'");
            rs=ps.executeQuery();
            //JOptionPane.showMessageDialog(null, "Datos Consultados");
            while(rs.next()){
                Mod_GetSetProductos ConsulProd=new Mod_GetSetProductos(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                produccli.add(ConsulProd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return produccli;
    }
    
}

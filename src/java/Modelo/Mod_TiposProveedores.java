
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_TiposProveedores {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public ArrayList<Mod_GetSetTiposProveedores>ConsultarTiposProveedores(){
        ArrayList<Mod_GetSetTiposProveedores>tiposProveedores=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Call ConsultarTipoProveedor()");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetTiposProveedores TipoProveedor=new Mod_GetSetTiposProveedores(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                tiposProveedores.add(TipoProveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tiposProveedores;
    }
}

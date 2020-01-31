
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    Connection cnn;
    public Connection Conexionpickup(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn=DriverManager.getConnection("jdbc:mysql://localhost/db_pickup","root","");
            //JOptionPane.showMessageDialog(null, "conexion ok");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cnn;
    }
    public static void main(String[]args){
        Conexion con=new Conexion();
        con.Conexionpickup();
    }
}

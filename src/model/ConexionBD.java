/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Markensi
 */
public class ConexionBD {
    private final String name = "datasEmpresaPrueba";
    private final String user = "root";
    private final String pass = "Markensi0619";
    private final String url = "jdbc:mysql://localhost:3306/" + name;
    private Connection conn = null;    
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public void closeConexion(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

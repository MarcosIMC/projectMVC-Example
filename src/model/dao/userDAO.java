/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.vo.user;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Markensi
 */
public class userDAO extends model.ConexionBD{
    
    public boolean checkUserLogin(user user){
        
        PreparedStatement ps = null;        
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE username = '"+ user.getUserName() +"' AND pass = '" + user.getPass() + "'";
        
        try {
            conn = getConexion();
            
            if(conn != null){
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                
                if(rs.getRow() != 0){
                    System.out.println("RS tiene registro");
                    if(user.getUserName().equals(rs.getString("username")) && user.getPass().equals(rs.getString("pass"))){
                        ps.close();
                        rs.close();
                        conn.close();

                        return true;
                    }
                }else{
                    conn.close();
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }  
}

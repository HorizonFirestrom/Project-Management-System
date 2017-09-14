/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softwarica.wetrack.controller;

import edu.softwarica.wetrack.dbconnection.DBConnection;
import edu.softwarica.wetrack.models.User;
import edu.softwarica.wetrack.utils.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class UserController {
    private Connection con = null;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public UserController(){
        if(con == null){
            con = DBConnection.getConnection();
        }
    }
    public User authenticate(User userObj){
        User currentUser = null;
        String query = "Select * from user where email = ? and password = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userObj.getEmail());
            pstmt.setString(2, userObj.getPassword());
            rs = pstmt.executeQuery();
            while(rs.next()){
                currentUser = new User();
                currentUser.setId(rs.getInt("id"));
                currentUser.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return currentUser;
    }

    public int create(User userObj) {
        int isCreated = 0;
        String query = "INSERT into user(fullname,address,contact,email,password,skills) values(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
              pstmt.setString(1, userObj.getFullname());
              pstmt.setString(2, userObj.getAddress());
               pstmt.setString(3, userObj.getContact());
                pstmt.setString(4, userObj.getEmail());
            pstmt.setString(5, userObj.getPassword());
            pstmt.setString(6, userObj.getSkills());
           
            isCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCreated;
    }
    
    
    public DefaultTableModel buildTableData() throws SQLException{
        DefaultTableModel data = Util.buildDataTable(getAllMembers());
        return data;
    }
    
    public ResultSet getAllMembers(){
        ResultSet rs = null;
        try{
            String query = "SELECT * FROM user";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    ///
   public int UpdateUser(User userObj) {
        int isupdated = 0;
        String query = "UPDATE user SET fullname =" + userObj.getFullname()+ ",address="
                + userObj.getAddress()+ ", contact=" + userObj.getContact()
                + "   ,skills=" + userObj.getSkill()+ " WHERE id = '"
                + userObj.getId() + "'; ";
        try {
            pstmt = con.prepareStatement(query);
              pstmt.setString(1, userObj.getFullname());
              pstmt.setString(2, userObj.getAddress());
               pstmt.setString(3, userObj.getContact());
            pstmt.setString(6, userObj.getSkills());
           
            isupdated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isupdated;
    }
}

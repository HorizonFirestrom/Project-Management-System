/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softwarica.wetrack.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Prashanna
 */
public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            connectToDb();
        }
        return con;
    }

    private static void connectToDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adiproject", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not onnect to database. Please Check db settings.");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

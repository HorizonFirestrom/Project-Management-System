/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softwarica.wetrack.controller;

import edu.softwarica.wetrack.dbconnection.DBConnection;
import edu.softwarica.wetrack.models.Project;
import edu.softwarica.wetrack.utils.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class ProjectController {
    
    private Connection con = null;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public ProjectController(){
        if(con == null){
            con = DBConnection.getConnection();
        }
    }
    
    public int createProject(Project project) throws SQLException{
        
        String query = "INSERT INTO project(name,skills_required,project_owner) VALUES(?,?,?)";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, project.getName());
        pstmt.setString(2, project.getSkillsRequired());
        pstmt.setInt(3, project.getProjectOwner().getId());
        int projectCreated = pstmt.executeUpdate();
        
        return projectCreated;
    }
    
    
    public DefaultTableModel buildTableData() throws SQLException{
        DefaultTableModel data = Util.buildDataTable(getAllProjects());
        return data;
    }
    
    public ResultSet getAllProjects(){
        ResultSet resultset = null;
        try{
            String query = "SELECT * FROM project";
            pstmt = con.prepareStatement(query);
            resultset = pstmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultset;
        
    }
}

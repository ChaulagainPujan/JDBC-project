/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.model.Student;
import com.utils.DBConnection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author Pujan Chaulagain
 */
public class DatabaseFunctions {

    boolean temp;
    DBConnection db;

    public DatabaseFunctions() throws ClassNotFoundException, SQLException {
        db = new DBConnection();
    }

    public boolean insertStudent(Student s) throws ClassNotFoundException, SQLException {
        temp = false;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit", "root", "");

        PreparedStatement pstmt = con.prepareStatement("insert into student values(null,?,?,?,?)");
        pstmt.setString(1, s.getName());
        pstmt.setString(2, s.getAddress());
        pstmt.setString(3, s.getContact());
        pstmt.setBoolean(4, s.isStatus());

        int r = pstmt.executeUpdate();
        if (r > 0) {
            temp = true;
        }
        return temp;
    }

    public boolean updateStudent(Student s) throws ClassNotFoundException, SQLException {
        temp = false;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit", "root", "");

        PreparedStatement pstmt = con.prepareStatement("UPDATE student set name=?,address=?,contact=?,status=? where id=?");
        pstmt.setString(1, s.getName());
        pstmt.setString(2, s.getAddress());
        pstmt.setString(3, s.getContact());
        pstmt.setBoolean(4, s.isStatus());
        pstmt.setInt(5, s.getId());
        int r = pstmt.executeUpdate();
        if (r > 0) {
            temp = true;
        }

        return temp;
    }

    public boolean checkID(int id) throws SQLException {
        temp = false;
        PreparedStatement pstmt = db.con.prepareStatement("select * from student where id =?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            temp = true;
        }
        return temp;
    }

    public boolean deleteStudent(int id) throws SQLException {
        temp = false;
        PreparedStatement pstmt = db.con.prepareStatement("Delete from student where id=?");
        pstmt.setInt(1, id);
        int r = pstmt.executeUpdate();
        if (r > 0) {
            temp = true;
        }
        return temp;
    }

    public ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        PreparedStatement pstmt = db.con.prepareStatement("select * from student");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
        }

        return list;
    }

    public ArrayList<Student> getByID(int id) throws SQLException {

        ArrayList<Student> list = new ArrayList<>();
        PreparedStatement pstmt = db.con.prepareStatement("select * from student where id=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
        }

        return list;
    }

}

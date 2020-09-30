/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.database.DatabaseFunctions;
import com.io.InputOutput;
import com.model.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pujan Chaulagain
 */
public class MainProgram {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        int choice;
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        int id;
        Student s;
         ArrayList<Student> list;
        InputOutput io = new InputOutput();
        DatabaseFunctions dbf = new DatabaseFunctions();
        boolean result;
        while (value) {
            System.out.println("-----------------------");
            System.out.println("1 Insert Student");
            System.out.println("2 Update Student");
            System.out.println("3 Delete Student");
            System.out.println("4 View All Student");
            System.out.println("5 View Particular Student");
            System.out.println("6 Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //insert ko kaam
                    s = io.readStudent();
                    result = dbf.insertStudent(s);
                    if (result) {
                        System.out.println("Data Inserted");
                    } else {
                        System.out.println("Data not inserted");
                    }

                    break;
                case 2:
                    //update ko kaam
                    id = io.getId();
                    result=dbf.checkID(id);
                    if(result)
                    {
                    s = io.readStudent();
                    s.setId(id);
                    result = dbf.updateStudent(s);
                    if (result) {
                        System.out.println("Data updated");
                    } else {
                        System.out.println("Data not updated");
                    }
                    }
                    else{
                        System.out.println("ID not found");
                    }

                    break;
                case 3:
                    //delete ko kaam
                    id=io.getId();
                    result=dbf.checkID(id);
                    if(result)
                    {
                        result=dbf.deleteStudent(id);
                        if(result)
                        {
                            System.out.println("Student deleted");
                        }
                        else{
                            System.out.println("Student not deleted");
                        }
                    }
                    else{
                        System.out.println("ID not found");
                    }
                    
                    
                    
                    break;
                case 4:
                    //view all student
                    list = dbf.getAllStudents();
                    io.displayStudent(list);
                    break;
                case 5:
                    //view a particular student ko kaam
                    id=io.getId();
                    result=dbf.checkID(id);
                    if(result)
                    {
                        list=dbf.getByID(id); 
                        io.displayStudent(list);
                    }
                    else{
                        System.out.println("Id Not Found");
                    }
                   
                    break;
                case 6:
                    value = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

}

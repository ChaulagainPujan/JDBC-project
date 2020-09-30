/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import com.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Pujan Chaulagain
 */
public class InputOutput {
    
    private BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
    private String name,address,contact;
    private boolean status;
    public Student readStudent() throws IOException
    {
        System.out.println("Enter your name");
        name=bfr.readLine();
        System.out.println("Enter your address");
        address=bfr.readLine();
        System.out.println("Enter your contact");
        contact=bfr.readLine();
        System.out.println("Enter your status");
        status=Boolean.parseBoolean(bfr.readLine());
        return new Student(0, name, address, contact, status);
    }
    
    
    public int getId() throws IOException
    {
        System.out.println("Enter the id you want to update");
        return Integer.parseInt(bfr.readLine());
        
    }
    public void displayStudent(ArrayList<Student> list)
    {
       for(Student x:list)
       {
           System.out.println("*********************************");
           System.out.println("ID  :"+x.getId());
           System.out.println("NAME  :"+x.getName());
           System.out.println("ADDRESS :"+x.getAddress());
           System.out.println("CONTACT  :"+x.getContact());
           System.out.println("STATUS  "+(x.isStatus()==true?"ACTIVE":"INACTIVE"));
           System.out.println("*********************************");
       }
    }
    
}

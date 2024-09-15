/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import java.sql.*;
/**
 *
 * @author rahul
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
           
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","porowski2020");
            s=c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

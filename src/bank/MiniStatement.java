/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.lang.String.*;
/**
 *
 * @author rahul
 */
public class MiniStatement extends JFrame{
    
    MiniStatement(String cardno){
        setLayout(null);
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        JLabel card = new JLabel("Card Number : "+cardno.substring(0, 4)+" XXXX XXXX "+cardno.substring(cardno.length()-4));
        card.setBounds(60,50,320,25);
        add(card);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(60,100,300,400);
        add(scrollPane);
        //textArea.setBounds(80, 100, 250, 400);
        textArea.setEditable(false);
        //add(textArea);
        try{
            Conn c = new Conn();
            String query = "select * from transaction where cardno='"+cardno+"' order by time desc;";
            ResultSet rs = c.s.executeQuery(query);
              // Set the size and position

            while (rs.next()) {
                //String cardnum = rs.getString("cardno");
                String type = rs.getString("transactiontype");
                double amount = rs.getDouble("amount");
                String date = rs.getString("time");
    
    // Append the result to the JTextArea
                //textArea.append("Card No: " + cardno + "\n");
                textArea.append("Transaction Type: " + type + "\n");
                textArea.append("Amount: " + amount + "\n");
                textArea.append("Transaction Date: " + date + "\n");
                textArea.append("-------------------------\n");
            }

// Add the JTextArea to your JFrame or JPanel
        

        }
        catch(Exception e){
            System.out.println(e);
        }
        textArea.setCaretPosition(0);
        setVisible(true);
        
        
    }
    
    public static void main(String args[]){
        new MiniStatement("1234-4567-7894-4851");
    }
    
}

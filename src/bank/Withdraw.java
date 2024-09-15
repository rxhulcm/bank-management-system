/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.*;

/**
 *
 * @author rahul
 */
public class Withdraw extends JFrame implements ActionListener{
    String pinno,cardno;
    JTextField amount;
    JButton withdrawal,back;
    Withdraw(String pinno,String cardno){
        
        setSize(800,800);
        setUndecorated(true);
        setLayout(null);
        this.pinno=pinno;
        this.cardno=cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Enter the Amount to Withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(170,280,300,25);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(210,320,180,25);
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(amount);
        
        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(315,370,140,25);
        image.add(withdrawal);
        back = new JButton("Back");
        back.setBounds(315,400,140,25);
        image.add(back);
        withdrawal.addActionListener(this);
        back.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawal){
            String amt = "";
            amt= amount.getText();
            try{
                if(amt.equals("")){
                    JOptionPane.showMessageDialog(null, "ENTER AMOUNT TO WITHDRAW");
                }
                else{
                    Conn c = new Conn();
                    String query="select balance from balance where cardno='"+cardno+"' and pinno='"+pinno+"';";
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        Double currentBalance = rs.getDouble("balance");
                        currentBalance=currentBalance- Double.parseDouble(amt);
                        if(currentBalance<0){
                            amount.setText("");
                            JOptionPane.showMessageDialog(null, "AMOUNT EXCEEDS BALANCE");
                        }
                        
                        else{
                        String querytwo="update balance set balance ="+currentBalance+" where cardno='"+cardno+"' and pinno='"+pinno+"';";
                        int rowsAffected = c.s.executeUpdate(querytwo);
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = now.format(formatter);  // e.g., "2024-09-14 16:30:25"

                        String querythree="insert into transaction values('"+cardno+"','WITHDRAW', '"+amt+"', '"+formattedDateTime+"');";
                        
                        if(rowsAffected>0){
                            JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED BALANCE");
                            amount.setText("");
                            c.s.executeUpdate(querythree);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "WITHDRAWAL UNSUCCESSFUL");
                        }
                        }
                    }
                    
                    
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno,cardno).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdraw("","");
    }
}

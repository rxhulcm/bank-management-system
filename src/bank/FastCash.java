/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rahul
 */
public class FastCash extends JFrame implements ActionListener{
    String pinno,cardno;
    JButton hundred,fivehundred,thousand,twothousand,back;
    FastCash(String pinno,String cardno){
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
        
        JLabel text = new JLabel("Click on Amount to Withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(170,280,300,25);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(315,370,140,25);
        image.add(hundred);
        hundred.addActionListener(this);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(315,400,140,25);
        image.add(fivehundred);
        fivehundred.addActionListener(this);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(315,430,140,25);
        image.add(thousand);
        thousand.addActionListener(this);
        
        twothousand  = new JButton("Rs 2000");
        twothousand.setBounds(315,460,140,25);
        image.add(twothousand);
        twothousand.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(145,460,140,25);
        image.add(back);
        back.addActionListener(this);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==hundred || ae.getSource()==fivehundred ||ae.getSource()==thousand||ae.getSource()==twothousand){
            float amt=0;
            
            if(ae.getSource() == hundred){
                amt=100;
            }
            else if(ae.getSource() == fivehundred){
                amt=500;
            }
            else if(ae.getSource() == thousand){
                amt=1000;
            }
            else if(ae.getSource() == twothousand){
                amt=2000;
            }

            try{
                
                
                    Conn c = new Conn();
                    String query="select balance from balance where cardno='"+cardno+"' and pinno='"+pinno+"';";
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        Double currentBalance = rs.getDouble("balance");
                        currentBalance=currentBalance- amt;
                        if(currentBalance<0){
                            
                            JOptionPane.showMessageDialog(null, "AMOUNT EXCEEDS BALANCE");
                        }
                        
                        else{
                        String querytwo="update balance set balance ="+currentBalance+" where cardno='"+cardno+"' and pinno='"+pinno+"';";
                        int rowsAffected = c.s.executeUpdate(querytwo);
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = now.format(formatter);
                        String querythree="insert into transaction values('"+cardno+"','FAST CASH', '"+amt+"', '"+formattedDateTime+"');";
                        
                        if(rowsAffected>0){
                            JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED BALANCE");
                            c.s.executeUpdate(querythree);
                            
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "WITHDRAWAL UNSUCCESSFUL");
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
    
    public static void main (String args[]){
        new FastCash("","");
    }
    
}

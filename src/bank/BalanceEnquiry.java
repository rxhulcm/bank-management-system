/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author rahul
 */

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinno,cardno;
    JButton back;
    BalanceEnquiry(String pinno,String cardno){
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
        
        JLabel text = new JLabel("YOUR CURRENT BALANCE IS");
        text.setForeground(Color.WHITE);
        text.setBounds(185,280,300,18);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        back = new JButton("BACK");
        back.setBounds(315,460,140,25);
        image.add(back);
        back.addActionListener(this);

        try{
            Conn c =  new Conn();
            String query = "select balance from balance where cardno='"+cardno+"' and pinno='"+pinno+"';";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                Double balance = rs.getDouble("balance");
                JLabel DispBalance = new JLabel("Rs "+balance);
                DispBalance.setForeground(Color.WHITE);
                DispBalance.setBounds(270,350,200,18);
                DispBalance.setFont(new Font("System",Font.BOLD,15));
                image.add(DispBalance);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno,cardno).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new BalanceEnquiry("","");
    }
    
}

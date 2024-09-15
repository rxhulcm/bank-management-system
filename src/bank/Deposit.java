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
import java.time.format.DateTimeFormatter;
/**
 *
 * @author rahul
 */
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinno,cardno;
    Deposit(String pinno,String cardno){
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
        
        JLabel text = new JLabel("Enter the Amount to Deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(170,280,300,25);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(210,320,180,25);
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(315,370,140,25);
        image.add(deposit);
        back = new JButton("Back");
        back.setBounds(315,400,140,25);
        image.add(back);
        deposit.addActionListener(this);
        back.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String amt = "";
            amt= amount.getText();
            try{
                if(amt.equals("")){
                    JOptionPane.showMessageDialog(null, "ENTER AMOUNT TO DEPOSIT");
                }
                else{
                    Conn c = new Conn();
                    String query="select balance from balance where cardno='"+cardno+"' and pinno='"+pinno+"';";
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        Double currentBalance = rs.getDouble("balance");
                        currentBalance=currentBalance+ Double.parseDouble(amt);
                        String querytwo="update balance set balance ="+currentBalance+" where cardno='"+cardno+"' and pinno='"+pinno+"';";
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = now.format(formatter);
                        String querythree="insert into transaction values('"+cardno+"','DEPOSIT', '"+amt+"', '"+formattedDateTime+"');";
                        int rowsAffected = c.s.executeUpdate(querytwo);
                        if(rowsAffected>0){
                            JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED BALANCE");
                            amount.setText("");
                            c.s.executeUpdate(querythree);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "DEPOSIT UNSUCCESSFUL");
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
        new Deposit("","");
    }
    
}

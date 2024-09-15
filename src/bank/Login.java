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
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    
    Login() {
        setLayout(null);
        setSize(800,800);
        //setLocation(300,200);
        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(250, 160, 400, 40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
        
        JLabel card = new JLabel("Card Number:");
        card.setBounds(120, 280, 200, 40);
        card.setFont(new Font("Raleway",Font.BOLD,28));
        add(card);
        
        cardtextfield = new JTextField();
        cardtextfield.setBounds(320, 280, 250, 40);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,18));
        add(cardtextfield);
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120, 340, 200, 40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);
        
        pintextfield = new JPasswordField();
        pintextfield.setBounds(320, 340, 250, 40);
        pintextfield.setFont(new Font("Arial",Font.BOLD,18));
        add(pintextfield);
        
        login = new JButton("LOG IN");
        login.setBounds(320, 400, 120, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,400,120,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        signup = new JButton("SIGN UP");
        signup.setBounds(395,460,120,40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        setVisible(true);
        
        
        
        
    }
            
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String cardno=cardtextfield.getText();
                char[] pinno=pintextfield.getPassword();
                String enteredpwd = new String(pinno);
                Conn con = new Conn();
                String query = "select * from signupthree where cardNumber='"+cardno+"' and pin='"+enteredpwd+"';";
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(enteredpwd,cardno).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "INCORRECT CARD NUMBER OR PIN");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        
        if(ae.getSource() == clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        
        if(ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
            
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}

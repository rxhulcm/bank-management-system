/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author rahul
 */
public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrawal,ministatement,fastcash,pinchange,balanceenquiry,exit;
    String pinno,cardno;
    Transaction(String pinno,String cardno){
        setSize(800,800);
        getContentPane().setBackground(Color.WHITE);
        
        this.pinno=pinno;
        this.cardno=cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setForeground(Color.WHITE);
        text.setBounds(160,250,300,25);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(145,370,140,25);
        image.add(deposit);
        deposit.addActionListener(this);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(145,400,140,25);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(145,430,140,25);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(315,370,140,25);
        image.add(withdrawal);
        withdrawal.addActionListener(this);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(315,400,140,25);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(315,430,140,25);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
        
        exit = new JButton("EXIT");
        exit.setBounds(315,460,140,25);
        image.add(exit);
        exit.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {  
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinno,cardno).setVisible(true);
        }
        if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdraw(pinno,cardno).setVisible(true);
        }
        if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinno,cardno).setVisible(true);
        }
        if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinno,cardno).setVisible(true);
        }
        if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinno,cardno).setVisible(true);
        }
        if(ae.getSource() == ministatement){
            new MiniStatement(cardno).setVisible(true);
        }
        
    }
    public static void main(String args[]){
        new Transaction("","");
    }
}

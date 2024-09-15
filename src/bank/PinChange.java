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
public class PinChange extends JFrame implements ActionListener{
    String pinno,cardno;
    JPasswordField reenterpin,updatedpin;
    JButton update,back;
    PinChange(String pinno,String cardno){
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
        
        JLabel updated = new JLabel("Enter New Pin");
        updated.setForeground(Color.WHITE);
        updated.setBounds(235,280,180,25);
        updated.setFont(new Font("System",Font.BOLD,18));
        image.add(updated);
        
        updatedpin = new JPasswordField();
        updatedpin.setBounds(210,310,180,25);
        updatedpin.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(updatedpin);
        
        JLabel reenter = new JLabel("Re-Enter New Pin");
        reenter.setForeground(Color.WHITE);
        reenter.setBounds(225,340,180,25);
        reenter.setFont(new Font("System",Font.BOLD,18));
        image.add(reenter);
        
        reenterpin = new JPasswordField();
        reenterpin.setBounds(210,370,180,25);
        reenterpin.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(reenterpin);
        
        update = new JButton("UPDATE");
        update.setBounds(315,430,140,25);
        image.add(update);
        update.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(315,460,140,25);
        image.add(back);
        back.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        char[] upd=updatedpin.getPassword();
        char[] reent=reenterpin.getPassword();
        String updated = new String(upd);
        String reenter = new String(reent);
        
        if(ae.getSource() == update){
            if(!updated.equals(reenter)){
                JOptionPane.showMessageDialog(null, "PINS DO NOT MATCH");
                updatedpin.setText("");
                reenterpin.setText("");
            }
            else if(updated.equals(pinno)){
                JOptionPane.showMessageDialog(null, "NEW PIN SHOULD NOT BE SAME AS OLD PIN");
                updatedpin.setText("");
                reenterpin.setText("");
            }
            else{
                try{
                Conn c = new Conn();
                String query = "update signupthree set pin='"+updated+"' where cardNumber='"+cardno+"' and pin='"+pinno+"';";
                String querytwo = "update balance set pinno='"+updated+"' where cardno='"+cardno+"' and pinno='"+pinno+"';";
                c.s.executeUpdate(query);
                c.s.executeUpdate(querytwo);
                JOptionPane.showMessageDialog(null,"PIN CHANGE SUCCESSFUL. LOGIN AGAIN");
                setVisible(false);
                new Login().setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno,cardno).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("","");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
/**
 *
 * @author rahul
 */
public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton type1,type2,type3,type4;
    JCheckBox stype1,stype2,stype3,stype4,stype5,stype6,declaration;
    JButton submit, cancel;
    String formno;
    long random1,random2,random3,random4,random5;
    SignUpThree(String formid){
        this.formno=formid;
        setLayout(null);
        setSize(800,800);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION PAGE THREE");
        
        JLabel accountDetails = new JLabel("PAGE 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
        accountDetails.setBounds(280,50,350,25);
        add(accountDetails);
        
        JLabel accountType = new JLabel("Type : ");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100,150,150,25);
        add(accountType);
        type1 = new JRadioButton("Savings");
        type1.setFont(new Font("Arial",Font.BOLD,18));
        type1.setBounds(320,150,190,20);
        add(type1);
        
        type2 = new JRadioButton("Current");
        type2.setFont(new Font("Arial",Font.BOLD,18));
        type2.setBounds(520,150,190,20);
        add(type2);
        type3 = new JRadioButton("Fixed Deposit");
        type3.setFont(new Font("Arial",Font.BOLD,18));
        type3.setBounds(320,180,190,20);
        add(type3);
        type4 = new JRadioButton("Recurring Deposit");
        type4.setFont(new Font("Arial",Font.BOLD,18));
        type4.setBounds(520,180,190,20);
        add(type4);
        type1.setBackground(Color.WHITE);
        type2.setBackground(Color.WHITE);
        type3.setBackground(Color.WHITE);
        type4.setBackground(Color.WHITE);
        
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(type1);
        typeGroup.add(type2);
        typeGroup.add(type3);
        typeGroup.add(type4);
        
        JLabel cardNumber = new JLabel("Card Number : ");
        cardNumber.setFont(new Font("Raleway",Font.BOLD,22));
        cardNumber.setBounds(100,250,180,25);
        add(cardNumber);
        
        Random ran = new Random();
        random1 = (ran.nextInt(9000))+1000;
        random2 = (ran.nextInt(9000))+1000;
        random3 = (ran.nextInt(9000))+1000;
        random4 = (ran.nextInt(9000))+1000;
        
        
        JLabel number = new JLabel(random1+"-"+random2+"-"+random3+"-"+random4);
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(400,250,290,25);
        add(number);
        
        JLabel details = new JLabel("(THIS IS YOUR 16 DIGIT CARD NUMBER)");
        details.setFont(new Font("Arial",Font.ITALIC,12));
        details.setBounds(100,280,400,20);
        add(details);
        
        random5 =(ran.nextInt(9000))+1000L;
        JLabel pinNumber = new JLabel("PIN Number : ");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinNumber.setBounds(100,310,180,25);
        add(pinNumber);
        
        JLabel pin = new JLabel(""+random5);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(400,310,290,25);
        add(pin);
        
        JLabel pinDetails = new JLabel("(THIS IS YOUR 4 DIGIT PIN NUMBER)");
        pinDetails.setFont(new Font("Arial",Font.ITALIC,12));
        pinDetails.setBounds(100,340,400,20);
        add(pinDetails);
        
        JLabel servicesReq = new JLabel("Services Required : ");
        servicesReq.setFont(new Font("Raleway",Font.BOLD,22));
        servicesReq.setBounds(100,370,250,25);
        add(servicesReq);
        
        stype1 = new JCheckBox("ATM CARD");
        stype1.setFont(new Font("Arial",Font.BOLD,18));
        stype1.setBounds(320,370,190,20);
        add(stype1);
        
        stype2 = new JCheckBox("INTERNET BANKING");
        stype2.setFont(new Font("Arial",Font.BOLD,18));
        stype2.setBounds(520,370,250,20);
        add(stype2);
        stype3 = new JCheckBox("MOBILE BANKING");
        stype3.setFont(new Font("Arial",Font.BOLD,18));
        stype3.setBounds(320,400,190,20);
        add(stype3);
        stype4 = new JCheckBox("EMAIL&SMS ALERTS");
        stype4.setFont(new Font("Arial",Font.BOLD,18));
        stype4.setBounds(520,400,250,20);
        add(stype4);
        
        stype5 = new JCheckBox("CHEQUE BOOK");
        stype5.setFont(new Font("Arial",Font.BOLD,18));
        stype5.setBounds(320,430,190,20);
        add(stype5);
        stype6 = new JCheckBox("E-STATEMENTS");
        stype6.setFont(new Font("Arial",Font.BOLD,18));
        stype6.setBounds(520,430,190,20);
        add(stype6);
        stype1.setBackground(Color.WHITE);
        stype2.setBackground(Color.WHITE);
        stype3.setBackground(Color.WHITE);
        stype4.setBackground(Color.WHITE);
        stype5.setBackground(Color.WHITE);
        stype6.setBackground(Color.WHITE);
        
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declaration.setFont(new Font("Arial",Font.BOLD,12));
        declaration.setForeground(Color.RED);
        declaration.setBounds(100,550,600,20);
        declaration.setBackground(Color.WHITE);
        add(declaration);
        
        submit = new JButton("SUBMIT");
        cancel = new JButton("CANCEL");
        submit.setFont(new Font("Raleway",Font.BOLD,22));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,600,150,25);
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(410,600,150,25);
        add(submit);
        add(cancel);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String AccountType="";
            if(type1.isSelected())
                AccountType="Savings Account";
            else if(type2.isSelected())
                AccountType="Current Account";
            else if(type3.isSelected())
                AccountType="Fixed Deposit Account";
            else if(type4.isSelected())
                AccountType="Recurring Deposit Account";
            String cardnumber=random1+"-"+random2+"-"+random3+"-"+random4;
            String pinnumber=""+random5;
            String atmcard="N",internetbanking="N",mobilebanking="N",smsalert="N",estatement="N",chequebook="N";
            if(stype1.isSelected())
                atmcard="Y";
            if(stype2.isSelected())
                internetbanking="Y";
            if(stype3.isSelected())
                mobilebanking="Y";
            if(stype4.isSelected())
                smsalert="Y";
            if(stype5.isSelected())
                chequebook="Y";
            if(stype6.isSelected())
                estatement="Y";
            
            try{
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null, "CHOOSE AN ACCOUNT TYPE");
                }
                else if(declaration.isSelected()==false){
                    JOptionPane.showMessageDialog(null, "CANNOT CONTINUE WITHOUT CHECKING THE DECLARATION");
                    
                }
                else
                {
                    Conn c = new Conn();
                    String query= "insert into signupthree values('"+formno+"', '"+AccountType+"', '"+cardnumber+"', '"+pinnumber+"');";
                    String querytwo= "insert into facilities values('"+formno+"', '"+atmcard+"', '"+internetbanking+"', '"+mobilebanking+"', '"+smsalert+"', '"+chequebook+"', '"+estatement+"');";
                    String querythree="insert into balance values('"+cardnumber+"', '"+pinnumber+"',"+0+");";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(querytwo);
                    c.s.executeUpdate(querythree);
                    setVisible(false);
                    new Login().setVisible(true);
//                    setVisible(false);
//                    new Transaction().setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == cancel){
            try{
            Conn c = new Conn();
            String query = "delete from signup where formno='"+formno+"';";
            String querytwo = "delete from signuptwo where formno='"+formno+"';";
            c.s.executeUpdate(query);
            c.s.executeUpdate(querytwo);
            setVisible(false);
            new Login().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new SignUpThree("");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


/**
 *
 * @author rahul
 */

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fathernameTextField,dobChooser,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    
    JRadioButton male,female,married,unmarried,others;
    public SignUpOne(){
        setLayout(null);
        setSize(800,800);
        
        setTitle("NEW ACCOUNT APPLICATION PAGE ONE");
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO : " + random);
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Information ");
        personDetails.setBounds(200,70,600,40);
        personDetails.setFont(new Font("Raleway",Font.BOLD,32));
        add(personDetails);
        
        JLabel name = new JLabel("Name : ");
        name.setBounds(100,140,200,25);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,400,25);
        nameTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father Name : ");
        fatherName.setBounds(100,170,200,25);
        fatherName.setFont(new Font("Raleway",Font.BOLD,22));
        add(fatherName);
        
        fathernameTextField = new JTextField();
        fathernameTextField.setBounds(300,170,400,25);
        fathernameTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(fathernameTextField);
        
        JLabel dob = new JLabel("DOB : ");
        dob.setBounds(100,200,200,25);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        add(dob);
        
        
        
        dobChooser = new JTextField();
        dobChooser.setBounds(300,200,400,25);
        dobChooser.setFont(new Font("Arial",Font.BOLD,22));
        add(dobChooser);
        
        
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100,230,200,25);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,230,120,25);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(500,230,120,25);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address : ");
        email.setBounds(100,260,200,25);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(300,260,400,25);
        emailTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status : ");
        maritalStatus.setBounds(100,290,200,25);
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,22));
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300,290,120,25);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(433,290,120,25);
        add(unmarried);
        others = new JRadioButton("Others");
        others.setBounds(566,290,120,25);
        add(others);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        JLabel address = new JLabel("Address : ");
        address.setBounds(100,320,200,25);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(300,320,400,25);
        addressTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(addressTextField);
        
        
        JLabel city = new JLabel("City : ");
        city.setBounds(100,350,200,25);
        city.setFont(new Font("Raleway",Font.BOLD,22));
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(300,350,400,25);
        cityTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(cityTextField);
        
        JLabel state = new JLabel("State : ");
        state.setBounds(100,380,200,25);
        state.setFont(new Font("Raleway",Font.BOLD,22));
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(300,380,400,25);
        stateTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setBounds(100,410,200,25);
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setBounds(300,410,400,25);
        pinTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(pinTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.setBounds(600,450,100,25);
        next.addActionListener(this);
        add(next);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name=nameTextField.getText();
        String fname= fathernameTextField.getText();
        String bday = dobChooser.getText();
        String gender="";
        if(male.isSelected())
            gender="Male";
        else if(female.isSelected())
            gender="Female";
        String email=emailTextField.getText();
        String maritalStatus = "";
        if(married.isSelected())
            maritalStatus = "Married";
        else if(unmarried.isSelected())
            maritalStatus = "Unmarried";
        else if(others.isSelected())
            maritalStatus="Others";
        
        String address = addressTextField.getText();
        String city=cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "NAME SHOULD NOT BE EMPTY");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "FATHER NAME SHOULD NOT BE EMPTY");
            }
            else if(bday.equals("")){
                JOptionPane.showMessageDialog(null, "DOB SHOULD NOT BE EMPTY");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"SELECT A GENDER");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "EMAIL SHOULD NOT BE EMPTY");
            }
            else if(maritalStatus.equals("")){
                JOptionPane.showMessageDialog(null, "SELECT A MARITAL STATUS");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "ADDRESS SHOULD NOT BE EMPTY");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "CITY SHOULD NOT BE EMPTY");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "STATE SHOULD NOT BE EMPTY");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "PINCODE SHOULD NOT BE EMPTY");
            }
            else{
                Conn c = new Conn();
                String query= "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+bday+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
     }
    
    public static void main(String args[]){
        new SignUpOne();
    }
    
}

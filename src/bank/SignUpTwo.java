/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 *
 * @author rahul
 */
public class SignUpTwo extends JFrame implements ActionListener{
//    long random;
    JTextField occupationTextField,aadharNoTextField,panNoTextField;
    JButton next;
    JComboBox religionopt,categoryopt,incomeopt,educationalQualificationopt;
    
    String formno;
    JRadioButton yes,no,yesSenior,noSenior;
    public SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setSize(800,800);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION PAGE TWO");
//        Random ran = new Random();
//        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
//        JLabel formno = new JLabel("APPLICATION FORM NO : " + random);
//        formno.setBounds(140,20,600,40);
//        formno.setFont(new Font("Raleway",Font.BOLD,38));
//        add(formno);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Information ");
        additionalDetails.setBounds(200,70,600,40);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,32));
        add(additionalDetails);
        
        
        
        JLabel category = new JLabel("Category : ");
        category.setBounds(100,140,300,25);
        category.setFont(new Font("Raleway",Font.BOLD,22));
        add(category);
        
        String categoryVal[]= {"General","OBC","SC","ST","Others"};
        categoryopt = new JComboBox(categoryVal);
        categoryopt.setBounds(400,140,350,25);
        categoryopt.setFont(new Font("Arial",Font.BOLD,18));
        categoryopt.setSelectedItem(null);
        add(categoryopt);
        
        JLabel income = new JLabel("Income : ");
        income.setBounds(100,170,300,25);
        income.setFont(new Font("Raleway",Font.BOLD,22));
        add(income);
        
        String incomeVal[]={"null","<3LPA","3-7LPA","7-10LPA",">10LPA"};
        incomeopt = new JComboBox(incomeVal);
        incomeopt.setBounds(400,170,350,25);
        incomeopt.setFont(new Font("Arial",Font.BOLD,18));
        incomeopt.setSelectedItem(null);
        add(incomeopt);
        
        JLabel educationalQualification = new JLabel("Educational Qualification : ");
        educationalQualification.setBounds(100,200,300,25);
        educationalQualification.setFont(new Font("Raleway",Font.BOLD,22));
        add(educationalQualification);
        
        
        String educationVal[]={"10th Grade","12th Grade","Undergraduate","Postgraduate","Phd Scholar"};
        educationalQualificationopt = new JComboBox(educationVal);
        educationalQualificationopt.setBounds(400,200,350,25);
        educationalQualificationopt.setFont(new Font("Arial",Font.BOLD,18));
        educationalQualificationopt.setSelectedItem(null);
        add(educationalQualificationopt);
        
        
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(100,230,300,25);
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        add(occupation);
        
        occupationTextField = new JTextField();
        occupationTextField.setBounds(400,230,350,25);
        occupationTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(occupationTextField);
        
        
        
        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(100,260,300,25);
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        add(religion);
        
        String religionVal[] = {"Hindu","Christian","Muslim","Jain","Budhist","Others"};
        religionopt = new JComboBox(religionVal);
        religionopt.setBounds(400,260,350,25);
        religionopt.setFont(new Font("Arial",Font.BOLD,18));
        religionopt.setSelectedItem(null);
        add(religionopt);
        
        JLabel AadharNo = new JLabel("Aadhar No : ");
        AadharNo.setBounds(100,290,300,25);
        AadharNo.setFont(new Font("Raleway",Font.BOLD,22));
        add(AadharNo);
        
        aadharNoTextField = new JTextField();
        aadharNoTextField.setBounds(400,290,350,25);
        aadharNoTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(aadharNoTextField);
        
        
        
        JLabel PanNo = new JLabel("PAN No : ");
        PanNo.setBounds(100,320,300,25);
        PanNo.setFont(new Font("Raleway",Font.BOLD,22));
        add(PanNo);
        
        panNoTextField = new JTextField();
        panNoTextField.setBounds(400,320,350,25);
        panNoTextField.setFont(new Font("Arial",Font.BOLD,18));
        add(panNoTextField);
        
        
        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setBounds(100,350,300,25);
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
        add(seniorCitizen);
        
        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(400,350,100,25);
        add(yesSenior);
        noSenior = new JRadioButton("No");
        noSenior.setBounds(650,350,100,25);
        add(noSenior);
        ButtonGroup senior = new ButtonGroup();
        senior.add(yesSenior);
        senior.add(noSenior);
        
        
        
        JLabel existingUser = new JLabel("Existing User : ");
        existingUser.setBounds(100,380,200,25);
        existingUser.setFont(new Font("Raleway",Font.BOLD,22));
        add(existingUser);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(400,380,100,25);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(650,380,100,25);
        add(no);
        ButtonGroup exist = new ButtonGroup();
        exist.add(yes);
        exist.add(no);
        
        
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
        
        String religion,category,income,education,senior="",existinguser="",pan,aadhar,occupation;
        
        if(yesSenior.isSelected())
            senior="Yes";
        else if(noSenior.isSelected())
            senior="No";
        pan=panNoTextField.getText();
        aadhar=aadharNoTextField.getText();
        occupation=occupationTextField.getText();
        
        if(yes.isSelected())
            existinguser = "Yes";
        else if(no.isSelected())
            existinguser = "No";
        
        
        
        
        try{
            if(categoryopt.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null, "SELECT A CATEGORY");
            }
            else if(incomeopt.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null, "SELECT INCOME RANGE");
            }
            else if(educationalQualificationopt.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null, "SELECT EDUCATIONAL QUALIFICATION");
            }
            else if(religionopt.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null,"SELECT A RELIGION");
            }
            else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "OCCUPATION SHOULD NOT BE EMPTY");
            }   
            else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN NUMBER SHOULD NOT BE EMPTY");
            }
            else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "AADHAR NUMBER SHOULD NOT BE EMPTY");
            }
            else if(senior.equals("")){
                JOptionPane.showMessageDialog(null, "MARK SENIOR CITIZENSHIP STATUS");
            }
            else if(existinguser.equals("")){
                JOptionPane.showMessageDialog(null, "MARK EXISTING USER OR NOT");
            }
            else{
                religion=(String)religionopt.getSelectedItem();
                category=(String)categoryopt.getSelectedItem();
                education=(String)educationalQualificationopt.getSelectedItem();
                income=(String)incomeopt.getSelectedItem();
                Conn c = new Conn();
                String query= "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+existinguser+"');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
     }
    
    
    public static void main(String args[]){
        new SignUpTwo("");
    }
    
}

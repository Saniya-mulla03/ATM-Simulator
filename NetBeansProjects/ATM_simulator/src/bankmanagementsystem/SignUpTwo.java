package bankmanagementsystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,e_yes,e_no;
    JComboBox religion,category,income,educational,occupation;
    String formNo;
    SignUpTwo(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290, 80, 400, 30);
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        add(additionalDetails);

        JLabel religionName = new JLabel("Religion:");
        religionName.setBounds(100, 140, 100, 30);
        religionName.setFont(new Font("Railway", Font.BOLD, 20));
        add(religionName);
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryName = new JLabel("Category:");
        categoryName.setBounds(100, 190, 200, 30);
        categoryName.setFont(new Font("Railway", Font.BOLD, 20));
        add(categoryName);
        String valCategory[] = {"Open","OBC","SC","NT","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomeStatus = new JLabel("Income:");
        incomeStatus.setBounds(100, 240, 200, 30);
        incomeStatus.setFont(new Font("Railway", Font.BOLD, 20));
        add(incomeStatus);
        String incomeCategory[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educationalStatus = new JLabel("Educational:");
        educationalStatus.setBounds(100, 290, 200, 30);
        educationalStatus.setFont(new Font("Railway", Font.BOLD, 20));
        add(educationalStatus);
        JLabel qualificationStatus = new JLabel("Qualification:");
        qualificationStatus.setBounds(100, 315, 200, 30);
        qualificationStatus.setFont(new Font("Railway", Font.BOLD, 20));
        add(qualificationStatus);
        String educationValues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctarate","Other"};
        educational = new JComboBox(educationValues);
        educational.setBounds(300, 340, 400, 30);
        educational.setBackground(Color.WHITE);
        add(educational);

        JLabel occupational = new JLabel("Occupation:");
        occupational.setBounds(100, 390, 200, 30);
        occupational.setFont(new Font("Railway", Font.BOLD, 20));
        add(occupational);
        String occupationValues[] = {"Salaried","Self-Employeed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100, 440, 200, 30);
        pan.setFont(new Font("Railway", Font.BOLD, 20));
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(100, 490, 200, 30);
        aadhar.setFont(new Font("Railway", Font.BOLD, 20));
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setBounds(100, 540, 200, 30);
        seniorCitizen.setFont(new Font("Railway", Font.BOLD, 20));
        add(seniorCitizen);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorcitizengroup = new ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setBounds(100, 590, 200, 30);
        existingAccount.setFont(new Font("Railway", Font.BOLD, 20));
        add(existingAccount);
        e_yes = new JRadioButton("Yes");
        e_yes.setBounds(300,590,100,30);
        e_yes.setBackground(Color.WHITE);
        add(e_yes);
        e_no = new JRadioButton("No");
        e_no.setBounds(450,590,100,30);
        e_no.setBackground(Color.WHITE);
        add(e_no);
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(e_yes);
        existinggroup.add(e_no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducational = (String)educational.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if(e_yes.isSelected()){
            existingAccount = "Yes";
        }
        else if(e_no.isSelected()){
            existingAccount = "No";
        }
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        try{
                Connect c = new Connect();
                String query = "insert into SignUpTwo Values('"+formNo+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducational+"', '"+soccupation+"', '"+seniorCitizen+"', '"+existingAccount+"', '"+pan+"', '"+aadhar+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}

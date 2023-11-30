package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton savingAccount,fixedDeposit,currentAccount,recurringDeposit;
    JCheckBox atmCard,internetBanking,mobileBanking,emailSMS,chequeBook,eStatement,declaration;
    JButton submit,cancel;
    String formNo;
    SignUpThree(String formNo){
        this.formNo = formNo;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100,180,150,20);
        add(savingAccount);
        
        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDeposit.setBackground(Color.WHITE);
        fixedDeposit.setBounds(350,180,250,20);
        add(fixedDeposit);
        
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100,220,150,20);
        add(currentAccount);
        
        recurringDeposit = new JRadioButton("Recurring Deposit Account");
        recurringDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringDeposit.setBackground(Color.WHITE);
        recurringDeposit.setBounds(350,220,250,20);
        add(recurringDeposit);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(fixedDeposit);
        groupAccount.add(currentAccount);
        groupAccount.add(recurringDeposit);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2003");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,300,30);
        add(services);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(100,500,200,30);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(350,500,200,30);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100,550,200,30);
        add(mobileBanking);
        
        emailSMS = new JCheckBox("Email and SMS Alerts");
        emailSMS.setBackground(Color.WHITE);
        emailSMS.setFont(new Font("Raleway", Font.BOLD, 16));
        emailSMS.setBounds(350,550,200,30);
        add(emailSMS);
        
        chequeBook = new JCheckBox("Check Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(100,600,200,30);
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(350,600,200,30);
        add(eStatement);
        
        declaration = new JCheckBox("I hereby declares that the above entered details are correct in the best of my Knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100,680,600,30);
        add(declaration);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if(savingAccount.isSelected()){
                accountType = "Saving Account";
            }
            else if(fixedDeposit.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(currentAccount.isSelected()){
                accountType = "Current Account";
            }
            else if(recurringDeposit.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
            String facility = "";
            if(atmCard.isSelected()){
                facility = facility + " ATM Card";
            }
            else if(mobileBanking.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if(emailSMS.isSelected()){
                facility = facility + " Email and SMS Alerts";
            }
            else if(chequeBook.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(eStatement.isSelected()){
                facility = facility + " E-Statement";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "All Details are Required");
                }
                else{
                    Connect c = new Connect();
                    String query1 = "insert into SignUpThree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into Login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\nPin: "+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignUpThree("");
    }
}

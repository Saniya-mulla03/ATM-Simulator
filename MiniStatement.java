package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    MiniStatement(String pinNumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from Login where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Connect c = new Connect();
            int currentBalance = 0;
            ResultSet rs = c.s.executeQuery("select * from Bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"   "+rs.getString("type")+"   "+rs.getString("amount")+"<br>");
                if(rs.getString("type").equals("Deposit")){
                        currentBalance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                        currentBalance -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your Current Account Balance is Rs. "+currentBalance);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}

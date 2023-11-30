package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber;
    JButton back;
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("D:/Project/ATM_simulator/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        Connect c = new Connect();
        int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from Bank where pin = '"+pinNumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e){
                     System.out.println(e);
            }
        JLabel repinText = new JLabel("Your Current Account Balance is Rs: "+balance);
        repinText.setBounds(170,300,400,30);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        label.add(repinText);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}

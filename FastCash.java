package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("D:/Project/ATM_simulator/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);
        
        hundred = new JButton("Rs. 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        label.add(hundred);
        
        fiveHundred = new JButton("Rs. 500");
        fiveHundred.setBounds(355,415,150,30);
        fiveHundred.addActionListener(this);
        label.add(fiveHundred);
        
        thousand = new JButton("Rs. 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        label.add(thousand);
        
        twoThousand = new JButton("Rs. 2000");
        twoThousand.setBounds(355,450,150,30);
        twoThousand.addActionListener(this);
        label.add(twoThousand);
        
        fiveThousand = new JButton("Rs. 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.addActionListener(this);
        label.add(fiveThousand);
        
        tenThousand = new JButton("Rs. 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.addActionListener(this);
        label.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Connect c = new Connect();
            try{
                ResultSet rs = c.s.executeQuery("select * from Bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into Bank values('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amount+" Withdraw Successfully");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
    
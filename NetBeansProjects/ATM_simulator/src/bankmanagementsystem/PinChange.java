package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pinNumber;
    JPasswordField pin,repin;
    JButton change,back;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("D:/Project/ATM_simulator/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(165,320,185,25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        label.add(pinText);
        
        pin = new JPasswordField();
        pin.setBounds(330,320,185,25);
        pin.setFont(new Font("System", Font.BOLD, 25));
        label.add(pin);
        
        JLabel repinText = new JLabel("Re-Enter New PIN:");
        repinText.setBounds(165,360,185,25);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        label.add(repinText);
        
        repin = new JPasswordField();
        repin.setBounds(330,360,185,25);
        repin.setFont(new Font("System", Font.BOLD, 25));
        label.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        label.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String spin = pin.getText();
                String srepin = repin.getText();
                if(!spin.equals(srepin)){
                   JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                   return;
                }
                if(spin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                if(srepin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                Connect c = new Connect();
                String query1 = "update Login set pinNumber = '"+spin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update Bank set pin = '"+spin+"' where pin = '"+pinNumber+"'";
                String query3 = "update SignUpThree set pinNumber = '"+spin+"' where pinNumber = '"+pinNumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Changed PIN Successfully");
                setVisible(false);
                new Transactions(spin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("");
    }
}

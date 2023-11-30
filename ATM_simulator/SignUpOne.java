import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpOne extends JFrame {
    SignUpOne() {
        setLayout(null);
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setBounds(140, 20, 600, 40);
        formNo.setFont(new Font("Railway", Font.BOLD, 38));
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290, 80, 400, 30);
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Railway", Font.BOLD, 20));
        add(name);
        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        add(fname);
        JTextField fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        add(dob);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        add(gender);

        JLabel email = new JLabel("Email Address:");
        email.setBounds(100, 340, 200, 30);
        email.setFont(new Font("Railway", Font.BOLD, 20));
        add(email);
        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 390, 200, 30);
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        add(marital);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Railway", Font.BOLD, 20));
        add(address);
        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Railway", Font.BOLD, 20));
        add(city);
        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 540, 200, 30);
        state.setFont(new Font("Railway", Font.BOLD, 20));
        add(state);
        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        add(pincode);
        JTextField pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}

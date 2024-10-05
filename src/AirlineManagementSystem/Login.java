package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField password_jtextfield, username_jtextfield;
    JButton reset_jbutton, close_jbutton, login_jbutton;

    public Login(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//      username - field
        JLabel username_jlabel = new JLabel("Username");
        username_jlabel.setBounds(20, 20, 100, 20);
        add(username_jlabel);

        username_jtextfield = new JTextField();
        username_jtextfield.setBounds(130, 20, 200, 20);
        add(username_jtextfield);

//        password - field
        JLabel password_jlabel = new JLabel("Password");
        password_jlabel.setBounds(20, 60, 100, 20);
        add(password_jlabel);

        password_jtextfield = new JTextField();
        password_jtextfield.setBounds(130, 60, 200, 20);
        add(password_jtextfield);


//        Buttons
//        1. Reset Button
        reset_jbutton = new JButton("Reset");
        reset_jbutton.setBounds(40, 120, 120, 20);
        reset_jbutton.addActionListener(this);
        add(reset_jbutton);

//        2. Login Button
        login_jbutton = new JButton("Login");
        login_jbutton.setBounds(200, 120, 120, 20);
        login_jbutton.addActionListener(this);
        add(login_jbutton);

//        1. Close Button
        close_jbutton = new JButton("Close");
        close_jbutton.setBounds(120, 160, 120, 20);
        close_jbutton.addActionListener(this);
        add(close_jbutton);


//        setting the window
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_jbutton){
//            accessing the form-login data that is fill-up by user
            String username = username_jtextfield.getText();
            String password = password_jtextfield.getText();

            try {
//                DB Connection
                DBConnection dbConnection = new DBConnection();

//                SQL QUERY for run
                String query = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
//                Executing the Query
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
//                Does the username and password exits or not
                if(resultSet.next()) {
                    new Home();
                    setVisible(false);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getSource() == close_jbutton){
//            close the desktop application
            setVisible(false);
        } else if (e.getSource() == reset_jbutton){
//            resetting the login-form field
            username_jtextfield.setText("");
            password_jtextfield.setText("");
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new Login();
    }
}

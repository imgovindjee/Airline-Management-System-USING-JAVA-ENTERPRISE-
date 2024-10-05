package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddCustomer extends JFrame implements ActionListener {

    JTextField name_jtextField, aadhaar_jtextField, address_jtextField, nationality_jtextField, phone_jtextField;
    JRadioButton male_jradioButton, female_jradioButton;

    public AddCustomer(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel jLabel = new JLabel("Add Customer Details");
        jLabel.setForeground(Color.BLUE);
        jLabel.setBounds(220, 20, 500, 35);
        jLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(jLabel);


//        Form to add customer details
//        1. name
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(60, 80, 150, 25);
        name_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name_jlabel);

        name_jtextField = new JTextField();
        name_jtextField.setBounds(220, 80, 150, 25);
        add(name_jtextField);

//        2. nationality
        JLabel nationality_jlabel = new JLabel("Nationality");
        nationality_jlabel.setBounds(60, 130, 150, 25);
        nationality_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationality_jlabel);

        nationality_jtextField = new JTextField();
        nationality_jtextField.setBounds(220, 130, 150, 25);
        add(nationality_jtextField);

//        3. Aadhaar
        JLabel aadhaar_jlabel = new JLabel("Aadhaar");
        aadhaar_jlabel.setBounds(60, 180, 150, 25);
        aadhaar_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(aadhaar_jlabel);

        aadhaar_jtextField = new JTextField();
        aadhaar_jtextField.setBounds(220, 180, 150, 25);
        add(aadhaar_jtextField);

//        4. Address
        JLabel address_jlabel = new JLabel("Address");
        address_jlabel.setBounds(60, 230, 150, 25);
        address_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(address_jlabel);

        address_jtextField = new JTextField();
        address_jtextField.setBounds(220, 230, 150, 25);
        add(address_jtextField);

//        5. Gender
        JLabel gender_jlabel = new JLabel("Gender");
        gender_jlabel.setBounds(60, 280, 150, 25);
        gender_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender_jlabel);
//        radioButton creation
        ButtonGroup buttonGroup = new ButtonGroup();
//        i. Male
        male_jradioButton = new JRadioButton("Male");
        male_jradioButton.setBounds(220, 280, 75, 25);
        male_jradioButton.setBackground(Color.WHITE);
        add(male_jradioButton);
//        2.Female
        female_jradioButton = new JRadioButton("Female");
        female_jradioButton.setBounds(300, 280, 75, 25);
        female_jradioButton.setBackground(Color.WHITE);
        add(female_jradioButton);
//        grouping the action of the RADIOBUTTON TOGETHER
        buttonGroup.add(male_jradioButton);
        buttonGroup.add(female_jradioButton);

//        6. Phone
        JLabel phone_jlabel = new JLabel("Phone");
        phone_jlabel.setBounds(60, 330, 150, 25);
        phone_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(phone_jlabel);

        phone_jtextField = new JTextField();
        phone_jtextField.setBounds(220, 330, 150, 25);
        add(phone_jtextField);


//        SAVE BUTTON
        JButton save_jbutton = new JButton("SAVE");
        save_jbutton.setBounds(220, 380, 150, 30);
        save_jbutton.setBackground(Color.BLACK);
        save_jbutton.setForeground(Color.WHITE);
        save_jbutton.addActionListener(this); // EVENT LISTENER
        add(save_jbutton);

//        setting the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        JLabel image_jlabel = new JLabel(imageIcon);
        image_jlabel.setBounds(450,80, 280, 400);
        add(image_jlabel);


//        setting the window
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = name_jtextField.getText();
        String nationality = nationality_jtextField.getText();
        String aadhaar = aadhaar_jtextField.getText();
        String address = address_jtextField.getText();
        String gender = male_jradioButton.isSelected()
                ? "male"
                : female_jradioButton.isSelected()
                ? "female"
                : null;
        String phone = phone_jtextField.getText();

        try {
//            DB Connection
            DBConnection dbConnection = new DBConnection();

//            SQL QUERY
            String query = "INSERT INTO passengers VALUES('"+name+"', '"+nationality+"', '"+aadhaar+"', '"+address+"', '"+gender+"', '"+phone+"')";
//            adding the Date of the passenger to the DB
            dbConnection.statement.executeUpdate(query);

//            showing pop-Out
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new AddCustomer();
    }
}

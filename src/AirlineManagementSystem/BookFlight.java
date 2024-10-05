package AirlineManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class BookFlight extends JFrame implements ActionListener {

    JButton book_flight_jbutton, fetchUserDetails_jbutton, flightExists_jbutton;

    JLabel name_jlabel_, address_jlabel_, nationality_jlabel_, gender_jlabel_;
    JLabel flightName_jlabel_, flightcode_jlabel_;
    JTextField aadhaar_jtextField;
    Choice source_choice, destination_choice;
    JDateChooser jDateChooser;


    public BookFlight(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel jLabel = new JLabel("Book Flight");
        jLabel.setForeground(Color.BLUE);
        jLabel.setBounds(420, 20, 500, 40);
        jLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(jLabel);


//        Form to Book Tickets
//        1. Aadhaar
        JLabel aadhaar_jlabel = new JLabel("Aadhaar");
        aadhaar_jlabel.setBounds(60, 80, 150, 25);
        aadhaar_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(aadhaar_jlabel);

        aadhaar_jtextField = new JTextField();
        aadhaar_jtextField.setBounds(220, 80, 150, 25);
        add(aadhaar_jtextField);

//        Fetch User Details based on it's Aadhaar Number
        fetchUserDetails_jbutton = new JButton("Fetch User");
        fetchUserDetails_jbutton.setBounds(380, 80, 150, 25);
        fetchUserDetails_jbutton.setBackground(Color.BLACK);
        fetchUserDetails_jbutton.setForeground(Color.WHITE);
        fetchUserDetails_jbutton.addActionListener(this); // EVENT LISTENER
        add(fetchUserDetails_jbutton);

//        2. name
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(60, 130, 150, 25);
        name_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name_jlabel);

        name_jlabel_ = new JLabel();
        name_jlabel_.setBounds(220, 130, 150, 25);
        add(name_jlabel_);

//        3. nationality
        JLabel nationality_jlabel = new JLabel("Nationality");
        nationality_jlabel.setBounds(60, 180, 150, 25);
        nationality_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationality_jlabel);

        nationality_jlabel_ = new JLabel();
        nationality_jlabel_.setBounds(220, 180, 150, 25);
        add(nationality_jlabel_);

//        4. Address
        JLabel address_jlabel = new JLabel("Address");
        address_jlabel.setBounds(60, 230, 150, 25);
        address_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(address_jlabel);

        address_jlabel_ = new JLabel();
        address_jlabel_.setBounds(220, 230, 150, 25);
        add(address_jlabel_);

//        5. Gender
        JLabel gender_jlabel = new JLabel("Gender");
        gender_jlabel.setBounds(60, 280, 150, 25);
        add(gender_jlabel);

        gender_jlabel_ = new JLabel();
        gender_jlabel_.setBounds(220, 280, 150, 25);
        add(gender_jlabel_);

//        6. Source
        JLabel source_jlabel = new JLabel("Source");
        source_jlabel.setBounds(60, 330, 150, 25);
        source_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(source_jlabel);

        source_choice = new Choice();
        source_choice.setBounds(220, 330, 150, 25);
        add(source_choice);

//        7. Destination
        JLabel destination_jlabel = new JLabel("Destination");
        destination_jlabel.setBounds(60, 380, 150, 25);
        destination_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(destination_jlabel);

        destination_choice= new Choice();
        destination_choice.setBounds(220, 380, 150, 25);
        add(destination_choice);
//        FETCHING THE DATA FROM THE "DB"
//        and Adding it to the
//        'SOURCE' and 'DESTINATION'
        addSourceDestination(destination_choice, source_choice);

//        Do flight from source and destination exists
        flightExists_jbutton = new JButton("Fetch Flights");
        flightExists_jbutton.setBounds(380, 380, 120, 25);
        flightExists_jbutton.setBackground(Color.BLACK);
        flightExists_jbutton.setForeground(Color.WHITE);
        flightExists_jbutton.addActionListener(this); // EVENT LISTENER
        add(flightExists_jbutton);

//        7. Flight name
        JLabel flightName_jlabel = new JLabel("Flight Name");
        flightName_jlabel.setBounds(60, 430, 150, 25);
        flightName_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(flightName_jlabel);

        flightName_jlabel_ = new JLabel();
        flightName_jlabel_.setBounds(220, 430, 150, 25);
        add(flightName_jlabel_);

//        8. Flight Code
        JLabel flightCode_jlabel = new JLabel("Flight Code");
        flightCode_jlabel.setBounds(60, 480, 150, 25);
        flightCode_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(flightCode_jlabel);

        flightcode_jlabel_ = new JLabel();
        flightcode_jlabel_.setBounds(220, 480, 150, 25);
        add(flightcode_jlabel_);

//        9. Flight Code
        JLabel travelDate_jlabel = new JLabel("Travel Date");
        travelDate_jlabel.setBounds(60, 530, 150, 25);
        travelDate_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(travelDate_jlabel);

        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(220, 530, 150, 25);
        add(jDateChooser);


//        BOOK FLIGHT BUTTON
        book_flight_jbutton = new JButton("BOOK FLIGHT");
        book_flight_jbutton.setBounds(220, 580, 150, 25);
        book_flight_jbutton.setBackground(Color.BLACK);
        book_flight_jbutton.setForeground(Color.WHITE);
        book_flight_jbutton.addActionListener(this); // EVENT LISTENER
        add(book_flight_jbutton);

//        setting the image
        ImageIcon unscaled_imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image scaled_image = unscaled_imageIcon.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon scaled_imageIcon = new ImageIcon(scaled_image);

        JLabel image_jlabel = new JLabel(scaled_imageIcon);
        image_jlabel.setBounds(550,80, 500, 410);
        add(image_jlabel);


//        setting the window
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void addSourceDestination(Choice destination_choice, Choice source_choice){
        source_choice.add("");
        destination_choice.add("");
        try {
//            DB Connection
            DBConnection dbConnection = new DBConnection();
//            SQL Query
            String query = "SELECT * FROM flightdetails";
//            Executing the SQL QUERY
//            FETCHING THE DATA FROM THE "DB"
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
//            Adding the Details to the DropDown
            while (resultSet.next()) {
                source_choice.add(resultSet.getString("source"));
                destination_choice.add(resultSet.getString("destination"));
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchUserDetails_jbutton){
            String aadhaar = aadhaar_jtextField.getText();
            try {
//                DB Connection
                DBConnection dbConnection = new DBConnection();
//                SQL Query
                String query = "SELECT * FROM passengers WHERE aadhaar = '"+aadhaar+"'";
//                Executing the SQL QUERY
//                FETCHING THE DATA FROM THE "DB"
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
                if (resultSet.next()){
//                    Adding the Details to the DropDown
                    name_jlabel_.setText(resultSet.getString("name"));
                    nationality_jlabel_.setText(resultSet.getString("nationality"));
                    address_jlabel_.setText(resultSet.getString("address"));
                    gender_jlabel_.setText(resultSet.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Correct Aadhaar number ("+aadhaar+")");
                }
            } catch (Exception exception){
                exception.printStackTrace();
            }
        } else if(e.getSource() == flightExists_jbutton){
            String source = source_choice.getSelectedItem();
            String destination = destination_choice.getSelectedItem();
            try {
//                DB Connection
                DBConnection dbConnection = new DBConnection();
//                SQL Query
                String query = "SELECT * FROM flightdetails WHERE source = '"+source+"' and destination = '"+destination+"'";
//                Executing the SQL QUERY
//                FETCHING THE DATA FROM THE "DB"
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
                if (resultSet.next()){
//                    Adding the Details to the DropDown
                    flightName_jlabel_.setText(resultSet.getString("flight_name"));
                    flightcode_jlabel_.setText(resultSet.getString("flight_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Available Flights from '"+source+"' to '"+destination);
                }
            } catch (Exception exception){
                exception.printStackTrace();
            }
        } else {
            Random random = new Random();
            String aadhaar = aadhaar_jtextField.getText();
            String name = name_jlabel_.getText();
            String nationality = nationality_jlabel_.getText();
            String address = address_jlabel_.getText();
            String travelDate = ((JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();
            String flight_name = flightName_jlabel_.getText();
            String flight_code = flightcode_jlabel_.getText();
            String source = source_choice.getSelectedItem();
            String destination = destination_choice.getSelectedItem();
            try {
//                DB Connection
                DBConnection dbConnection = new DBConnection();
//                SQL Query
                String query = "INSERT INTO bookticket VALUES('PNR-"+random.nextInt(1000000)+"', 'AW-ID-"+random.nextInt(10000)+"', '"+name+"', '"+nationality+"', '"+aadhaar+"', '"+flight_code+"', '"+flight_name+"', '"+address+"', '"+source+"', '"+destination+"', '"+travelDate+"')";
//                Executing the SQL QUERY and DATA INSERTION
                dbConnection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Flights Booked Successfully from '"+source+"' to '"+destination);
                setVisible(false);
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new BookFlight();
    }
}

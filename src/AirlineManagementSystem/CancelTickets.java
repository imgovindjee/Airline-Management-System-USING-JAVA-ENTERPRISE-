package AirlineManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class CancelTickets extends JFrame implements ActionListener {

    Random random = new Random();

    JButton fetchUserDetails_jbutton, flightExists_jbutton;
    JLabel cancellation_jlabel_, flight_code_jlabel_, travelDate_jlabel_, name_jlabel_;
    JTextField pnr_number_jtextField;


    public  CancelTickets(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel jLabel = new JLabel("Cancel Flight");
        jLabel.setBounds(180, 20, 250, 35);
        jLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(jLabel);

//        setting the image
        ImageIcon unscaled_imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image scaled_image = unscaled_imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon scaled_imageIcon = new ImageIcon(scaled_image);

        JLabel image_jlabel = new JLabel(scaled_imageIcon);
        image_jlabel.setBounds(470,120, 250, 250);
        add(image_jlabel);


//        PNR-NUMBER
        JLabel pnr_number_jlabel = new JLabel("PNR Number");
        pnr_number_jlabel.setBounds(60, 80, 150, 25);
        pnr_number_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr_number_jlabel);

        pnr_number_jtextField = new JTextField();
        pnr_number_jtextField.setBounds(220, 80, 150, 25);
        add(pnr_number_jtextField);

//        Fetch Flight Details based on it's PNR-Number
        fetchUserDetails_jbutton = new JButton("Show Details");
        fetchUserDetails_jbutton.setBounds(380, 80, 150, 25);
        fetchUserDetails_jbutton.setBackground(Color.BLACK);
        fetchUserDetails_jbutton.setForeground(Color.WHITE);
        fetchUserDetails_jbutton.addActionListener(this); // EVENT LISTENER
        add(fetchUserDetails_jbutton);

//        name
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(60, 130, 150, 25);
        name_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name_jlabel);

        name_jlabel_ = new JLabel();
        name_jlabel_.setBounds(220, 130, 150, 25);
        add(name_jlabel_);

//        Cancellation Number
        JLabel cancellation_number_jlabel = new JLabel("Cancellation Number");
        cancellation_number_jlabel.setBounds(60, 180, 150, 25);
        cancellation_number_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cancellation_number_jlabel);

        cancellation_jlabel_ = new JLabel(""+random.nextInt(1000000));
        cancellation_jlabel_.setBounds(220, 180, 150, 25);
        add(cancellation_jlabel_);

//        Flight Code
        JLabel flight_code_jlabel = new JLabel("Flight Code");
        flight_code_jlabel.setBounds(60, 230, 150, 25);
        flight_code_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(flight_code_jlabel);

        flight_code_jlabel_ = new JLabel();
        flight_code_jlabel_.setBounds(220, 230, 150, 25);
        add(flight_code_jlabel_);

//        Date of Travel
        JLabel travelDate_jlabel = new JLabel("Travel Date");
        travelDate_jlabel.setBounds(60, 280, 150, 25);
        travelDate_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(travelDate_jlabel);

        travelDate_jlabel_ = new JLabel();
        travelDate_jlabel_.setBounds(220, 280, 150, 25);
        add(travelDate_jlabel_);


//        Do flight from source and destination exists
        flightExists_jbutton = new JButton("CANCEL");
        flightExists_jbutton.setBounds(220, 330, 120, 25);
        flightExists_jbutton.setBackground(Color.BLACK);
        flightExists_jbutton.setForeground(Color.WHITE);
        flightExists_jbutton.addActionListener(this); // EVENT LISTENER
        add(flightExists_jbutton);

//        setting the window
        setSize(800, 440);
        setLocation(350, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchUserDetails_jbutton) {
            String pnr = pnr_number_jtextField.getText();
            try {
//            DB Connection
                DBConnection dbConnection = new DBConnection();
//            SQL Query
                String query = "SELECT * FROM bookticket WHERE PNR = '"+pnr+"'";
//            Executing the SQL QUERY and DATA INSERTION
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
                if (resultSet.next()) {
                    name_jlabel_.setText(resultSet.getString("name"));
                    flight_code_jlabel_.setText(resultSet.getString("flight_code"));
                    travelDate_jlabel_.setText(resultSet.getString("travelDate"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Booking Found");
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getSource() == flightExists_jbutton){
            String name = name_jlabel_.getText();
            String pnr = pnr_number_jtextField.getText();
            String cancellation_number = cancellation_jlabel_.getText();
            String flight_code = flight_code_jlabel_.getText();
            String travelDate = travelDate_jlabel_.getText();
            try {
//                DB Connection
                DBConnection dbConnection = new DBConnection();

//                1. INSERTING INTO THE CANCELLING-TABLE DATA
//                SQL Query
                String query = "INSERT INTO cancellticket VALUES('"+pnr+"', '"+name+"', '"+cancellation_number+"', '"+flight_code+"', '"+travelDate+"')";
//                Executing the SQL QUERY and DATA INSERTION
                dbConnection.statement.executeUpdate(query);

//                2. DELETING FROM THE Booking DATA
//                SQL Query
                String query_ = "DELETE FROM bookticket WHERE PNR = '"+pnr+"'";
//                Executing the SQL QUERY and DATA INSERTION
                dbConnection.statement.executeUpdate(query_);

                JOptionPane.showMessageDialog(null, name+", Your flight has been Cancelled Successfully");
                setVisible(false);
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        new CancelTickets();
    }
}

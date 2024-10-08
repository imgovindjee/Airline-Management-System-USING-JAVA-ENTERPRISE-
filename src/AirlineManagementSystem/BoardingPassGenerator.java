package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BoardingPassGenerator extends JFrame implements ActionListener {

    JButton fetchUserDetails_jbutton, printBookingPass_jbutton;
    JLabel source_jlabel_, name_jlabel_, nationality_jlabel_, flightName_jlabel_, travelDate_jlabel_, destination_jlabel_, flightcode_jlabel_;
    JTextField pnr_number_jtextField;

    public BoardingPassGenerator(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Heading
        JLabel jLabel = new JLabel("AIR WORLD");
        jLabel.setBounds(380, 10, 450, 35);
        jLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(jLabel);
//        subHeading
        JLabel jLabel1 = new JLabel("Boarding Pass");
        jLabel1.setForeground(Color.BLUE);
        jLabel1.setBounds(360, 50, 450, 35);
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(jLabel1);

//        PNR-NUMBER
        JLabel pnr_number_jlabel = new JLabel("PNR Number");
        pnr_number_jlabel.setBounds(60, 100, 150, 25);
        pnr_number_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr_number_jlabel);

        pnr_number_jtextField = new JTextField();
        pnr_number_jtextField.setBounds(220, 100, 150, 25);
        add(pnr_number_jtextField);

//        Fetch User Details based on it's Aadhaar Number
        fetchUserDetails_jbutton = new JButton("Show Details");
        fetchUserDetails_jbutton.setBounds(380, 100, 150, 25);
        fetchUserDetails_jbutton.setBackground(Color.BLACK);
        fetchUserDetails_jbutton.setForeground(Color.WHITE);
        fetchUserDetails_jbutton.addActionListener(this); // EVENT LISTENER
        add(fetchUserDetails_jbutton);

//        name
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(60, 140, 150, 25);
        name_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name_jlabel);

        name_jlabel_ = new JLabel();
        name_jlabel_.setBounds(220, 140, 150, 25);
        add(name_jlabel_);

//        nationality
        JLabel nationality_jlabel = new JLabel("Nationality");
        nationality_jlabel.setBounds(60, 180, 150, 25);
        nationality_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationality_jlabel);

        nationality_jlabel_ = new JLabel();
        nationality_jlabel_.setBounds(220, 180, 150, 25);
        add(nationality_jlabel_);

//        Source
        JLabel source_jlabel = new JLabel("Source");
        source_jlabel.setBounds(60, 220, 150, 25);
        source_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(source_jlabel);

        source_jlabel_ = new JLabel();
        source_jlabel_.setBounds(220, 220, 150, 25);
        add(source_jlabel_);

//        Destination
        JLabel destination_jlabel = new JLabel("Destination");
        destination_jlabel.setBounds(380, 220, 150, 25);
        destination_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(destination_jlabel);

        destination_jlabel_ = new JLabel();
        destination_jlabel_.setBounds(540, 220, 150, 25);
        add(destination_jlabel_);

//        Flight name
        JLabel flightName_jlabel = new JLabel("Flight Name");
        flightName_jlabel.setBounds(60, 260, 150, 25);
        flightName_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(flightName_jlabel);

        flightName_jlabel_ = new JLabel();
        flightName_jlabel_.setBounds(220, 260, 150, 25);
        add(flightName_jlabel_);

//        Flight Code
        JLabel flightCode_jlabel = new JLabel("Flight Code");
        flightCode_jlabel.setBounds(380, 260, 150, 25);
        flightCode_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(flightCode_jlabel);

        flightcode_jlabel_ = new JLabel();
        flightcode_jlabel_.setBounds(540, 260, 150, 25);
        add(flightcode_jlabel_);

//        Travel Date
        JLabel travelDate_jlabel = new JLabel("Travel Date");
        travelDate_jlabel.setBounds(60, 300, 150, 25);
        travelDate_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(travelDate_jlabel);

        travelDate_jlabel_ = new JLabel();
        travelDate_jlabel_.setBounds(220, 300, 150, 25);
        add(travelDate_jlabel_);



//        Do flight from source and destination exists
        printBookingPass_jbutton = new JButton("PRINT");
        printBookingPass_jbutton.setBounds(220, 350, 150, 25);
        printBookingPass_jbutton.setBackground(Color.BLACK);
        printBookingPass_jbutton.setForeground(Color.WHITE);
        printBookingPass_jbutton.addActionListener(this); // EVENT LISTENER
        add(printBookingPass_jbutton);


//        setting the image
        ImageIcon unscaled_imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
        Image scaled_image = unscaled_imageIcon.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon scaled_imageIcon = new ImageIcon(scaled_image);

        JLabel image_jlabel = new JLabel(scaled_imageIcon);
        image_jlabel.setBounds(600,0, 300, 300);
        add(image_jlabel);


//        setting the window
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fetchUserDetails_jbutton) {
            try {
                String pnr = pnr_number_jtextField.getText();

//            DB Connection
                DBConnection dbConnection = new DBConnection();
//            SQL Query
                String query = "SELECT * FROM bookticket WHERE PNR = '" + pnr + "'";
//            Executing the SQL QUERY and DATA INSERTION
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
                if (resultSet.next()) {
                    name_jlabel_.setText(resultSet.getString("name"));
                    nationality_jlabel_.setText(resultSet.getString("nationality"));
                    source_jlabel_.setText(resultSet.getString("source"));
                    destination_jlabel_.setText(resultSet.getString("destination"));
                    travelDate_jlabel_.setText(resultSet.getString("travelDate"));
                    flightcode_jlabel_.setText(resultSet.getString("flight_code"));
                    flightName_jlabel_.setText(resultSet.getString("flight_name"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Booking Found With " + pnr);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if(e.getSource() == printBookingPass_jbutton) {
            String pnr = pnr_number_jtextField.getText();

            JTable jTable = new JTable();
            try {
//            DB Connection
                DBConnection dbConnection = new DBConnection();
//            SQL Query
                String query = "SELECT * FROM bookticket WHERE PNR = '"+pnr+"'";
//            Data from the DB
                ResultSet resultSet = dbConnection.statement.executeQuery(query);

//            adding the Data into the Table
                jTable.setModel(DbUtils.resultSetToTableModel(resultSet));
//                Print the Ticket[Booking Pass]
                jTable.print();

//                Close the window
                setVisible(false);
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new BoardingPassGenerator();
    }
}

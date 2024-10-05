package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame implements ActionListener {

    JTable jTable;
    JTextField pnrdetails_jtextField;
    JButton showDetails_jbutton;

    public JourneyDetails(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        PNR Details
        JLabel pnrdetails_jlabel = new JLabel("PNR Details");
        pnrdetails_jlabel.setBounds(50, 50, 100, 25);
        pnrdetails_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnrdetails_jlabel);

        pnrdetails_jtextField = new JTextField();
        pnrdetails_jtextField.setBounds(160, 50, 100, 25);
        add(pnrdetails_jtextField);

//        Button to show the details
        showDetails_jbutton = new JButton("SHOW DETAILS");
        showDetails_jbutton.setBounds(290, 50, 160, 25);
        showDetails_jbutton.setForeground(Color.WHITE);
        showDetails_jbutton.setBackground(Color.BLACK);
        showDetails_jbutton.addActionListener(this);
        add(showDetails_jbutton);



//        Table creation
        jTable = new JTable();

//        adding the Scroll to the table
        JScrollPane table_jscrollPane = new JScrollPane(jTable);
        table_jscrollPane.setBounds(10,100,800, 150);
        table_jscrollPane.setBackground(Color.WHITE);
        add(table_jscrollPane);

//        setting the window
        setSize(830, 500);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pnr = pnrdetails_jtextField.getText();
        try {
//            DB Connection
            DBConnection dbConnection = new DBConnection();
//            SQL Query
            String query = "SELECT * FROM bookticket WHERE PNR = '"+pnr+"'";
//            Data from the DB
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
            if(!resultSet.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Booking Found for PNR-"+pnr);
                return;
            }
//            adding the Data into the Table
            jTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new JourneyDetails();
    }
}

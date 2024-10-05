package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class FlightDetailsInfo extends JFrame {

    public FlightDetailsInfo(){
//        changing the window color and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        Table creation
        JTable jTable = new JTable();
        try {
//            DB Connection
            DBConnection dbConnection = new DBConnection();
//            SQL Query
            String query = "SELECT * FROM flightdetails";
//            Data from the DB
            ResultSet resultSet = dbConnection.statement.executeQuery(query);

//            adding the Data into the Table
            jTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception exception){
            exception.printStackTrace();
        }

//        adding the Scroll to the table
        JScrollPane table_jscrollPane = new JScrollPane(jTable);
        table_jscrollPane.setBounds(0,0,800, 500);
        add(table_jscrollPane);


//        setting the window
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new FlightDetailsInfo();
    }
}

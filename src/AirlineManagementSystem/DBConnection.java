package AirlineManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBConnection {

    Connection connection;
    Statement statement;

    public DBConnection(){
        try {
//            REGISTER A SQL DB
            Class.forName("com.mysql.cj.jdbc.Driver");

//            ESTABLISHING  A CONNECTION TO THE DB DRIVER
            connection = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "$Govindjee123_");

//            CREATING A STATEMENT
            statement =  connection.createStatement();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

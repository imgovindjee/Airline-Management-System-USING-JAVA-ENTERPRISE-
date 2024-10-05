package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {

    public Home(){
//        changing the window color and layout
        setLayout(null);

//        setting the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        JLabel image_jlabel = new JLabel(imageIcon);
        image_jlabel.setBounds(0,0, 1600, 800);
        add(image_jlabel);

//        Heading
        JLabel heading_jlabel = new JLabel("AirWorld Welcome's You");
        heading_jlabel.setBounds(500, 40, 1000, 40);
        heading_jlabel.setForeground(Color.BLUE);
        heading_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image_jlabel.add(heading_jlabel);


//        DropDown MenuBar
//        Menu Frame
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

//        1. Home Menu
        JMenu home_jmenu = new JMenu("Home");
        jMenuBar.add(home_jmenu);
//        adding items in the Menu-DropDown
//        i. FLightDetails
        JMenuItem flightDetails_jmenuItem = new JMenuItem("Flight Details");
        flightDetails_jmenuItem.addActionListener(this);
        home_jmenu.add(flightDetails_jmenuItem);
//        ii. CustomerDetails
        JMenuItem customerDetails_jmenuItem = new JMenuItem("Add Customer Details");
        customerDetails_jmenuItem.addActionListener(this);
        home_jmenu.add(customerDetails_jmenuItem);
//        iii. Book Flight Details
        JMenuItem bookflight_jmenuItem = new JMenuItem("Book Flight");
        bookflight_jmenuItem.addActionListener(this);
        home_jmenu.add(bookflight_jmenuItem);
//        iv. Journey Details
        JMenuItem journey_jmenuItem = new JMenuItem("Journey Details");
        journey_jmenuItem.addActionListener(this);
        home_jmenu.add(journey_jmenuItem);
//        v. FLightDetails
        JMenuItem ticketCanceliation_jmenuItem = new JMenuItem("Cancel Ticket");
        ticketCanceliation_jmenuItem.addActionListener(this);
        home_jmenu.add(ticketCanceliation_jmenuItem);

//        2. Ticket Menu
        JMenu ticket_jmenu = new JMenu("Ticket");
        jMenuBar.add(ticket_jmenu);
//        adding items in the Menu-DropDown
//        i. Boarding Pass
        JMenuItem boardingpass_jmenuItem = new JMenuItem("Boarding Pass");
        boardingpass_jmenuItem.addActionListener(this);
        ticket_jmenu.add(boardingpass_jmenuItem);


//        setting the window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Flight Details":
                new FlightDetailsInfo();
                break;
            case "Add Customer Details":
                new AddCustomer();
                break;
            case "Book Flight":
                new BookFlight();
                break;
            case "Journey Details":
                new JourneyDetails();
                break;
            case "Cancel Ticket":
                new CancelTickets();
                break;
            case "Boarding Pass":
                new BoardingPassGenerator();
                break;
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new Home();
    }
}

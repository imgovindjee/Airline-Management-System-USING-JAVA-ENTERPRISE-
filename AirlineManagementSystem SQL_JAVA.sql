CREATE DATABASE AirlineManagementSystem;

USE airlinemanagementsystem;



CREATE TABLE login(username VARCHAR(20), password VARCHAR(20));
INSERT INTO login VALUES('ganesh', '12345');
INSERT INTO login VALUES('admin', 'admin');
SELECT * FROM login;



CREATE TABLE flightdetails(flight_code VARCHAR(20), flight_name VARCHAR(20), source VARCHAR(40), destination VARCHAR(40));
INSERT INTO flightdetails VALUES('1003', 'AW-23AE', 'Delhi', 'UK');
INSERT INTO flightdetails VALUES('1001', 'AW-10QW', 'Mumbai', 'New Zealand');
INSERT INTO flightdetails VALUES('1002', 'AW-33DD', 'Dharbhanga', 'Delhi');
INSERT INTO flightdetails VALUES('1403', 'AW-83LM', 'London', 'Mumbai');
SELECT * FROM flightdetails;




CREATE TABLE passangers(name VARCHAR(23), nationality VARCHAR(20), aadhaar VARCHAR(20), address VARCHAR(50), gender VARCHAR(20), phone VARCHAR(18));
SELECT * FROM passengers;





CREATE TABLE bookticket(PNR VARCHAR(10), ticketID VARCHAR(10), name VARCHAR(20), nationality VARCHAR(20), aadhaar VARCHAR(20), flight_code VARCHAR(10), flight_name VARCHAR(25), address VARCHAR(40), source VARCHAR(20), destination VARCHAR(20), travelDate VARCHAR(30));
SELECT * FROM bookticket;




CREATE TABLE cancellticket(PNR VARCHAR(20), name VARCHAR(20), cancellation_number VARCHAR(10), flight_code VARCHAR(10), travelDate VARCHAR(20));
SELECT * FROM cancellticket;

package JDBC;

import java.sql.*;
import java.util.Scanner;

abstract class Restaurant {
    protected int numberOf2Seaters = 6;
    protected int numberOf4Seaters = 10;
    protected int numberOf6Seaters = 4;

    public abstract int checkTableAvailability(int numberOfGuests);
}

class Reservation extends Restaurant {
    protected String customerName;
    protected String customerEmail;
    protected int numberOfGuests;
    protected String timeSlot;

    public Reservation() {}

    public Reservation(String customerName, String customerEmail, int numberOfGuests, String timeSlot) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.numberOfGuests = numberOfGuests;
        this.timeSlot = timeSlot;
    }

    @Override
    public int checkTableAvailability(int numberOfGuests) {
        System.out.println("Checking Table Availability for " + customerName + ":");
        if (numberOfGuests <= 0) {
            System.out.println("Invalid number of guests!");
            return -1;
        } else if (numberOfGuests <= 2 && numberOf2Seaters > 0) {
            numberOf2Seaters--;
            System.out.println("Table Available! ");
            return 1;
        } else if (numberOfGuests <= 4 && numberOf4Seaters > 0) {
            numberOf4Seaters--;
            System.out.println("Table Available!");
            return 1;
        } else if (numberOfGuests <= 6 && numberOf6Seaters > 0) {
            numberOf6Seaters--;
            System.out.println("Table Available!");
            return 1;
        } else {
            System.out.println("Sorry! Table is not available!");
            return 0;
        }
    }
}

class Queries {
    public static void addReservationToDB(Connection conn, Reservation r) {
        try {
            String sql = "INSERT INTO reservations (customer_name, customer_email, number_of_guests, time_slot) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, r.customerName);
            stmt.setString(2, r.customerEmail);
            stmt.setInt(3, r.numberOfGuests);
            stmt.setString(4, r.timeSlot);
            stmt.executeUpdate();
            System.out.println("Reservation Successful for " + r.customerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayReservation(Connection conn, String c_email ){
        try{
            String sql = "SELECT * FROM reservations WHERE customer_email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c_email);
            ResultSet rs = stmt.executeQuery();
            boolean found = false;
            while (rs.next()){
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("customer_name");
                String email = rs.getString("customer_email");
                int guests = rs.getInt("number_of_guests");
                String timeSlot = rs.getString("time_slot");

                System.out.println("Reservation ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("E-mail Address: " + email);
                System.out.println("Guests: " + guests);
                System.out.println("Time Slot: " + timeSlot);
                System.out.println("------------------------------");
            }
            if (!found) {
            System.out.println("No reservation found for E-mail: " + c_email);
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    

    public static void cancelReservation(Connection conn, String email) {
        try {
            String sql = "DELETE FROM reservations WHERE customer_email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            System.out.println("Reservation cancelled successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class TableReservationDB {
    public static void main(String[] args){
        try (Connection conn = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.password);
            Scanner scanner = new Scanner(System.in)) {

                System.out.println("Connected to database.");
                while (true) {
                    System.out.println("\n---- Restaurant Reservation System ----");
                    System.out.println("1. Reserve a Table");
                    System.out.println("2. View your Reservation");
                    System.out.println("3. Cancel your Reservation");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option (1-4): ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (choice) {
                        case 1:
                            System.out.print("Enter your Name: ");
                            String name = scanner.nextLine();

                            System.out.print("Enter your E-mail Address: ");
                            String email = scanner.nextLine();

                            System.out.print("Enter the Total Number of Guests: ");
                            int guests = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Enter time slot (e.g., 6:00 PM): ");
                            String timeSlot = scanner.nextLine();

                            Reservation res = new Reservation(name, email, guests, timeSlot);
                            int result = res.checkTableAvailability(guests);
                            if(result < 0){
                                System.out.println("Please try again with the right informations!");
                                break;
                            }
                            else if(result > 0){
                                Queries.addReservationToDB(conn, res);
                                break;
                            }
                            else break;
                    
                        case 2:
                            System.out.println("Enter your E-mail Address: ");
                            email = scanner.nextLine();
                            Queries.displayReservation(conn, email);
                            break;

                        case 3:
                            System.out.println("Enter your E-mail Address: ");
                            email = scanner.nextLine();
                            Queries.cancelReservation(conn, email);
                            break;
                    
                        case 4:
                            System.out.println("Exiting... Goodbye!");
                            return;
                    
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

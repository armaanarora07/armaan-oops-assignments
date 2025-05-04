import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class User {
    private String name, email, phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Ride {
    protected User driver;
    protected String start, destination, time;
    protected double cost;
    protected static final int MAX_SEATS = 4;

    public Ride(User driver, String start, String destination, String time, double cost) {
        this.driver = driver;
        this.start = start;
        this.destination = destination;
        this.time = time;
        this.cost = cost;
    }

    public String getRideDetails() {
        return String.format("Driver: %s | From: %s | To: %s | Time: %s | Cost: %.2f",
                driver.getName(), start, destination, time, cost);
    }
}

public class CarPoolingServiceGUI {
    private static User currentUser;

    public static void main(String[] args) {
        DBInitializer.initializeDatabase();
        createLoginPage();
    }

    private static void createLoginPage() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeLoginComponents(panel);

        loginFrame.setVisible(true);
    }

    private static void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(100, 50, 165, 25);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 80, 80, 25);
        panel.add(phoneLabel);

        JTextField phoneField = new JTextField(20);
        phoneField.setBounds(100, 80, 165, 25);
        panel.add(phoneField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 110, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            registerUser(name, email, phone);
            createRideBookingPage();
        });
    }

    private static void createRideBookingPage() {
        JFrame rideFrame = new JFrame("Book a Ride");
        rideFrame.setSize(500, 400);
        rideFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        rideFrame.add(panel);
        placeRideBookingComponents(panel);

        rideFrame.setVisible(true);
    }

    private static void placeRideBookingComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(10, 20, 80, 25);
        panel.add(sourceLabel);

        JTextField sourceField = new JTextField(20);
        sourceField.setBounds(100, 20, 165, 25);
        panel.add(sourceField);

        JLabel destLabel = new JLabel("Destination:");
        destLabel.setBounds(10, 50, 80, 25);
        panel.add(destLabel);

        JTextField destField = new JTextField(20);
        destField.setBounds(100, 50, 165, 25);
        panel.add(destField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 80, 25);
        panel.add(searchButton);

        JTextArea rideArea = new JTextArea();
        rideArea.setBounds(10, 110, 450, 200);
        panel.add(rideArea);

        searchButton.addActionListener(e -> {
            String source = sourceField.getText();
            String destination = destField.getText();
            rideArea.setText("Available Rides:\n");

            for (Ride ride : getAvailableRides(source, destination)) {
                rideArea.append(ride.getRideDetails() + "\n");
            }
        });

        JButton bookButton = new JButton("Book");
        bookButton.setBounds(10, 320, 80, 25);
        panel.add(bookButton);

        bookButton.addActionListener(e -> {
            String source = sourceField.getText();
            String destination = destField.getText();

            List<Ride> rides = getAvailableRides(source, destination);
            if (!rides.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ride booked successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No available rides found.");
            }
        });
    }

    private static void registerUser(String name, String email, String phone) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT OR IGNORE INTO Users (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            currentUser = new User(name, email, phone);
            System.out.println("User registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    private static List<Ride> getAvailableRides(String start, String destination) {
        List<Ride> rides = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM Rides WHERE start_location = ? AND destination = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, start);
            pstmt.setString(2, destination);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User driver = new User(rs.getString("driver_id"), "unknown", "unknown");
                Ride ride = new Ride(driver, rs.getString("start_location"), rs.getString("destination"), rs.getString("time"), rs.getDouble("cost"));
                rides.add(ride);
            }
        } catch (Exception e) {
            System.out.println("Error fetching rides: " + e.getMessage());
        }
        return rides;
    }
}

class DBConnection {
    private static final String URL = "jdbc:sqlite:CarPoolingDB.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

class DBInitializer {
    public static void initializeDatabase() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT UNIQUE, " +
                "phone TEXT);";

        String createRidesTable = "CREATE TABLE IF NOT EXISTS Rides (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "driver_id TEXT, " +
                "start_location TEXT, " +
                "destination TEXT, " +
                "time TEXT, " +
                "cost REAL);";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createRidesTable);
            System.out.println("Database initialized successfully!");
        } catch (Exception e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
}
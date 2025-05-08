package medicalhealth;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper {

    // Database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/period_tracker"; // Update if needed
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    // Logger for this class
    private static final Logger LOGGER = Logger.getLogger(DatabaseHelper.class.getName());

    // Test connection in the main method
    public static void main(String[] args) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection connection = getConnection();
            System.out.println("Database connection successful: " + connection);
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Database connection failed.", ex);
        }
    }

    // Get a database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    // Insert a new record into the database
    public static void insertRecord(LadyCycleRecord record) {
        String sql = "INSERT INTO period_history (startDate, cycleLength, periodLength, symptom, mood, painLevel, endDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Format dates to MySQL format
            SimpleDateFormat mysqlFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateForDB = mysqlFormat.format(record.getStartDate());
            String endDateForDB = mysqlFormat.format(record.getEndDate());

            // Set parameters
            pstmt.setString(1, startDateForDB);
            pstmt.setInt(2, record.getCycleLength());
            pstmt.setInt(3, record.getPeriodLength());
            pstmt.setString(4, record.getSymptom());
            pstmt.setString(5, record.getMood());
            pstmt.setInt(6, record.getPainLevel());
            pstmt.setString(7, endDateForDB);

            pstmt.executeUpdate();
            LOGGER.info("Record inserted successfully.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting record.", e);
        }
    }

    // Fetch all records from the database
    public static List<LadyCycleRecord> fetchAllRecords() {
        List<LadyCycleRecord> records = new ArrayList<>();
        String sql = "SELECT id, startDate, cycleLength, periodLength, symptom, mood, painLevel, endDate FROM period_history";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Parse fields from the result set
                int id = rs.getInt("id");
                Date startDate = rs.getDate("startDate");
                int cycleLength = rs.getInt("cycleLength");
                int periodLength = rs.getInt("periodLength");
                String symptom = rs.getString("symptom");
                String mood = rs.getString("mood");
                int painLevel = rs.getInt("painLevel");

                // Create a record object
                LadyCycleRecord record = new LadyCycleRecord(id, startDate, cycleLength, periodLength, symptom, mood, painLevel);
                records.add(record);
            }
            LOGGER.info("Records fetched successfully.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching records.", e);
        }
        return records;
    }
}

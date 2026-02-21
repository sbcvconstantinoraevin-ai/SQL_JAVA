import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private String dbName;
    private Connection connection;
    public Repository(String dbName) {
        this.dbName = dbName;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            createTable();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_studentDetails (" +
                "studentId INTEGER PRIMARY KEY, " +
                "firstName TEXT NOT NULL, " +
                "lastName TEXT NOT NULL, " +
                "age INTEGER, " +
                "email TEXT NOT NULL, " +
                "course TEXT NOT NULL, " +
                "yearLevel INTEGER, " +
                "gpa REAL, " +
                "section TEXT NOT NULL, " +
                "contactNumber TEXT NOT NULL) ";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO tbl_studentDetails(studentId, firstName, lastName, age, email, " +
                "course, yearLevel, gpa, section, contactNumber) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setInt(4, student.getAge());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getCourse());
            pstmt.setInt(7, student.getYearLevel());
            pstmt.setDouble(8, student.getGpa());
            pstmt.setString(9, student.getSection());
            pstmt.setString(10, student.getContactNumber());
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public Student getStudent(int studentId) {
        String sql = "SELECT * FROM tbl_studentDetails WHERE studentId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student.StudentBuilder()
                        .setStudentId(rs.getInt("studentId"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setAge(rs.getInt("age"))
                        .setEmail(rs.getString("email"))
                        .setCourse(rs.getString("course"))
                        .setYearLevel(rs.getInt("yearLevel"))
                        .setGpa(rs.getDouble("gpa"))
                        .setSection(rs.getString("section"))
                        .setContactNumber(rs.getString("contactNumber"))
                        .Build();
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM tbl_studentDetails";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student.StudentBuilder()
                        .setStudentId(rs.getInt("studentId"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setAge(rs.getInt("age"))
                        .setEmail(rs.getString("email"))
                        .setCourse(rs.getString("course"))
                        .setYearLevel(rs.getInt("yearLevel"))
                        .setGpa(rs.getDouble("gpa"))
                        .setSection(rs.getString("section"))
                        .setContactNumber(rs.getString("contactNumber"))
                        .Build();
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return students;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE tbl_studentDetails SET firstName = ?, lastName = ?, age = ?, " +
                "email = ?, course = ?, yearLevel = ?, gpa = ?, " +
                "section = ?, contactNumber = ? WHERE studentId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getCourse());
            pstmt.setInt(6, student.getYearLevel());
            pstmt.setDouble(7, student.getGpa());
            pstmt.setString(8, student.getSection());
            pstmt.setString(9, student.getContactNumber());
            pstmt.setInt(10, student.getStudentId());
            pstmt.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM tbl_studentDetails WHERE studentId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database: " + e.getMessage());
        }
    }
}

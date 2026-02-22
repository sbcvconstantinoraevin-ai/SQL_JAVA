import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository("studentDetails.db");

        System.out.println("=================================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("   (with Static Nested Class - StudentBuilder)");
        System.out.println("=================================================\n");

        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudentInterface(repository, scanner);
                    break;
                case 2:
                    viewAllStudents(repository);
                    break;
                case 3:
                    searchStudent(repository, scanner);
                    break;
                case 4:
                    updateStudentInterface(repository, scanner);
                    break;
                case 5:
                    deleteStudentInterface(repository, scanner);
                    break;
                case 6:
                    generateMasterList(repository);
                    break;
                case 7:
                    running = false;
                    repository.close();
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("==========MENU==========");
        System.out.println("1. Add Student");
        System.out.println("2. View All Student");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Generate Master List");
        System.out.println("7. Exit");
        System.out.println("========================");
    }

    public static void addStudentInterface(Repository repository, Scanner scanner) {
        System.out.println("\n---Add New Student---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Year Level: ");
        int yearlevel = scanner.nextInt();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Section: ");
        String Section = scanner.nextLine();

        System.out.print("Enter ContactNumber: ");
        String ContactNumber = scanner.nextLine();


        Student newStudent = new Student.StudentBuilder()
                .setStudentId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setCourse(course)
                .setYearLevel(yearlevel)
                .setGpa(gpa)
                .setSection(Section)
                .setContactNumber(ContactNumber)
                .Build();

        repository.addStudent(newStudent);
        System.out.println("Student Successfully Added");
    }

    public static void viewAllStudents(Repository repository) {
        System.out.println("\n--- All Students ---");
        ArrayList<Student> students = repository.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found in the database.");
        } else {
            System.out.println("Total Students: " + students.size());
            System.out.println("--------------------------------------------------");
            for (Student student : students) {
                System.out.println("ID: " + student.getStudentId());
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Course: " + student.getCourse());
                System.out.println("Year Level: " + student.getYearLevel());
                System.out.println("GPA: " + student.getGpa());
                System.out.println("Enrollment Date: " + student.getSection());
                System.out.println("Contact: " + student.getContactNumber());
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public static void searchStudent(Repository repository, Scanner scanner) {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = repository.getStudent(id);

        if (student != null) {
            System.out.println("Student Found!");
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Year Level: " + student.getYearLevel());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("Enrollment Date: " + student.getSection());
            System.out.println("Contact: " + student.getContactNumber());
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void updateStudentInterface(Repository repository, Scanner scanner) {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student existingStudent = repository.getStudent(id);

        if (existingStudent == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.println("Current student information:");
        System.out.println(existingStudent.toString());
        System.out.println("\nEnter new information (press Enter to keep current value):");

        System.out.print("First Name [" + existingStudent.getFirstName() + "]: ");
        String firstName = scanner.nextLine();
        if (firstName.isEmpty()) firstName = existingStudent.getFirstName();

        System.out.print("Last Name [" + existingStudent.getLastName() + "]: ");
        String lastName = scanner.nextLine();
        if (lastName.isEmpty()) lastName = existingStudent.getLastName();

        System.out.print("Age [" + existingStudent.getAge() + "]: ");
        String ageInput = scanner.nextLine();
        int age = ageInput.isEmpty() ? existingStudent.getAge() : Integer.parseInt(ageInput);

        System.out.print("Email [" + existingStudent.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (email.isEmpty()) email = existingStudent.getEmail();

        System.out.print("Course [" + existingStudent.getCourse() + "]: ");
        String course = scanner.nextLine();
        if (course.isEmpty()) course = existingStudent.getCourse();

        System.out.print("Year Level [" + existingStudent.getYearLevel() + "]: ");
        String yearInput = scanner.nextLine();
        int yearLevel = yearInput.isEmpty() ? existingStudent.getYearLevel() : Integer.parseInt(yearInput);

        System.out.print("GPA [" + existingStudent.getGpa() + "]: ");
        String gpaInput = scanner.nextLine();
        double gpa = gpaInput.isEmpty() ? existingStudent.getGpa() : Double.parseDouble(gpaInput);

        System.out.print("Section [" + existingStudent.getSection() + "]: ");
        String section = scanner.nextLine();
        if (section.isEmpty()) section = existingStudent.getSection();

        System.out.print("Contact Number [" + existingStudent.getContactNumber() + "]: ");
        String contactNumber = scanner.nextLine();
        if (contactNumber.isEmpty()) contactNumber = existingStudent.getContactNumber();

        Student updatedStudent = new Student.StudentBuilder()
                .setStudentId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setCourse(course)
                .setYearLevel(yearLevel)
                .setGpa(gpa)
                .setSection(section)
                .setContactNumber(contactNumber)
                .Build();

        repository.updateStudent(updatedStudent);
    }

    public static void deleteStudentInterface(Repository repository, Scanner scanner) {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = repository.getStudent(id);

        if (student != null) {
            System.out.println("Student to delete: " + student.getFirstName() + " " + student.getLastName());
            System.out.print("Are you sure you want to delete this student? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                repository.deleteStudent(id);
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void generateMasterList(Repository repository) {
        System.out.println("\n========== MASTER LIST OF STUDENTS ==========");
        ArrayList<Student> students = repository.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found in the database.");
        } else {
            System.out.printf("%-5s %-15s %-15s %-5s %-25s %-20s %-6s %-6s%n",
                    "ID", "First Name", "Last Name", "Age", "Email", "Course", "Year", "GPA");
            System.out.println("=".repeat(115));

            for (Student student : students) {
                System.out.printf("%-5d %-15s %-15s %-5d %-25s %-20s %-6d %-6.2f%n",
                        student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getEmail(),
                        student.getCourse(),
                        student.getYearLevel(),
                        student.getGpa());
            }
            System.out.println("=".repeat(115));
            System.out.println("Total Students: " + students.size());
        }
    }
}

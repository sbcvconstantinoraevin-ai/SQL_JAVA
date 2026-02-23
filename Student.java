public class Student {
    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String course;
    private final int yearLevel;
    private final double gpa;
    private final String section;
    private final String contactNumber;

    public Student(int studentId, String firstName, String lastName, int age,
                   String email, String course, int yearLevel, double gpa,
                   String section, String contactNumber){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.course = course;
        this.yearLevel = yearLevel;
        this.gpa = gpa;
        this.section = section;
        this.contactNumber = contactNumber;
    }
    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public String getSection() {
        return section;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    /*
    // Setter methods (only for modifiable fields)
    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }*/

    public String toString(){
        return "Student{" +
                ", Student ID = '" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", yearLevel=" + yearLevel +
                ", gpa=" + gpa +
                ", enrollmentDate='" + section + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
    public static class StudentBuilder{
        private int studentId;
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String course;
        private int yearLevel;
        private double gpa;
        private String section;
        private String contactNumber;

        public StudentBuilder(){
            this.studentId = 0;
            this.firstName = "";
            this.lastName = "";
            this.age = 0;
            this.email = "";
            this.course = "";
            this.yearLevel = 1;
            this.gpa = 0.0;
            this.section = "";
            this.contactNumber = "";
        }

        public StudentBuilder setStudentId(int studentId){
            this.studentId = studentId;
            return this;
        }
        public StudentBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName){
            this.lastName=lastName;
            return this;
        }
        public StudentBuilder setAge (int age){
            this.age=age;
            return this;
        }
        public StudentBuilder setEmail(String email){
            this.email=email;
            return this;
        }
        public StudentBuilder setCourse (String course){
            this.course=course;
            return this;
        }
        public StudentBuilder setYearLevel(int yearLevel){
            this.yearLevel=yearLevel;
            return this;
        }
        public StudentBuilder setGpa(double gpa){
            this.gpa=gpa;
            return this;
        }
        public StudentBuilder setSection(String section){
            this.section = section;
            return this;
        }
        public StudentBuilder setContactNumber(String contactNumber){
            this.contactNumber=contactNumber;
            return this;
        }

        public Student Build(){
            return new Student(
                    this.studentId,
                    this.firstName,
                    this.lastName,
                    this.age,
                    this.email,
                    this.course,
                    this.yearLevel,
                    this.gpa,
                    this.section,
                    this.contactNumber
            )
                ;
        }
    }
}

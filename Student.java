public class Student {
    private final int STUDENTID;
    private final String FIRSTNAME;
    private final String LASTNAME;
    private final int AGE;
    private final String EMAIL;
    private final String COURSE;
    private final int YEARLEVEL;
    private final double GPA;
    private final String SECTION;
    private final String CONTACTNUMBER;

    public Student(int STUDENTID, String FIRSTNAME, String LASTNAME, int AGE,
                   String EMAIL, String COURSE, int YEARLEVEL, double GPA,
                   String SECTION, String CONTACTNUMBER){
        this.STUDENTID = STUDENTID;
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.AGE = AGE;
        this.EMAIL = EMAIL;
        this.COURSE = COURSE;
        this.YEARLEVEL = YEARLEVEL;
        this.GPA = GPA;
        this.SECTION = SECTION;
        this.CONTACTNUMBER = CONTACTNUMBER;
    }
    // Getter methods
    public int getSTUDENTID() {
        return STUDENTID;
    }

    public String getFirstName() {
        return FIRSTNAME;
    }

    public String getLastName() {
        return LASTNAME;
    }

    public int getAge() {
        return AGE;
    }

    public String getEmail() {
        return EMAIL;
    }

    public String getCourse() {
        return COURSE;
    }

    public int getYearLevel() {
        return YEARLEVEL;
    }

    public double getGpa() {
        return GPA;
    }

    public String getSection() {
        return SECTION;
    }

    public String getContactNumber() {
        return CONTACTNUMBER;
    }

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
            );
        }
    }
}

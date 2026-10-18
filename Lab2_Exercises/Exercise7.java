class UITStudent {
    private String studentId;
    private String fullName;
    private String major;
    private double gpa;

    UITStudent() {
        this("Unknown", "Unknown", "Undeclared", 0.0);
    }

    UITStudent(String studentId, String fullName) {
        this(studentId, fullName, "Undeclared", 0.0);
    }

    UITStudent(String studentId, String fullName, String major, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        setGpa(gpa); // use setter for validation
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA must be in [0.0, 10.0]. Got: " + gpa);
        }
        this.gpa = gpa;
    }

    public void displayInfo() {
        System.out.println("| Student ID     : " + studentId);
        System.out.println("| Full Name      : " + fullName);
        System.out.println("| Major          : " + major);
        System.out.printf("| GPA            : %.2f%n", gpa);
        System.out.println("| Passed         : " + (isPassed() ? "Yes" : "No"));
        System.out.println("| Classification : " + academicClassification());
    }

    public boolean isPassed() {
        return gpa >= 5.0;
    }

    // Academic classification based on GPA (10-point scale, Vietnamese system)
    // Excellent : 9.0 - 10.0
    // Very Good : 8.0 - 8.9
    // Good : 7.0 - 7.9
    // Above Average: 6.5 - 6.9
    // Average : 5.0 - 6.4
    // Fail : below 5.0
    public String academicClassification() {
        if (gpa >= 9.0)
            return "Excellent";
        if (gpa >= 8.0)
            return "Very Good";
        if (gpa >= 7.0)
            return "Good";
        if (gpa >= 6.5)
            return "Above Average";
        if (gpa >= 5.0)
            return "Average";
        return "Fail";
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        // Student 1: No-argument constructor (all defaults)
        System.out.println(" Student 1: No-argument constructor ");
        UITStudent s1 = new UITStudent();
        s1.displayInfo();

        // Student 2: studentId + fullName constructor
        System.out.println("\n Student 2: studentId + fullName constructor ");
        UITStudent s2 = new UITStudent("24560071", "Nguyen Van A");
        s2.displayInfo();

        // Student 3: Full constructor — Excellent student
        System.out.println("\n Student 3: Full constructor (Excellent) ");
        UITStudent s3 = new UITStudent("24560072", "Tran Thi B", "Computer Science", 9.2);
        s3.displayInfo();

        // Student 4: Full constructor — Average student
        System.out.println("\n Student 4: Full constructor (Average) ");
        UITStudent s4 = new UITStudent("24560073", "Le Van C", "Software Engineering", 5.8);
        s4.displayInfo();

        // Student 5: Full constructor — Failing student
        System.out.println("\n Student 5: Full constructor (Fail) ");
        UITStudent s5 = new UITStudent("24560074", "Pham Thi D", "Information Security", 4.3);
        s5.displayInfo();

        // Student 6: studentId + fullName, then update via setters
        System.out.println("\n Student 6: Two-arg constructor + setters ");
        UITStudent s6 = new UITStudent("24560075", "Hoang Van E");
        s6.setMajor("Data Science");
        s6.setGpa(7.5);
        s6.displayInfo();
    }
}

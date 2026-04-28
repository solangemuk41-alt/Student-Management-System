class Student extends Person {
    private int studentId;
    private Course requestedCourse;
    private double marks;

    public Student(String name, int age, int studentId) {
        super(name, age);

        if (studentId <= 0) {
            throw new RuntimeException("Student ID must be greater than 0!");
        }

        this.studentId = studentId;
        this.marks = 0;
    }

    public int getStudentId() {
        return studentId;
    }

    public Course getRequestedCourse() {
        return requestedCourse;
    }

    public void setRequestedCourse(Course requestedCourse) {
        this.requestedCourse = requestedCourse;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new RuntimeException("Marks must be between 0 and 100!");
        }
        this.marks = marks;
    }

    @Override
    public void display() {
        String course = (requestedCourse != null) ? requestedCourse.getCourseName() : "None";
        String status = (marks >= 50) ? "PASS" : "FAIL";

        System.out.println(studentId + "," + name + "," + age + "," + course + "," + marks + "," + status);
    }
}
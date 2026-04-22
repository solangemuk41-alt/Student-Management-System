import java.util.*;

class Student extends Person {
    private int studentId;
    private List<Course> courses = new ArrayList<>();

    public Student(String name, int age, int studentId) {
        super(name, age);

        // ❌ INVALID ID CHECK (IMPORTANT FOR YOUR TASK)
        if (studentId <= 0) {
            throw new RuntimeException("Student ID cannot be negative or zero!");
        }

        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + studentId +
                ", Name: " + name +
                ", Age: " + age);

        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}
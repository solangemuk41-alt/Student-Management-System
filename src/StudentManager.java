import java.util.*;

class StudentManager {

    private List<Person> people = new ArrayList<>();
    private Set<Course> courses = new HashSet<>();
    private Map<Student, List<Course>> studentCourses = new HashMap<>();

    public void addPerson(Person p) {
        people.add(p);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enroll(Student s, Course c) {
        studentCourses.putIfAbsent(s, new ArrayList<>());
        studentCourses.get(s).add(c);
        s.addCourse(c);
    }

    public void viewPeople() {
        for (Person p : people) {
            p.display();
        }
    }

    public void viewCourses() {
        System.out.println("\n--- Courses ---");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public void viewEnrollments() {
        System.out.println("\n--- Enrollments ---");

        for (Map.Entry<Student, List<Course>> entry : studentCourses.entrySet()) {
            Student s = entry.getKey();

            System.out.println("Student ID: " + s.getStudentId());

            for (Course c : entry.getValue()) {
                System.out.println(" - " + c.getCourseName());
            }
        }
    }
}
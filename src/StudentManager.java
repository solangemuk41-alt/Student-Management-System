import java.io.*;
import java.util.*;

class StudentManager {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // ================= LOAD DATA =================
    public StudentManager() {
        loadStudents();
        loadTeachers();
        loadCourses();
    }

    // ================= FILE PATHS =================
    private final String STUDENT_FILE = "students.txt";
    private final String TEACHER_FILE = "teachers.txt";
    private final String COURSE_FILE = "courses.txt";

    // ================= SAVE ALL =================
    private void saveStudents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENT_FILE))) {
            for (Student s : students) {
                String course = (s.getRequestedCourse() != null)
                        ? s.getRequestedCourse().getCourseName()
                        : "None";

                pw.println(s.getStudentId() + "," + s.name + "," + s.age + "," + course + "," + s.getMarks());
            }
        } catch (Exception e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    private void saveTeachers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TEACHER_FILE))) {
            for (Teacher t : teachers) {
                pw.println(t.name + "," + t.age + "," + t.getSubject());
            }
        } catch (Exception e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }

    private void saveCourses() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(COURSE_FILE))) {
            for (Course c : courses) {
                String teacher = (c.getAssignedTeacher() != null)
                        ? c.getAssignedTeacher().name
                        : "None";

                pw.println(c.getCourseName() + "," + teacher);
            }
        } catch (Exception e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // ================= LOAD =================
    private void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Student s = new Student(d[1], Integer.parseInt(d[2]), Integer.parseInt(d[0]));
                s.setMarks(Double.parseDouble(d[4]));
                students.add(s);
            }
        } catch (Exception e) {
            // file may not exist first time
        }
    }

    private void loadTeachers() {
        try (BufferedReader br = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                teachers.add(new Teacher(d[0], Integer.parseInt(d[1]), d[2]));
            }
        } catch (Exception e) {}
    }

    private void loadCourses() {
        try (BufferedReader br = new BufferedReader(new FileReader(COURSE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Course c = new Course(d[0]);
                courses.add(c);
            }
        } catch (Exception e) {}
    }

    // ================= OPERATIONS =================
    public void addStudent(Student s) {
        students.add(s);
        saveStudents();
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
        saveTeachers();
    }

    public void addCourse(Course c) {
        courses.add(c);
        saveCourses();
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) return s;
        }
        return null;
    }

    public Course findCourse(String name) {
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public void requestCourse(int studentId, String courseName) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseName);

        if (s == null || c == null) {
            System.out.println("Student or Course not found!");
            return;
        }

        s.setRequestedCourse(c);
        saveStudents();
        System.out.println("Course requested successfully!");
    }

    public void assignMarks(int studentId, double marks) {
        Student s = findStudent(studentId);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        s.setMarks(marks);
        saveStudents();
        System.out.println("Marks updated and saved!");
    }

    public void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    public void viewTeachers() {
        for (Teacher t : teachers) {
            t.display();
        }
    }

    public void viewCourses() {
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }
}
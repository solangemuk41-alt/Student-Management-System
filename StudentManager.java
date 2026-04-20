import java.util.ArrayList;

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }
}
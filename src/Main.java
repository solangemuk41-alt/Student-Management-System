public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        Course java = new Course("Java Programming");
        Course db = new Course("Database Systems");

        manager.addCourse(java);
        manager.addCourse(db);

        // ✅ VALID STUDENT
        try {
            Student s1 = new Student("John", 20, 1);
            manager.addPerson(s1);

            manager.enroll(s1, java);
            manager.enroll(s1, db);

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ❌ INVALID STUDENT (NEGATIVE ID)
        try {
            Student s2 = new Student("Alice", 22, -5); // ❌ error
            manager.addPerson(s2);

        } catch (RuntimeException e) {
            System.out.println("INVALID ID ERROR: " + e.getMessage());
        }

        System.out.println("\n--- PEOPLE ---");
        manager.viewPeople();

        manager.viewCourses();
        manager.viewEnrollments();
    }
}
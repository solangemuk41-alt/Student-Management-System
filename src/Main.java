public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        Person s1 = new Student("John", 20, 1);
        Person s2 = new Student("Alice", 22, 2);
        Person t1 = new Teacher("Mr. Smith", 40, "Math");

        manager.addPerson(s1);
        manager.addPerson(s2);
        manager.addPerson(t1);

        manager.viewAll();
    }
}
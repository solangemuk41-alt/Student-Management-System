import java.util.ArrayList;

class StudentManager {
    private ArrayList<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
    }

    public void viewAll() {
        for (Person p : people) {
            p.display();
        }
    }
}
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name cannot be empty!");
        }
        if (age <= 0) {
            throw new RuntimeException("Age must be greater than 0!");
        }
        this.name = name;
        this.age = age;
    }

    public abstract void display();
}
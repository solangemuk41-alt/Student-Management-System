abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Age must be greater than 0!");
        }
        this.name = name;
        this.age = age;
    }

    public abstract void display();
}
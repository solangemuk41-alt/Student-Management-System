class Student extends Person {
    private int studentId;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void display() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Age: " + age);
    }
}
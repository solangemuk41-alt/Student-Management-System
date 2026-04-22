class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);

        if (subject == null || subject.isEmpty()) {
            throw new RuntimeException("Subject cannot be empty!");
        }

        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Teacher Name: " + name +
                ", Age: " + age +
                ", Subject: " + subject);
    }
}
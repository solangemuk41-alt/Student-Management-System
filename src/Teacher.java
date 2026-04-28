class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);

        if (subject == null || subject.isEmpty()) {
            throw new RuntimeException("Subject cannot be empty!");
        }

        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void display() {
        System.out.println(name + "," + age + "," + subject);
    }
}
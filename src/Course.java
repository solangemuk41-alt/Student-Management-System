class Course {
    private String courseName;

    public Course(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new RuntimeException("Course name cannot be empty!");
        }
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}  
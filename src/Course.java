class Course {
    private String courseName;
    private Teacher assignedTeacher;

    public Course(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new RuntimeException("Course name cannot be empty!");
        }
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }
}
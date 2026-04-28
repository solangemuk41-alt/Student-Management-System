import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Request Course");
            System.out.println("5. Assign Marks");
            System.out.println("6. View Students");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String sn = sc.nextLine();
                    System.out.print("Age: ");
                    int sa = sc.nextInt();
                    System.out.print("ID: ");
                    int sid = sc.nextInt();

                    manager.addStudent(new Student(sn, sa, sid));
                    break;

                case 2:
                    System.out.print("Name: ");
                    String tn = sc.nextLine();
                    System.out.print("Age: ");
                    int ta = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Subject: ");
                    String sub = sc.nextLine();

                    manager.addTeacher(new Teacher(tn, ta, sub));
                    break;

                case 3:
                    System.out.print("Course Name: ");
                    String cn = sc.nextLine();

                    manager.addCourse(new Course(cn));
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course Name: ");
                    String rc = sc.nextLine();

                    manager.requestCourse(rid, rc);
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    int mid = sc.nextInt();
                    System.out.print("Marks: ");
                    double m = sc.nextDouble();

                    manager.assignMarks(mid, m);
                    break;

                case 6:
                    manager.viewStudents();
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}
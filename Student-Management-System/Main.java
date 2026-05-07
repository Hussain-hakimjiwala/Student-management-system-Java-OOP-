import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // ADD
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    // Check duplicate ID
                    boolean exists = false;
                    for (Student s : list) {
                        if (s.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("ID already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    list.add(new Student(id, name, age));
                    System.out.println("Student Added!");
                    break;

                case 2: // VIEW
                    if (list.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;
                    for (Student s : list) {
                        if (s.getId() == uid) {
                            System.out.print("Enter new name: ");
                            s.setName(sc.nextLine());

                            System.out.print("Enter new age: ");
                            s.setAge(sc.nextInt());

                            System.out.println("Student Updated!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4: // DELETE
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    boolean removed = list.removeIf(s -> s.getId() == did);

                    if (removed) {
                        System.out.println("Student Deleted!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5: // SEARCH
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();

                    boolean searchFound = false;
                    for (Student s : list) {
                        if (s.getId() == sid) {
                            s.display();
                            searchFound = true;
                            break;
                        }
                    }

                    if (!searchFound) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6: // EXIT
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
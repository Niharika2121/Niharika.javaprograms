import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String name;
    private int marks;
    private double attendance;
    private char grade;
    public Student(String name, int marks, double attendance) {
        this.name = name;
        this.marks = marks;
        this.attendance = attendance;
        this.grade = calculateGrade();
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public double getAttendance() {
        return attendance;
    }
    public char getGrade() {
        return grade;
    }
    private char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public void displayStudentReport() {
        System.out.println("-----------------------------------------");
        System.out.println("Student Name : " + name);
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + grade);
        System.out.println("Attendance   : " + attendance + "%");
        if (attendance < 75) {
            System.out.println("Warning     : Attendance below required minimum!");
        }
        System.out.println("-----------------------------------------");
    }
}
public class SchoolManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        System.out.println("************ Welcome to School Management System ************");
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 6);
        sc.close();
    }
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student Details");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        int marks = inputMarks();
        double attendance = inputAttendance();
        Student student = new Student(name, marks, attendance);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    private static int inputMarks() {
        int marks;
        while (true) {
            System.out.print("Enter marks (0-100): ");
            marks = sc.nextInt();
            if (marks >= 0 && marks <= 100) {
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
            }
        }
        return marks;
    }
    private static double inputAttendance() {
        double attendance;
        while (true) {
            System.out.print("Enter attendance percentage (0-100): ");
            attendance = sc.nextDouble();
            if (attendance >= 0 && attendance <= 100) {
                sc.nextLine(); 
                break;
            } else {
                System.out.println("Invalid attendance! Please enter between 0 and 100.");
            }
        }
        return attendance;
    }
    private static void viewAllStudents() {
        System.out.println("\n--- Student Reports ---");

        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            student.displayStudentReport();
        }
    }
    private static void searchStudent() {
        System.out.print("\nEnter the student name to search: ");
        String searchName = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                student.displayStudentReport();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found with name containing: " + searchName);
        }
    }
    private static void deleteStudent() {
        System.out.print("\nEnter the student name to delete: ");
        String nameToDelete = sc.nextLine();
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(nameToDelete)) {
                students.remove(i);
                removed = true;
                System.out.println("Student \"" + nameToDelete + "\" deleted successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found with name: " + nameToDelete);
        }
    }
    private static void updateStudent() {
        System.out.print("\nEnter the student name to update: ");
        String nameToUpdate = sc.nextLine();
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(nameToUpdate)) {
                studentToUpdate = student;
                break;
            }
        }
        if (studentToUpdate == null) {
            System.out.println("Student not found with name: " + nameToUpdate);
            return;
        }
        System.out.println("Updating details for " + studentToUpdate.getName());
        int newMarks = inputMarks();
        double newAttendance = inputAttendance();
        students.remove(studentToUpdate);
        students.add(new Student(studentToUpdate.getName(), newMarks, newAttendance));
        System.out.println("Student details updated successfully!");
    }
}
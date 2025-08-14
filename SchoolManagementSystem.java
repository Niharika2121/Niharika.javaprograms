import java.util.Scanner;
public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        System.out.print("Enter attendance percentage (0-100): ");
        double attendance = sc.nextDouble();
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("Attendance: " + attendance + "%");
        if (attendance < 75) {
            System.out.println("Warning: Attendance below required minimum!");
        }
        sc.close();
    }
}

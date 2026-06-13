package com.student.main;

import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class StudentMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.print("Enter Id: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student s =
                        new Student(id, name, course);

                dao.addStudent(s);
                break;

            case 2:

                dao.viewStudents();
                break;

            case 3:

                System.out.print("Enter Student Id: ");
                int updateId = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                dao.updateStudent(updateId, newName);
                break;

            case 4:

                System.out.print("Enter Student Id: ");
                int deleteId = sc.nextInt();

                dao.deleteStudent(deleteId);
                break;

            case 5:

                System.out.println("Thank You...");
                break;

            default:

                System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }
}
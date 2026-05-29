package chessclub;

import java.util.Scanner;

// this is abstract parent class that keeps the common profile information
abstract class Profile {
    private String name;
    protected String department;

    Profile(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void showProfile();
}

// here i extended Student from Profile
class Student extends Profile {
    private int age;
    private int year;
    private String club;
    private String role;

    Student(String name, int age, String department, int year, String club, String role) {
        super(name, department);
        this.age = age;
        this.year = year;
        this.club = club;
        this.role = role;
    }

    // constructor overloading: this constructor gives the student a default role
    Student(String name, int age, String department, int year, String club) {
        this(name, age, department, year, club, "Member");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showRole() {
        System.out.println("Role: " + role);
    }

    // method overloading: same method name, but this one accepts a message
    public void showRole(String message) {
        System.out.println(message + role);
    }

    // this method overrides the abstract showProfile method from Profile
    @Override
    public void showProfile() {
        System.out.println("Student: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Current Year: " + year);
        System.out.println("Club: " + club);
        showRole();
    }
}

// here i extended ClubLeader from Student. and here ClubLeader is type of Student, like one of the roles of the Student
class ClubLeader extends Student {
    ClubLeader(String name, int age, String department, int year, String club, String role) {
        super(name, age, department, year, club, role);
    }

    // This method overrides Student showProfile with leader specific output.
    @Override
    public void showProfile() {
        System.out.println("Leader Name: " + getName());
        showRole("Role: ");
    }
}

public class ChessClubRegistrationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // parent class array stores both Student and ClubLeader objects
        Profile[] profiles = new Profile[2];
        int index = 0;

        // the club is fixed because this MVP is only for Chess Club registration
        String club = "Chess Club";

        // try catch is used to handle invalid number input.
        try {
            System.out.println("Chess Club Registration System");
            System.out.println("--------------------------------");

            System.out.print("Enter your name: ");
            String name = input.nextLine();

            System.out.print("Enter your age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter your department: ");
            String department = input.nextLine();

            System.out.print("Enter your current year of study: ");
            int year = input.nextInt();
            input.nextLine();

            // the user input is used to create a registered chess club member, which we will show after the user/student is registered
            profiles[index] = new Student(name, age, department, year, club, "Member");
            index++;

            // here i added a hardcoded leader values, so we can just use it from here
            profiles[index] = new ClubLeader("Sara", 22, "SWE", 3, club, "Leader");
            index++;

            System.out.println();
            System.out.println("Registration Successful!");

            System.out.println();
            System.out.println("=== Registered Member ===");
            // the same showProfile method call works for different object types
            profiles[0].showProfile();

            System.out.println();
            System.out.println("=== Club Leader ===");
            // this calls the ClubLeader version of showProfile, to show the leader's values
            profiles[1].showProfile();

        } catch (Exception e) {
            System.out.println("Invalid input. Age and current year must be numbers.");
        }

        input.close();
    }
}

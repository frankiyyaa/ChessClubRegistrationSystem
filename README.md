# Chess Club Registration System

This is my MVP project for Object Oriented Programming. It is a simple console based Java program that registers student for the Chess Club.

The user enters name, age, department, and current year. The program then prints registration successful and shows the registered member. 

## How to compile and run

Open the terminal inside this project folder.

Compile the program:

```bash
javac chessclub/ChessClubRegistrationSystem.java
```

Run the program:

```bash
java chessclub.ChessClubRegistrationSystem
```

## Short description of the MVP

This MVP works like a small Chess Club registration form. The student gives basic information and the system automatically registers the student under Chess Club. then the system shows the registered member and the club leader.

The main source file is:

```text
chessclub/ChessClubRegistrationSystem.java
```

## Classes and Objects

I used classes to model the real things in the program.

`Profile` is the general parent class at line 6.

`Student` is the class for the registered student at line 27.

`ClubLeader` is the class for the chess club leader at line 76.

`ChessClubRegistrationSystem` is the main class at line 89.

Objects are created in the main method. A `Student` object is created at line 120. A `ClubLeader` object is created at line 124.

## Encapsulation

I used private fields to protect data.

The `name` field is private at line 7.

The `age`, `year`, `club`, and `role` fields are private at lines 28 to 31.

The `department` field is protected at line 8. I made it protected because child classes need to use it.

Getter and setter methods for `name` are at lines 15 to 20.

Getter and setter methods for `age` are at lines 46 to 51.

## Inheritance

I used inheritance with `extends`.

Line 27 shows `Student extends Profile`. This means a Student is a Profile.

Line 76 shows `ClubLeader extends Student`. This means a ClubLeader is a Student.

Line 34 uses `super(name, department)` to call the parent constructor.

Line 78 uses `super(...)` to call the Student constructor from the ClubLeader class.

## Polymorphism

I used both method overriding and method overloading.

The abstract method `showProfile()` is declared in the parent class at line 23.

`Student` overrides `showProfile()` at lines 64 to 65.

`ClubLeader` overrides `showProfile()` at lines 82 to 83.

Method overloading is shown with `showRole()` at line 54 and `showRole(String message)` at line 59.

I also used superclass references. The parent class array is created at line 94:

```java
Profile[] profiles = new Profile[2];
```

A `Student` object is stored inside that parent array at line 120.

A `ClubLeader` object is stored inside the same parent array at line 124.

The program calls `showProfile()` through the array at lines 133 and 138. Java runs the correct version depending on the real object.

## Other parts used in the program

The package is written at line 1.

Scanner is imported at line 3 and created at line 91.

The `try` block starts at line 101.

The `catch` block starts at line 140 and handles invalid number input.

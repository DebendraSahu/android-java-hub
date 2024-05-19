# Basic Syntax, Java Program Structure, and Java Naming Conventions

## Basic Syntax

Java's syntax is heavily influenced by C++ and is known for being relatively simple and clean. Here are the fundamental elements of Java syntax:

1. **Comments**: 
   - Single-line comments start with `//`.
   - Multi-line comments are enclosed within `/* */`.
   - Documentation comments are enclosed within `/** */` and are used to create API documentation.

   ```java
   // This is a single-line comment
   /*
    * This is a multi-line comment
    */
   /**
    * This is a documentation comment
    */
   ```

2. **Classes and Methods**:
   - A Java program is a collection of classes.
   - Each class contains methods and fields.
   - Every Java program must have a `main` method, which is the entry point.

   ```java
   public class Main {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```

## Java Program Structure

A typical Java program consists of the following structure:

1. **Package Declaration**:
   - The package is a namespace for organizing classes.

   ```java
   package com.example.myapp;
   ```

2. **Import Statements**:
   - Used to import other classes and interfaces.

   ```java
   import java.util.Scanner;
   ```

3. **Class Definition**:
   - A Java program must contain at least one class definition.

   ```java
   public class Main {
       // Fields
       int number;
       
       // Methods
       public void displayNumber() {
           System.out.println(number);
       }
       
       // Main method
       public static void main(String[] args) {
           Main obj = new Main();
           obj.number = 5;
           obj.displayNumber();
       }
   }
   ```

## Java Naming Conventions

Java naming conventions are guidelines to improve the readability of the code and make it consistent:

1. **Classes and Interfaces**:
   - Use CamelCase.
   - Start with an uppercase letter.
   - Example: `MyClass`, `EmployeeDetails`.

2. **Methods**:
   - Use camelCase.
   - Start with a lowercase letter.
   - Example: `calculateTotal`, `getName`.

3. **Variables**:
   - Use camelCase.
   - Start with a lowercase letter.
   - Example: `totalAmount`, `employeeName`.

4. **Constants**:
   - Use uppercase letters.
   - Words are separated by underscores.
   - Example: `MAX_VALUE`, `PI`.

5. **Packages**:
   - Use lowercase letters.
   - Typically, use the reverse domain name.
   - Example: `com.example.myapp`.

6. **Examples**:
   
   ```java
   // Class name
   public class Student {
       // Variable name
       private String studentName;
       
       // Method name
       public void setStudentName(String name) {
           this.studentName = name;
       }
       
       // Constant name
       public static final int MAX_AGE = 100;
   }
   ```


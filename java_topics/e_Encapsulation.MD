# Encapsulation in Java

## Introduction

Encapsulation is one of the four fundamental concepts of object-oriented programming (OOP). It refers to the bundling of data (fields) and methods (functions) that operate on that data into a single unit, known as a class. Encapsulation restricts direct access to some of the object's components, which can help prevent the accidental modification of data.

## Key Concepts

1. **Private Fields**: Fields of a class are declared as private to hide them from other classes.
2. **Public Methods**: Methods are provided to access and update the value of the private fields. These methods are called getters and setters.
3. **Access Control**: Using access modifiers to restrict access to the fields and methods of a class.

## Benefits of Encapsulation

- **Control of Data**: Restricts unauthorized access and modification of data.
- **Improved Maintenance**: Changes to the implementation can be made without affecting other parts of the program.
- **Increased Flexibility**: The internal representation of an object can be changed without affecting its external behavior.
- **Enhanced Security**: Sensitive data is hidden from unauthorized access.

## Syntax

Encapsulation is achieved by:
1. Declaring the fields of a class as private.
2. Providing public getter and setter methods to access and update the values of the private fields.

### Example

```java
public class Person {
    // Private fields
    private String name;
    private int age;

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter for age
    public int getAge() {
        return age;
    }

    // Public setter for age
    public void setAge(int age) {
        if (age > 0) { // Simple validation
            this.age = age;
        } else {
            System.out.println("Please enter a valid age.");
        }
    }
}
```

### Main Class to Demonstrate Encapsulation

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Person class
        Person person = new Person();

        // Setting values using setter methods
        person.setName("John Doe");
        person.setAge(30);

        // Getting values using getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
```

### Example Explanation

1. **Private Fields**: The fields `name` and `age` are declared as private to restrict direct access from outside the `Person` class.
2. **Public Getters and Setters**: Public methods `getName`, `setName`, `getAge`, and `setAge` are provided to access and modify the private fields. These methods allow controlled access to the fields with validation logic in the setter methods.
3. **Main Class**: In the `Main` class, an object of the `Person` class is created. The setter methods are used to set values for the private fields, and the getter methods are used to retrieve and display those values.

## Access Modifiers

Java provides four access modifiers to set access levels for classes, fields, methods, and constructors:

1. **private**: The member is accessible only within its own class.
2. **default** (no modifier): The member is accessible only within its own package.
3. **protected**: The member is accessible within its own package and by subclasses.
4. **public**: The member is accessible from any other class.

### Example of Access Modifiers

```java
public class Example {
    private int privateVar;   // Accessible only within this class
    int defaultVar;           // Accessible within this package
    protected int protectedVar; // Accessible within this package and subclasses
    public int publicVar;     // Accessible from any other class
}
```

# Summary

Encapsulation is a crucial concept in object-oriented programming that helps in hiding the internal state of an object and allows controlled access through public methods. By using encapsulation, developers can ensure that the object's internal state is protected from unauthorized access and modification, leading to more robust and maintainable code.
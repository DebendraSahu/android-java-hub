# Inheritance in Java

## Introduction

Inheritance is a fundamental concept of object-oriented programming (OOP) that allows one class to inherit the properties and methods of another class. The class that inherits is called the **subclass** (or child class), and the class being inherited from is called the **superclass** (or parent class). Inheritance promotes code reuse and establishes a natural hierarchy between classes.

## Key Concepts

1. **Superclass (Parent Class)**: The class whose properties and methods are inherited by another class.
2. **Subclass (Child Class)**: The class that inherits the properties and methods of another class.

## Types of Inheritance in Java

Java supports the following types of inheritance:
1. **Single Inheritance**: A subclass inherits from one superclass.
2. **Multilevel Inheritance**: A class inherits from a subclass, making the subclass a superclass for another class.
3. **Hierarchical Inheritance**: Multiple subclasses inherit from a single superclass.

Java does not support multiple inheritance (a class inheriting from multiple classes) directly to avoid complexity and ambiguity.

## Syntax

To inherit from a class, use the `extends` keyword.

```java
class Superclass {
    // Fields
    int age;

    // Method
    void displayAge() {
        System.out.println("Age: " + age);
    }
}

class Subclass extends Superclass {
    // Additional fields and methods
    String name;

    void displayName() {
        System.out.println("Name: " + name);
    }
}
```

## Example

### Superclass

```java
public class Animal {
    String type = "Animal";

    void eat() {
        System.out.println("This animal eats food.");
    }
}
```

### Subclass

```java
public class Dog extends Animal {
    String breed = "Labrador";

    void bark() {
        System.out.println("The dog barks.");
    }
}
```

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the subclass
        Dog myDog = new Dog();
        
        // Accessing fields and methods from both the subclass and superclass
        System.out.println("Type: " + myDog.type); // Inherited from Animal
        myDog.eat(); // Inherited from Animal
        System.out.println("Breed: " + myDog.breed); // Defined in Dog
        myDog.bark(); // Defined in Dog
    }
}
```

### Example Explanation

1. **Animal Class (Superclass)**:
   - `type` field and `eat` method are defined in the `Animal` class.

2. **Dog Class (Subclass)**:
   - `Dog` inherits the `type` field and `eat` method from `Animal`.
   - `breed` field and `bark` method are defined in the `Dog` class.

3. **Main Class**:
   - Creates an instance of the `Dog` class.
   - Accesses inherited fields and methods from the `Animal` class.
   - Accesses fields and methods defined in the `Dog` class.

## Method Overriding

Inheritance allows subclasses to provide a specific implementation of a method already defined in its superclass. This is called **method overriding**. The method in the subclass must have the same name, return type, and parameters as in the superclass.

### Example of Method Overriding

```java
public class Animal {
    void sound() {
        System.out.println("The animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("The dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.sound(); // Calls the overridden method in Dog class
    }
}
```

### Example Explanation

- The `Dog` class overrides the `sound` method of the `Animal` class.
- When `sound` is called on a `Dog` object, the overridden method in the `Dog` class is executed.

## Advantages of Inheritance

1. **Code Reusability**: Reuse methods and fields of the existing class.
2. **Method Overriding**: Implement different behavior for existing methods.
3. **Polymorphism**: Achieve runtime polymorphism using inheritance.

# Summery

Inheritance is a powerful feature in Java that enhances code reusability and establishes a hierarchical relationship between classes. It allows subclasses to inherit and override methods and properties from superclasses, promoting flexible and maintainable code.
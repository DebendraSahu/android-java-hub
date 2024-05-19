# Polymorphism in Java

## Introduction

Polymorphism is one of the four core concepts of object-oriented programming (OOP). It allows objects of different classes to be treated as objects of a common superclass. Polymorphism enables a single interface to represent different underlying forms (data types). The two types of polymorphism in Java are **compile-time polymorphism** and **runtime polymorphism**.

## Types of Polymorphism

1. **Compile-Time Polymorphism (Static Binding)**: Achieved through method overloading.
2. **Runtime Polymorphism (Dynamic Binding)**: Achieved through method overriding.

## Method Overloading

Method overloading is a form of compile-time polymorphism where multiple methods have the same name but different parameters (different type or number of parameters). The correct method to call is determined at compile time.

### Example of Method Overloading

```java
public class MathOperations {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        // Calling overloaded methods
        System.out.println("Sum of 2 integers: " + math.add(10, 20));
        System.out.println("Sum of 3 integers: " + math.add(10, 20, 30));
        System.out.println("Sum of 2 doubles: " + math.add(10.5, 20.5));
    }
}
```

### Explanation

- The `MathOperations` class has three `add` methods with different parameter lists.
- The correct `add` method is called based on the number and type of arguments passed.

## Method Overriding

Method overriding is a form of runtime polymorphism where a subclass provides a specific implementation for a method that is already defined in its superclass. The method in the subclass must have the same name, return type, and parameters as the method in the superclass. The method to be called is determined at runtime.

### Example of Method Overriding

```java
public class Animal {
    // Method to be overridden
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    // Overriding the sound method
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Cat extends Animal {
    // Overriding the sound method
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;

        // Creating an object of Dog
        myAnimal = new Dog();
        myAnimal.sound(); // Calls the overridden method in Dog

        // Creating an object of Cat
        myAnimal = new Cat();
        myAnimal.sound(); // Calls the overridden method in Cat
    }
}
```

### Explanation

- The `Animal` class has a `sound` method.
- The `Dog` and `Cat` classes override the `sound` method.
- The `sound` method called is determined at runtime based on the object type.

## Polymorphic Behavior

Polymorphism allows a single method to be used with different types of objects, resulting in different behaviors. This is useful for designing flexible and reusable code.

### Example of Polymorphic Behavior

```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Animal()};

        for (Animal animal : animals) {
            animal.makeSound(); // Calls the overridden method in each subclass
        }
    }
}
```

### Explanation

- An array of `Animal` type is created with objects of `Dog`, `Cat`, and `Animal`.
- The `makeSound` method is called on each object in the array, demonstrating polymorphic behavior.

## Summary

Polymorphism in Java allows methods to perform different tasks based on the object that it is acting upon. It is achieved through method overloading (compile-time polymorphism) and method overriding (runtime polymorphism). Polymorphism enhances the flexibility and maintainability of the code by allowing the same method to behave differently for different object types.

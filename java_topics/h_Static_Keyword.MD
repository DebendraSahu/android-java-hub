# The `static` Keyword in Java

## Introduction

The `static` keyword in Java is used for memory management primarily. It can be applied to variables, methods, blocks, and nested classes. When a member is declared `static`, it belongs to the class rather than instances of the class. This means the static member is shared among all instances of the class.

## Static Variables

A static variable is shared among all instances of a class. It is initialized only once when the class is loaded.

### Syntax

```java
class MyClass {
    static int staticVariable;
}
```

### Example

```java
public class Counter {
    // Static variable
    static int count = 0;

    // Constructor to increment the count
    public Counter() {
        count++;
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        // Creating objects
        Counter obj1 = new Counter();
        Counter obj2 = new Counter();
        Counter obj3 = new Counter();
    }
}
```

### Explanation

- The `count` variable is static, so it is shared among all instances of the `Counter` class.
- Each time a `Counter` object is created, the `count` variable is incremented.

## Static Methods

A static method belongs to the class rather than an instance of the class. It can be called without creating an instance of the class. Static methods can access static variables and other static methods directly.

### Syntax

```java
class MyClass {
    static void staticMethod() {
        // method body
    }
}
```

### Example

```java
public class MathUtils {
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Calling static method without creating an object
        int sum = MathUtils.add(5, 10);
        System.out.println("Sum: " + sum);
    }
}
```

### Explanation

- The `add` method is static, so it can be called without creating an instance of `MathUtils`.
- The method calculates the sum of two integers and returns the result.

## Static Blocks

A static block is used to initialize static variables. It runs once when the class is loaded into memory.

### Syntax

```java
class MyClass {
    static {
        // static block
    }
}
```

### Example

```java
public class InitializationExample {
    static int staticVar;

    // Static block
    static {
        staticVar = 10;
        System.out.println("Static block executed. staticVar: " + staticVar);
    }

    public static void main(String[] args) {
        System.out.println("Main method executed. staticVar: " + staticVar);
    }
}
```

### Explanation

- The static block initializes the `staticVar` variable.
- The static block runs once when the class is loaded, before the main method is executed.

## Static Nested Classes

A static nested class is a static class defined within another class. It can be accessed without creating an instance of the outer class.

### Syntax

```java
class OuterClass {
    static class NestedStaticClass {
        // nested static class body
    }
}
```

### Example

```java
public class Outer {
    // Static nested class
    static class NestedStaticClass {
        void display() {
            System.out.println("Inside static nested class");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the static nested class
        Outer.NestedStaticClass nestedObject = new Outer.NestedStaticClass();
        nestedObject.display();
    }
}
```

### Explanation

- The `NestedStaticClass` is a static nested class inside the `Outer` class.
- It is instantiated without creating an instance of the outer class (`Outer`).

## Summary

The `static` keyword in Java provides a way to create members that belong to the class rather than any instance of the class. It can be used with variables, methods, blocks, and nested classes. Understanding the use of `static` helps in efficient memory management and designing utility classes and methods.

### Key Points

- **Static Variables**: Shared among all instances of a class.
- **Static Methods**: Can be called without creating an instance of the class.
- **Static Blocks**: Used for initializing static variables.
- **Static Nested Classes**: Can be accessed without creating an instance of the outer class.

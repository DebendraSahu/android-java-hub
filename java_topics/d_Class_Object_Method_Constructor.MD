# Classes, Objects, Methods, and Constructors in Java

## Classes

A class in Java is a blueprint for creating objects. It defines a datatype by bundling data (fields) and methods (functions) that operate on the data into a single unit. Classes are fundamental to object-oriented programming.

### Defining a Class

A class is defined using the `class` keyword followed by the class name and a pair of curly braces.

```java
public class Person {
    // Fields (variables)
    String name;
    int age;

    // Methods
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

## Objects

An object is an instance of a class. When a class is defined, no memory is allocated until an object of that class is created. Objects are created using the `new` keyword.

### Creating an Object

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Person class
        Person person1 = new Person();
        
        // Accessing fields and methods of the object
        person1.name = "John Doe";
        person1.age = 30;
        person1.displayInfo();
    }
}
```

### Example Explanation

- `Person person1 = new Person();`: This statement creates an object `person1` of the class `Person`.
- `person1.name = "John Doe";`: Sets the `name` field of the `person1` object.
- `person1.age = 30;`: Sets the `age` field of the `person1` object.
- `person1.displayInfo();`: Calls the `displayInfo` method to display the object's information.

## Methods

Methods are functions defined inside a class that describe the behaviors of the objects created from the class. Methods can take parameters, perform actions, and return values.

### Defining a Method

A method is defined with a return type, a method name, a pair of parentheses (which may include parameters), and a body enclosed in curly braces.

```java
public class Calculator {
    // Method to add two numbers
    int add(int a, int b) {
        return a + b;
    }
    
    // Method to subtract two numbers
    int subtract(int a, int b) {
        return a - b;
    }
}
```

### Calling Methods

Methods are called using the dot operator.

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Calculator class
        Calculator calc = new Calculator();
        
        // Calling methods
        int sum = calc.add(10, 5);
        int difference = calc.subtract(10, 5);
        
        // Displaying results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}
```

## Constructors

A constructor is a special method that is called when an object is instantiated. Constructors are used to initialize the object's state. The constructor name must match the class name, and it does not have a return type.

### Defining a Constructor

```java
public class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

### Creating an Object with a Constructor

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Person class with constructor
        Person person1 = new Person("John Doe", 30);
        
        // Displaying object information
        person1.displayInfo();
    }
}
```

### Example Explanation

- `public Person(String name, int age)`: This is the constructor of the `Person` class.
- `Person person1 = new Person("John Doe", 30);`: This statement creates an object `person1` and initializes it with the specified name and age using the constructor.

## Key Points

- **Class**: A blueprint for creating objects.
- **Object**: An instance of a class.
- **Method**: A function defined inside a class to describe behaviors of the objects.
- **Constructor**: A special method called when an object is instantiated to initialize the object's state.

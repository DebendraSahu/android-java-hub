# Java Data Types, Variables, Operator and Control Flow Statements

## Data Types

Java is a statically typed language, which means that every variable must be declared with a data type. Java has two categories of data types:

### Primitive Data Types

Primitive data types are predefined by the language and named by a keyword. There are 8 primitive data types in Java:

1. **byte**: 
   - 8-bit integer.
   - Range: -128 to 127.

   ```java
   byte b = 100;
   ```

2. **short**: 
   - 16-bit integer.
   - Range: -32,768 to 32,767.

   ```java
   short s = 10000;
   ```

3. **int**: 
   - 32-bit integer.
   - Range: -2^31 to 2^31 - 1.

   ```java
   int i = 100000;
   ```

4. **long**: 
   - 64-bit integer.
   - Range: -2^63 to 2^63 - 1.

   ```java
   long l = 100000L;
   ```

5. **float**: 
   - 32-bit floating-point.
   - Use for precise values like currency.

   ```java
   float f = 10.5f;
   ```

6. **double**: 
   - 64-bit floating-point.

   ```java
   double d = 10.5;
   ```

7. **char**: 
   - 16-bit Unicode character.

   ```java
   char c = 'A';
   ```

8. **boolean**: 
   - Represents one bit of information.
   - Only two possible values: `true` and `false`.

   ```java
   boolean isJavaFun = true;
   ```

### Reference Data Types

Reference types are objects and arrays. They are declared using the `class` or `interface` name.

```java
String str = "Hello, World!";
int[] numbers = {1, 2, 3, 4, 5};
```

## Variables

Variables are containers for storing data values. Each variable in Java must be declared with a data type. There are three types of variables in Java:

1. **Local Variables**: Declared inside a method, constructor, or block.
   
   ```java
   public void myMethod() {
       int localVar = 10; // Local variable
   }
   ```

2. **Instance Variables**: Declared in a class but outside any method, constructor, or block.
   
   ```java
   public class MyClass {
       int instanceVar = 20; // Instance variable
   }
   ```

3. **Static Variables**: Declared with the `static` keyword in a class but outside any method, constructor, or block.
   
   ```java
   public class MyClass {
       static int staticVar = 30; // Static variable
   }
   ```

## Operators

Operators are special symbols that perform operations on variables and values. Java operators include:

1. **Arithmetic Operators**:
   - `+` (Addition)
   - `-` (Subtraction)
   - `*` (Multiplication)
   - `/` (Division)
   - `%` (Modulus)

   ```java
   int a = 10;
   int b = 5;
   System.out.println(a + b); // 15
   System.out.println(a - b); // 5
   System.out.println(a * b); // 50
   System.out.println(a / b); // 2
   System.out.println(a % b); // 0
   ```

2. **Relational Operators**:
   - `==` (Equal to)
   - `!=` (Not equal to)
   - `>` (Greater than)
   - `<` (Less than)
   - `>=` (Greater than or equal to)
   - `<=` (Less than or equal to)

   ```java
   int a = 10;
   int b = 5;
   System.out.println(a == b); // false
   System.out.println(a != b); // true
   System.out.println(a > b);  // true
   System.out.println(a < b);  // false
   System.out.println(a >= b); // true
   System.out.println(a <= b); // false
   ```

3. **Logical Operators**:
   - `&&` (Logical AND)
   - `||` (Logical OR)
   - `!` (Logical NOT)

   ```java
   boolean x = true;
   boolean y = false;
   System.out.println(x && y); // false
   System.out.println(x || y); // true
   System.out.println(!x);     // false
   ```

4. **Assignment Operators**:
   - `=` (Assignment)
   - `+=` (Add and assign)
   - `-=` (Subtract and assign)
   - `*=` (Multiply and assign)
   - `/=` (Divide and assign)
   - `%=` (Modulus and assign)

   ```java
   int a = 10;
   a += 5; // a = a + 5
   System.out.println(a); // 15
   a -= 3; // a = a - 3
   System.out.println(a); // 12
   a *= 2; // a = a * 2
   System.out.println(a); // 24
   a /= 4; // a = a / 4
   System.out.println(a); // 6
   a %= 2; // a = a % 2
   System.out.println(a); // 0
   ```

5. **Increment and Decrement Operators**:
   - `++` (Increment)
   - `--` (Decrement)

   ```java
   int a = 10;
   a++; // a = a + 1
   System.out.println(a); // 11
   a--; // a = a - 1
   System.out.println(a); // 10
   ```

## Control Flow Statements

Control flow statements allow you to dictate the flow of your program. Java provides several control flow statements:

### If-Else Statements

Used to execute code based on a condition.

```java
int number = 10;

if (number > 0) {
    System.out.println("Positive number");
} else if (number < 0) {
    System.out.println("Negative number");
} else {
    System.out.println("Zero");
}
```

### Switch Statement

Allows the variable to be tested for equality against a list of values.

```java
int day = 2;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Other day");
        break;
}
```

### Loops

Loops are used to execute a block of code repeatedly.

1. **For Loop**:
   
   ```java
   for (int i = 0; i < 5; i++) {
       System.out.println(i);
   }
   ```

2. **While Loop**:
   
   ```java
   int i = 0;
   while (i < 5) {
       System.out.println(i);
       i++;
   }
   ```

3. **Do-While Loop**:
   
   ```java
   int i = 0;
   do {
       System.out.println(i);
       i++;
   } while (i < 5);
   ```

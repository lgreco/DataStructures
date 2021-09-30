# Lab session of 28 October 2020

In this lab we'll build a rudimentary *relational* database. Quite simply, relational database systems **relate** the keys of various key-value pairs to each other. For example, consider the following tables:
  
| studentID | studentName     |            
| :---      | :---            | 
| LUC001    | Hercule Poirot  |   
| LUC002    | Arthur Hastings |
| LUC003    | Felicity Lemon  |
| LUC004    | Ariadne Oliver  |

And:

| courseCode | courseName          |   
| :-----     | :---                |   
| COMP271    | Data Structures     |
| COMP170    | Intro to OOP        |
| COMP163    | Discrete Structures |
| COMP363    | Algorithms          |

We can create a course registration system by matching student IDs and course codes as needed. For example:

| studentID | courseCode |  
| ---       | ---        | 
| LUC001    | COMP271    | 
| LUC003    | COMP271    |
| LUC004    | COMP271    |
| LUC001    | COMP363    |
| LUC003    | COMP363    |
| LUC002    | COMP170    |
| LUC002    | COMP163    |
| LUC004    | COMP163    |

By combining just the keys of the key-value tables for students and courses, we avoid repeating names and titles. Information such as names and titles are entered once and then represented by their unique keys. This ensures data integrity and that's why relational databases are still going strong, fifty years after their discovery.

Key-value pairs can be created easily as Java classes. Using Strings, as in the example above, we can write students and courses as:

```java
public class Student {
  private String studentID;
  private String studentName;
  ...}
...
public class Course {
  private String courseCode;
  private String courseName
...}
```

Classes `Student` and `Course` have identical structures and in general this is the structure of a key-value pair:

```java
public class SomeObject<K,V>{
    private K key;
    private V value;
}
```
where `K` and `V` are two object references of our choice -- in the example here, both are `String`. 

Java allows us to write classes whose object types can be parameterized -- these parameters are called *generics*. Later in the course we'll see that `Student` and `Course` implement the same generic interface. For now, let's focus on the `Student` and `Course` classes as defined explicitly.

## Lab assignment


### Flesh out `Student` and `Course` classes
Complete these two classes with the necessary constructors, accessors (`get`), and mutators (`set`). These classes should be written as **linkable** objects, so don't forget the `Student next` and `Course next` fields.

### Implement the `Comparable` interface for both classes
Consider two `Student` (or `Course`) objects, `o1` and `o2`. How would you compare them to tell if they are equal? (For example, how can you tell if two course registrations, both for the same student "John Smith", refer to the same individual?) How would you sort students when you generate a nicely formatted output if their names are identical? 

If `o1` and `o2` where `Strings`, you could write

```java
o1.equals(o2)
```

or 

```java
o1.compareTo(o2)
```

because `String` implements the `Comparable` interface already. But the classes `Student` and `Course` do not, and you have to implement it explicitly, **i.e., write a `compareTo()` method in each of these classes.**

Technically speaking, you do not have to implement the Comparable interface. You can create your own method, still call it `compareTo`, and direct how two student or course objects are to be compared. For that matter, you can can write a method like this:
```java
boolean areTheyTheSame(Student s1, Student s2) {
  boolean objectsAreTheSame = false;
  // ... magical stuff ...
  return objectsAreTheSame;
}
```
By implementing the Comparable interface, i.e., by writing a `compareTo` method that returns an `int` value of -1, 0, or 1, you are making your student and course objects consistent with one of the most popular interfaces in Java, and therefore reusable by code that relies on that interface.

### Write the "database" class
Write a 
```java
public class Database {...}
```
with the following functionality:
* Create a new student record -- if student name exists, the creation method must indicate so and reject the process (a boolean type method may be a good idea). Student records shall be kept in a `Student[10]` array, using a hash function of your own design.

* Force a new student record -- if you have reason to create a student record even though the person's name already exists (for example, you are registering multiple student with a very common name like *Irakliotis*).

* Create a new course record. Course records shall be kept in a `Course[10]` array, using a hash function of your own design.

* Register a student for a course, using a method called `courseRegistration`. The registration transaction should lead to a **unique** ordered pair of the form `(studentID, courseCode)` for every registration. (Hint: you may want to put together a simple data structure for these registrations, as an inner class in your `Database` class).

* Display a *per-student* report, like so (using the data from the tables above, but keep in mind there may be more students and more courses in the mix):
 ```text
Arthur Hastings (LUC002): COMP170 Intro to OOP
                           COMP163 Discrete Structures

Felicity Lemon (LUC003):  COMP271 Data Structures
                           COMP363 Algorithms

Ariadne Oliver (LUC004):  COMP271 Data Structures
                           COMP163 Discrete Structures

Hercule Poirot (LUC001):  COMP271 Data Structures
                           COMP363 Algorithms
```
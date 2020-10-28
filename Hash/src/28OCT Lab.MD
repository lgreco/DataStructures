# Lab session of 28 October 2020

In this lab we'll build a rudimentary *relational* database. Quite simply, relational database systems (or RDBS) **relate** the keys of various key-value pairs. For example, consider the following tables:


  
  
| studentID | studentName     |            
| :---      | :---            | 
| LUC001    | Hercule Poirot  |   
| LUC002    | Arthur Hastings |
| LUC003    | Felicity Lemon  |
| LUC004    | Ariadne Oliver  |

| CourseCode | Title               |   
| :-----     | :---                |   
| COMP271    | Data Structures     |
| COMP170    | Intro to OOP        |
| COMP163    | Discrete Structures |
| COMP363    | Algorithms          |

We can now create a course registration system by matching student IDs and course codes as needed. For example:

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
 

```java

```

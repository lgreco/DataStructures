# COMP 271 Fall 2021 Midterm Assessment


## Rules of the road

* This is a take-home exam. It is due Friday 10/22/21 at 11:55 PM. Submit through Sakai only.

* Each problem is worth up to 2 points: 0 if no viable solution is observed; 1 if an incomplete/partial but possibly viable solution is shown; 2 if a complete solution is present.

* The exam has 4 problems, listed from the most challenging to the least so.

* Show and narrate/explain/justify all derivations and assumptions. (Narrating/explaining/justifying is not the same as describing. Describing alone is not enough).

* Before submitting, check and double-check: does your work answer the question? If your answer includes computer code, test it. Ensure that it works as expected.

* You are welcome to send a draft of your work to Leo for a quick review and feedback. Email (subject must include *COMP 271*) or Teams-chat, only. Review requests within 6-7 hours of the deadline may not be considered.

* Student Hours have been extended. Please don't wait for an appointment if you have a pressing question. Use Email or Teams messaging to expedite things.

* Your final work can be in the form of java files or text files as needed. 

 * Upload java and text files to Sakai. 

* You are responsible for an on-time submission. Verify that Sakai has accepted your submission. Solutions will be published right after the deadline. No late work will be accepted after solutions are posted.

* Neatness matters, a lot. At this stage of your studies, **your work must reflect your knowledge and your professionalism.** Code must look need and clean, easy to read, and well documented with comments. Code that doesn't compile will not be graded.

## Inheritance (Cleaning up someone else's mess)

You are assigned to work on a project and you discover the following five classes in it. Do you keep them all? Do you change them a bit? Why and how?

```java
public class Country {
    private String name;
    private String capital;
    private String typeOfGovernment;
    private String currency;
    private int population;
    // Misc methods and constructors ...
}

public class State {
    private String name;
    private String capital;
    private int population;
    private String stateBird;
    // Misc methods and constructors ...
}

public class County {
    private String name;
    private String Seat;
    private int population;
    // Misc methods and constructors ...
}

public class Town {
    private String name;
    private int population;
    private int yearEstablish;
    private String typeOfRule;
    // Misc methods and constructors ...
}
public class Province {
    private String name;
    private String capital;
    private int population;
    // Misc methods and constructors ...
}
```



## Learn something new

Java offers a [special data type called **enum**](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) that allows a variable to be assigned to predetermined constant values. This is a great tool, if you want to restrict choices and avoid typos that may result from typing information. In practical terms ``enum`` (short for enumerations) are the equivalent of a pull down menu on an app. 

Consider the following simple example where enumeration ``Major`` contains all the degree programs offered by the (not so) highly selective *Leo University*.

```java
public enum Major {
    Computer Science, Aviation, Physics, Diving 
}
```

We can use this enumeration as a data type to define a class field like so:

```java
public class Student {
    private String firstName,
    private String lastName,
    private Major fieldOfStudy;
    // etc
}
```

By making variable ``fieldOfStudy`` above a ``Major`` we restrict it to the values listed in ``enum Major``. And so, if a setter method tries to change the ``fieldOfStudy`` for a ``Student`` object to, say, ``Mathematics`` (which is not included in ``enum Major`` ), the program will not accept the change. Enumerations are one of the way that Java can protect data integrity.

Looking at the code for the previous problem (on Inheritance), do you see any class fields that could be converted to an enumerated type? What would you call those ``enum`` types and what will be their content?

## Implement an interface

Using the [Node and Treeee classes](https://github.com/lgreco/DataStructures/tree/master/Assignments/TreesAndNodes), implement the ``Comparable`` interface on ``Node``. The implementation should allow node comparisons based on parity of the number of characters in each ``Node``'s string, as follows:



| Node A | Node B | comparison |
|--------|--------|------------|
|   odd  | odd    |      0     |
|   odd  | even   |     -1     |
|   even | odd    |     +1     |
|   even | even   |      0     |

## Write a ``toString()``

Write a ``String toString()`` method in ``Node`` to return the following output:

```text
This node contains "<content>" and has no children.
```

or
```text
This node contains "<content>" and has 1 child.
```

or
```text
This node contains "<content>" and has 2 children.
```

Where ``"<content>"`` above is the value of the node's field ``content``.


## Deliverables
For this exam, upload the following files to Sakai.

| Problem | Material to submit |
|---------|--------------|
| Inheritance | Revised ``Country``, ``State``, ``County`` etc classes plus any additional class(es) you write. **OK to put everything in a single file.** |
| ``enum``    | text file with your answer. |
| ``Comparable`` | Your revised ``Node.java`` file |
| ``toString()`` | The revised file above, with one more revision! |

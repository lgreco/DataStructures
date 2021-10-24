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

## Solutions

### Inheritance


Create a superclass ``Location`` to be extended by every other class.

```java

public class Location{
    private String name;
    private int population;
}
public class Country extends Location {
    private String capital;
    private String typeOfGovernment;
    private String currency;
    // Misc methods and constructors ...
}

public class State extends Location {
    private String capital;
    private String stateBird;
    // Misc methods and constructors ...
}

public class County extends Location {
    private String Seat;
    // Misc methods and constructors ...
}

public class Town extends Location {
    private int yearEstablish;
    private String typeOfRule;
    // Misc methods and constructors ...
}
public class Province extends Location  {
    private String capital;
    // Misc methods and constructors ...
}
```

### Enumerations

There are several candidate fields to be converted to ``enum`` types: ``typeOfRule``, ``Country.name``, and maybe ``Country.currency``.

### ``compareTo`` and ``toString``

```java
public class Node implements Comparable<Node>{

    String content;
    Node left;
    Node right;

    /**
     * Basic constructor.
     *
     * @param content String to place in node.
     */
    public Node(String content) {
        this.content = content;
        this.left = null;
        this.right = null;
    } // constructor Node


    /**
     * Implementation of Comparable.
     * @param node Node to compare this node with.
     * @return -1 for even/odd, 0 for same parity, 1 for odd/even
     */
    public int compareTo(Node node) {
        return this.content.length()%2 - node.content.length()%2;
    } // method compareTo


    /**
     * Creates a string representation of Node.
     * @return String with Node information.
     */
    public String toString() {
        String output = "This node is empty";
        if (this.content != null) {
           output = String.format("This node contains \"%s\" and has ", this.content);
           if (this.left != null && this.right != null) {
               output += "2 children.";
           } else if (this.left==null && this.right==null) {
               output += "0 children";
           } else {
               output += "1 child.";
           }
        }
        return output;
    } // method toString

} // class Node
```

## Grading notes

### Inheritance

Most of you recognized the need to create some superclass that will be extended by other classes in the problem. 
The most common mistake was have some form of hierarchical extension, e.g.

```java
State extends Country
County extends State
Town extends County
```

``Town`` ends up inheriting all ``County`` fields, including those ``County`` inherits from ``State`` which include those ``State`` inherits from ``Country``. As a result, a ``Town`` objects has four names, four populations, one currency, and two capitals! 

When dealing with classes that have similar fields, we should try to move these fields into a superclass. Then have the classes extend that superclass. For this problem, the common fields were ``name`` and ``population``.

Upon closer inspection, we may even discover that ``Country``, ``State``, ``Province``, ``County``, and ``Town``, fall into two different superclasses: a ``LargeGeographicEntity`` that can be extended by ``Country``, ``State``, and ``Province``; and a ``SmallGeographicEntity`` that can be extended by ``County`` and ``Town``. 

### Enumerations

The most popular field to convert to an ``enum`` was ``typeOfRule``.

There were some good arguments in favor of enumerating ``Country.name``, ``Country.currency``, and ``Country.capital``. These are also good choices. The UN lists 193 member countries and 2 additional observer entities, so the total count for an enumeration would be 195. That's quite reasonable. There are several [open source enumerations for countries](https://github.com/TakahikoKawasaki/nv-i18n/blob/master/src/main/java/com/neovisionaries/i18n/CountryCode.java) available, some on GitHub.

### Implement ``compareTo``

The most common mistake I observed here was multiple return statements. The second most common was the omission of the ``implements`` declaration at the class header, or an incomplete declaration instead of ``implements Comparable<Node>``.



### Implement ``toString``

The most common mistake I observed here was multiple return statements. 

The second most common mistake was to forget to check for ``content==null``, that would prevent a null pointer exception.

The third mistake that I noticed, was repetitive code like so:

```java
String result  = "";
if (this.left == null && this.right == null)
   result = String.format("This node contains \"%s\" and has 0 children.");
else if (this.left != null && this.right != null)
   result = String.format("This node contains \"%s\" and has 2 children.");
else
   result = String.format("This node contains \"%s\" and has 1 child.");
```

All three ``result`` assignments above have a common part. It's always a good idea to factor common parts out:

```java
String result  = String.format("This node contains \"%s\" and has ");
```

and then augment things as needed:
```java
if (this.left ==  null && this.right == null)
   result += "0 children.";
else if (this.left != null && this.right != null)
   result += "2 children.";
else
   result += "has 1 child.";
```
   

I noticed a few implementations that included ``println`` statements. Method ``toString`` is not supposed to print. It creates a string representation of the object. In general, it is **good practice** to avoid any printing from methods that have a return type.
# The CTA

The Chicago Transit Authority is the major mass transit operator for Chicago. Nearly half a billion passengers rely on CTA's trains and buses every year to get around. For all its complexity, the network of buses and trains can be conceptualized as sequences of locations forming routes. These locations are either bus stops or train stations. Some locations serve as both.

The preliminary analysis we did in class showed that both types of locations share some characteristics. For example, they both have a name, an address, and inevitably a hash tag for social media. They also have different fields. For example, a train station may have an elevator; a bus not. Thus we introduced the concept of a [*superclass*, a class that has only the common characteristics of stops and stations. These characteristics are [*inherited*](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) by other classes that *extend* the superclass. These classes then add their own fields to reflect their individual characteristics. 

Here's the class diagram:

![](../TheCTA.png)

These three classes are in the same directory (folder) as this `readme.md` file and they were generated with the **Diagrams** feature of IntelliJ's full version (which is available at no cost to students everywhere).

## Lab planning

In this lab session we'll explore the interplay between a superclass and the classes that extend it (Ch. 9 in BJP).

We'll start with the use of he [super()](https://docs.oracle.com/javase/tutorial/java/IandI/super.html) keyword.

Then we'll move to the obfuscation that Java causes when we privatize -- as we should -- the fields in each class. Thankfully, IDEs like IntelliJ come to the rescue. Try Alt-Ins on your Windows keyboard or Command-N on your Mac for some magical code writing.

### Constructors

Constructors are similar to methods but not quite. The most notable difference is that constructors may be called once per object and their sole purpose is to create one. Methods can be called many times on an object after it has been created.

A constructor creates an object with the fields and the methods specified in a class. The values of the fields may be assigned by the constructor. For example, if we have a simple class like

```java
class Person {
    String firstName;
    String lastName;
    String homeAddress;
}
```

may have a constructor to initiate an object with a name, leaving the addition of a home address for later:

```java
class Person {
    String firstName;
    String lastName;
    String homeAddress;
    ... other fields as needed ...
    
    /** Basic constructor for name only */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /** Mutator for home address */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
```

Using this approach, we can create a new person object with the information we have available, because it's more likely we know the names of a person before we know their address:

```java
Person p1 = new Person("Leo", "Irakliotis");
```
Once we obtain an address, we can modify the object with the set method:

```java
p1.setHomeAddress("123 Main St.");
```

Another characteristic of constructors is that they have the same method as the class whose objects are initiating. 

A class that extends another class inherits its constructor(s). For example, `CTAStop` and `CTAStation` both extend `CTALocation`. They inherit its constructor `CTALocation(String name)` that they can call using the keyword `super()`. So, when class `CTAStation` is told how to create a station with a given name, it can pass the name to its superclass, as follows:

```java
class CTAStation extends CTALocation {
    ...
    public CTAStation(String name) {
        super(name);
    }
}
```

The `super()` keyword calls the constructor of the superclass, i.e., the class identified by the `extends` keyword. That constructor creates a `CTALocation` object whose field `name` aquires the value of `String name`, and returns thst object to the `CTAStation` constructor for further handling.

### Accessors and mutators

First, let's write a few *accessors* and *mutators* methods. Informally, we call them getters and setters because we use the verbs "get" and "set" to name the methods. IDE automation can help us automate the writing of these methods. One technique is to write one getter and one setter for each class field. That's a lot, but it is done automatically. Just tuck these methods away (near the bottom of the class) and let them be.

#### Mutators 
Going back to the example with `class Person`, and assuming it has more than three fieds, we can instantiate an object as

```java
Person p1 = new Person("Leo", "Irakliotis");
```

and then assign its remaining fields as follows

```java
p1.setHomeAddress("123 Main St."); 
p1.setEmail("...");
p1.setBirthday(...);
p1.setPhoneNumber(...)
...
```

That's a lot of writing and there may be ways to reduce it. For example, if we know that by the time we have a home address we may also have an email address and a phone number for a person, we can write an mutator for all three fields:

```java
void setAddressEmailPhone(String homeAddress, 
        String email, 
        String phoneNumber) {
    this.homeAddress = homeAddress;
    this.email = email;
    tis.phoneNumber = phoneNumber;
}
```

Now, we can instantiate a new object person like before,

```java
Person p1 = new Person("Leo", "Irakliotis");
```

and then provide additional information about home address, email, and phone number, using one method instead of three:

```java
p1.setAddressEmailPhone("123 Main St.", 
        "leo@cs.luc.edu", 
        "5555551212");
```

For now, it's ok to be a little verbose and use one set method for each field.

#### Accessors

These are methods that get a value for us. Because the fields of an object are private, we cannot simply make a call to `p1.name` to get the name of the person represented in object `p1`. We need a method to fetch it for us, e.g., `p1.getName()`. The method itself can be as simple as
```java
public String getName() {
    return this.name;
}
```
or something more complex:
```java
public String getName() {
    String result = this.name;
    if (this.name.equals("Voldemort") || this.name.equals("Tom Riddle"))
        result = "He who shall not be named";
    return result;
}
```

We write one accessor for every class field that we need to access from outside the class. These methods can be produced automatically by most IDEs.

## Lab work 23 SEP 2021

* Review an [*actual* data set](https://data.cityofchicago.org/Transportation/CTA-System-Information-List-of-L-Stops/8pix-ypme) about CTA train stations. Make sure you understand what each field in the data set represents. If unsure, be ready to ask for clarifications.
* Propose how to modify class `CTAStation` so that it reflects the actual data set above accurately.
* If your group's proposal is approved, then:
  * add the necessary fields in `CTAStation`;
  * modify the constructor in `CTAStation` to include more fields that you feel confident you can assign at the creation of the object.
* Assume that you have access to a [comma separated values (CSV)](https://en.wikipedia.org/wiki/Comma-separated_values) file with the data from the actual data set. Discuss and propose a strategy to create `CTAStation` objects based on the information from that file. You need only one object per station. Your strategy shall be based on the data structures that we have covered in class so far: arrays, enchanted arrays (ok, ArrayLists), and Trees. You may use one of these data structures (_hint:_ not trees)


## Lab work 30 SEP 2021

* Modify class `CTALocation` as follows:
  * add fields to include latitude and longitude information, justifying your choice for their data type;
  * provide a constructor to include these new fields in addition to the location's name. (Do not replace the basic constructor);
  * include accessors (getters) for every field in the class.
* Use the `main` method in class `CTAImplementation` to obtain a data structure of your choice with all the train stations in the CTA network captured as `CTAStation` objects. 
  * You'll need to employ the methods of class `CTAUtilities`. The data file with the train station information is [available online](https://github.com/lgreco/DataStructures/blob/master/data/stations.csv). Method `CTAUtilities.pullCTAData` can access the CSV file when invoked as\
  `... = pullCTAData("https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv");`
  * Before using class `CTAUtilities`, you must finish its `pullCTAData` method. Specifically you need to decide, and justify what data structure you'll use.
  * To make things interesting, you cannot add or modify constructors in CTAStation.
  * And, in that vein, you cannot have station duplicates in `CTAImplementation`. Each station must appear only once in the data structure that method `CTAUtilities.pullCTAData` returns.
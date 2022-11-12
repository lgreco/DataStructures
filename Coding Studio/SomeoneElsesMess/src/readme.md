# Coding Studio for November 11, 2022

## Someone else's mess

You were just hired as the new developer for a construction company. The previous programmer, Enol Kusm left the company to join the circus. On your first day on the job, you find that Enol was not so good of a programmer as you have heard. Looking at the code left behind by Enol, you realize it's a mess. Suddenly, it all comes back to you: didn't you hear something about classes extending a class, and classes implementing interfaces, to make things more manageable? Can you apply your knowledge of inheritance using a superclass and an interface, to clean up after Enol Kusm's mess?

## Wait, there is more!

After cleaning up the mess left by your predecessor, your boss decided to make a few changes in the code. They changed the superclass ``Building`` slightly, to implement [interface ``Comparable``](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-). They changed the class signature to 

```java
public class Building implements Comparable<Building> 
```

and they left for vacation. Of course it falls on you to finish the work they started. You know that to satisfy the interface, you must add a ``compareTo`` method to ``Bulding``, as described in the interface:

```java
public int compareTo(Bulding building) {
  int valueToReturn;
  // Some awesome code to determine the value to return
  return valueToReturn;
}
```

Your boss did not leave you any instruction how to implement the ``compareTo`` method, i.e., what fields to use. It is now up to you to either use an **existing** field or introduce a **new** field in ``Building`` to use in ``compareTo``.

Make your choice (new field? existing field?) and finish the ``compareTo`` method.  Justify your choice (new or existing field) in the method's Javadoc.

## Hello from Aruba!

As you finish writing ``Building.compareTo``, your boss sends you a message from their vacationing spot. 

*Aruba is lovely this time of the year! And, hey, if you implement ``Comparable``, make sure that ``ResidentialCarGarage`` has a separate ``compareTo`` method that uses the number of cars as the basis for comparison.*

You oblige.


# Asynchronous assignment for 04 NOV 2020

Consider the class `Airplane` provided here. The class has 10 fields. Some of them are of `enum` type. These are *enumerations*, i.e., a collection of fixed values for a variable. For example, we can create an enumeration for the seasons of the year:

```java
public enum Season {
  WINTER, SPRING, SUMMER, AUTUMN
}
```

Enumerated content can be access with the dot operator, e.g.,
```java
Season myFavoriteTimeOfTheYear = Season.AUTUMN
```
Enumerations can also be used in switch/case blocks:
```java
public class EnumDemo {

    Season season;
    
    public EnumDemo(Season season) {
        this.season = season;
    }   
    
    public void seasonFeelings() {
        switch (season) {
            case WINTER:
                 System.out.println("Winter is lovely.");
                 break;
            case SPRING:
                 System.out.println("Spring is nice");
                 break;
            case SUMMER:
                 System.out.println("Summer is meh");
                 break;
            case AUTUMN:
                System.out.println("Autumn is the best season");
                break;
        }
    }

    public static void main(String[] args) {
        EnumDemo season1 = new EnumDemo(Season.SUMMER);
        season1.seasonFeelings();
    }
}
```
The program above will print out `Summer is meh`.

You may [read more about `enum` on the Java documentation site](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html).

## Back to the Airplane class now.

Notice that the class has a single constructor, and a fully loaded at that. For brevity, I have omitted the various `get` methods, except one. You can auto-generate the remaining in your IDE (from IntelliJ's menu: Code .. Generate). Instantiating Aircraft objects using such a long constructor can be tricky: you have to remember, which argument goes were. When you don't need a field, you must provide a `null` or a `0` (as would be the case with a glider, an airplane with no engine and, therefore, no fuel requirements).

Of course, you can write a partial constructor for such airplanes, and then you may decide to write partial constructors for any combination of fields. That would be **a lot** of constructors to write. You may end up with two or more constructors with identical signatures, which is not allowed.

## Let's work around this.

### Interface

Write an interface, called **Builder**, with `set` methods for *every* field in class `Airplane`. For example:
```java
public interface Builder {
    void setTailNumber(String tailNumber);
    ...
}
```
Your interface should have as many `set` methods as the fields of `Airplane`. That is 10.

### Implement the interface
Write a class, called **AirplaneBuilder**, that implements interface `Builder`. For example:
```java
public class AirplaneBuilder implements Builder {
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }
    ...
}
```
This class should have all the fields of `Aiplane`. It should also have as many methods as those of the interface it implements, *plus one more!* Add a method to fetch a **new** Airplane, in the `AirplaneBuilder` class by invoking the sole and full constructor, like so:

```java
    public Airplane fetch() {
        return new Airplane(tailNumber, manufacturer, wings, gear, 
                            tailWheel, engines, powerPlant, powerPerEngine, 
                            fuel, passengers);
    }   
```

### Put it together
Let's write a driver class, and call it **Hangar**. Its sole purpose is to configure airplanes by calling `AirplaneBuilder` methods. I am showing an example below, building a Cessna 172 (C172) without populating every field in the class.

```java
public class Hangar { 
    public void C172(Builder builder) {
        builder.setTailNumber("N969RR");
        builder.setWings(Wings.HIGH);
        builder.setFuel(Fuel.AVGAS);
        builder.setEngines(1);
    }
    public static void main(String[] args){
        Hangar ourHangar = new Hangar();
        AirplaneBuilder builder = new AirplaneBuilder();
        ourHangar.C172(builder);
        Airplane mySkyhawk = builder.fetch();
        String m = mySkyhawk.getManufacturer();
        System.out.println("Can you explain this value for the airplane's manufacturer? "+m);
    }
}
```

### What have you done?
Describe what you think you have done, **without** using the word "pattern"!
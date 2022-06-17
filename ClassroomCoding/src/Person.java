import java.util.Scanner;

public class Person {

    // CONSTANTS
    private static final String DEF_FOOD = "tuna sashimi with maple fudge";
    private static final int DEF_REST = 6;

    // STATE
    private String name;
    private String favoriteFood;
    private int restLength;

    // CONSTRUCTORS

    public Person(String name) {
        this.name = name;
        this.restLength = DEF_REST;
        this.favoriteFood = DEF_FOOD;
    }

    public Person(String name, String favoriteFood, int restLength) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.restLength = restLength;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setRestLength(int restLength) {
        this.restLength = restLength;
    }

    public String toString() {
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", restLength=" + restLength +
                '}';
    }

    // BEHAVIOR

    public void eat() {
        System.out.println("I'd like some " + favoriteFood);
    }

    public void rest() {
        System.out.println("I'll close my eyes for " + restLength + " hours.");
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name);
    }

}

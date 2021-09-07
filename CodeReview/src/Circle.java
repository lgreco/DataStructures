/*
Write a class of objects named Circle that remembers information about a circle.
You must include the following public members. It may help you to know that there
is a constant named Math.PI storing the value of π, roughly 3.14159.
 */
public class Circle {

    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2.0 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle{radius=" + radius +"}";
    }
}









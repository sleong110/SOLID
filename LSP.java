// LSP: Liskov Substitution Principle
//
// LSP states that the design must provide the ability to replace any instance of a parent class with an instance of its child classes. Whatever a parent class can do a child class must also be able to do it.


// CODE THAT VIOLATES LSP PRINCIPLE

abstract class Shape {
	protected double area;

	public abstract double calcArea();
}
class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	public double calcArea() {
		area = length * width;
		return (area)
	};
}
class Square extends Rectangle {
	public Square(double s) {
		super(s, s);
	}
}

public class LiskovSubstitution {
	public static void main(String args[]) {
		System.out.println("Hello World");
		Rectangle r = new Rectangle(1,2);
		System.out.println("Area = " + r.calcArea());
		Square s = new Square(2);
		System.out.println("Area = " + s.calcArea());
	}
}

// Note that the functionality to compute area between Square and Rectangle has subtle different. Square only need 1 parameter while Rectangle need 2 parameters of length and width. Hence, we can say that a square is not a substitue for a rectangle and should not be a child class. Thus they should be separate classes.

// CODE THAT OBEYS LSP
abstract class Shape {
	protected double area;

	public abstract double calcArea();
}

class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}

	public double calcArea() {
		area = length * width;
		return (area);
	};
}

class Square extends Shape {
	private double side;

	public Square(double s){
		side = s;
	}
	public double calcArea() {
		area = side * side;
		return(area);
	};
}

public class LiskovSubstitution {
	public static void main(String args[]) {
		System.out.println("Hello World");
		Rectangle r = new Rectangle(1,2);
		System.out.println("Area = " + r.calcArea());
		Square s = new Square(2);
		System.out.println("Area = " + s.calcArea());
	}
}


// OCP: Open/Close Principle
//
// OCP states that a class's behavior should be able to extend without any modification

// CODE THAT VIOLATES THE OCP PRINCIPLE

class Rectangle {
	protected double length;
	protected double width;

	public Rectangle(double l, double w) {
		length = l;
		width = w;
	};
}
class CalculateAreas {
	private double area;

	public double calcArea(Rectangle r) {
		area = r.length * r.width;
		return area;
	}
}
public class OpenClosed {
	public static void main(String args[]) {
		System.out.println("Hello World");
		Rectangle r = new Rectangle(1, 2);
		CalculateAreas ca = new CalculateAreas();
		System.out.println("Area = " + ca.calcArea(r));
	}
}

// Note that the code above violates the OCP priciple because if we want to add a Circle to CalculateAreas class, we must change the module itself. To comply with OCP principle, we will add an abstract class called Shape and let all shapes to inherit from the shap class, which has an abstract method called getArea()

// CODE THAT OBEYS OCP PRINCIPLE
abstract class Shape {
	public abstract double getArea()
}

class Rectangle extends Shape {
	protected double length;
	protected double width;

	public Rectangle(double l, double w) {
		length = l;
		width = w;
	};
	public double getArea() {
		return length * width;
	}
}

class Circle extends Shape {
	protected double radius;
	
	public Circle(double r) {
		radius = r;
	};
	public double getArea() {
		return radius * radius * 3.14;
	}
}

class CalculateAreas {
	private double area;

	public double calcArea(Shape s) {
		area = s.getArea();
		return area;
	}
}

public class OpenClosed {
	public static void main(String args[]) {
		System.out.println("Hello World");
		CalculateAreas ca = new CalculateAreas();
		Rectangle r = new Rectangle(1,2);
		System.out.println("Area = " + ca.calcArea(r));
		Circle c = new new Circle(3);
		System.out.println("Area = " + ca.calcArea(c));
	}
}

// Note from the above implementation, the CalculateAreas() method does not have to change when you add a new Shape. This complies to OCP principle whereby you can extend your code via subclasses and the original class does not need to changed.

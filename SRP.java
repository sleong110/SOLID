// SRP: Single Responsibility Principle
// SRP states that a class should have only a single reason to change. Each class and mocule in a program should focus on a single task.
// KEY: If the description of the class includes the word "and", then we need to break the SRP.


// CODE THAT VOILATE SRP PRINCIPLE
abstract class Shape {
	protected string name;
	protected double area;
	public abstract double clacArea();
}

class Circle extedns Shape{
	private double radius;
	
	public Circle(double r) {
		radius = r;
	}
	public double calcArea() {
		area = 3.14 * (radius*radius)
		return(area)
	};
}

class CalculateAreas {
	Shape[] shapes;
	double sumTotal=0;
	public CalculateAreas(Shape[] sh) {
		this.shape = sh;
	}
	public double sumAreas() {
		sumTotal=0;
		for (init i=0; i < shpaes.length; i++) {
			sumTotal = sumTotal + shapes[i].calcArea();
		}
		return sumTotal;
	}
	public void output() {
		System.out.println("Total of all areas = " + sumTotal);
	}
}

// Note that the class CalculateAreas is problematic because it also handles output fo the application. This means that the area calculation behavior and output behavior are coupled. We can write a test function call TestShape to verify this.

public class TestShape {
	public static void main(String args[]) {
		System.out.println("Hello World!");

		Circle circle = new Circle(1);

		Shape[] shapeArray = new Shape[1];
		shapeArray[0] = circle;

		CalculateAreas ca = new CalculateAreas(shapeArray);

		ca.sumAreas();
		ca.output();
	}
}

// Note that now if now we want to change the functionality of the output() we have to change the CalcualteAreas class regardless of whether the method for summing the areas changes.

// CODE THAT OBEYS SRP PRINCIPLE


class CalculateAreas {
	Shape[] shapes;
	double sumTotal=0;
	public CalculateAreas(Shape[] sh) {
		this.shape = sh;
	}
	public double sumAreas() {
		sumTotal=0;
		for (init i=0; i < shpaes.length; i++) {
			sumTotal = sumTotal + shapes[i].calcArea();
		}
		return sumTotal;
	}
}

class OutputArea {
	double area=0;
	public OutputAreas(double a) {
		this.areas = a;
	}
	public void console() {
		System.out.println("Total of all areas = " + areas);
	}

	public void HTML() {
		System.out.println("<HTML");
		System.out.println("Total of all areas = " + areas);
		System.out.println("</HTML");
	}
}

public class TestShape {
	public static void main(String args[]) {
		System.out.println("Hello World!");

		Circle circle = new Circle(1);

		Shape[] shapeArray = new Shape[1];
		shapeArray[0] = circle;

		CalculateAreas ca = new CalculateAreas(shapeArray);
		OutputAreas oAreas = new OutputAreas(sum.sumAreas())
		
		oAreas.console(); // output to console
		oAreas.HTML(); // output to HTML
		
	}
}

// Note that in the TestShape class above we can now output to variaou destination depending on requirements. We can now add output to new destination to OutputAreas class without having to change the CalculateAreas class. Hence we can redistribute the CalculateAreas class independently without having to do anything to other class.

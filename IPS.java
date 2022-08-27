// IPS: Interface Segregation Principle
//
// IPS states that it is better to have many small interfaces than a few larger ones.


// CODE THAT VOILATES IPS

interface IMammal {
	public void eat();
	public void makeNoise();
}

class Dog implements IMammal {
	public void eat() {
		System.out.println("Dog is eating");
	}
	public void makeNoise() {
		System.out.println("Dog is making noise");
	}
}
public class MyClass {
	public static void main(String args[]) {
		System.out.println("Hello World");

		Dog fido = new Dog();
		fido.eat();
		fido.makeNoise();
	}
}

// Note that the code above uses a single interface Mammal. According to IPS we can actually seperate the IMammal into smaller IEat and IMakeNoise interfaces.
//
// CODE THAT OBEYS IPS

interface IEat {
	public void eat();
}
interface IMakeNoise {
	public void makeNoise();
}
class Dog implements IEat, IMakeNoise {
	public void eat() {
		System.out.println("Dog is eating");
	}
	public void makeNose() {
		System.out.println("Dog is making noise");
	}
}
public class MyClass {
	public static void main(String args[]) {
		System.out.println("Hello World");
		Dog fido = new Dog();
		fido.eat();
		fido.makeNoise();
	}
}


// The above implementation decouples the behaviors from the Mammal class. Rather than creating a single Mammal entity via inheritance we are moving to a composition-based design. 

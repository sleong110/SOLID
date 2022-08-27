// DIP: Dependency Inversion Principle
//
// DIP states that code should depend on abstraction. 
//
// KEY TERMS:
// Dependency inversion - The principle of inverting the dependency
// Dependency injection - The act of inverting the dependencies
// Constructor injection - Performing dependency injection via the constrcutor
// Parameter injection - Performing dependency via the Parameter of a method, like a setter

// The goal of dependency inversion is to couple to something abstract rather than concerte
//
// One of the goals of Dependency Inversion Principle is to choose objects at runtime, not at compile time. (You can change the behavior of your program at runtime.)
//
//
// Step 1: Intial Example

public class TestMammal {
	public static void main(String args[]) {
		System.out.println("Hello World\n");

		Mammal cat = new Cat();
		Mammal dog = new Dog();

		System.out.println("Cat says " + cat.makeNoise());
		System.out.println("Dog says " + dog.makeNoise());
	}
}

abstract class Mammal {
	public abstract String makeNoise();
}

class Cat extends Mammal {
	public String makeNoise() {
		return "Meow";
	}
}

class Dog extends Mammal {
	public String makeNoise() {
		return "Bark";
	}
}

// Step 2: Separating Out behavior
// The preceding code is couping the mammals and the makingNoise behavior which is problematic. We are making a class called MakingNoise to decouple form Mammal class so that it can be used by all mammals and non-mammals.

public class TestMammal {
	public static void main(String args[]) {
		System.out.println("Hello World\n");

		Mammal cat = new Cat();
		Mammal dog = new Dog();

		System.out.println("Cat says " + cat.makeNoise());
		System.out.println("Dog says " + dog.makeNoise());
	}
}

abstract class MakingNoise {
	public abstract String makeNoise();
}

class CatNoise extends MakingNoise {
	public String makeNoise() {
		return "Meow";
	}
}

class DogNoise extends MakingNoise {
	public String makeNoise() {
		return "Bark";
	}
}

abstract class Mammal {
	public abstract String makeNoise();
}

class Cat extends Mammal {
	CatNoise behavior = new CatNoise();
	public String makeNoise() {
		return behavior.makeNoise();
	}
}

class Dog extends Mammal {
	DogNoise behavior = new DogNoise();
	public String makeNoise() {
		return behavior.makeNoise();
	}
}

// At this point, we have decoupled a major part of the code, but we still haven't reach our goal of depency inversion because the Cat is still instantiating Cat noise-making behavior. The Cat is coupled to low-level module CatNoise. The Cat should not be coupled to CatNoise but to the abstraction for making noise. The Cat class should not instantiate its noise-making behaviior but instead receive the behavior via injection.


// Step 3: Dependency Injection
//
// We are abandoning inheritence aspects of our design and see how to utilitze dependency injection via composition. 

public class TestMammal {
	public static void main(String args[]) {
		System.out.println("Hello World\n");

		Mammal cat = new Cat(new CatNoise());
		Mammal dog = new Dog(new DogNoise());

		System.out.println("Cat says " + cat.makeNoise());
		System.out.println("Dog says " + dog.makeNoise());
	}
}

class Mammal {
	MakingNoise speaker;
	
	public Mammal(MakingNoise sb) {
		this.speaker = sb;
	}
	public String makeNoise() {
		return this.speaker.makeNoise();
	}
}

interface MakingNoise {
	public String makeNoise();
}

class CatNoise implements MakingNoise {
	public String makeNoise() {
		return "Bark";
	}
}

// When discussing dependency injection, when to actually instantiate an object is now a key consideration. One simple goal is to create a concerte object (by using new) as far up the chain as possible, such as the main() method. Always evaluate things when you see a new keyword.

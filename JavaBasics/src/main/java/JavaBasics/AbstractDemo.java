package JavaBasics;


//Abstract class, is we have atleast one abstract method then make that class as abstract class.
abstract class Animal {
 // Abstract method, just declaring.
 public abstract void sound();

 // Concrete method
 public void sleep() {
     System.out.println("Zzz");
 }
}

//Concrete subclass of Animal
class Dog extends Animal {
 // Implementation of abstract method sound() for Dog
 @Override
 public void sound() {
     System.out.println("Woof");
 }
}


public class AbstractDemo {

	public static void main(String[] args) {
	     // Creating an object of the concrete subclass Dog
	     Dog dog = new Dog();

	     // Calling methods
	     dog.sound(); // Output: Woof
	     dog.sleep(); // Output: Zzz
	}

}

package JavaBasics;

interface Greet
{
	public void show();
}

public class AnonymousClass {

	public static void main(String[] args) {
		//Anonymous classes in Java are a way to declare and instantiate a class at the same time, 
		//without explicitly naming the class.
		//They are often used for one-time use or for implementing interfaces with minimal code.
		Greet obj = new Greet()
				{
					public void show()
					{
						System.out.println("Hi Good Morning");
					}
				};
		obj.show(); //Calling the method of anonymous class
		
	}

}

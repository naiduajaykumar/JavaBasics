package JavaBasics;


class Demo
{
	//Static variables will be called only once during the class loading in JVM, and same across all objects.
	//Object independent
	static int a;
	static int b;
	
	
	//Here we can also declare static variables in static block as well
	// Static block (optional)
    static {
        // This is a static block, it could be used for additional initialization
        System.out.println("Static block initialized.");
        
        //In order resolve P1 we can call static show() in here
        show();
    }

	
    //Instance variables called during object creation, object dependent
	int c;
	int d;
	
	static void show()
	{
		a = 10;
		b = 15;
		System.out.println("a = " + a + " " + "b = " + b);
	}
	
	void display()
	{
		c = 20;
		d = 25;
		System.out.println("c = " + c + " " + "d = " + d);
		//Problem1
		System.out.println(a + "," +b); //To print a,b we must call the static method in order to initilize a,b
	}
	
	
	
}
public class StaticDemo {

	public static void main(String[] args) {
		//Here without calling show() we cannot instiansiate a,b. To resolve this we call show() in static block
		Demo.show(); //Here show() is static method we no need to create the object for it.
		
		Demo d = new Demo();
		d.display();
	}

}

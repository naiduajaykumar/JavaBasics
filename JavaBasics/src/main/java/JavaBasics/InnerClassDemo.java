package JavaBasics;

class Outer {
    private int outerData;

    public void outerMethod() {
    	System.out.println("outer method called");
    	
    	//In the Outer class itself we are creating & calling the Inner class.
        Inner inner = new Inner();
        inner.innerMethod();
    }

    class Inner {
        public void innerMethod() {
        	outerData = 10;	//Here we can access the main class data
            System.out.println("Inner method called");
            System.out.println("Outer data: " + outerData); // Inner class can access outer class's private data
        }
    }
}

public class InnerClassDemo {

	public static void main(String[] args) {
		Outer out = new Outer();
		out.outerMethod();
	}

}

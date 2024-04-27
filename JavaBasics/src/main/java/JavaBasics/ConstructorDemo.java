package JavaBasics;

class HelloWorld{
    String a = "Ajay";
    String b;
    
    HelloWorld()
    {}
    
    //If we declare parameterised constructor then we must declare default constructor on our own.
    HelloWorld(String b){
    	this.b = b;
    }

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
}

public class ConstructorDemo {
	public static void main(String[] args) {
		HelloWorld d = new HelloWorld();
	    System.out.println(d.getA());
	    HelloWorld d1 = new HelloWorld("Kumar");
	    System.out.println(d1.getB());
	}
}

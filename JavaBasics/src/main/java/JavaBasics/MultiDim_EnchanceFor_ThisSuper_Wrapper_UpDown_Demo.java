package JavaBasics;

//super() and this() concepts below example
class A extends Object
{
	public A() 
	{
		super();
		System.out.println("in A");
	}
	public A(int n)
	{
		super();
		System.out.println("in A int");
	}
	
	public void aMethod()
	{
		System.out.println("Im A");
	}
	
	public void greet() {
		System.out.println("Hi, from A");
	}
	
	@Override
    public String toString() {
        return "Object of class A";
    }
}

class B extends A
{
	public B() 
	{
		super();
		System.out.println("in B");
	}
	public B(int n)
	{
		//this();
		super();
		System.out.println("in B int");
	}
	
	public void bMethod()
	{
		System.out.println("Im B");
	}
	
	@Override
	public void greet() {
		System.out.println("Hi, from B");
	}
	
	@Override
    public String toString() {
        return "Object of class B";
    }
}


public class MultiDim_EnchanceFor_ThisSuper_Wrapper_UpDown_Demo {

	public static void main(String[] args) {
		//muti-dimensional array
		int multiArray[][] = new int[3][4];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				multiArray[i][j] = (int)(Math.random() * 10);
			}
		}
				
		///Enchanced for loop to print muli-dimensional array
		for(int m[] : multiArray) {
			for(int n:m) {
				//System.out.print(n+" ");
			}
			//System.out.println();
		}
		
        
        //super() and this() concepts below example     
        B obj = new B(5); 

        
        //Wrapper class
        int num = 7;
        //If we assign primitive data type to Integer(Wrapper class) is Auto-boxing.
        Integer IntNum = num;	//Auto-boxing
        
        //If we assign Wrapper class to primitive type is Auto-unboxing.
        int num2 = IntNum.intValue(); //Unboxing
        num2 = IntNum;	//Auto-unboxing.
        
        
        // Upcasting
        A obj1 = new B(); // Upcasting B object to A reference, *Here cannot call B class methods though it referring to B class.
        //obj1.bMethod(); //gets compile time error
        //obj1.greet();	 //Here greet is override method, and called from B class bcz it it B's object.
        
        // Downcasting
        B obj2 = (B) obj1; // Downcasting A reference to B reference, *Here I call both A,B methods.
        //obj2.aMethod();	//No errors here
        //obj2.bMethod();
        
        // Printing objects
        System.out.println("Object 1: " + obj1);
        System.out.println("Object 2: " + obj2);
		
	}

}

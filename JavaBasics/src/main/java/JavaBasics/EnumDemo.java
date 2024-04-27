package JavaBasics;

enum Status 
{
	Running, Pending, Success, Failed;
}


enum Rectangle {
    SMALL(2, 3),
    MEDIUM(4, 5),
    LARGE(6, 7),
	UNEVEN; //Here we can also create no parameter constructor

    private final int length;
    private final int width;

  //For UNEVEN, we had created this defaulf constructort constructor is private
    Rectangle() {
		this.length = 0;
		this.width = 0;
		}
    
    //Here by default constructor is private
    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}


public class EnumDemo {

	public static void main(String[] args) {
		Status s = Status.Success;
		System.out.println(s);
		
		Status[] ss = Status.values();
		for(Status i : ss) {
			//System.out.println(i);
		}
		
		//enum with if-else
		if(s == Status.Failed) {
			System.out.println("Connection Failed: 400");
		}
		else 
		{
			System.out.println("Connection Success: 200");
		}
		
		//enum with switch
		switch(s)
		{
			case Pending:
				System.out.println("Connection Pending");
				break;
		
			case Failed:
				System.out.println("Connection Failed");
				break;
			
			case Running:
				System.out.println("Connection Running");
				break;
			
			default:
				System.out.println("Connection Success");
		}
		
		
		//Enum class
		for(Rectangle rect : Rectangle.values())
		{
			System.out.println(rect + " : " + rect.area());
		}
	}

}

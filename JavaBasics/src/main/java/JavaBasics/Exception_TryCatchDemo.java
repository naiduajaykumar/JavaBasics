package JavaBasics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Custom Exception
class MyException extends Exception
{
	//Constructor
	MyException(String string)
	{
		super(string); //To print message we are using Exception class method to print msg by using "super()" method.
	}
}

//Ducking Exception ------------- Eq(1)
class FileProcessor {

    // Method that may throw FileNotFoundException or IOException
    public void processFile(String filename) throws FileNotFoundException, IOException {
        // Attempt to read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line of the file
                System.out.println(line);
            }
        }
    }
}

public class Exception_TryCatchDemo {
//***We not put throws to main() method bcz the Execution will stop, instead use try..block the error code..
	public static void main(String[] args) {
		
		int a = 5;
		int b = 0;
		String ajay = "";
		try {
			//The Sequence is very important it follow the each line one by one 
			//Suppose if any line throws error, remaining excepetions won't get executed.
			
			//Throwing custom Exception
			if(ajay == "")
				throw new MyException("Declare ajay, he is empty");
			
			if(b == 0)
				//If we want to throw an Exception to some results(Ex:- Getting "Not Found Error" from server, and for some arthamatic result we should not get Zero for these types we can "throw" Exception.
		    	throw new ArithmeticException("Ohh Denominator is 0");

			int res = a/b;
		    int[] arr = {1, 2, 3};
		    System.out.println(arr[5]); 		    
		}catch (ArithmeticException e) {
		    // Handle ArithmeticException
		    System.out.println("An exception occurred: " + e.getMessage());
		    //e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
		    // Handle ArrayIndexOutOfBoundsException
		    System.out.println("An exception occurred: " + e.getMessage());
		}catch (MyException e) {
		    // Handle any other exception
		    System.out.println(e.getMessage());
		}catch (Exception e) {
		    // Handle any other exception
		    System.out.println("Something Went Wrong");
		}
		
		
		//-----------------------Eq(2)
		FileProcessor fp = new FileProcessor();
		try {
			//fp.processFile("D:/Java/JavaBasics/src/main/java/JavaBasics/ajay.txt");
			//Wrong name given
			fp.processFile("D:/Java/JavaBasics/src/main/java/JavaBasics/ajay.txt1");
		} catch (IOException e) {
			System.out.println("There is no file, for which the path you had given...");
			//e.printStackTrace();
		}finally {
			//Finally will execute irrespcitive of Exception occurred or not
			//Mostly used to close resources.
			System.out.println("Resources closed, Good Bye...");
		}

		
		
//For Eq(1) & Eq(2) for these both we are handling exceptions, but why one is enought? 
//		In the `FileProcessor` class, the `processFile` method declares that it may throw two types of checked exceptions: `FileNotFoundException` and `IOException`. By declaring these exceptions in the method signature using the `throws` keyword (`throws FileNotFoundException, IOException`), the method signals to the caller that it may encounter these exceptions during execution and that the caller should handle them appropriately.
//
//		In the second code snippet, you're creating an instance of the `FileProcessor` class (`FileProcessor fp = new FileProcessor();`) and invoking the `processFile` method to read from a file. Since the `processFile` method may throw `FileNotFoundException` and `IOException`, the caller (the code snippet) must handle these exceptions.
//
//		You're handling these exceptions correctly in the second code snippet by using a try-catch block. Specifically, you catch `FileNotFoundException` to handle the case where the specified file does not exist, and you catch `IOException` to handle other types of IO-related errors that may occur during file processing.
//
//		In summary:
//		- In the `FileProcessor` class, the method declares that it may throw two types of exceptions.
//		- In the caller code, you're invoking the method that may throw these exceptions, so you must handle them appropriately to ensure robust error handling and prevent the program from crashing if exceptions occur during file processing.
//
//		So, both the `throws` declaration in the method signature and the try-catch block in the caller code are necessary to handle potential exceptions that may occur during file processing.
	}
}

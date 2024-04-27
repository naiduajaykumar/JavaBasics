package JavaBasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput_TryCatch {

	public static void main(String[] args) throws IOException {
		System.out.println("Please Enter a value: ");
//Reads only single character		
//			int value = System.in.read();	//Reads only one character
//			System.out.println(value);	//This read() will read ASCII value, for user entered input.

		
//Old Way
		//To resolve above issue we have another way mentioned below
//			InputStreamReader inSR = new InputStreamReader(System.in); 
//			BufferedReader bf = new BufferedReader(inSR);
//			
//			int num = Integer.parseInt(bf.readLine());
//			System.out.println(num);
//			bf.close();   //BufferedReader is a resource so we need to close this after using.


//New Way(Introduced in java 1.5) 
		//try (Scanner sc = new Scanner(System.in)) this will implicitly close the resources
		try (Scanner sc = new Scanner(System.in)) {
			int NUM = sc.nextInt();
			System.out.println("New way-"+ NUM);
		}
	}

}

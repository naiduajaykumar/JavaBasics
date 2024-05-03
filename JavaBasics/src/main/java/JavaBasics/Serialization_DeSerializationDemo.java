package JavaBasics;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student2 implements Serializable
{
	private int id;
	private String name;
	transient	private int age; //Will exclude in Serialization i.e ***Transient(Selective Serialization)
	public Student2(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void display()
	{
		System.out.println("id "+ id);
		System.out.println("name "+ name);
		System.out.println("age "+ age);
	}
}
public class Serialization_DeSerializationDemo {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Ajayk\\git\\JavaBasics\\JavaBasics\\src\\main\\java\\JavaBasics\\serial.txt";
		Student2 st = new Student2(1, "Ajay", 25);
		st.display();
		try {
//Serialization
			FileOutputStream fos = new FileOutputStream(filePath);
			//For enchance we can BufferedOutputStream instead FileOutputStream
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(st);
			System.out.println("Check serialized file");
			
			
			oos.close();
			fos.close();
			
//DeSerialization
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois= new ObjectInputStream(fis);
			
			Student2 st1 = (Student2) ois.readObject();
			st1.display();
			
			ois.close();
			fis.close();
			

			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

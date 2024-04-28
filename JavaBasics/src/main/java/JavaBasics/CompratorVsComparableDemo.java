package JavaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>
{
	String name;
	int age;
	public Student(int age, String name) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	//We must write this method to to sort we want to sort using Comparable interface
	public int compareTo(Student that) {
		if(this.age > that.age)
			return 1;
		else 
			return -1;
	}
	
	
}
public class CompratorVsComparableDemo {

	public static void main(String[] args) {
//		The Comparator interface is used to define custom comparison logic for sorting objects that do not implement the Comparable interface.
		Comparator<Integer> intCom = (i,j) -> (i%10 > j%10 ? 1 : -1);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(19);
		nums.add(65);
		nums.add(56);
		nums.add(12);
		
		//Collections.sort(nums); //Will print default sorting
		//Collections.sort(nums,com);	//Will print the custom sorting
		
//		The Comparable interface is implemented by a class whose instances can be ordered or sorted.
//		It defines a single method, compareTo(), which compares the current object with another object of the same type.
//		Classes that implement Comparable can be sorted using the Collections.sort() method or by calling Arrays.sort().
		//**Our goal is to sort the students based on their age.
		ArrayList<Student> studs = new ArrayList<Student>();
		
		studs.add(new Student(26,"Rob"));
		studs.add(new Student(31,"Mike"));
		studs.add(new Student(45,"Ted"));
		studs.add(new Student(27,"John"));
		//Collections.sort(studs); //Throws error because out Student is implementing comparable interface
		//After implementing still won't sort the way we want
		//Collections.sort(studs);
//1-Way->(Comparable)We want to write logic in compareTo() method to sort the way we want
		Collections.sort(studs);
		System.out.println(studs);
//2nd-Way->(Comparator)If we want to sort the studs array with Comparator
		Comparator<Student> studsCom = (i,j) -> (i.age > j.age ? 1 : -1);
		Collections.sort(studs,studsCom);
		System.out.println(studs);
		
		
	}

}

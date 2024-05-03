package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Student1
{
	String name;
	int age;
	Student1() {}
	public Student1(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student1 [name=" + name + ", age=" + age + "]";
	}	
}

public class Optional_MethodRef_ConstructorRef {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("ajay","Kumar","pavan","ramu");
		
		//Optional Class
		//Suppose if we want to find and name that contains "u".
		//Here we declaring Optional class instead of Stream class bcz "findFirst()" may throw null pointer exception if name not found.
		Optional<String> stream = names.stream()
							.filter(n -> n.contains("u"))
							.findFirst();
		System.out.println(stream.get());
		
		//OR
		String name = names.stream()
				.filter(n -> n.contains("u"))
				.findFirst()
				.orElse("Not Found");		//Another way to void null pointer exception
		System.out.println(name);
		
		
		//Method Reference(Java 8)
		List<String> upNames = names.stream()
				.map(String::toUpperCase) //Here we are passing direct f-name "toUpperCase" and where it belongs to "String" with ::, instead this n->n.toUpperCase(), called as Method Reference. 
				.toList();
		upNames.forEach(System.out :: println);
		
		//Constructor Reference topic
		List<Student1> students = new ArrayList<>();
		
		//Here we need to add multiple students to students list normal way
		for(String eachName:names)
		{
			students.add(new Student1());
		}
		System.out.println(students.stream().toList());
		
		//By constructor reference
		students = names.stream()
						.map(Student1::new) //**Note:= It works only when we are creating a object with name, for this we have to be constructor that is accepting name as parameter.
						.toList();
		System.out.println(students);
	}

}

package JavaBasics;

public class StringBufferStringBuild {

	public static void main(String[] args) {
		///String buffer
		StringBuffer strBuf = new StringBuffer();
		System.out.println("strBuf "+strBuf.capacity());
		StringBuffer stringBuffer = new StringBuffer("Hello");
				        
		///Operations on String Buffer class
		// Get the capacity of the StringBuffer
		int capacity = stringBuffer.capacity();
		System.out.println("Capacity of StringBuffer: " + capacity);
		stringBuffer.append("Hello");
		// Append " World" to the string
		stringBuffer.append(" World");
		// Insert " Java" at index 6
		stringBuffer.insert(6, " Java");
		// Replace "Hello" with "Hi"
		stringBuffer.replace(0, 5, "Hi");
		// Delete "Java"
		stringBuffer.delete(10, 15);
		System.out.println(stringBuffer.toString()); // Output: Hi World
		System.out.println(stringBuffer.length());
						
		// Get the capacity of the StringBuilder
		StringBuilder stringBuilder = new StringBuilder("Hello");
		int capacity1 = stringBuilder.capacity();
		System.out.println("Capacity of StringBuilder: " + capacity1);
			

	}

}

package JavaBasics;

//Define a generic class Box that can hold any type of object
class Box<T> {
 private T value;

 public void setValue(T value) {
     this.value = value;
 }

 public T getValue() {
     return value;
 }
 
 //All generics methods must be static
 public static <T> void printArray(T[] arr) {
     for (T element : arr) {
         System.out.print(element + " ");
     }
     System.out.println();
 }
}

public class GenericsDemo {
 public static void main(String[] args) {
     // Create a Box for Integer
     Box<Integer> intBox = new Box<>();
     intBox.setValue(10);
     int intValue = intBox.getValue(); // No need for casting
     System.out.println(intValue);

     // Create a Box for String
     Box<String> strBox = new Box<>();
     strBox.setValue("Hello");
     String strValue = strBox.getValue(); // No need for casting
     System.out.println(strValue);
     
//-----------------------------------------     
     Integer[] intArray = {1, 2, 3, 4, 5};
     String[] strArray = {"Hello", "World"};

     // Print integer array
     Box.printArray(intArray);

     // Print string array
     Box.printArray(strArray);
 }
}


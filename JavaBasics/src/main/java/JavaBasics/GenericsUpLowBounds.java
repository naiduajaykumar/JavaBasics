package JavaBasics;
import java.util.List;

//Employee class representing an employee in an organization
class Employee {
 private String name;
 private double salary;

 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 // Getters
 public String getName() {
     return name;
 }

 public double getSalary() {
     return salary;
 }

@Override
public String toString() {
	return "Employee [name=" + name + ", salary=" + salary + "]";
}
}


//Manager class representing a manager, subclass of Employee
class Manager extends Employee {
 public Manager(String name, double salary) {
     super(name, salary);
 }
}

//Organization class(Different class) to manage employees
class Organization {
 // Method to calculate total salary of employees (upper bound: read-only access)
 public static double calculateTotalSalary(List<? extends Employee> employees) {
     double totalSalary = 0;
     for (Employee employee : employees) {
         totalSalary += employee.getSalary();
     }
     return totalSalary;
 }

 // Method to add new employees (lower bound: write-only access)
 //Here are send the super type Object to
 public static void hireEmployees(List<? super Employee> employees, Object newEmployee) {
     employees.add((Employee) newEmployee);
 }

}

public class GenericsUpLowBounds {
 public static void main(String[] args) {
     // Create a list of employees
     List<Employee> employeesList = new java.util.ArrayList<>();

     // Add employees to the list (using upper bound), UPPERBOUND works will all of its same of subclass types
     employeesList.add(new Employee("John Doe", 50000));
     employeesList.add(new Manager("Jane Smith", 60000)); // Manager is a subclass of Employee

     // Calculate total salary of employees (using upper bound)
     double totalSalary = Organization.calculateTotalSalary(employeesList);
     System.out.println("Total salary of employees: $" + totalSalary);

     // Create a new employee (lower bound)
     //Here Im sending the Object class type which is super class of Emplolyee
     Object newEmployee = new Employee("Alice Johnson", 55000);

     // Add the new employee to the list (using lower bound),  LOWERBOUND works will all of its same of superclass types
     Organization.hireEmployees(employeesList, newEmployee);
     System.out.println("Updated employees list: " + employeesList);
 }
}

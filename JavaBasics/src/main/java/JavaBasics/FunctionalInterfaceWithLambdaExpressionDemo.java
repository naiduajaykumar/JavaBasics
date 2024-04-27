package JavaBasics;

@FunctionalInterface
interface Calculator
{
	int calculate(int x, int y);
}

public class FunctionalInterfaceWithLambdaExpressionDemo {

	public static void main(String[] args) {
		// Using lambda expression to implement the calculate method
		Calculator add = (x,y) -> x + y;
		Calculator sub = (x,y) -> x - y;
		
		System.out.println(add.calculate(10,5));
		System.out.println(sub.calculate(10,5));
	}

}

package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamAPIDemo {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(7,6,56,3,6,7,4);
		
		//forEach loop
		nums.forEach(n -> System.out.println(n));
		
		//Convert our orginal 'nums' list into STREAM so we can have lot of methods to do on our list
		Stream<Integer> s1 = nums.stream();
		Stream<Integer> s2 = s1.filter(n -> n%2 ==0);
		Stream<Integer> s3 = s2.map(n-> n*2);
		int result = s3.reduce(0, (carry,element) -> carry+element);
		
		//In-short we can write like this...
		int sum = nums.stream()
						.filter(n -> n%2 ==0)
						.map(n-> n*2)
						.reduce(0, (carry,element) -> carry+element);
		System.out.println(sum);
		
		
		//Parallel Stream
		int size = 10_000;
		List<Integer> values = new ArrayList(size);
		Random ran = new Random();
		
		for(int i=1;i<=size;i++)
		{
			values.add(ran.nextInt(100)); //100 is our upper-bound, range will 1-100.
		}
		
		//Sequential stream(single thread will perform the Sequential stream)
		int sum1 = values.stream()
						.map(n -> n*2)
						.reduce(0, (c,e)-> c+e);
		//OR
		long startSeq = System.currentTimeMillis();
		int sum2 = values.stream()
				.map(n -> {try {Thread.sleep(1);} catch(Exception e) {}	return n*2;})
				.mapToInt(n -> n) //mapToInt will internally have reduce function
				.sum();
		long endSeq = System.currentTimeMillis();
		
		
		//Parallel Stream(Internally create multiple threads to do tasks parallely in Parallel stream)
		long startPara = System.currentTimeMillis();
		int sum3 = values.parallelStream()
				.map(n -> {try {Thread.sleep(1);} catch(Exception e) {}	return n*2;})
				.mapToInt(n -> n) //mapToInt will internally have reduce function
				.sum();
		long endPara = System.currentTimeMillis();
		
		
		//Since we are adding delay by sleep() the parallel steam executes faster because it executes parallel
		//**NOTE:- We should not use parallel when we are working with the data that is independent.
		System.out.println("Sequential Time Taken "+(endSeq-startSeq));
		System.out.println("Parallel Time Taken "+(endPara-startPara));
	}

}

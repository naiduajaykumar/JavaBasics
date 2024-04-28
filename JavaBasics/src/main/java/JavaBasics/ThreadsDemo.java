package JavaBasics;

class Ajay extends Thread
{
	public void run()
	{
		for(int i=0; i<25; i++)
		{
			System.out.println("Ajay");
			//We have to place the sleep method of our operation
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {e.printStackTrace();}	
		}
	}
}

class Kumar extends Thread
{
	public void run()
	{
		for(int i=0; i<25; i++)
		{
			System.out.println("Kumar");
			//We have to place the sleep method of our operation
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class ThreadsDemo {

	public static void main(String[] args) {
		//We cannot control threads but we can Optimise them.
		Ajay obj1 = new Ajay();
		Kumar obj2 = new Kumar();
		
		
//		However, thread priorities are only hints to the scheduler and don't guarantee the order of execution.
//		The valid range for thread priorities is from Thread.MIN_PRIORITY (1) to Thread.MAX_PRIORITY (10), inclusive. The default priority is Thread.NORM_PRIORITY (5).
		//To get priority of a object, range is from 1 to 10
		System.out.println("Priority is:" + obj1.getPriority());
		
		//To set high priority of a obj2, output will 1st Kumar 2nd Ajay
		obj2.setPriority(Thread.MAX_PRIORITY);
		
		
		//To print objects parallely we can set the threads in SLEEP
		obj1.start();
		obj2.start();
	}

}

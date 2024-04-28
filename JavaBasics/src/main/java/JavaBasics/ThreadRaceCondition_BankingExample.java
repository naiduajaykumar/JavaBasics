package JavaBasics;

class BankAccount
{
	int balance = 10_000;
//	public void withDraw()
	//Through two people are withdrawing from same account but it will execute only once with help of synchronized.
	//In order to maintain consistency we use "synchronized".
	public synchronized int withDraw(int amount) 
	{
		if(balance > amount)
		{
			balance -= amount;
			System.out.println("Remaining Balace: " + balance);
			return balance;
		}
		else
		{
			System.out.println("No Sufficient Balance");
			return 0;
		}
	}
}

public class ThreadRaceCondition_BankingExample {
    public static void main(String[] args) throws InterruptedException{   
    	
    	BankAccount c = new BankAccount();
    	
    	Runnable personA=()->
    	{
    		//Each time we have to with enter random amount 
    		int amount1 = (int) (Math.random() * 3000);
    		for(int i=1;i<=3;i++) //If A trying to withdraw 3 times from the account 
    		{
    			System.out.println("Person A is withdrawing: " + amount1);
    			int remainingBalance  = c.withDraw(amount1);
    		}
    	};
    	
    	Runnable personB=()->
    	{
    		//Each time we have to with enter random amount 
    		int amount2 = (int) (Math.random() * 3000);
    		for(int i=1;i<=3;i++) //If B trying to withdraw 3 times from the account
    		{
    			System.out.println("Person B is withdrawing: " + amount2);
    			int remainingBalance  = c.withDraw(amount2);
    		}
    	};
    	
    	Thread t1=new Thread(personA);
    	Thread t2=new Thread(personB);

//    	The start() method is used to start the execution of a thread. When you call start() on a Thread object, it initiates the execution of the thread, and the JVM calls the run() method of that thread.
//    	In the given code, t1.start() and t2.start() are used to start the execution of the personA and personB threads, respectively.
    	t1.start();
    	t2.start();
    	
//    	The join() method is used to wait for a thread to finish its execution before continuing with the current thread.
//    	In the given code, t1.join() and t2.join() are used to make sure that the main thread waits for t1 and t2 to complete their execution before printing the total remaining balance.
//    	If join() is called on a thread, the current thread will wait until the specified thread (in this case, t1 or t2) completes its execution before continuing.
    	t1.join();
    	t2.join();
    	
    	System.out.println("------Total Remaining Balace in account------ " + c.balance + ".00");

//*******What we achieved*******
//    	By using start() and join(), the main thread ensures that both personA and personB threads have completed their executions before printing the total remaining balance. 
//    	This helps in synchronizing the main thread with the execution of the other threads, ensuring that the balance is printed only after all the withdrawals are completed.
    }
}

    


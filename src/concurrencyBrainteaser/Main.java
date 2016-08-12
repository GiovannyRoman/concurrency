package concurrencyBrainteaser;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread t1 =new Thread(new Custom("a"));
		Thread t2 =new Thread(new Custom("b"));
		Thread t3 =new Thread(new Custom("c"));

		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
	}

}

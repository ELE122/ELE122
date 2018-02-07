package lecture9;

public class Corruptor implements Runnable {

	String threadName;
	static int counter = 0;
	
	public Corruptor(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello from " + threadName + Thread.currentThread().getName());
			System.out.println("Counter is now: " + counter);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(threadName.equals("Ole") || threadName.equals("Dole")) {
				counter++;
			}
			else if(threadName.equals("Pluto") || threadName.equals("Doffen")) {
				counter--;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Corruptor("Ole")).start();
		new Thread(new Corruptor("Dole")).start();
		new Thread(new Corruptor("Doffen")).start();
		new Thread(new Corruptor("Pluto")).start();
		System.out.println("Hello from " + Thread.currentThread().getName());
	}


}

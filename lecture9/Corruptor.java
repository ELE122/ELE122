package lecture9;

public class Corruptor implements Runnable {

	String threadName;
	
	public Corruptor(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello from " + threadName);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Corruptor("Ole")).start();
		Thread.sleep(10);
		new Thread(new Corruptor("Dole")).start();
		new Thread(new Corruptor("Doffen")).start();
	}


}

package lecture9;

public class ThreadsDemo1 implements Runnable {

	String threadName;
	
	public ThreadsDemo1(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		
		// Let the thread print its name every 6 second for eternity
		while(true) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello from " + threadName);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// Print the name of the current thread. What do you expect it to be?
		System.out.println("Hello from " + Thread.currentThread().getName());
		
		// Start 4 new threads
		new Thread(new ThreadsDemo1("Ole")).start();
		new Thread(new ThreadsDemo1("Dole")).start();
		new Thread(new ThreadsDemo1("Doffen")).start();
		new Thread(new ThreadsDemo1("Pluto")).start();

		// What do you see in console? Why?
	}
}

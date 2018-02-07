package lecture9;

public class Corruptor3 implements Runnable {

	Integer threadName;
	
	public Corruptor3(Integer threadName) {
		this.threadName = threadName;
		System.out.println(threadName.hashCode());
		System.out.println(this.threadName.hashCode());
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello from " + threadName);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadName = 2;
		}
	}
}

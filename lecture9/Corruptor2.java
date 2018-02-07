package lecture9;

public class Corruptor2 implements Runnable {

	Integer threadName;
	
	public Corruptor2(Integer threadName) {
		this.threadName = threadName;
		System.out.println(threadName.hashCode());
		System.out.println(this.threadName.hashCode());
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
		Integer nameOfThread = 1;
		new Thread(new Corruptor2(nameOfThread)).start();
		new Thread(new Corruptor3(nameOfThread)).start();
	}


}

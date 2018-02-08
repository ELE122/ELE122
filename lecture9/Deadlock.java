package lecture9;

public class Deadlock {
    static class Friend {
        private String name;
        
        public Friend(String name) {
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
        
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            // Call the bowBack function on Friend object bower
            bower.bowBack(this);
        }
        
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Friend alphonse =
            new Friend("Alphonse");
        
        Friend gaston =
            new Friend("Gaston");
        
        // Implemented Runnable using Anonymous class, see
        // https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        
        // Sleeping solves the deadlock
//        Thread.sleep(1000);
        
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
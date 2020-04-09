public class SaleTicket {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("窗口1");
        Ticket t2 = new Ticket("窗口2");
        Ticket t3 = new Ticket("窗口3");
        t1.start();
        t2.start();
        t3.start();

        Tickets t = new Tickets();
        Thread t4 = new Thread(t, "窗口1");
        Thread t5 = new Thread(t, "窗口2");
        Thread t6 = new Thread(t, "窗口3");
        t4.start();
        t5.start();
        t6.start();
    }
}

class Ticket extends Thread {
    private static int total = 100;
    private static final Object lock = new Object(); //锁的选择之一，单独造一个锁对象
    public Ticket(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (total > 0) {
                    System.out.println(getName() + "卖出一张票");
                    total--;
                    System.out.println("剩余: " + total);
                }
                else {
                    break;
                }
            }
        }

    }
}

class Tickets implements Runnable {
    private int total = 10;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出一张票");
                    total--;
                    System.out.println("剩余: " + total);
                }
                else {
                    break;
                }
            }
        }
    }
}
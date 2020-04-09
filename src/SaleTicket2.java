public class SaleTicket2 {
    public static void main(String[] args) {
        Ticket2 t1 = new Ticket2("窗口一");
        Ticket2 t2 = new Ticket2("窗口二");
        Ticket2 t3 = new Ticket2("窗口三");
        Ticket2 t4 = new Ticket2("窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Ticket2 extends Thread {
    private static int total = 10000;

    public Ticket2(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (total > 0) { // 程序停止的条件
            saleOneTicket();
        }
    }
    // 同步方法，锁的是方法的一次调用过程
    public synchronized static void saleOneTicket() {
        if (total > 0) { // 线程安全问题的条件
            System.out.println(Thread.currentThread().getName() + "卖出一张票");
            total--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("剩余: " + total);
        }
    }
}

class Ticket3 implements Runnable {
    private int total = 10;

    @Override
    public void run() {
        while (total > 0) { // 程序停止的条件
            saleOneTicket();
        }
    }
    // 同步方法，锁的是方法的一次调用过程
    public synchronized void saleOneTicket() {
        if (total > 0) { // 线程安全问题的条件
            System.out.println(Thread.currentThread().getName() + "卖出一张票");
            total--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("剩余: " + total);
        }
    }
}
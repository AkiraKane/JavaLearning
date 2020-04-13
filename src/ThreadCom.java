public class ThreadCom {
    public static void main(String[] args) {
        WorkBench bench = new WorkBench();
        Chef chef = new Chef("Hezijian", bench);
        Waiter waiter = new Waiter("Shuobai", bench);
        chef.start();
        waiter.start();
    }
}

class WorkBench {
    private static final int MAX = 10;
    private static final int MIN = 0;
    private int count;

    /**
     * 往工作台上放一盘菜
     */
    public synchronized void put() {
        // 生产者等待
        if (count >= MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "放了一盘菜，剩余： " + count + "盘菜");
        notify();
    }

    /**
     * 取走一盘菜
     */
    public synchronized void take() {
        // 消费者等待
        if (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "取走一盘菜，剩余： " + count + "盘菜");
        notify();
    }
}

class Chef extends Thread {
    private WorkBench workBench;

    public Chef(String name, WorkBench bench) {
        super(name);
        workBench = bench;
    }

    @Override
    public void run() {
        while (true) {
            workBench.put();
        }
    }
    
}

class Waiter extends Thread {
    private WorkBench workBench;

    public Waiter(String name, WorkBench bench) {
        super(name);
        workBench = bench;
    }

    @Override
    public void run() {
        while (true) {
            workBench.take();
        }
    }

}
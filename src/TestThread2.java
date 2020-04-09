public class TestThread2 {
    public static void main(String[] args) {
        System.out.println("Hello Thread!");

        //继承Thread类的线程开启
//        MyThread thread = new MyThread();
//        thread.start();

        //实现Runnable类的线程开启
        MyRunnable runnableThread = new MyRunnable();
        Thread t = new Thread(runnableThread);
        t.start();

        for (int i = 10; i >= 1; i--) {
            System.out.println("main" + i);
            if (i == 3) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) System.out.println("mythread:" + i);
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) System.out.println("runnable thread:" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
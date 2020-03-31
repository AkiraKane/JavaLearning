public class DeadLock {
}


class Boy extends Thread {
    private Object girl;
    private Object money;

    @Override
    public void run() {
        synchronized (money) {
            System.out.println("放了我女朋友，给你500万");
            synchronized (girl) {
                System.out.println("给了对方500万");
            }
        }
    }
}


class Gang extends Thread {
    private Object girl;
    private Object money;

    @Override
    public void run() {
        synchronized (girl) {
            System.out.println("给我500万，我放人");
            synchronized (money) {
                System.out.println("拿钱放人");
            }
        }
    }
}
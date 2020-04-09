public class TemplateTest {
    public static void main(String[] args) {
        MyCalTime my = new MyCalTime();
        long time = my.getTime();
        System.out.println(time);
    }
}

abstract class CalTime {
    public long getTime() {
        long start = System.currentTimeMillis();

        doWork();

        long end = System.currentTimeMillis();

        return end - start;
    }

    public abstract void doWork();

}


class MyCalTime extends CalTime {

    @Override
    public void doWork() {
        int sum = 0;
        for (int i = 1; i < 100; i++) sum += i;
        System.out.println(sum);
    }
}
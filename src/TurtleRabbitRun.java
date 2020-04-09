import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class TurtleRabbitRun {
    public static void main(String[] args) {
        Athlete rabbit = new Athlete("兔子", 30, 10, 1000);
        Athlete turtle = new Athlete("乌龟", 30, 100, 10);

        rabbit.start();
        turtle.start();

        while (true) {
            if (rabbit.isEnded() || turtle.isEnded()) {
                turtle.interrupt();
                rabbit.interrupt();

                turtle.setStoped(true);
                rabbit.setStoped(true);
                break;
            }
        }



//        try {
//            rabbit.join(); //阻塞main
//            turtle.join(); //阻塞main
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        if (rabbit.isEnded() && turtle.isEnded()) System.out.println("平局");
        else if (rabbit.isEnded()) System.out.println(rabbit.getName() + "赢了");
        else System.out.println(turtle.getName() + "赢了");
    }
}

class Athlete extends Thread {
    private int distance;
    private long millsPerMeter;
    private long restPerTenMeter;
    private long runtime;
    private volatile boolean ended;
    private boolean stoped;

    public Athlete(String name, int distance, long millsPerMeter, long restPerTenMeter) {
        super(name);
        this.distance = distance;
        this.millsPerMeter = millsPerMeter;
        this.restPerTenMeter = restPerTenMeter;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int i;
        for (i = 1; i <= distance && !stoped; i++) {
            try {
                Thread.sleep(millsPerMeter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "跑了" + i + "米");
            if (i < distance && i % 10 == 0) {
                System.out.println(getName() + "休息中...");
                try {
                    Thread.sleep(restPerTenMeter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        runtime = end - start;
        if (i >= distance) ended = true;
    }

    public long getRuntime() {
        return runtime;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }
}
import javax.sound.sampled.SourceDataLine;

public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        Season[] all = Season.values();

    }

}

class Gender {
    private String description;
    // public 使得外面可以直接访问
    // static 使得可以使用类名访问
    // final 使得对象不可变
    public static final Gender MALE = new Gender("男");
    public static final Gender FEMALE = new Gender("女");


    private Gender(String description) {
        this.description = description;
    }
}

interface Inter {
    void test();
}

enum Season implements Inter {
    SPRING("春暖花开") {
        @Override
        public void test() {
        System.out.println("这是个春季");
    }
    }, SUMMER("夏季") {
        @Override
        public void test() {
        System.out.println("这是个夏季");
    }
    }, FALL {
        @Override
        public void test() {
        System.out.println("这是个秋季");
    }
    }, WINTER {
        @Override
        public void test() {
        System.out.println("这是个冬季");
    }
    };

    private String description;

    private Season() {}

    private Season(String description) {
        this.description = description;
    }

}       
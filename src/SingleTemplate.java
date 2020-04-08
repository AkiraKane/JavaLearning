public class SingleTemplate {
    public static void main(String[] args) {
//        SingleClass s1 = SingleClass.INSTANCE;
//        SingleClass s2 = SingleClass.INSTANCE;
//        System.out.println(s1 == s2);
//        SingleClass2 s3 = SingleClass2.getInstance();
//        SingleClass2 s4 = SingleClass2.getInstance();
//        System.out.println(s3 == s4);
    }
}

enum SingleEnum {
    INSTANCE
}

class SingleClass {
    public static final SingleClass INSTANCE = new SingleClass();
    private SingleClass() {

    }
}

class SingleClass2 {
    private static final SingleClass2 INSTANCE = new SingleClass2();
    private SingleClass2() {
    }
    public static SingleClass2 getInstance() {
        return INSTANCE;
    }
}

class LazyClass {
    private volatile static LazyClass instance;
    private LazyClass() {}

    // 有线程安全问题
//    public static LazyClass getInstance() {
//        if (instance == null) instance = new LazyClass(); //线程安全问题
//        return instance;
//    }

    // 安全没问题，性能不是最优
//    public synchronized static LazyClass getInstance() {
//        if (instance == null) instance = new LazyClass();
//        return instance;
//    }

    public static LazyClass getInstance() {
        if (instance == null) { //提高效率
            synchronized (LazyClass.class) { //当前类的Class对象
                if (instance == null) instance = new LazyClass(); //安全判断
            }
        }
        return instance;
    }
}

class LazyClass2 {
    private LazyClass2() {}

    private static class Inner {
        public static final LazyClass2 INSTANCE = new LazyClass2();
    }

    public static LazyClass2 getInstance() {
        return Inner.INSTANCE;
    }
}
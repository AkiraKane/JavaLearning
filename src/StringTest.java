
public class StringTest {

}

interface A {
    public default void test() {}
}

interface B {
    public default void test() {}
}

class C implements A, B {
    public void test() {
        A.super.test(); // 保留A接口的默认方法实现
    }
}

class D implements A, B {
    public void test() {
        System.out.println("D");; // 直接重写
    }
}

class Father {
    public void test() {}
}

class Son extends Father implements A {
    // 默认选择

    // 选择接口
    public void test() {
        A.super.test();
    }
}
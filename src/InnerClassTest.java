import java.util.Arrays;
import java.util.Comparator;

public class InnerClassTest {
    public void method() {
        class InnerClass {} // 局部内部类

    }
    public static void main(String[] args) {
        
        // 可以把匿名内部类的对象赋值一个变量
        // 多态引用
        Object obj = new Object() {
            public void test() {
                System.out.println("Hello World");
            }
        };

        // 用对象直接调用方法
        new Object() {
            public void test() {
                System.out.println("Hello World");
            }
        }.test();

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Circle c1 = (Circle) o1;
                Circle c2 = (Circle) o2;
                if (c1.getRadius() > c2.getRadius()) return 1;
                else if (c1.getRadius() < c2.getRadius()) return -1;
                return 0;
            }
        };
        Circle[] circles = new Circle[5];
        Arrays.sort(circles, c);
        Arrays.sort(circles, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Circle c1 = (Circle) o1;
                Circle c2 = (Circle) o2;
                if (c1.getRadius() > c2.getRadius()) return 1;
                else if (c1.getRadius() < c2.getRadius()) return -1;
                return 0;
            }
        });

        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}

class Outer {
    static class StaticInner {}
    class Inner {}

    public Inner getInner() {
        return new Inner();
    }
}
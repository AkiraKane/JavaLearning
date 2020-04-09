/*
1. 接口
    行为标准
2. 如何声明接口
    权限修饰符 interface 接口名{}
    2.1. 接口成员
        2.1.1. 全局静态常量：public static final
            为什么是常量？
3. 如何去实现接口

不是一个父类派生出来的，但是这些类都具有相同的行为特征
通过这个接口可以同时管理这些类
 */
public class Interface {
    public static void main(String[] args) {
        Flyable[] sky = new Flyable[3];
        sky[0] = new Bird();
        sky[1] = new Kite();
        sky[2] = new Plane();
        for (Flyable object: sky) {
            object.fly();
        }
    }
}

interface Flyable {
    long MAX_SPEED = 7900000; // public static final instance variable
    void fly(); // public abstract method
}

interface Jump {
    void jump();
}

class Bird implements Flyable, Jump {

    @Override
    public void fly() {
        System.out.println("Bird is flying!");
    }

    @Override
    public void jump() {
        System.out.println("Bird is jumping!");
    }
}

class Kite implements Flyable {

    @Override
    public void fly() {
        System.out.println("Kite is flying!");
    }
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("Plane is flying!");
    }
}

interface A {
    void a();
}

interface B {
    void b();
}

interface C extends A, B {
    void c();
}

class CImplement implements C {

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
    
}
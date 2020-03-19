/*
抽象
1. 什么情况下会用到抽象？
    当声明一个父类时，某个方法的实现不清楚，无法给出具体的实现，要等到具体的子类中才能具体实现，
    这样的方法就可以声明为抽象方法。

2. 抽象方法：没有方法体
    语法格式：其他修饰符 abstract 返回值类型 方法名();

3. 抽象类
    如果一个类包含了抽象方法，那么这个类必须是抽象类
    语法格式：其他修饰符 abstract class 类名 {}

4. 抽象类的特点
    4.1. 抽象类不能实例化
    4.2. 如果子类继承抽象类，必须重写父类所有的抽象方法，否则子类也必须是抽象类
    4.3. 抽象类有构造器，是为子类创建对象服务的
    4.4. 抽象父类与子类之间可以构成多态引用
    4.5. 抽象类中也有可能没有抽象方法
        存在的意义：不希望创建父类的对象，而是创建子类的对象；和为了多态的应用

5. abstract的使用
    5.1. abstract和final不能一起修饰类
    5.2. abstract和final不能一起修饰方法
    5.3. abstract和native不能一起修饰方法
    5.4. abstract和static不能一起修饰方法
    5.4. abstract和private不能一起修饰方法
 */


public class Abstract {
}

abstract class Graphic {
    String name;

    public Graphic(String name) {
        this.name = name;
    }

    public Graphic() {

    }

    public abstract double getArea();
}

class Circle extends Graphic {
    private double radius;
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public Circle() {
        super();
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
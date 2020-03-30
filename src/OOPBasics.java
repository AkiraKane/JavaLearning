/*
封装
1. 封装的类型
	1.1. 属性的封装、方法的封装
	2.1. 组件的封装
	3.1. 系统的封装
2. 哪些可以加权限修饰符
    2.1. 类、属性、方法、构造器、内部类
    2.2. 类：缺省或者public
    2.3. 属性：四种都可以
    2.4. 方法：四种都可以
3. 属性的封装
    大多数情况下是private
4. 方法的封装
    大多数情况下是public
 */

/*
可见范围	本类	本包	其他包子类	所有位置
private	    v	    x	    x	        x
缺省	    v	    v	    x	        x
protected	v	    v	    v	        x
public	    v	    v	    v	        v
 */

import java.util.Arrays;

class  Encapsulation {

}

/*
继承
1. 为什么要有继承？
	1.1. 当某个类，需要派生出很多子类别
	1.2. 当多个类出现共同特征又不完全相同时，可以把共同部分抽取到父类
2. 继承的特点：
	2.1. 子类会继承父类所有的特征，但是父类中私有的属性、方法在子类中不能直接使用
	2.2. 子类继承父类时，构造器是不能被继承的
	2.3. 子类继承父类时，在子类的构造器中一定会去调用父类的构造器，默认情况下调用的是父类的无参构造器
	2.4. 如果父类没有无参构造器，那么在子类的构造器首行，必须手动调用父类的有参构造
	2.5. Java只支持单继承，即一个Java类只有一个直接父类。子类可以扩展父类没有的属性和方法
3. 继承之方法重写（override）
    当子类继承了父类的方法，但是父类的方法体不适用于子类了，子类可以选择进行重写
    3.1. 重写的要求
        3.1.0. 哪些方法不能被重写
            1）static方法不能被重写（在编译期间就已经确定了，不需要再运行时动态绑定）
            2）private方法不能被重写（在子类中不可见）
            3）final方法不能被重写
            4）如果跨包，修饰符缺省也不能被重写
	    3.1.1. 方法名：必须和父类被重写的方法名相同
	    3.1.2. 形参列表：必须和父类被重写的形参列表相同
	    3.1.3. 返回值类型：
	        基本数据类型和void -> 要求与父类被重写的方法的返回值相同
	        引用数据类型 -> 要求子类重写的方法的返回值类型 <= 父类被重写的方法的返回值类型
	    3.1.4. 修饰符
            权限修饰符-> 要求子类重写的方法的权限修饰符的可见性范围 >= 父类被重写的方法的权限修饰符的可见性范围
4. super的用法
    要求：super只能访问父类中可见的属性、方法和构造器
    用法：
	    4.1. super.property
	    4.2. super.method
	        当在子类中需要调用父类被重写的方法时，可以使用
	    4.3. super(). super(实参列表)
            调用父类的无参构造或有参构造
 */

class Inheritance {

}

/*
多态
1. 好处：使得程序员编写代码更加灵活

2. 前提：（1）继承（2）重写（3）多态引用
        和属性无关，只和方法有关

3. 变量的引用形式：
	3.1. 本态引用：左边的变量与右边的对象是同一种类型
	3.2. 多态引用：左边的变量是父类，右边的对象是子类

4. 多态表现出来的特征：编译类型与运行时的类型不一致
	4.1. 编译的时候，按照父类的类型进行编译的（没法调用子类的方法，因为没有编译）
	4.2. 执行的方法，按照子类运行，是子类重写的方法
 */

/*
多态的应用
1. 多态数组
    数组的元素是父类的类型，实际存储的是子类的对象
    用这样的数组，可以统一管理所有子类的对象
2. 多态参数
    形参是父类的类型，实参是子类的对象
 */


class Polymorphism {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        Rectangle[] rectangles = new Rectangle[3];
        Graphic[] graphics = new Graphic[3]; // 可以存储各种图形对象
        graphics[0] = new Circle(1.2);
        Graphic g1 = new Rectangle(2, 4); //多态
        graphics[1] = g1;
    }
    // Polymorphism
    public static void check(Animal animal) {
        animal.eat();
    }

    // Overload
    public static void check(Dog dog) {
        dog.eat();
    }
    public static void check(Cat cat) {
        cat.eat();
    }


    static class Animal {
        public void eat() {
            System.out.println("EAT");
        }
    }
    static class Dog extends Animal {
        public void eat() {
            System.out.println("EAT BONES");
        }

    }
    static class Cat extends Animal {
        public void eat() {
            System.out.println("EAT FISH");
        }
    }

    static class Graphic {
        public double getArea() {
            return 0.0;
        }
    }
    static class Circle extends Graphic {
        private double radius;
        public Circle(double radius) {
            this.radius = radius;
        }
        // Override
        public double getArea() {
            return 3.14 * radius * radius;
        }
    }
    static class Rectangle extends Graphic {
        private double length;
        private double width;
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }
        // Override
        public double getArea() {
            return length * width;
        }
    }
}
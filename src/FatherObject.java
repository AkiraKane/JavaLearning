/*
Object，根父类
如果一个类没有显式声明父类，那么默认这个类的父类是Object

    1. 所有对象（包括数组）都实现这个类的方法
    2. 所有类的对象的实例化过程，都会调用Ojbect的实例初始化方法
    3. 所有的对象都可以赋值给Object的变量
 */

/*
Object类型的方法
    1. public String toString()
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        建议重写
    2. public final Class getClass()：返回此Object的运行时类
    3. protected void finalize()：留临终遗言
        3.1. Java程序员无法确定具体哪个时间会调用
        3.2. 是由GC调用的
        3.3. 每一个对象，finalize()只能被调用一次
            如果某个对象再被回收之前复活了，那么再死的时候，就不会调用finalize()
            当我们再finalize()方法种又让一个引用指向了当前对象this，那么这个对象就会复活
    4. public int hashCode()：支持此方法是为了提高哈希表的性能
        理想状态下，每一个对象有唯一的哈希值。
        如果两个对象哈希值不同，则这两个对象一定“不相等”
        如果哈希值相同，则需要判断。
    5. public boolean equals(Object obj)
        没有重写的情况下，等价于“==”，比较的是对象的地址值
        可以选择重写，要求如下：
        1）重写equals就要重写hashcode
            原因：
                如果两个对象调用equals方法返回true，那么这两个对象的hashCode值必须相等
                如果两个对象的hashCode值不同，那么调用equals方法必须是false
                如果两个对象的hashCode值相同，那么调用equals方法可能true可能false
            遵顼原则：
                自反性、对称性、传递性、一致性、对于任何非空引用值x与null比较必定返回false
 */

/*
instanceOf
    obj 必须为引用类型，不能是基本类型
 */

import java.util.Objects;

public class FatherObject {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FatherObject)) return false;
        FatherObject that = (FatherObject) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = "Hello";
        String s4 = "Hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

    }

}


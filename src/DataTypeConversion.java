/*
数据类型的转换
1. 基本数据类型的转换
    1.1. 自动类型转换
        byte -> short -> int -> long -> float -> double
                 char ->
        boolean不参与
    1.2. 强制类型转换
        double -> float -> long -> int -> short -> byte
                                       -> char
2. 引用数据类型
    2.1. 编译期间父子类之间的转换
        2.1.1. 向上转型（Upcasting）：子类 -> 父类 | 把子类的变量赋值给父类的变量
            一旦向上转型后，只能调用父类的方法。
        2.1.2. 向下转型（DownCasting）：父类 -> 子类 | 把父类的变量赋值给子类的变量
            为了想要调用子类特有的方法
            要想转型成功，必须保证变量中保存的对象运行时类型 <= 强转的类型
            instanceof 运算符
 */


public class DataTypeConversion {
    public static void main(String[] args) {
        // 向上转型
        Person person = new Woman(); // 多态引用
        // 向下转型
        Woman woman = (Woman) person;
    }

    static class Person {

    }

    static class Woman extends Person {

    }

    static class Man extends Person {

    }
}

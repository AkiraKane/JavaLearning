/*
1. 变量分类
    1.1. 成员变量
        类变量：静态的成员变量
        实例变量：非静态的成员变量
    1.2. 局部变量

2. 区别
    2.1. 声明的位置
        2.1.1. 成员变量：类中，方法外
        2.1.2. 局部变量：方法()形参列表，方法体{}中的局部变量，代码块中的局部变量
    2.2. 内存中存储位置
        2.2.1. 成员变量
            类变量：方法区
            实例变量：堆
        2.2.2. 局部变量
            native方法的局部变量：本地方法栈
            非native方法的局部变量：虚拟机栈
    2.3. 修饰符
        2.3.1. 成员变量：4种权限修饰符、static、final
        2.3.2. 局部变量：final
    2.4. 生命周期
        2.4.1. 成员变量
            类变量：随着类的加载而分配空间，随着类的卸载而消亡
            实例变量：随着对象的创建而分配空间，随着对象被垃圾回收而回收
        2.4.2. 局部变量
            方法调用时，在栈种分配空间，方法调用结束就消亡
    2.5. 作用域
        2.5.1. 成员变量
            类变量：在本类中随便用，在其他类中用Class.variable
            实例变量：在静态成员种不能用，在其它类中用Object.variable
        2.5.2. 局部变量
            超过作用域就不能用了
 */

public class Variable {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i: arr) {
            System.out.println("Hello");
        }
    }
}
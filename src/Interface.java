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
}

interface Flyable {
    public static final long MAX_SPEED = 7900000;
}

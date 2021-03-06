/*
栈存储的是局部变量
堆存储的是对象

new表示再堆中新建一块新的空间，用来存储“对象”
array是引用数据类型，表示引用堆中的这个对象的变量
引用数据类型的初始默认值是null

数组名中存储的是数组在堆中的首地址
下标表示的是这个元素的位置距离首地址的偏移量
 */

/*
对象数组
Circle[] arr = new Circle[5]; new创建的是数组对象
arr[0] = new Circle(); 创建了一个圆对象
 */

/*
1. 变量的分类：
	1.1. 成员变量：类中，方法外
	1.2. 局部变量：方法中，包括形参和方法体中的变量

2. 内存中的位置不同：
	2.1. 成员变量：堆
	2.2. 局部变量：栈

3.初始化不同：
	3.1. 成员变量：没有初始化会有默认真
	3.2. 局部变量：没有初始化会报错

4. 生命周期不同：
	4.1. 成员变量：随着对象的创建而分配，随着对象被垃圾回收而回收
	4.2. 局部变量：方法被调用直到结束

5. 可用的修饰符：
	5.1. 成员变量
    5.2. 局部变量：唯一的为final
 */

public class StackHeap {
}

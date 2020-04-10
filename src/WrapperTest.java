
public class WrapperTest {
    public static void main(String[] args) {

        Integer a = 120;
        Integer b = 120;
        // a和b比较的是地址值，但指向的是同一个缓存的常量对象
        System.out.println(a == b); // true

        Integer c = 130;
        Integer d = 130;
        // c和d比较的是地址值，但都是堆中新建的Integer对象
        System.out.println(c == d); // false
    
    }

}
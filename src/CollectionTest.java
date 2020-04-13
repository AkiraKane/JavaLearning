import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("Shuobai");
        c.add("Hezijian");
        c.add("Minhao");

        Iterator iterator = c.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

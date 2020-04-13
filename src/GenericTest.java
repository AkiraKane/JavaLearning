import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        // public static <T> List<T> asList(T... a)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<int[]> list2 = Arrays.asList(new int[]{1, 2, 3});

        // public <T> T[] toArray(T[] a)
        ArrayList<String> arr0 = new ArrayList<>();
        arr0.add("wtf");
        arr0.add("this");
        arr0.add("is");
        String[] res0 = arr0.toArray(new String[]{});

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        Integer[] res1 = arr1.toArray(new Integer[0]);

        ArrayList<int []> arr2 = new ArrayList<>();
        arr2.add(new int[]{1, 2});
        arr2.add(new int[]{3, 4});
        arr2.add(new int[]{5, 6});
        int[][] res2 = arr2.toArray(new int[][]{});

        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("wtf");
        arr3.add("this");
        arr3.add("is");
        String[] help = new String[]{"1", "2", "3", "4", "5", "6"};
        String[] res3 = arr0.toArray(help);
        for (String str: res3) System.out.println(str);
        System.out.println("END");
        
    }
}
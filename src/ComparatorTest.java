import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Student s1 = new Student("Hezijian", 24, 89);
        Student s2 = new Student("Shuobai", 25, 96);
        AgeComparator comparator = new AgeComparator();
        System.out.println(comparator.compare(s1, s2));
        Student[] students = new Student[5];
        students[0] = s1;
        students[1] = s2;
        students[2] = new Student("Farmer", 27, 82);
        students[3] = new Student("Justin", 32, 87);
        students[4] = new Student("Blake", 45, 92);
        Arrays.sort(students, comparator);
        Arrays.sort(students);
    }
    
}

class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // (1) 向下转型
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        // (2) 开始比较
        if (s1.getAge() > s2.getAge()) return 1;
        else if (s1.getAge() < s2.getAge()) return -1;
        return 0;
    }

}


class Student implements Comparable {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    
    public Student() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return this.getScore() - other.getScore();
    }
}
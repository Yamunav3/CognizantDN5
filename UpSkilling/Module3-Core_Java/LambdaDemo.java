import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        list.add("ammu");
        list.add("zoo");
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        System.out.println(list);
    }
}
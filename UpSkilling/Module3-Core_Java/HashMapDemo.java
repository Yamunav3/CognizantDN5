import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(101, "Yamuna");
        map.put(102, "Ram");

        System.out.println(map.get(101));
    }
}
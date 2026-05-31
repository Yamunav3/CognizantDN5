import java.util.*;
import java.util.stream.*;

record Person(String name, int age) {
}

public class RecordDemo {
    public static void main(String[] args) {

        Person p1 = new Person("Yamuna", 20);
        Person p2 = new Person("Ram", 17);
        Person p3 = new Person("Sita", 22);

        System.out.println("Individual Records:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> people = Arrays.asList(p1, p2, p3);

        System.out.println("\nPeople age >= 18:");

        people.stream()
                .filter(person -> person.age() >= 18)
                .forEach(System.out::println);
    }
}
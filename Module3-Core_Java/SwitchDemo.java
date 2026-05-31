
public class SwitchDemo {

    static void test(Object obj) {

        switch (obj) {
            // old style
            // case Integer i:
            // System.out.println("Integer");
            // break;
            // case String s:
            // System.out.println("String");
            // break;
            // default:
            // System.out.println("Other");

            // new style
            case Integer i ->
                System.out.println("Integer");

            case String s ->
                System.out.println("String");

            case Double d ->
                System.out.println("Double");

            default ->
                System.out.println("Other");
        }
    }

    public static void main(String[] args) {
        test("Hello");
        test("1");
        test(1);
        test(1.0);
    }
}
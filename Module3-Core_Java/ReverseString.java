import java.util.Scanner;

class ReverseString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        System.out.println();

        StringBuilder sb = new StringBuilder(s);

        System.out.println(sb.reverse());
        sc.close();
    }
}
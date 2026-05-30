import java.util.Random;
import java.util.Scanner;

class GuessGame {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int secret = rand.nextInt(100) + 1;

        while (true) {

            int guess = sc.nextInt();

            if (guess > secret)
                System.out.println("Too High");
            else if (guess < secret)
                System.out.println("Too Low");
            else {
                System.out.println("Correct!");
                break;
            }
        }
        sc.close();
    }
}
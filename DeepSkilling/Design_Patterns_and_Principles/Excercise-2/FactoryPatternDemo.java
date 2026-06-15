import java.util.*;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Notification Type");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Message: ");
        String message = sc.nextLine();

        NotificationCreator creator = null;

        switch (choice) {

            case 1:
                creator = new EmailCreator();
                break;

            case 2:
                creator = new SMSCreator();
                break;

            case 3:
                creator = new PushCreator();
                break;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }
        System.out.println("Sending Notification...");
        creator.notifyUser(message);
        sc.close();
    }
}
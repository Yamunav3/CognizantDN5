public abstract class NotificationCreator {

    // Factory Method
    public abstract Notification createNotification();

    // Business Logic
    public void notifyUser(String message) {

        System.out.println(createNotification().send(message));
    }
}
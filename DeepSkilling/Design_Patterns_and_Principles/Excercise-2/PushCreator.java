public class PushCreator extends NotificationCreator {

    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
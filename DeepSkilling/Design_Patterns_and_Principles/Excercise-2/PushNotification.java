public class PushNotification implements Notification {

    @Override
    public String send(String message) {
        return "[PUSH] Sent to device: " + message;
    }


}
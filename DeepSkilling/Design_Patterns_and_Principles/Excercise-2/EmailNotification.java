public class EmailNotification implements Notification {

    @Override
    public String send(String message) {
        return "[EMAIL] Sent to inbox: " + message;
    }

}
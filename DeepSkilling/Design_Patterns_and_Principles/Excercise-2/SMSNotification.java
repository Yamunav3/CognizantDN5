public class SMSNotification implements Notification {

    @Override
    public String send(String message) {
        return "[SMS] Sent to phone: " + message;
    }

    
}
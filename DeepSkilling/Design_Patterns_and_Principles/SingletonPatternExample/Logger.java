
package DeepSkilling.Design_Patterns_and_Principles.SingletonPatternExample;

//  Singleton Class

public class Logger {

    private static Logger instance = null;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
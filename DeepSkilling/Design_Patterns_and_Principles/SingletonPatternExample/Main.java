
package DeepSkilling.Design_Patterns_and_Principles.SingletonPatternExample;
//Test Class
public class Main {

    public static void main(String[] args) {

        System.out.println("===== Singleton Pattern - Logger =====\n");

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in.");

        Logger logger3 = Logger.getInstance();
        logger3.log("Data fetched successfully.");

        System.out.println("\n--- Verifying Single Instance ---");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("Only ONE instance of Logger exists. Singleton verified!");
        }
    }
}
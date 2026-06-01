
import java.lang.reflect.*;

public class ReflectionApi {

    public static void main(String[] args) {

        try {

            // Load class dynamically
            Class<?> cls = Class.forName("Car");

            System.out.println("Class Name: "
                    + cls.getName());

            // Print all methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("\nMethods:");

            for (Method m : methods) {

                System.out.println(
                        m.getName());

                Parameter[] params = m.getParameters();

                System.out.println(
                        "Parameters: "
                                + params.length);
            }

            // Create object
            Object obj = cls.getDeclaredConstructor()
                    .newInstance();

            // Invoke method
            Method method = cls.getDeclaredMethod(
                    "displayDetails");

            method.invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
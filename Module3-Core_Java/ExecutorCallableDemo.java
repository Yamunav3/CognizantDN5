import java.util.concurrent.*;

public class ExecutorCallableDemo {

        public static void main(String[] args)
                        throws Exception {

                ExecutorService executor = Executors.newFixedThreadPool(3);

                Callable<Integer> task1 = () -> {
                        return 10 * 10;
                };

                Callable<Integer> task2 = () -> {
                        return 20 * 20;
                };

                Callable<Integer> task3 = () -> {
                        return 30 * 30;
                };

                Future<Integer> future1 = executor.submit(task1);

                Future<Integer> future2 = executor.submit(task2);

                Future<Integer> future3 = executor.submit(task3);

                System.out.println(
                                "Result 1: " + future1.get());

                System.out.println(
                                "Result 2: " + future2.get());

                System.out.println(
                                "Result 3: " + future3.get());

                executor.shutdown();
        }
}
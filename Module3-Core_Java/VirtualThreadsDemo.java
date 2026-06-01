public class VirtualThreadsDemo {

        public static void main(String[] args)
                        throws InterruptedException {

                long startTime = System.currentTimeMillis();

                for (int i = 1; i <= 100000; i++) {

                        int id = i;

                        Thread.startVirtualThread(() -> {

                                System.out.println(
                                                "Virtual Thread : "
                                                                + id);

                        });
                }

                Thread.sleep(5000);

                long endTime = System.currentTimeMillis();

                System.out.println(
                                "\nTime Taken: "
                                                + (endTime - startTime)
                                                + " ms");
        }
}

//thread by implementing runnable interface

// public class ThreadDemo implements Runnable {
//     public void run() {
//         for (int i = 1; i <= 5; i++)
//             System.out.println(Thread.currentThread().getName());
//     }

//     public static void main(String[] args) {
//         Thread t1 = new Thread(new ThreadDemo());
//         t1.start();
//         Thread t2 = new Thread(new ThreadDemo());
//         t2.start();
//     }

//thread by extending thread class
class Thread1 extends Thread {
    public void run() {
        for (int i = 1; i < 5; i++)
            System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread1 t2 = new Thread1();
        t2.start();
    }
}
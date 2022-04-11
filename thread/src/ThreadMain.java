
class CustomizedThread extends Thread {
    @Override
    public void run() {
        int i;
        for(i = 1; i <= 2; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

public class ThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + " start");
        CustomizedThread th1 = new CustomizedThread();
        CustomizedThread th2 = new CustomizedThread();
        th1.start();
        th2.start();

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3 thread run");
            }
        });
        th3.run();
        Runnable th4 = new Runnable() {
            @Override
            public void run() {
                System.out.println("4 thread run");
            }
        };
        th4.run();

        System.out.println(Thread.currentThread() + "end");
    }
}

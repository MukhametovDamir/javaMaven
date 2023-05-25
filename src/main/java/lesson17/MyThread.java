package lesson17;

public class MyThread extends Thread {
    @Override
    public void run() {

        Thread.currentThread().setName("MyThread");
        for (int i = 100; ; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(150);

                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);


            }
        }

    }
}

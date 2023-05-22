package lesson17;

public class Pevec1 extends Thread {
    private int count = 5;

    public Pevec1() {
    }

    public Pevec1(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int j = 0;
        while (true) {
            //лог певец 1 начал петь
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("La_la_____________");
                    //слодная логика
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MIKROFON) {
                //лог певец 1 передал микрофон
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {
                    //лог певец ждет
                    Monitors.MIKROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}

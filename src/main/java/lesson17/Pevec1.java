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
            //��� ����� 1 ����� ����
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("La_la_____________");
                    //������� ������
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MIKROFON) {
                //��� ����� 1 ������� ��������
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {
                    //��� ����� ����
                    Monitors.MIKROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}

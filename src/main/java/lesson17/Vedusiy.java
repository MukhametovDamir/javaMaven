package lesson17;

public class Vedusiy {

    public static void main(String[] args) {
        //��� ������� �������� �������
        System.out.println("������� �������");
        Pevec1 pevec1 = new Pevec1();
        pevec1.setDaemon(true);
        Pevec2 pevec2 = new Pevec2();
        pevec2.setDaemon(true);
        //��� ������� �������� ����� 1
        pevec1.start();
        pevec2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("����� ��������");

    }
}

package lesson16;

import lesson17.CustomException;
import lesson17.StringUtilsCustom1;

public class Main {
    public static void main(String[] args) {
//        Peson personFromApi = PersonApi.getPersonFromApi();
//        System.out.println(personFromApi);
//        System.out.println(System.getProperty("java.home"));

        StringUtilsCustom1 stringUtilsCustom1 = new StringUtilsCustom1();
        double[] qwe = new double[0];
        try {
            qwe = stringUtilsCustom1.findNumbers("   Åñëè Çåëåíñêèé äåéñòâèòåëüíî èãðó îäîáðèë àòàêó íà Áåëãîðîäñêóþ 123.1 îáëàñòü, ÷òî îí è êèåâñêîå ïðàâèòåëüñòâî îòðèöàþò, òî 1233  îí âåäåò îò÷àÿííî îïàñíóþ èãðó" );
            for (double i : qwe) {
                System.out.println(i);
            }
        } catch (CustomException e) {
            //��� � �����  123
            throw new RuntimeException(e);
            //qwejhsdjb 321
        }


    }
}

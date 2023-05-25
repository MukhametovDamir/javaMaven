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
            qwe = stringUtilsCustom1.findNumbers("   ≈сли «еленский действительно игру одобрил атаку на Ѕелгородскую 123.1 область, что он и киевское правительство отрицают, то 1233  он ведет отча€нно опасную игру" );
            for (double i : qwe) {
                System.out.println(i);
            }
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }


    }
}

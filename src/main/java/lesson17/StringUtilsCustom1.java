package lesson17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsCustom1 implements StringUtils {

    @Override
    public double div(String number1, String number2) throws NullPointerException, NumberFormatException, ArithmeticException {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("number1==null || number2 == null");
        }
        double n1, n2;
        try {
            n1 = Double.parseDouble(number1);
            n2 = Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("number or number2 not number");
        }
        if (n2 == 0) {
            throw new ArithmeticException("number2 = 0");
        }
        return n1 / n2;
    }

    //    @Override
//    public int[] findWord(String text, String word) throws NullPointerException {
//        int count = 0;
//        int index = text.indexOf(word, 0);
//        try {
//            while (index > -1) {
//                index = text.indexOf(word, index + word.length());
//                count++;
//            }
//            int[] ints = new int[count];
//            count = 0;
//            index = text.indexOf(word, 0);
//
//            while (index > -1) {
//                ints[count] = index;
//                index = text.indexOf(word, index + word.length());
//                count++;
//            }
//            return ints;
//        } catch (Exception e) {
//            throw new NullPointerException("Not word in text");
//        }
//    }
    @Override
    public int[] findWord(String text, String word) throws NullPointerException {
        if (text == null || word == null) {
            throw new NullPointerException("text== null||word==null");
        }
        String[] s = text.split(" ");
        int count = 0;
        for (String s1 : s) {
            if (s1.equals(word)) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(word)) {
                res[count] = i;
                count++;
            }
        }
        return res;
    }

    @Override
    public double[] findNumbers(String text) throws CustomException {
        String[] s = text.split(" ");
        double[] res = new double[100];
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            try {
                res[i] = Double.parseDouble(s[i]);
            }
            catch (Exception e){
            }
        }
        return res;
    }
}


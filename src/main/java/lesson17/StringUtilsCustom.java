package lesson17;

public class StringUtilsCustom implements StringUtils {
    @Override
    public double div(String number1, String number2) throws NullPointerException, NumberFormatException, ArithmeticException {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("number1 == null || number2 == null");
        }
        double n1;
        double n2;
        try {
            n1 = Double.parseDouble(number1);
            n2 = Double.parseDouble(number2);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("number 1 or number2 is not number");
        }
        if (n2 == 0) {
            throw new ArithmeticException("n2 == 0");
        }
        return n1 / n2;
    }

    @Override
    public int[] findWord(String text, String word) throws NullPointerException {
        if (text == null || word == null) {
            throw new NullPointerException("text == null || word == null");
        }

        String replacedText = getTextWithoutSymbols(text);
        String[] words = replacedText.split(" ");
        int countWords = countWords(word, words);
        return getArrayWithWordsIndexes(word, words, countWords);
    }

    // заменяет все специальные символы на пусоту, чтобы не сломать счетчик слов в тексте
    // исключает случаи: слово. слово, слово! слово? и прочие.
    private static String getTextWithoutSymbols(String text) {
        String symbols = "[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]";
        return text.replaceAll(symbols, "");
    }

    // считает кол-во слов в строке текста для определения размера будущего массива индексов этих же слов
    private static int countWords(String word, String[] textArray) {
        int countWords = 0;
        for (String s : textArray) {
            if (s.equals(word)) {
                countWords++;
            }
        }
        return countWords;
    }

    // возвращает массив индексов слов в строке
    private static int[] getArrayWithWordsIndexes(String word, String[] textArray, int countWords) {
        int index = 0;
        int[] wordIndexesArray = new int[countWords];
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].equals(word)) {
                wordIndexesArray[index++] = i;
            }
        }
        return wordIndexesArray;
    }

    @Override
    public double[] findNumbers(String text) throws CustomException, NullPointerException {
        if (text == null) {
            throw new NullPointerException("text == null");
        }
        String[] words = text.split(" ");
        int countNumbers = countNumbers(words);
        if (countNumbers == 0) {
            throw new CustomException("Not Found. countNumbers == 0");
        }
        return getArrayWithDoubleNumbers(words, countNumbers);
    }

    // считает кол-во чисел в строке текста для определения размера будущего массива этих же чисел
    private static int countNumbers(String[] words) {
        int countNumbers = 0;
        for (String word : words) {
            if (isNumber(word)) {
                countNumbers++;
            }
        }
        return countNumbers;
    }

    // возвращает массив типа double с цифрами из текстовой строки
    private static double[] getArrayWithDoubleNumbers(String[] words, int countNumbers) {
        int index = 0;
        double[] array = new double[countNumbers];
        for (String word : words) {
            if (isNumber(word)) {
                String unparsed = correctNumber(word);
                double numberDouble = Double.parseDouble(unparsed);
                array[index++] = numberDouble;
            }
        }
        return array;
    }

    // берет слово и проверет, содержит ли оно вообще числа и стоит ли пытаться его парсить
    private static boolean isNumber(String string) {
        String numbers = "1234567890";
        for (int i = 0; i < string.length(); i++) {
            String symbol = String.valueOf(string.charAt(i));
            if (numbers.contains(symbol)) {
                return true;
            }
        }
        return false;
    }

    // коррекция числа которое записано некорректно и это помешает ему спарситься, если оно:
    // с , вместо . (2,3 вместо 2.3) [числа с , не парсятся в Double.parseDouble(), необходимо заменять , на .]
    // содержит точку или запятую на конце (2.3. или 2.3,)
    // содержит прочие приписки к нему (2.3-, 2.3qwe и прочие)
    private static String correctNumber(String word) {
        String availableSymbols = "1234567890.,";
        if (isNumber(word)) {
            if (word.lastIndexOf(".") == word.length() - 1) {
                word = word.replace(".", "");
            }
            if (word.lastIndexOf(",") == word.length() - 1) {
                word = word.substring(0, word.lastIndexOf(","));
            }
            if (word.contains(",")) {
                word = word.replace(",", ".");
            }
            if (!word.contains(availableSymbols)) {
                String[] letters = word.split("");
                for (String letter : letters) {
                    if (!availableSymbols.contains(letter)) {
                        word = word.replace(letter, "");
                    }
                }
            }
        }
        return word;
    }
}

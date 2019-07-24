package com.tavisca.workshops.MerchantGalaxy;

import java.util.HashMap;

public class ArabicNumeralToRomanParser {

    private HashMap<Integer, String> numberToRoman
            = new HashMap<>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");

    }};

    public String Parse(int arabicNumeral) {

        String romanNumber = "";
        while (arabicNumeral > 0) {
            int count = countDigits(arabicNumeral);
            int divisor = (int) Math.pow(10, count - 1);
            int mostSignificantDigit = arabicNumeral / divisor;


            if (mostSignificantDigit <= 3) {
                for (int i = 0; i < mostSignificantDigit; i++) {
                    romanNumber += numberToRoman.get(divisor);
                    ;
                }

            } else if (mostSignificantDigit == 4) {
                romanNumber += numberToRoman.get(divisor) + numberToRoman.get(divisor * 5);

            } else if (mostSignificantDigit <= 8) {
                romanNumber += numberToRoman.get(divisor * 5);
                for (int i = 0; i < mostSignificantDigit - 5; i++) {
                    romanNumber += numberToRoman.get(divisor);
                }

            } else if (mostSignificantDigit == 9) {
                romanNumber += numberToRoman.get(divisor) + numberToRoman.get(divisor * 10);

            } else {

            }
            arabicNumeral = arabicNumeral % divisor;
        }
        return romanNumber;
    }

    private int countDigits(int arabicNumeral) {
        int number = arabicNumeral;
        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }
        return count;
    }
}

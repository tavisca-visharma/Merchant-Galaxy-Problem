package com.tavisca.workshops.MerchantGalaxy;

import java.text.DecimalFormat;

public class MetalToCreditParser {
    public Object[] Parse(String languageStatement) {

        String[] metalToCredits = languageStatement.split(" is ");
        String[] words = metalToCredits[0].split(" ");
        String[] credits = metalToCredits[1].split(" ");


        Object[] resultedRomanWithValue = calculateWordsValueCount(words);
        String resultedRomanNumeral = (String)resultedRomanWithValue[0];
        double wordsValueCount = (double)resultedRomanWithValue[1];
//        System.out.println("wordsValueCount = " + wordsValueCount);

        if(RomanValidator.validateRomanNumeral(resultedRomanNumeral) == false){
            System.out.println("resultedRomanNumeral = " + resultedRomanNumeral);
            throw new RuntimeException("Invalid Roman Numeral");
        }

        String metal = words[words.length - 1];
        double givenCreditsOfMetal = Double.parseDouble(credits[0]);

        String creditOfMetal = getCreditsOfMetal(wordsValueCount, metal, givenCreditsOfMetal);

        MetalToCreditsMapper.addMetalWithCredits(metal, Double.parseDouble(creditOfMetal));

        return new Object[]{metal, creditOfMetal};
    }

    private String getCreditsOfMetal(double wordsValueCount, String metal, double givenCreditsOfMetal) {

        String pattern = "###########.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        double creditOfMetal = givenCreditsOfMetal / wordsValueCount;
        return decimalFormat.format(creditOfMetal);
    }

    public static Object[] calculateWordsValueCount(String[] words) {
        double valueCount = 0;
        double max = Double.MIN_VALUE;
        String resultedRoman = "";
        for (int i = words.length - 2; i >= 0; i--) {
            resultedRoman = WordToRomanMapper.getRomanNumeralOfTheWord(words[i]) + resultedRoman;
            double currentLiteralValue = MetalToCreditsMapper.getMetalCredits(words[i]);
            if (currentLiteralValue < max) {
                valueCount -= currentLiteralValue;
            }
            else {
                valueCount += currentLiteralValue;
                max = currentLiteralValue;
            }
        }
        return new Object[] { resultedRoman , valueCount};
    }
}

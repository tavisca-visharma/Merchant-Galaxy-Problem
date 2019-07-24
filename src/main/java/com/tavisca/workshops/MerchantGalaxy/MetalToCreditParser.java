package com.tavisca.workshops.MerchantGalaxy;

import java.text.DecimalFormat;

public class MetalToCreditParser {
    public Object[] Parse(String languageStatement) {

        String[] metalToCredits = languageStatement.split(" is ");
        String[] words = metalToCredits[0].split(" ");
        String[] credits = metalToCredits[1].split(" ");


        double wordsValueCount  = calculateWordsValueCount(words);

        String metal = words[words.length - 1];
        double givenCreditsOfMetal = Double.parseDouble(credits[0]);

        double creditOfMetal = Double.parseDouble(getCreditsOfMetal(wordsValueCount, metal, givenCreditsOfMetal));

        return new Object[]{metal, creditOfMetal};
    }

    private String getCreditsOfMetal(double wordsValueCount, String metal, double givenCreditsOfMetal) {

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        double creditOfMetal = givenCreditsOfMetal / wordsValueCount;
        return decimalFormat.format(creditOfMetal);
    }

    private double calculateWordsValueCount(String[] words) {
        return 1;
    }
}

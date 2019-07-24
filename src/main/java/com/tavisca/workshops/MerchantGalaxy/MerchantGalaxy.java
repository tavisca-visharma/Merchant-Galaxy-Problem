package com.tavisca.workshops.MerchantGalaxy;

import java.util.HashMap;

public class MerchantGalaxy {

    private static HashMap<String, String> wordToRomanNumeral;
    private static HashMap<String, Double> romansToCredits;


    MerchantGalaxy() {
        wordToRomanNumeral = new HashMap<>();

    }

    public String translateWordsToRomanNumerals(String language) {
        String[] wordToRomans = language.split("is");
        wordToRomanNumeral.put(wordToRomans[0].trim(), wordToRomans[1].trim());
//        System.out.println(wordToRomans[0] + " - " + wordToRomans[1] + " = " + wordToRomanNumeral.get(wordToRomans[0]));
        return wordToRomanNumeral.get(wordToRomans[0].trim());
    }

    public double translateRomanNumeralsToCredits(String romanNumber) {
        return 0;
    }
}

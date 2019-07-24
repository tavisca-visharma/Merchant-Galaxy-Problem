package com.tavisca.workshops.MerchantGalaxy;

import java.util.HashMap;

public class WordToRomanMapper {
    private static HashMap<String,String> wordToRoman = new HashMap<>();

    public static void addWordWithRomanNumeral(String word, String romanNumeral){

        wordToRoman.put(word, romanNumeral);

    }

    public static String getRomanNumeralOfTheWord(String word){
        System.out.println("word = " + word + " roman = " + wordToRoman.get(word));
        return wordToRoman.get(word);
    }

}

package com.tavisca.workshops.MerchantGalaxy;

public class WordToRomanParser {
    public String[] Parse(String languageStatement) {
        String wordToRoman[] = languageStatement.split(" is ");
        return new String[]{wordToRoman[0], wordToRoman[1]};
    }
}

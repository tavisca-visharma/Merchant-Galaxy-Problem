package com.tavisca.workshops.MerchantGalaxy.Mapper;

import java.util.HashMap;

public class WordToRomanNumeralMapper implements IMapper {
    private static HashMap<String, String> wordToRomanNumeral;

    WordToRomanNumeralMapper() {
        wordToRomanNumeral = new HashMap<>();
    }

    public boolean selectMapper(String mapperName) {
        return mapperName.equalsIgnoreCase(MappersName.wordToRomanNumeralMapperName);
    }

    public void addItemWithCredits(String item, String romanNumeral) {
        wordToRomanNumeral.put(item,romanNumeral);
    }

    public String get(String item) {
        return wordToRomanNumeral.get(item);
    }

}

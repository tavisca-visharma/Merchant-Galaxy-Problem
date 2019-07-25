package com.tavisca.workshops.MerchantGalaxy.Parsers;

import com.tavisca.workshops.MerchantGalaxy.Mapper.*;
import com.tavisca.workshops.MerchantGalaxy.Validator.RomanValidator;

import java.text.DecimalFormat;

public class MetalToCreditParser implements IParser {

    String[] words;
    String[] credits;
    DecimalFormat decimalFormat;
    Mapper mapper;

    public MetalToCreditParser() {
        String pattern = "###########.###";
        decimalFormat = new DecimalFormat(pattern);
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        mapper = Mapper.getInstance();
    }

    public boolean select(String parserName) {
        return parserName.equalsIgnoreCase(ParserLanguageType.MetalToCredit);
    }

    public Object[] Parse(String languageStatement) {

        convertWordsAndCreditsFromLanguageStatement(languageStatement);

        Object[] resultedRomanWithValue = calculateWordsValueCount(words);
        String resultedRomanNumeral = (String) resultedRomanWithValue[0];
        double wordsValueCount = (double) resultedRomanWithValue[1];

        if (RomanValidator.validateRomanNumeral(resultedRomanNumeral) == false)
            throw new RuntimeException("Invalid Roman Numeral");

        String metal = words[words.length - 1];
        double givenCreditsOfMetal = Double.parseDouble(credits[0]);

        String creditOfMetal = getCreditsOfMetal(wordsValueCount, metal, givenCreditsOfMetal);

        mapper.addItem(MappersName.metalMapperName,metal, creditOfMetal);

        return new Object[]{metal, creditOfMetal};
    }

    private void convertWordsAndCreditsFromLanguageStatement(String languageStatement) {
        String[] metalToCredits = languageStatement.split(" is ");
        this.words = metalToCredits[0].split(" ");
        this.credits = metalToCredits[1].split(" ");
    }

    private String getCreditsOfMetal(double wordsValueCount, String metal, double givenCreditsOfMetal) {
        double creditOfMetal = givenCreditsOfMetal / wordsValueCount;
        return decimalFormat.format(creditOfMetal);
    }

    private Object[] calculateWordsValueCount(String[] words) {
        double valueCount = 0;
        double max = Double.MIN_VALUE;
        String resultedRoman = "";
        for (int i = words.length - 2; i >= 0; i--) {
            resultedRoman = mapper.getItemValue(MappersName.wordToRomanNumeralMapperName,words[i]) + resultedRoman;
            double currentLiteralValue = Double.parseDouble(mapper.getItemValue(MappersName.metalMapperName,words[i]));
            if (currentLiteralValue < max) {
                valueCount -= currentLiteralValue;
            } else {
                valueCount += currentLiteralValue;
                max = currentLiteralValue;
            }
        }
        return new Object[]{resultedRoman, valueCount};
    }

}

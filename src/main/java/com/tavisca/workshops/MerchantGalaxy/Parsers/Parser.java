package com.tavisca.workshops.MerchantGalaxy.Parsers;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<IParser> parsers;
    private static final String TYPE1 = "wordToRomanNumeral";
    private static final String TYPE2 = "metalToCredit";
    private static final String TYPE3 = "questionToAnswer";


    public Parser() {
        parsers = new ArrayList<>();
        parsers.add(new ArabicNumeralToRomanParser());
        parsers.add(new MetalToCreditParser());
        parsers.add(new QuestionToAnswerParser());
        parsers.add(new WordToRomanNumeralParser());
    }

    public Object[] Parse(String languageStatement) {
        String languageType = getLanguageType(languageStatement);
        return Parse(languageType,languageStatement);
    }

    private String getLanguageType(String languageStatement){
        String languageType;
        if (languageStatement.split(" ").length == 3)
            languageType = TYPE1;
        else if (languageStatement.contains("?"))
            languageType = TYPE3;
        else
            languageType = TYPE2;
        return languageType;
    }

    private Object[] Parse(String parserName, String languageStatement) {
        for (int i = 0; i < parsers.size(); i++) {
            if (parsers.get(i).select(parserName) == true) {
                return parsers.get(i).Parse(languageStatement);
            }
        }
        return null;
    }

}

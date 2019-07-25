package com.tavisca.workshops.MerchantGalaxy.Parsers;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<IParser> parsers;
    static Parser parser = null;



    private Parser() {
        parsers = new ArrayList<>();
        parsers.add(new ArabicNumeralToRomanParser());
        parsers.add(new MetalToCreditParser());
        parsers.add(new QuestionToAnswerParser());
        parsers.add(new WordToRomanNumeralParser());
    }

    public static Parser getInstance(){
        if(parser == null)
            parser = new Parser();
        return parser;
    }

    public Object[] Parse(String languageStatement) {
        String languageType = getLanguageType(languageStatement);
        return Parse(languageType,languageStatement);
    }

    private String getLanguageType(String languageStatement){
        String languageType;
        if (languageStatement.split(" ").length == 3)
            languageType = ParserLanguageType.WordToRomanNumeral;
        else if (languageStatement.contains("?"))
            languageType = ParserLanguageType.QuestionToAnswer;
        else
            languageType = ParserLanguageType.MetalToCredit;
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

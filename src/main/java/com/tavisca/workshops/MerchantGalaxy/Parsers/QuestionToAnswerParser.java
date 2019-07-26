package com.tavisca.workshops.MerchantGalaxy.Parsers;

import com.tavisca.workshops.MerchantGalaxy.Mapper.Mapper;
import com.tavisca.workshops.MerchantGalaxy.Mapper.MappersName;
import com.tavisca.workshops.MerchantGalaxy.Validator.RomanValidator;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public class QuestionToAnswerParser implements IParser {

    DecimalFormat decimalFormat;
    String questionType;
    Mapper mapper;

    public QuestionToAnswerParser() {
        decimalFormat = new DecimalFormat("#########.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        mapper = Mapper.getInstance();
    }

    public boolean select(String parserName) {
        return parserName.equalsIgnoreCase(ParserLanguageType.QuestionToAnswer);
    }

    public Object[] Parse(String questionStatement) {

        String[] wordsWhoseValueToCalculate = getWords(questionStatement);

//        System.out.println("questionType = " + questionType + " val = " + wordsWhoseValueToCalculate);
        String valueOfTheWords = null;

        switch (questionType.toLowerCase()) {
            case "much":
                valueOfTheWords = calculateValueOfTheWordsOfMuchTypeStatement(wordsWhoseValueToCalculate,false);
                break;
            case "many":
                valueOfTheWords = calculateValueOfTheWordsOfManyTypeStatement(wordsWhoseValueToCalculate,true);
                break;
        }

        return new Object[]{String.join(" ",wordsWhoseValueToCalculate), valueOfTheWords};
    }

    private String[] getWords(String questionStatement) {
        String[] question = questionStatement.split(" is ");
        String questionType = question[0].split(" ")[1];
        String wordsWhoseValueToCalculate = question[1].substring(0, question[1].length() - 2);

        this.questionType = questionType;

        return wordsWhoseValueToCalculate.split(" ");
    }

    private String calculateValueOfTheWordsOfManyTypeStatement(String[] words, boolean ignoreLastWord) {

        double wordsValue = Double.parseDouble(calculateWordsValueCount(words, ignoreLastWord));
        double metalValue = Double.parseDouble(mapper.getItemValue(MappersName.metalMapperName, words[words.length - 1]));
        return decimalFormat.format(wordsValue * metalValue);
    }

    private String calculateValueOfTheWordsOfMuchTypeStatement(String[] words, boolean ignoreLastWord) {

        return calculateWordsValueCount(words,ignoreLastWord);
    }

    private String calculateWordsValueCount(String[] words, boolean ignoreLastWord) {
        double valueCount = 0;
        double max = Double.MIN_VALUE;
        String resultedRomanNumeral = "";
        int lengthOfWords = (ignoreLastWord) ? (words.length - 2) : (words.length -1);
        for (int i = lengthOfWords; i >= 0; i--) {
            resultedRomanNumeral = mapper.getItemValue(MappersName.wordToRomanNumeralMapperName,words[i]) + resultedRomanNumeral;
            double currentLiteralValue = Double.parseDouble(mapper.getItemValue(MappersName.metalMapperName,words[i]));
            if (currentLiteralValue < max) {
                valueCount -= currentLiteralValue;
            } else {
                valueCount += currentLiteralValue;
                max = currentLiteralValue;
            }
        }
        if (RomanValidator.validateRomanNumeral(resultedRomanNumeral) == false) {
            throw new RuntimeException("Invalid Roman Literal");
        }
        return decimalFormat.format(valueCount);
    }

}

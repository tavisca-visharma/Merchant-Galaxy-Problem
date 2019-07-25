package com.tavisca.workshops.MerchantGalaxy.Parsers;

import com.tavisca.workshops.MerchantGalaxy.Mapper.MetalToCreditsMapper;
import com.tavisca.workshops.MerchantGalaxy.Mapper.WordToRomanMapper;
import com.tavisca.workshops.MerchantGalaxy.Validator.RomanValidator;

import java.text.DecimalFormat;

public class QuestionToAnswerParser implements IParser {

    DecimalFormat decimalFormat;
    String questionType;

    public QuestionToAnswerParser() {
        decimalFormat = new DecimalFormat("#########.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
    }

    public boolean select(String parserName) {
        return parserName.equalsIgnoreCase("questionToAnswer");
    }

    public Object[] Parse(String questionStatement) {

        String wordsWhoseValueToCalculate = getWords(questionStatement);

//        System.out.println("questionType = " + questionType + " val = " + wordsWhoseValueToCalculate);
        String valueOfTheWords = null;

        switch (questionType.toLowerCase()) {
            case "much":
                valueOfTheWords = calculateValueOfTheWords(wordsWhoseValueToCalculate);
                break;
            case "many":
                valueOfTheWords = calculateValueOfTheWordsOfManyTypeStatement(wordsWhoseValueToCalculate);
                break;
        }

        return new Object[]{wordsWhoseValueToCalculate, valueOfTheWords};
    }

    private String getWords(String questionStatement) {
        String[] question = questionStatement.split(" is ");
        String questionType = question[0].split(" ")[1];
        String wordsWhoseValueToCalculate = question[1].substring(0, question[1].length() - 2);

        this.questionType = questionType;

        return wordsWhoseValueToCalculate;
    }

    private String calculateValueOfTheWordsOfManyTypeStatement(String wordsWhoseValueToCalculate) {

        String[] words = wordsWhoseValueToCalculate.split(" ");

        Object[] wordsParsedInRomanWithValue = calculateWordsValueCount(words);
        String resultedRomanNumeral = (String) wordsParsedInRomanWithValue[0];
        double wordsValue = (double) wordsParsedInRomanWithValue[1];

        if (RomanValidator.validateRomanNumeral(resultedRomanNumeral) == false) {
            throw new RuntimeException("Invalid Roman Literal");
        }

        double metalValue = MetalToCreditsMapper.getMetalCredits(words[words.length - 1]);

        return decimalFormat.format(wordsValue * metalValue);
    }
    private static Object[] calculateWordsValueCount(String[] words) {
        double valueCount = 0;
        double max = Double.MIN_VALUE;
        String resultedRoman = "";
        for (int i = words.length - 2; i >= 0; i--) {
            resultedRoman = WordToRomanMapper.getRomanNumeralOfTheWord(words[i]) + resultedRoman;
            double currentLiteralValue = MetalToCreditsMapper.getMetalCredits(words[i]);
            if (currentLiteralValue < max) {
                valueCount -= currentLiteralValue;
            } else {
                valueCount += currentLiteralValue;
                max = currentLiteralValue;
            }
        }
        return new Object[]{resultedRoman, valueCount};
    }

    private String calculateValueOfTheWords(String wordsWhoseValueToCalculate) {

        String[] words = wordsWhoseValueToCalculate.split(" ");

        double valueCount = 0;
        double max = Double.MIN_VALUE;
        for (int i = words.length - 1; i >= 0; i--) {
            double currentLiteralValue = MetalToCreditsMapper.getMetalCredits(words[i]);
            if (currentLiteralValue < max) {
                valueCount -= currentLiteralValue;
            } else {
                valueCount += currentLiteralValue;
                max = currentLiteralValue;
            }
        }
        return decimalFormat.format(valueCount);
    }

}

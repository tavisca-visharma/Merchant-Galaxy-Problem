package com.tavisca.workshops.MerchantGalaxy;

import java.text.DecimalFormat;

public class QuestionToAnswerParser {

    public String[] Parse(String questionStatement) {

        String[] question = questionStatement.split(" is ");
        String questionType = question[0].split(" ")[1];
        String wordsWhoseValueToCalculate = question[1].substring(0, question[1].length() - 2);

//        System.out.println("questionType = " + questionType + " val = " + wordsWhoseValueToCalculate);
        String valueOfTheWords = null;
        if (questionType.equalsIgnoreCase("much")) {
            valueOfTheWords = calculateValueOfTheWords(wordsWhoseValueToCalculate);
        } else if (questionType.equalsIgnoreCase("many")) {
            valueOfTheWords = calculateValueOfTheWordsOfManyTypeStatement(wordsWhoseValueToCalculate);
        } else {

        }

        return new String[]{wordsWhoseValueToCalculate, valueOfTheWords};
    }

    private String calculateValueOfTheWordsOfManyTypeStatement(String wordsWhoseValueToCalculate) {

        String[] words = wordsWhoseValueToCalculate.split(" ");

        double wordsValue = MetalToCreditParser.calculateWordsValueCount(words);
        double metalValue = MetalToCreditsMapper.getMetalCredits(words[words.length - 1]);

        DecimalFormat decimalFormat = new DecimalFormat("#########.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);

        return decimalFormat.format(wordsValue * metalValue);
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
        DecimalFormat decimalFormat = new DecimalFormat("#########.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        return decimalFormat.format(valueCount);
    }
}

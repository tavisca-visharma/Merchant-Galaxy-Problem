package com.tavisca.workshops.MerchantGalaxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InputParserTest {

    @Test
    void canParseWordToRomanNumeralStatement() {
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        assertArrayEquals(new String[]{"glob", "I"},
                wordToRomanParser.Parse("glob is I"));
        assertArrayEquals(new String[]{"prok", "V"},
                wordToRomanParser.Parse("prok is V"));
        assertArrayEquals(new String[]{"pish", "X"},
                wordToRomanParser.Parse("pish is X"));
        assertArrayEquals(new String[]{"tegj", "L"},
                wordToRomanParser.Parse("tegj is L"));

    }

    @Test
    void canParseMetalToCreditStatementTest1(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        wordToRomanParser.Parse("glob is I");
        wordToRomanParser.Parse("prok is V");
        wordToRomanParser.Parse("pish is X");
        wordToRomanParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver","17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest2(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        wordToRomanParser.Parse("glob is I");
        wordToRomanParser.Parse("prok is V");
        wordToRomanParser.Parse("pish is X");
        wordToRomanParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver","17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold","14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest3(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        wordToRomanParser.Parse("glob is I");
        wordToRomanParser.Parse("prok is V");
        wordToRomanParser.Parse("pish is X");
        wordToRomanParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver","17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold","14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron","195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

    }

    @Test
    void canProvideAnswersToQuestionsAsked(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        wordToRomanParser.Parse("glob is I");
        wordToRomanParser.Parse("prok is V");
        wordToRomanParser.Parse("pish is X");
        wordToRomanParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver","17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold","14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron","195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

        QuestionToAnswerParser questionToAnswerParser = new QuestionToAnswerParser();
        assertArrayEquals(new String[]{"pish tegj glob glob","42"},
                questionToAnswerParser.Parse("how much is pish tegj glob glob ?"));

    }

}

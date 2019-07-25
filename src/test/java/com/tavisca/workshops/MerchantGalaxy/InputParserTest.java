package com.tavisca.workshops.MerchantGalaxy;

import com.tavisca.workshops.MerchantGalaxy.Parsers.MetalToCreditParser;
import com.tavisca.workshops.MerchantGalaxy.Parsers.QuestionToAnswerParser;
import com.tavisca.workshops.MerchantGalaxy.Parsers.WordToRomanNumeralParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {

    @Test
    void canParseWordToRomanNumeralStatement() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        assertArrayEquals(new String[]{"glob", "I"},
                wordToRomanNumeralParser.Parse("glob is I"));
        assertArrayEquals(new String[]{"prok", "V"},
                wordToRomanNumeralParser.Parse("prok is V"));
        assertArrayEquals(new String[]{"pish", "X"},
                wordToRomanNumeralParser.Parse("pish is X"));
        assertArrayEquals(new String[]{"tegj", "L"},
                wordToRomanNumeralParser.Parse("tegj is L"));

    }

    @Test
    void canParseMetalToCreditStatementTest1() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest2() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest3() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

    }

    @Test
    void canProvideAnswersToQuestionsAsked1() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

        QuestionToAnswerParser questionToAnswerParser = new QuestionToAnswerParser();
        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                questionToAnswerParser.Parse("how much is pish tegj glob glob ?"));

    }

    @Test
    void canProvideAnswersToQuestionsAsked2() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

        QuestionToAnswerParser questionToAnswerParser = new QuestionToAnswerParser();
        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                questionToAnswerParser.Parse("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"glob prok Gold", "57800"},
                questionToAnswerParser.Parse("how many Credits is glob prok Gold ?"));
        assertArrayEquals(new String[]{"glob prok Iron", "782"},
                questionToAnswerParser.Parse("how many Credits is glob prok Iron ?"));

    }

    @Test
    void cannotProvideAnswersToIrrelevantQuestions1() {
        WordToRomanNumeralParser wordToRomanNumeralParser = new WordToRomanNumeralParser();
        wordToRomanNumeralParser.Parse("glob is I");
        wordToRomanNumeralParser.Parse("prok is V");
        wordToRomanNumeralParser.Parse("pish is X");
        wordToRomanNumeralParser.Parse("tegj is L");

        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new String[]{"Silver", "17"},
                metalToCreditParser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                metalToCreditParser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                metalToCreditParser.Parse("pish pish Iron is 3910 Credits"));

        QuestionToAnswerParser questionToAnswerParser = new QuestionToAnswerParser();
        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                questionToAnswerParser.Parse("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"glob prok Gold", "57800"},
                questionToAnswerParser.Parse("how many Credits is glob prok Gold ?"));
        assertArrayEquals(new String[]{"glob prok Iron", "782"},
                questionToAnswerParser.Parse("how many Credits is glob prok Iron ?"));
        assertThrows(Exception.class,
                () -> {
                    questionToAnswerParser.Parse("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
                }
        );

    }

    @Test
    void cannotProvideAnswersToIrrelevantQuestions2(){
        QuestionToAnswerParser questionToAnswerParser = new QuestionToAnswerParser();
        assertThrows(Exception.class,
                () -> {
                    questionToAnswerParser.Parse("how much space is allocated for the bags ?");
                }
        );
    }
}

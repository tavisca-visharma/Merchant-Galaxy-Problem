package com.tavisca.workshops.MerchantGalaxy;

import com.tavisca.workshops.MerchantGalaxy.Parsers.MetalToCreditParser;
import com.tavisca.workshops.MerchantGalaxy.Parsers.Parser;
import com.tavisca.workshops.MerchantGalaxy.Parsers.QuestionToAnswerParser;
import com.tavisca.workshops.MerchantGalaxy.Parsers.WordToRomanNumeralParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {

    Parser parser;

    @BeforeEach
    void initialize(){
        parser = Parser.getInstance();
    }

    @Test
    void canParseWordToRomanNumeralStatement() {
        assertArrayEquals(new String[]{"glob", "I"},
                parser.Parse("glob is I"));
        assertArrayEquals(new String[]{"prok", "V"},
                parser.Parse("prok is V"));
        assertArrayEquals(new String[]{"pish", "X"},
                parser.Parse("pish is X"));
        assertArrayEquals(new String[]{"tegj", "L"},
                parser.Parse("tegj is L"));

    }

    @Test
    void canParseMetalToCreditStatementTest1() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest2() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                parser.Parse("glob prok Gold is 57800 Credits"));

    }

    @Test
    void canParseMetalToCreditStatementTest3() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                parser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                parser.Parse("pish pish Iron is 3910 Credits"));

    }

    @Test
    void canProvideAnswersToQuestionsAsked1() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                parser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                parser.Parse("pish pish Iron is 3910 Credits"));

        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                parser.Parse("how much is pish tegj glob glob ?"));

    }

    @Test
    void canProvideAnswersToQuestionsAsked2() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                parser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                parser.Parse("pish pish Iron is 3910 Credits"));

        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                parser.Parse("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"glob prok Gold", "57800"},
                parser.Parse("how many Credits is glob prok Gold ?"));
        assertArrayEquals(new String[]{"glob prok Iron", "782"},
                parser.Parse("how many Credits is glob prok Iron ?"));

    }

    @Test
    void cannotProvideAnswersToIrrelevantQuestions1() {
        parser.Parse("glob is I");
        parser.Parse("prok is V");
        parser.Parse("pish is X");
        parser.Parse("tegj is L");

        assertArrayEquals(new String[]{"Silver", "17"},
                parser.Parse("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[]{"Gold", "14450"},
                parser.Parse("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[]{"Iron", "195.5"},
                parser.Parse("pish pish Iron is 3910 Credits"));

        assertArrayEquals(new String[]{"pish tegj glob glob", "42"},
                parser.Parse("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"glob prok Gold", "57800"},
                parser.Parse("how many Credits is glob prok Gold ?"));
        assertArrayEquals(new String[]{"glob prok Iron", "782"},
                parser.Parse("how many Credits is glob prok Iron ?"));
        assertThrows(Exception.class,
                () -> {
                    parser.Parse("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
                }
        );

    }

    @Test
    void cannotProvideAnswersToIrrelevantQuestions2(){
        assertThrows(Exception.class,
                () -> {
                    parser.Parse("how much space is allocated for the bags ?");
                }
        );
    }
}

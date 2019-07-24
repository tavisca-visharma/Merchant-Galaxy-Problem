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
    void canParseMetalToCreditStatement(){
        MetalToCreditParser metalToCreditParser = new MetalToCreditParser();
        assertArrayEquals(new Object[]{"Silver",34},metalToCreditParser.Parse("glob glob Silver is 34 Credits"));

    }
}

package com.tavisca.workshops.MerchantGalaxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArabicNumeralToRomanParserTest {

    @Test
    void canParseArabicNumeralIntoRomanNumberTest1(){
        ArabicNumeralToRomanParser arabicNumeralToRomanParser = new ArabicNumeralToRomanParser();
        String romanNumber = arabicNumeralToRomanParser.Parse(1903);
        assertEquals("MCMIII",romanNumber);
    }

    @Test

    void canParseArabicNumeralIntoRomanNumberTest2(){
        ArabicNumeralToRomanParser arabicNumeralToRomanParser = new ArabicNumeralToRomanParser();
        String romanNumber = arabicNumeralToRomanParser.Parse(123);
        assertEquals("CXXIII",romanNumber);
    }
}

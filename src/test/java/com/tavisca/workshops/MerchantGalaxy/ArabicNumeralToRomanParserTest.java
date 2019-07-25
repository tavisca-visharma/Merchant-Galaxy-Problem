package com.tavisca.workshops.MerchantGalaxy;

import com.tavisca.workshops.MerchantGalaxy.Parsers.ArabicNumeralToRomanParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArabicNumeralToRomanParserTest {

    @Test
    void canParseArabicNumeralIntoRomanNumberTest1(){
        ArabicNumeralToRomanParser arabicNumeralToRomanParser = new ArabicNumeralToRomanParser();
        String romanNumber = (String)arabicNumeralToRomanParser.Parse(1903 + "")[0];
        assertEquals("MCMIII",romanNumber);
    }

    @Test

    void canParseArabicNumeralIntoRomanNumberTest2(){
        ArabicNumeralToRomanParser arabicNumeralToRomanParser = new ArabicNumeralToRomanParser();
        String romanNumber = (String)arabicNumeralToRomanParser.Parse(123 + "")[0];

        assertEquals("CXXIII",romanNumber);
    }
}

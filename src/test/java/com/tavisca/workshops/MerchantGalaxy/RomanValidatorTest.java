package com.tavisca.workshops.MerchantGalaxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanValidatorTest {

    @Test
    void canValidateTheSingleRomanLiteral(){
        assertTrue(RomanValidator.validateRomanNumeral("I"));
        assertTrue(RomanValidator.validateRomanNumeral("V"));
        assertTrue(RomanValidator.validateRomanNumeral("X"));
        assertTrue(RomanValidator.validateRomanNumeral("L"));
        assertTrue(RomanValidator.validateRomanNumeral("C"));
        assertTrue(RomanValidator.validateRomanNumeral("D"));
        assertTrue(RomanValidator.validateRomanNumeral("M"));
    }

    @Test
    void canValidateSequenceOfRomanLiterals1(){
        assertTrue(RomanValidator.validateRomanNumeral("XXXIX"));

    }

    @Test
    void canValidateSequenceOfRomanLiterals2(){
        assertTrue(RomanValidator.validateRomanNumeral("MCMXLIV"));

    }

    @Test
    void cannotValidateWrongSequenceOfRomanLiterals1(){
        assertFalse(RomanValidator.validateRomanNumeral("XXXX"));

    }
    @Test
    void cannotValidateWrongSequenceOfRomanLiterals2(){
        assertFalse(RomanValidator.validateRomanNumeral("IL"));

    }

    @Test
    void cannotValidateWrongSequenceOfRomanLiterals3(){
        assertFalse(RomanValidator.validateRomanNumeral("VV"));
        assertFalse(RomanValidator.validateRomanNumeral("DD"));
        assertFalse(RomanValidator.validateRomanNumeral("LL"));

    }
    @Test
    void cannotValidateWrongSequenceOfRomanLiterals4(){
        assertFalse(RomanValidator.validateRomanNumeral("IIVVMM"));
    }

}

package com.tavisca.workshops.MerchantGalaxy;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MerchantGalaxyTest {

    @Test
    void merchantCanTranslateIntergalacticWordsIntoRomanNumerals() {
        MerchantGalaxy merchantGalaxy = new MerchantGalaxy();
        String translatedRoman = merchantGalaxy.translateWordsToRomanNumerals("glob is I");
        assertEquals("I", translatedRoman);

    }

    @Test
    void merchantCanTranslateRomanNumeralsIntoCredits() {
        MerchantGalaxy merchantGalaxy = new MerchantGalaxy();
        double translatedCredits = merchantGalaxy.translateRomanNumeralsToCredits("C");
        assertEquals(100, translatedCredits);
    }

    @Test
    @Tag("to_be_done-tests")
    public void inputIsTakenCorrectly() {
        String inputs = "glob is I\n" +
                "prok is V\n" +
                "pish is X\n" +
                "tegj is L\n" +
                "glob glob Silver is 34 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "pish pish Iron is 3910 Credits\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n" +
                "how many Credits is glob prok Gold ?\n" +
                "how many Credits is glob prok Iron ?\n" +
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

    }

}

package com.tavisca.workshops.MerchantGalaxy.Parsers;

import com.tavisca.workshops.MerchantGalaxy.Mapper.MetalToCreditsMapper;
import com.tavisca.workshops.MerchantGalaxy.Mapper.RomanToCreditMapper;
import com.tavisca.workshops.MerchantGalaxy.Mapper.WordToRomanMapper;

public class WordToRomanNumeralParser implements IParser {

    public Object[] Parse(String languageStatement) {
        String wordToRoman[] = languageStatement.split(" is ");
        addWordToCurrentDataset(wordToRoman[0],wordToRoman[1]);
        return new Object[]{wordToRoman[0], wordToRoman[1]};
    }

    private void addWordToCurrentDataset(String word, String romanNumeral) {
        WordToRomanMapper.addWordWithRomanNumeral(word,romanNumeral);
        double romanCredits = RomanToCreditMapper.getRomanCredits(romanNumeral);
        MetalToCreditsMapper.addMetalWithCredits(word,romanCredits);

    }

    public boolean select(String parserName) {
        return parserName.equalsIgnoreCase("wordToRomanNumeral");
    }

}

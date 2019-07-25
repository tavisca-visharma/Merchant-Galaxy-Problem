package com.tavisca.workshops.MerchantGalaxy.Parsers;

import com.tavisca.workshops.MerchantGalaxy.Mapper.*;

public class WordToRomanNumeralParser implements IParser {
    Mapper mapper;

    public boolean select(String parserName) {
        return parserName.equalsIgnoreCase(ParserLanguageType.WordToRomanNumeral);
    }

    public WordToRomanNumeralParser(){
        mapper = Mapper.getInstance();
    }

    public Object[] Parse(String languageStatement) {
        String wordToRoman[] = languageStatement.split(" is ");
        addWordToCurrentDataset(wordToRoman[0],wordToRoman[1]);
        return new Object[]{wordToRoman[0], wordToRoman[1]};
    }

    private void addWordToCurrentDataset(String word, String romanNumeral) {
        mapper.addItem(MappersName.wordToRomanNumeralMapperName,word,romanNumeral);
        String romanCredits = mapper.getItemValue(MappersName.romanNumeralToCreditMapper,romanNumeral);
        mapper.addItem(MappersName.metalMapperName,word,romanCredits);

    }

}

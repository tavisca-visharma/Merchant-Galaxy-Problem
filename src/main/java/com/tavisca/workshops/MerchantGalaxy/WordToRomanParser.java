package com.tavisca.workshops.MerchantGalaxy;

public class WordToRomanParser {
    public String[] Parse(String languageStatement) {
        String wordToRoman[] = languageStatement.split(" is ");
        addWordToCurrentDataset(wordToRoman[0],wordToRoman[1]);
        return new String[]{wordToRoman[0], wordToRoman[1]};
    }

    private void addWordToCurrentDataset(String word, String romanNumeral) {

        WordToRomanMapper.addWordWithRomanNumeral(word,romanNumeral);
        double romanCredits = RomanToCreditMapper.getRomanCredits(romanNumeral);
        MetalToCreditsMapper.addMetalWithCredits(word,romanCredits);

    }
}

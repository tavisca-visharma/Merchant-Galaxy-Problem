package com.tavisca.workshops.MerchantGalaxy;

public class MetalToCreditParser {
    public Object[] Parse(String languageStatement) {

        String[] metalToCredits = languageStatement.split(" is ");
        String[] words = metalToCredits[0].split(" ");
        String[] credits = metalToCredits[1].split(" ");

        String metal = words[words.length - 1];
        double creditOfMetal = Double.parseDouble(credits[0]);

        if (creditOfMetal == (int) creditOfMetal)
            return new Object[]{metal, (int) creditOfMetal};
        return new Object[]{metal, creditOfMetal};
    }
}

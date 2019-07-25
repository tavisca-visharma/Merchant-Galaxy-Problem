package com.tavisca.workshops.MerchantGalaxy.Mapper;

import java.util.HashMap;

public class RomanToCreditMapper {
    private static HashMap<String, Double> romanToCredits = new HashMap<>() {{
        put("I", 1.0);
        put("V", 5.0);
        put("X", 10.0);
        put("L", 50.0);
        put("C", 100.0);
        put("D", 500.0);
        put("M", 1000.0);

    }};

    public static void addRomanWithCredits(String romanNumerals, double credits) {

        romanToCredits.put(romanNumerals, credits);

    }

    public static double getRomanCredits(String romanNumeral) {
        return romanToCredits.get(romanNumeral);
    }
}

package com.tavisca.workshops.MerchantGalaxy.Mapper;

import java.util.HashMap;

public class RomanNumeralToCreditMapper implements IMapper {
    private HashMap<String, String> romanNumeralToCredits;

    RomanNumeralToCreditMapper(){
        romanNumeralToCredits = new HashMap<>() {{
            put("I", "1");
            put("V", "5");
            put("X", "10");
            put("L", "50");
            put("C", "100");
            put("D", "500");
            put("M", "1000");

        }};
    }

    public boolean selectMapper(String mapperName) {
        return mapperName.equalsIgnoreCase(MappersName.romanNumeralToCreditMapper);
    }

    public void addItemWithCredits(String item, String credits) {
        romanNumeralToCredits.put(item,credits);
    }

    public String get(String item) {
        return romanNumeralToCredits.get(item);
    }

}

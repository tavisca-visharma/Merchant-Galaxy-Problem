package com.tavisca.workshops.MerchantGalaxy.Validator;

import java.util.regex.Pattern;

public class RomanValidator {

    public static boolean validateRomanNumeral(String romanNumeral) {
        Pattern romanPattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
        return romanPattern.matcher(romanNumeral).matches();
    }
}

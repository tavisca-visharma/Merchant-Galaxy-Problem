package com.tavisca.workshops.MerchantGalaxy;

public class RomanValidator {
    public static boolean validateRomanNumeral(String romanNumeral) {
        for (int i = 0; i < romanNumeral.length() - 1; i++) {

            if (romanNumeral.charAt(i) == 'I') {

                if (romanNumeral.charAt(i+1) != 'I' && romanNumeral.charAt(i + 1) != 'V' && romanNumeral.charAt(i + 1) != 'X'
                        && RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i) + "") < RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i+1)+"") ) {
//                    System.out.println("Hello 1");
                    return false;
                }
            }
            if (romanNumeral.charAt(i) == 'X') {
                if (romanNumeral.charAt(i+1) != 'X' && romanNumeral.charAt(i + 1) != 'L' && romanNumeral.charAt(i + 1) != 'C'
                        && RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i) + "") < RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i+1)+"") ) {
//                    System.out.println("Hello 2");
                    return false;
                }
            }
            if (romanNumeral.charAt(i) == 'C') {
                if (romanNumeral.charAt(i+1) != 'C' && romanNumeral.charAt(i + 1) != 'D' && romanNumeral.charAt(i + 1) != 'M'
                        && RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i) + "") < RomanToCreditMapper.getRomanCredits(romanNumeral.charAt(i+1)+"") ) {
//                    System.out.println("Hello 3");
                    return false;
                }
            }

            if (i < romanNumeral.length() - 3) {
                if (romanNumeral.charAt(i) == 'I' || romanNumeral.charAt(i) == 'X' || romanNumeral.charAt(i) == 'C' || romanNumeral.charAt(i) == 'M') {
                    if (romanNumeral.charAt(i) == romanNumeral.charAt(i + 1)
                            && romanNumeral.charAt(i + 1) == romanNumeral.charAt(i + 2)
                            && romanNumeral.charAt(i + 2) == romanNumeral.charAt(i + 3)) {
//                        System.out.println("Hello 4");
                        return false;
                    }

                }
            }
            if (romanNumeral.charAt(i) == 'D' || romanNumeral.charAt(i) == 'L' || romanNumeral.charAt(i) == 'V') {
                if (romanNumeral.charAt(i) == romanNumeral.charAt(i + 1)) {
//                    System.out.println("Hello 5");
                    return false;
                }
                double currentRomanLiteral = RomanToCreditMapper.getRomanCredits("" + romanNumeral.charAt(i));
                double nextRomanLiteral = RomanToCreditMapper.getRomanCredits("" + romanNumeral.charAt(i + 1));
                if (currentRomanLiteral < nextRomanLiteral) {
//                    System.out.println("Hello 6");
                    return false;
                }
            }
        }
        return true;
    }
}

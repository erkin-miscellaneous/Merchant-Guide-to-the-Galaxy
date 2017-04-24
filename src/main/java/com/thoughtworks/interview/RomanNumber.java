package com.thoughtworks.interview;



/**
 * A class that converts roman numbers to Arabic values
 *
 * Created by erkinkarincaoglu on 17/04/2017.
 */
public class RomanNumber {

    private final static String ROMAN_REGEXP = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private final static int[] VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    // array containing all of the roman numerals
    private final static String[] ROMAN_NUMERALS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    /**
     *
     * @param roman a String containing the roman number to be parsed
     * @return the int value represented by the argement in roman
     * @throws InvalidRomanNumberException if the given string is not a valid roman number
     */
    public static int toArabic(String roman) throws InvalidRomanNumberException {
        if (!roman.matches(ROMAN_REGEXP)) {
            throw new InvalidRomanNumberException("Invalid roman number=" + roman);
        }
        return toInteger(roman);
    }


    static int toInteger(String source) {
        for (int i = 0; i< ROMAN_NUMERALS.length; i++) {
            if(source.startsWith(ROMAN_NUMERALS[i])) {
                // repeat until string is empty
                return VALUES[i] + toInteger(source.replaceFirst(ROMAN_NUMERALS[i], ""));
            }
        }
        // end of source
        return 0;
    }

}

package com.thoughtworks.interview;

import java.util.HashMap;

/**
 * Created by erkin.karincaoglu on 18/04/2017.
 *
 * Keeps a map of symbols to roman numbers
 */
public class Assignments {
    private  final HashMap<String,String> assignments = new HashMap<>();

    public void addAssignment(String symbol, String romanNumeral) {
        assignments.put(symbol,romanNumeral);
    }

    public String getAssignment(String symbol) {
        return assignments.get(symbol);
    }

    /**
     * Returns the integer value represented by symbols. If one of the symbols are not known or resulted value is not
     * a valid roman number it return null
     * @param text combination of words representing roman number
     * @return the integer value to which text represents
     * or null if the text does not represent a valid value
     */
    public Integer convertSymbolsToNumber(String text)  {
        try {
            StringBuilder romanNumber = new StringBuilder();
            for (String value : text.split(" ") )  {
                String symbol = assignments.get(value);
                if (symbol == null) {
                    return null;
                }
                romanNumber.append(symbol);
            }
            return RomanNumber.toArabic(romanNumber.toString());
        } catch (InvalidRomanNumberException e) {
            return null;
        }

    }
}

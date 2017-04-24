package com.thoughtworks.interview;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by erkinkarincaoglu on 17/04/2017.
 */
public class RomanNumberTest {

    @Test
    public void testToArabic() throws InvalidRomanNumberException {
        assertEquals(1000, RomanNumber.toArabic("M"));
        assertEquals(900, RomanNumber.toArabic("CM"));
        assertEquals(500, RomanNumber.toArabic("D"));
        assertEquals(400, RomanNumber.toArabic("CD"));
        assertEquals(100, RomanNumber.toArabic("C"));
        assertEquals(90, RomanNumber.toArabic("XC"));
        assertEquals(50, RomanNumber.toArabic("L"));
        assertEquals(40, RomanNumber.toArabic("XL"));
        assertEquals(10, RomanNumber.toArabic("X"));
        assertEquals(9, RomanNumber.toArabic("IX"));
        assertEquals(5, RomanNumber.toArabic("V"));
        assertEquals(4, RomanNumber.toArabic("IV"));
        assertEquals(1, RomanNumber.toArabic("I"));
        assertEquals(1001, RomanNumber.toArabic("MI"));
        assertEquals(955, RomanNumber.toArabic("CMLV"));
        assertEquals(501, RomanNumber.toArabic("DI"));
        assertEquals(422, RomanNumber.toArabic("CDXXII"));
        assertEquals(103, RomanNumber.toArabic("CIII"));
        assertEquals(57, RomanNumber.toArabic("LVII"));
        assertEquals(41, RomanNumber.toArabic("XLI"));
        assertEquals(12, RomanNumber.toArabic("XII"));
        assertEquals(6, RomanNumber.toArabic("VI"));
        assertEquals(3, RomanNumber.toArabic("III"));
        assertEquals(300, RomanNumber.toArabic("CCC"));
        assertEquals(3000, RomanNumber.toArabic("MMM"));
        assertEquals(30, RomanNumber.toArabic("XXX"));
        assertEquals(3900, RomanNumber.toArabic("MMMCM"));
        assertEquals(3999, RomanNumber.toArabic("MMMCMXCIX"));
    }

    @Test
    public void testInvalidRomanNumber()  {
        // The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
        invalidRomanNumber("IIII");
        invalidRomanNumber("XXXX");
        invalidRomanNumber("MMMM");
        invalidRomanNumber("CCCC");
        // "D", "L", and "V" can never be repeated.
        invalidRomanNumber("DD");
        invalidRomanNumber("LL");
        invalidRomanNumber("VV");
        // "I" can be subtracted from "V" and "X" only.
        invalidRomanNumber("IL");
        invalidRomanNumber("IC");
        invalidRomanNumber("ID");
        invalidRomanNumber("IM");
        // "X" can be subtracted from "L" and "C" only.
        invalidRomanNumber("XD");
        invalidRomanNumber("XM");
        // "C" can be subtracted from "D" and "M" only.
        // "V", "L", and "D" can never be subtracted
        invalidRomanNumber("VX");
        invalidRomanNumber("LC");
        invalidRomanNumber("DM");
    }

    void invalidRomanNumber(String romanNumber) {
        try {
            RomanNumber.toArabic(romanNumber);
            fail("expected invalid roman number=" + romanNumber);
        } catch (InvalidRomanNumberException e) {
            // expected exception
        }
    }


}

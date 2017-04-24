package com.thoughtworks.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by erkin.karincaoglu on 19/04/2017.
 */
public class AssignmentsTest {

    @Test
    public void testConvertSymbolsToNumber() {
        Assignments assignments = new Assignments();
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        assignments.addAssignment("zoo", "X");
        assertEquals(16,assignments.convertSymbolsToNumber("zoo boo foo").intValue());
    }

    @Test
    public void tesInvalidUnkownSymbol() {
        Assignments assignments = new Assignments();
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        assignments.addAssignment("zoo", "X");
        assertEquals(null,assignments.convertSymbolsToNumber("zoo boo far")); // 'far' is unknown
    }

    @Test
    public void tesInvalidRomanNumer() {
        Assignments assignments = new Assignments();
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        assignments.addAssignment("zoo", "X");
        assertEquals(null,assignments.convertSymbolsToNumber("zoo boo boo")); // XVV is invalid roman number
    }
}

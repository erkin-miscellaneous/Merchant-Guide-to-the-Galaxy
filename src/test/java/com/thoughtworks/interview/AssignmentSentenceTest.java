package com.thoughtworks.interview;

/**
 * Created by erkin.karincaoglu on 18/04/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class AssignmentSentenceTest {
    @Test
    public void testValidAssigmentSentence() {
        String line = "foo is I";
        Assignments assignments = new Assignments();
        AssignmentSentence sentence = new AssignmentSentence(new Output(),assignments);
        assertTrue( sentence.canTranslate(line ));
        sentence.translate(line);
        assertEquals( "I" , assignments.getAssignment("foo"));

    }

    @Test
    public void testInvalidManySymbols() {
        String line = "foo boo is I";
        AssignmentSentence sentence = new AssignmentSentence(new Output(),new Assignments());
        assertFalse( sentence.canTranslate(line ));

    }

    @Test
    public void testInvalidMissingIs() {
        String line = "foo was I";
        AssignmentSentence sentence = new AssignmentSentence(new Output(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }

    @Test
    public void testInvalidRomanNumber() {
        String line = "foo was A";
        AssignmentSentence sentence = new AssignmentSentence(new Output(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }
}

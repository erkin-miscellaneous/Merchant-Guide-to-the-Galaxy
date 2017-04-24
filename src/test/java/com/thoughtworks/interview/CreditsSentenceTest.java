package com.thoughtworks.interview;

import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;
/**
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class CreditsSentenceTest {
    @Test
    public void testValidCreditsSentence() {
        String line = "foo boo Metal is 24 Credits";
        Assignments assignments = new Assignments();
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        HashMap<String,Float> credits = new HashMap<>();
        credits.put("Metal", new Float(6.0));
        CreditsSentence sentence = new CreditsSentence(new Output(),credits,assignments);
        assertTrue( sentence.canTranslate(line ));
        sentence.translate(line);
        assertEquals( new Float(6.0) , credits.get("Metal"));

    }


    @Test
    public void testInvalidPriceMissing() {
        String line = "glob glob Silver is Credits";
        CreditsSentence sentence = new CreditsSentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }

    @Test
    public void testInvalidIsMissing() {
        String line = "glob glob Silver 34 Credits";
        CreditsSentence sentence = new CreditsSentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }

    @Test
    public void testInvalidSymbolsMissing() {
        String line = "Silver is 34 Credits";
        CreditsSentence sentence = new CreditsSentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }
}

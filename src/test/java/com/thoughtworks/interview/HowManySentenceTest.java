package com.thoughtworks.interview;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;
/**
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class HowManySentenceTest {

    Assignments assignments = new Assignments();
    HashMap<String,Float> credits = new HashMap<>();

    @Before
    public void setup() {
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        credits.put("Metal", new Float(6.0));
    }

    @Test
    public void testValidHowManySentence() {Output output = new Output();
        String line = "how many Credits is boo foo foo foo Metal ?";
        HowManySentence sentence = new HowManySentence(output,credits,assignments);
        assertTrue( sentence.canTranslate(line ));
        sentence.translate(line);
        assertEquals( "boo foo foo foo Metal is 48 Credits", output.getLastLine());
    }

    @Test
    public void testInvalidUnknownSymbol() {
        Output output = new Output();
        String line = "how many Credits is boo foo foo foo Iron ?"; // notice good 'Iron' is not known
        HowManySentence sentence = new HowManySentence(output,credits, assignments);
        assertTrue( sentence.canTranslate(line ));
        sentence.translate(line);
        assertEquals( output.ERROR_LINE, output.getLastLine());
    }


    @Test
    public void testSymbolsMissing() {
        String line = "how many Credits is Silver ?";
        HowManySentence sentence = new HowManySentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }

    @Test
    public void testQuestionMarkMissing() {
        String line = "how many Credits is glob prok Silver ";
        HowManySentence sentence = new HowManySentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }

    @Test
    public void testQuestionInvalid() {
        String line = "how many Credits could would is glob prok Silver ?";
        HowManySentence sentence = new HowManySentence(new Output(),new HashMap<>(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }
}

package com.thoughtworks.interview;

/**
 * Created by erkin.karincaoglu on 18/04/2017.
 */

import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class HowMuchSentenceTest {

    @Test
    public void testValidHowMuchSentence() {
        Assignments assignments = new Assignments();
        assignments.addAssignment("foo", "I");
        assignments.addAssignment("boo", "V");
        Output output = new Output();
        String line = "how much is boo foo foo ?";
        HowMuchSentence sentence = new HowMuchSentence(output,assignments);
        assertTrue( sentence.canTranslate(line ));
        sentence.translate(line);
        assertEquals( "boo foo foo is 7", output.getLastLine());
    }

    @Test
    public void testQuestionInvalid() {
        String line = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
        HowMuchSentence sentence = new HowMuchSentence(new Output(),new Assignments());
        assertFalse( sentence.canTranslate(line ));
    }
}

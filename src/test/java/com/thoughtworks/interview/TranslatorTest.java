package com.thoughtworks.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by erkinkarincaoglu on 17/04/2017.
 */
public class TranslatorTest {

    static String testInput = "glob is I\n" +
            "prok is V\n" +
            "pish is X\n" +
            "tegj is L\n" +
            "glob glob Silver is 34 Credits\n" +
            "glob prok Gold is 57800 Credits\n" +
            "pish pish Iron is 3910 Credits\n" +
            "how much is pish tegj glob glob ?\n" +
            "how many Credits is glob prok Silver ?\n" +
            "how many Credits is glob prok Gold ?\n" +
            "how many Credits is glob prok Iron ?\n" +
            "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

    String testExpected = "pish tegj glob glob is 42\n" +
            "glob prok Silver is 68 Credits\n" +
            "glob prok Gold is 57800 Credits\n" +
            "glob prok Iron is 782 Credits\n" +
            "I have no idea what you are talking about";


    @Test
    public void testExampleInput() {
        assertEquals(testExpected,new Translator().translate(testInput));
    }
}

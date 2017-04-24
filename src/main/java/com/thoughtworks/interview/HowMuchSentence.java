package com.thoughtworks.interview;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Translates and processes How much questions
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class HowMuchSentence implements LineTranslator {
    private final static Pattern QUESTION_HOW_MUCH = Pattern.compile("^how much is (.*) \\?$");


    private final Assignments assignments;
    private final Output output;

    public HowMuchSentence(Output output,Assignments assignments) {
        this.assignments = assignments;
        this.output = output;
    }

    @Override
    public boolean canTranslate(String line) {
        return QUESTION_HOW_MUCH.matcher(line).matches();
    }

    @Override
    public void translate(String line) {
        Matcher m = QUESTION_HOW_MUCH.matcher(line);
        m.find();
        String romanLiteral = m.group(1);
        Integer value = assignments.convertSymbolsToNumber(romanLiteral);
        if (value == null) {
            output.addErrorLine();
            return;
        }
        output.addLine(romanLiteral + " is " + value);
    }
}

package com.thoughtworks.interview;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Translates and processes Assignment sentences
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class AssignmentSentence implements LineTranslator {
    private final static Pattern ASSIGNMENT = Pattern.compile("^(\\w+) \\bis\\b ([I|V|X|L|C|D|M])$");

    private final Assignments assignments;
    private final Output output;

    public AssignmentSentence(Output output, Assignments assignments) {
        this.assignments = assignments;
        this.output = output;
    }

    @Override
    public void translate(String line) {
        Matcher m = ASSIGNMENT.matcher(line);
        m.find();
        String symbol = m.group(1);
        String romanNumber = m.group(2);
        assignments.addAssignment(symbol,romanNumber);
    }

    @Override
    public boolean canTranslate(String line) {
        return ASSIGNMENT.matcher(line).matches();
    }
}

package com.thoughtworks.interview;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Translates and processes Credits sentences
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class CreditsSentence implements LineTranslator {
    private final static Pattern CREDITS = Pattern.compile("^(.*) (\\b\\w+\\b) is (\\d+) Credits$");

    private final HashMap<String,Float> credits;
    private final Assignments assignments;
    private final Output output;

    public CreditsSentence(Output output, HashMap<String, Float> credits, Assignments assignments) {
        this.credits = credits;
        this.assignments = assignments;
        this.output = output;
    }

    @Override
    public boolean canTranslate(String line) {
        return CREDITS.matcher(line).matches();
    }


    @Override
    public void translate(String line)  {
        Matcher m = CREDITS.matcher(line);
        m.find();
        String romanLiteral = m.group(1);
        String good = m.group(2);
        String totalCredits = m.group(3);
        Integer value = assignments.convertSymbolsToNumber(romanLiteral);
        if (value == null) {
            output.addErrorLine();
            return;
        }
        float result = Long.parseLong(totalCredits) / (float) value;
        credits.put(good, result);
    }

}

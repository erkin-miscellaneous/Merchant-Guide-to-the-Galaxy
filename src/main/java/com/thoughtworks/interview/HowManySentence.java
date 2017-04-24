package com.thoughtworks.interview;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sun.security.krb5.Confounder.longValue;

/**
 * Translates and processes How many questions
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class HowManySentence  implements LineTranslator {
    private final static Pattern QUESTION_HOW_MANY = Pattern.compile("^how many Credits is (.*) (\\w+) \\?$");

    private final HashMap<String,Float> credits;
    private final Assignments assignments;
    private final Output output;

    public HowManySentence(Output output, HashMap<String, Float> credits, Assignments assignments) {
        this.credits = credits;
        this.assignments = assignments;
        this.output = output;
    }
    @Override
    public boolean canTranslate(String line) {
        return QUESTION_HOW_MANY.matcher(line).matches();
    }

    @Override
    public void translate(String line)  {
        Matcher m = QUESTION_HOW_MANY.matcher(line);
        m.find();
        String romanLiteral = m.group(1);
        String good = m.group(2);
        Integer value = assignments.convertSymbolsToNumber(romanLiteral);
        if (value == null) {
            output.addErrorLine();
            return;
        }
        Float credit = credits.get(good);
        if (credit == null) {
            output.addErrorLine();
            return;
        }
        output.addLine(romanLiteral + " " +good + " is " + new Float(credit * value).longValue() + " Credits");
    }




}

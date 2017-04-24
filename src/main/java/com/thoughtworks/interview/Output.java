package com.thoughtworks.interview;

import java.util.ArrayList;
import java.util.List;


/**
 * Collects the translated lines
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public class Output {


    public final static String ERROR_LINE = "I have no idea what you are talking about";
    private final List<String> output = new ArrayList();


    public void addLine(String line) {
        output.add(line);
    }

    public void addErrorLine() {
        output.add(ERROR_LINE);
    }

    public String getLastLine() {
        return  output.get( output.size() -1 );
    }

    public String toParagraph() {
        return String.join(System.lineSeparator(), output);
    }
}

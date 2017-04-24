package com.thoughtworks.interview;

import java.util.*;

/**
 * A class that translates the given conversation
 *
 * Created by erkinkarincaoglu on 17/04/2017.
 */
public class Translator {

    /**
     * Output lines
     */
    Output output = new Output();
    /**
     * Keeps the mapping between symbols and roman numbers. eg: glob->I
     */
    Assignments assignments = new Assignments();

    /**
     * Keeps the mapping between goods and credits eg. Silver->17.0
     */
    HashMap<String,Float> credits = new HashMap<>();

    /**
     * List of available lines translators.
     */
    final List<LineTranslator> lineTranslators = new ArrayList<>(
            Arrays.asList( new AssignmentSentence(output,assignments),
                    new CreditsSentence(output,credits,assignments),
                    new HowMuchSentence(output,assignments),
                    new HowManySentence(output,credits,assignments)));

    /**
     * Translates the given conversation
     * @param input conversation to be translated
     * @return Translation output
     */
    public String translate(String input) {
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextLine() ) {
            String group = null;
            String line = scanner.nextLine();
            boolean foundTranslator = false;
            for (LineTranslator lineTranslator : lineTranslators) {
                if (lineTranslator.canTranslate(line) ) {
                    lineTranslator.translate(line);
                    foundTranslator = true;
                    break;
                }
            }
            if (!foundTranslator) {
                output.addErrorLine();
            }
        }
        return output.toParagraph();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java -jar merchants-guide-1.0-SNAPSHOT-jar-with-dependencies.jar \"<text_to_translate>\"");
            return;
        }
        System.out.println (new Translator().translate(args[0]) );
    }



}

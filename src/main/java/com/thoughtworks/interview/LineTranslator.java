package com.thoughtworks.interview;

import java.util.List;

/**
 * An interface that translates the lines in a conversation.
 *
 * Created by erkin.karincaoglu on 18/04/2017.
 */
public interface  LineTranslator {

    /**
     * Translates a line
     * @param line A string value to be translated
     */
    void translate(String line);

    /**
     * Determines if this line translator is able to translate given line
     * @param line A string value to be tested.
     * @return Returns true if this translator can translate the given line.
     */
    boolean canTranslate(String line);
}

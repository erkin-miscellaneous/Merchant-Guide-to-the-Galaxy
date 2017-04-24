package com.thoughtworks.interview;

/**
 * Thrown to indicate that roman number was invalid
 *
 * Created by erkinkarincaoglu on 17/04/2017.
 */
public class InvalidRomanNumberException extends Exception{
    public InvalidRomanNumberException(String message) { super(message); }
    public InvalidRomanNumberException(Throwable cause) {
        super(cause);
    }
}

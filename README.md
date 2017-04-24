# Merchant-guide

An application for the merchants to translate conversations. It is implemented using java 8 and IntelliJ.

# Design

Translator class translates the given conversation. It holds a list of LineTranslators, output, unit prices and assigments
of symbols to roman numbers. For each line in the conversation it tries to find a suitable line translator and translates it.

New line translators can be added by implementing the LineTranslator interface. Line translators implement translate,
and canTranslate methods.

Regular expressions are used to determine if a line translator is able to translate a given line. If no matching
 translator is  found  for the given line an error line is added to the output.

A line translator may fail to translate a line even if it matches a line. This can happen if the given symbols doesn't
represent a valid roman number or unit(good) credits are not known.

# Build

Project is implemented in java and requires java 8 SDK

mvn clean install

It produces a runnable jar under target/merchants-guide-1.0-SNAPSHOT.jar

# Run

usage : java -cp target/merchants-guide-1.0-SNAPSHOT.jar com.thoughtworks.interview.Translator "<text_to_translate>"

example :
java -cp target/merchants-guide-1.0-SNAPSHOT.jar com.thoughtworks.interview.Translator "glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"




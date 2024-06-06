package com.cimt.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * This class is a delegate for a service task "Text auf Bad Words prüfen".
 *
 * Author: Harsh,Kshitij
 * Date: 06 June 2024
 */
@Component
public class SearchBadWordsTaskDelegate implements JavaDelegate {

    // A list of predefined "bad words" that is required to be searched in the input text.
    private static final List<String> predefinedList = Arrays.asList("dumb", "idiot", "rude", "stupid", "lazy");

    /**
     * This method is called when the service task "Text auf Bad Words prüfen" is executed.
     * It checks if the input text contains any of the predefined bad words
     * and sets the matched words as a process variable.
     *
     * @param delegateExecution the context of the process execution
     * @throws Exception if an error occurs during execution
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String inputTextOld = (String) delegateExecution.getVariable("inputText");
        if (inputTextOld != null) {
            String inputText = inputTextOld.toLowerCase(Locale.ROOT);
            List<String> matchedWords = new ArrayList<>();

            for (String word : predefinedList) {
                if (inputText.contains(word)) {
                    matchedWords.add(word);
                }
            }

            String matchedWordsString = String.join(", ", matchedWords);

            delegateExecution.setVariable("matchedWords", matchedWordsString);
        } else {
            delegateExecution.setVariable("matchedWords", "");
        }
    }
}

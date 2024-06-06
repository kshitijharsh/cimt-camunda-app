package com.cimt.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * SearchBadWordsTaskDelegateTest
 *
 * This class contains test cases for the {@link SearchBadWordsTaskDelegate} class.
 * It verifies the output of the delegate when checking input text.
 *
 * Author: Kshitij Harsh
 * Date: 06 June 2024
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchBadWordsTaskDelegateTest {

    @Mock
    private DelegateExecution delegateExecution;

    @InjectMocks
    private SearchBadWordsTaskDelegate searchBadWordsTaskDelegate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteWithNullInputText() throws Exception {
        when(delegateExecution.getVariable("inputText")).thenReturn(null);

        searchBadWordsTaskDelegate.execute(delegateExecution);

        verify(delegateExecution).setVariable("matchedWords", "");
    }

    @Test
    public void testExecuteWithNoMatchedWords() throws Exception {
        String inputText = "No bad words in this text.";
        when(delegateExecution.getVariable("inputText")).thenReturn(inputText);

        searchBadWordsTaskDelegate.execute(delegateExecution);

        verify(delegateExecution).setVariable("matchedWords", "");
    }

    @Test
    public void testExecuteWithMatchedWords() throws Exception {
        String inputText = "This text contains dumb and stupid words.";
        when(delegateExecution.getVariable("inputText")).thenReturn(inputText);

        searchBadWordsTaskDelegate.execute(delegateExecution);

        verify(delegateExecution).setVariable("matchedWords", "dumb, stupid");
    }
}

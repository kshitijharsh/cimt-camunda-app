package com.cimt.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 *
 * This class is a delegate for a service task "Text senden".
 *
 * Author: Kshitij Harsh
 * Date: 06 June 2024
 */
@Component
public class SendTextDelegate implements JavaDelegate {

    /**
     * This method is called when the service task "Text senden" is executed.
     * It simply prints the text to the console.
     *
     * @param delegateExecution the context of the process execution
     * @throws Exception if an error occurs during execution
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println(delegateExecution.getVariable("inputText"));
    }
}

package com.ignite.kss.bpm.demo.task;

import java.io.FileWriter;
import java.io.IOException;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostApprovalTask implements JavaDelegate
{
    private static Logger logger = LoggerFactory.getLogger(PostApprovalTask.class);
    @Override
    public void execute(final DelegateExecution delegateExecution) {
        String firstName = (String)delegateExecution.getVariable("firstName");
        String lastName = (String)delegateExecution.getVariable("lastName");
        String caseId = delegateExecution.getProcessInstanceId();
        logger.info("Will persist into DB : firstName = {}, lastName = {}, caseId = {}",firstName,lastName,caseId);
        FileWriter fw = null;
        try {
            fw = new FileWriter("/Users/sayantan.sb/Downloads/PostApprovalTaskOutput.txt");
            String text = "New Employee onboarded with name = ".concat(firstName).concat(" ").concat(lastName).concat(" . Case ID : ").concat(caseId);
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

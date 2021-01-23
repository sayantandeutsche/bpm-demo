package com.ignite.kss.bpm.demo.service;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.kss.bpm.demo.dto.ProcessDetail;
import com.ignite.kss.bpm.demo.mapping.MapperUtil;

@Service
public class ProcessRepositoryService {
    private static Logger logger = LoggerFactory.getLogger(ProcessRepositoryService.class);

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private MapperUtil mapperUtil;



    public ProcessDetail getProcessDefinitionByKey(String processKey){

        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey).singleResult();
        return mapperUtil.getProcessDetailFromDefinition(processDefinition);

    }


    public boolean suspendProcessDefinitionByKey(String processKey){
        boolean suspended = false;
        try{
            RepositoryService repositoryService = processEngine.getRepositoryService();
            repositoryService.suspendProcessDefinitionByKey(processKey);
            suspended = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return suspended;

    }

    public boolean activateProcessDefinitionByKey(String processKey){
        boolean suspended = false;
        try{
            RepositoryService repositoryService = processEngine.getRepositoryService();
            repositoryService.activateProcessDefinitionByKey(processKey);
            suspended = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return suspended;

    }

}

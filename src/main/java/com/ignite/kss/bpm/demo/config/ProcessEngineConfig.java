package com.ignite.kss.bpm.demo.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessEngineConfig {

    private static Logger logger = LoggerFactory.getLogger(ProcessEngineConfig.class);

    @PostConstruct
    public void deploy(){
        RepositoryService repositoryService = processEngine().getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("EmployeeOnboarding.bpmn20.xml")
                .addClasspathResource("leave_Application_Process.bpmn20.xml")
                .deploy();

        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .list();
        processDefinitionList.forEach(processDefinition->{logger.info("Found process definition : " + processDefinition.getName());});

    }

    @Bean
    public ProcessEngine processEngine(){

        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();
        return processEngine;

    }



}

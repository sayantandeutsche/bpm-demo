/*
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
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ignite.kss.bpm.demo.mapping.MapperUtil;
import com.ignite.kss.bpm.demo.rest.EventController;
import com.ignite.kss.bpm.demo.rest.IdentityManagementController;
import com.ignite.kss.bpm.demo.rest.ProcessController;
import com.ignite.kss.bpm.demo.rest.RepositoryController;
import com.ignite.kss.bpm.demo.service.IdentityManagementService;
import com.ignite.kss.bpm.demo.service.ProcessRepositoryService;
import com.ignite.kss.bpm.demo.service.ProcessService;
import com.ignite.kss.bpm.demo.task.PostApprovalTask;

@Configuration
public class TasksAutoConfig {

    private static Logger logger = LoggerFactory.getLogger(TasksAutoConfig.class);

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
        mapperUtil();
        processService();
        processRepositoryService();
        identityManagementService();
        repositoryController();
        processController();
        identityManagementController();
        eventController();
        postApprovalTask();

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

    @Bean
    //@ConditionalOnMissingBean(MapperUtil.class)
    public MapperUtil mapperUtil() {
        return new MapperUtil();
    }

    @Bean
    //@ConditionalOnMissingBean(ProcessService.class)
    public ProcessService processService() {
        return new ProcessService();
    }


    @Bean
    //@ConditionalOnMissingBean(ProcessRepositoryService.class)
    public ProcessRepositoryService processRepositoryService() {
        return new ProcessRepositoryService();
    }

    @Bean
    //@ConditionalOnMissingBean(IdentityManagementService.class)
    public IdentityManagementService identityManagementService() {
        return new IdentityManagementService();
    }

    @Bean
    //@ConditionalOnMissingBean(RepositoryController.class)
    public RepositoryController repositoryController() {
        return new RepositoryController();
    }

    @Bean
    //@ConditionalOnMissingBean(ProcessController.class)
    public ProcessController processController() {
        return new ProcessController();
    }

    @Bean
   // @ConditionalOnMissingBean(IdentityManagementController.class)
    public IdentityManagementController identityManagementController() {
        return new IdentityManagementController();
    }

    @Bean
    //@ConditionalOnMissingBean(EventController.class)
    public EventController eventController() {
        return new EventController();
    }


    @Bean
    //@ConditionalOnMissingBean(PostApprovalTask.class)
    public PostApprovalTask postApprovalTask() {
        return new PostApprovalTask();
    }




}
*/

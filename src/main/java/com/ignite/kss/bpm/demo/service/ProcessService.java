package com.ignite.kss.bpm.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.kss.bpm.demo.dto.WorkItem;
import com.ignite.kss.bpm.demo.mapping.MapperUtil;

@Service
public class ProcessService {
    private static Logger logger = LoggerFactory.getLogger(ProcessService.class);

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private MapperUtil mapperUtil;

    public String startCaseEmployeeOnboarding(String hrAssignee, String financeAssignee, String resourceMgmtAssignee, String execDirector){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("hr", hrAssignee);
        variables.put("finance", financeAssignee);
        variables.put("resource_management", resourceMgmtAssignee);
        variables.put("executive_director", execDirector);
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("employeeOnboarding", variables);
        return processInstance.getId();
    }

    public String startCaseLeaveApplication(String employee, String manager){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", employee);
        variables.put("manager", manager);
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("leave_Application_Process", variables);
        return processInstance.getId();
    }

    public List<WorkItem> findWorkItemsForUser(String user){
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskOwner(user).list();
        logger.info("Size of task list : {}",tasks.size());

        List<WorkItem> workItemList = tasks.stream().map(task->{WorkItem workItem = mapperUtil.getWorkItemFromTask(task);workItem.setProcessVariables(getProcessVariablesForTask(task.getId()));return workItem;}).collect(Collectors.toList());
        logger.info("ProcessService::findWorkItemsForUser : workItemList = {}",workItemList);
        return workItemList;
    }

    public Map<String, Object> getProcessVariablesForTask(String taskId){
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> processVariables = taskService.getVariables(taskId);

        return processVariables;
    }

    public boolean lockWorkItem(String taskId,String user){
        boolean result = false;
        try{
            TaskService taskService = processEngine.getTaskService();
            taskService.claim(taskId,user);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public boolean unlockWorkItem(String taskId){
        boolean result = false;
        try{
            TaskService taskService = processEngine.getTaskService();
            taskService.unclaim(taskId);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public boolean updateWorkItem(WorkItem workItem) throws Exception {
        if(StringUtils.isBlank(workItem.getId())){
            throw new Exception("Task Id is Null!!");
        }
        boolean result = false;
        try{
            TaskService taskService = processEngine.getTaskService();
            Task task = taskService.createTaskQuery().taskId(workItem.getId()).singleResult();
            Map<String,Object> taskVars = taskService.getVariables(workItem.getId());
            taskVars.putAll(workItem.getProcessVariables());
            taskService.setVariables(workItem.getId(),taskVars);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public boolean releaseWorkItem(WorkItem workItem) throws Exception {
        if(StringUtils.isBlank(workItem.getId())){
            throw new Exception("Task Id is Null!!");
        }
        boolean result = false;
        try{
            TaskService taskService = processEngine.getTaskService();
            Task task = taskService.createTaskQuery().taskId(workItem.getId()).singleResult();
            Map<String,Object> taskVars = taskService.getVariables(workItem.getId());
            taskVars.putAll(workItem.getProcessVariables());
            taskService.setVariables(workItem.getId(),taskVars);
            taskService.complete(workItem.getId());
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}

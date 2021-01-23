package com.ignite.kss.bpm.demo.mapping;

import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.idm.api.User;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Component;

import com.ignite.kss.bpm.demo.dto.ManagedUser;
import com.ignite.kss.bpm.demo.dto.ProcessDetail;
import com.ignite.kss.bpm.demo.dto.ProcessInstanceHistoryData;
import com.ignite.kss.bpm.demo.dto.WorkItem;

@Component
public class MapperUtil {

    public WorkItem getWorkItemFromTask(Task task){
        WorkItem workItem = new WorkItem();
        workItem.setName(task.getName());
        workItem.setAssignee(task.getAssignee());
        workItem.setOwner(task.getOwner());
        workItem.setId(task.getId());
        workItem.setProcessInstanceId(task.getProcessInstanceId());
        workItem.setCreateTime(task.getCreateTime());
        return workItem;
    }

    public ProcessDetail getProcessDetailFromDefinition(ProcessDefinition processDefinition){
        ProcessDetail processDetail = new ProcessDetail();
        processDetail.setCategory(processDefinition.getCategory());
        processDetail.setDeploymentId(processDefinition.getDeploymentId());
        processDetail.setId(processDefinition.getId());
        processDetail.setKey(processDefinition.getKey());
        processDetail.setName(processDefinition.getName());
        processDetail.setVersion(processDefinition.getVersion());
        return processDetail;
    }

    public ManagedUser getManagedUserFromUserInfo(User user){
        ManagedUser managedUser = new ManagedUser();
        managedUser.setEmail(user.getEmail());
        managedUser.setFirstName(user.getFirstName());
        managedUser.setLastName(user.getLastName());
        managedUser.setUserName(user.getId());
        return managedUser;
    }

    public ProcessInstanceHistoryData getProcessInstanceHistoryDataFromHistoryInstance(HistoricProcessInstance historicProcessInstance){
        ProcessInstanceHistoryData processInstanceHistoryData = new ProcessInstanceHistoryData();
        processInstanceHistoryData.setProcessDefId(historicProcessInstance.getProcessDefinitionId());
        processInstanceHistoryData.setProcessDefinitionName(historicProcessInstance.getProcessDefinitionName());
        processInstanceHistoryData.setStartTime(historicProcessInstance.getStartTime());
        processInstanceHistoryData.setEndTime(historicProcessInstance.getEndTime());
        processInstanceHistoryData.setProcessInstanceId(historicProcessInstance.getId());
        processInstanceHistoryData.setProcessVariables(historicProcessInstance.getProcessVariables());
        return processInstanceHistoryData;

    }


}

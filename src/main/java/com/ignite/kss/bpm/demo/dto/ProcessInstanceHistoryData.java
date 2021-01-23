package com.ignite.kss.bpm.demo.dto;

import java.util.Date;
import java.util.Map;

public class ProcessInstanceHistoryData {

    private String processDefId;
    private String processInstanceId;
    private String processDefinitionName;
    private Date startTime;
    private Date endTime;
    private Map<String, Object> processVariables;

    public String getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(final String processDefId) {
        this.processDefId = processDefId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(final String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(final String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(final Map<String, Object> processVariables) {
        this.processVariables = processVariables;
    }

    @Override
    public String toString() {
        return "ProcessInstanceHistoryData{" +
                "processDefId='" + processDefId + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", processDefinitionName='" + processDefinitionName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", processVariables=" + processVariables +
                '}';
    }
}

package com.ignite.kss.bpm.demo.dto;

import java.util.Date;
import java.util.Map;

public class WorkItem {
    private String id;
    private String processInstanceId;
    private String name;
    private String owner;
    private String assignee;
    private Map<String,Object> processVariables;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(final String assignee) {
        this.assignee = assignee;
    }

    public Map<String, Object> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(final Map<String, Object> processVariables) {
        this.processVariables = processVariables;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(final String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id='" + id + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", assignee='" + assignee + '\'' +
                ", processVariables=" + processVariables +
                ", createTime=" + createTime +
                '}';
    }
}

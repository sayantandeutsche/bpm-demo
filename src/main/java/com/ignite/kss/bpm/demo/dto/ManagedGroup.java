package com.ignite.kss.bpm.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManagedGroup {


    private String groupName;

    @JsonIgnore
    private String id;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ManagedGroup{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

package com.ignite.kss.bpm.demo.dto;

public class ProcessDetail {

    private String name;
    private String id;
    private String category;
    private String deploymentId;
    private String key;
    private Integer version;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(final String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ProcessDetail{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", deploymentId='" + deploymentId + '\'' +
                ", key='" + key + '\'' +
                ", version=" + version +
                '}';
    }
}

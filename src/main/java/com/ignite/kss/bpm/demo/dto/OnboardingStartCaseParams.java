package com.ignite.kss.bpm.demo.dto;

public class OnboardingStartCaseParams {

    private String hr;
    private String admin;
    private String resourceMgmt;
    private String executiveDir;

    public String getHr() {
        return hr;
    }

    public void setHr(final String hr) {
        this.hr = hr;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(final String admin) {
        this.admin = admin;
    }

    public String getResourceMgmt() {
        return resourceMgmt;
    }

    public void setResourceMgmt(final String resourceMgmt) {
        this.resourceMgmt = resourceMgmt;
    }

    public String getExecutiveDir() {
        return executiveDir;
    }

    public void setExecutiveDir(final String executiveDir) {
        this.executiveDir = executiveDir;
    }

    @Override
    public String toString() {
        return "dto{" +
                "hr='" + hr + '\'' +
                ", admin='" + admin + '\'' +
                ", resourceMgmt='" + resourceMgmt + '\'' +
                ", executiveDir='" + executiveDir + '\'' +
                '}';
    }
}

package com.ignite.kss.bpm.demo.dto;

public class LeaveAppStartCaseParams {

    private String employee;
    private String manager;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(final String employee) {
        this.employee = employee;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(final String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "LeaveAppStartCaseParams{" +
                "employee='" + employee + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}

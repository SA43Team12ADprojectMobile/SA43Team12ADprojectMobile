package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Employee {
    private String employeeId;
    private Department department;
    private String password;
    private String name;
    private String position;
    private String number;
    private String emailAddress;
    private boolean isDelegated;
    private String delegationStartDate;
    private String delegationEndDate;

    public Employee() {
    }

    public Employee(String employeeId, Department department, String password, String name, String position, String number, String emailAddress, boolean isDelegated) {
        this.employeeId = employeeId;
        this.department = department;
        this.password = password;
        this.name = name;
        this.position = position;
        this.number = number;
        this.emailAddress = emailAddress;
        this.isDelegated = isDelegated;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isDelegated() {
        return isDelegated;
    }

    public void setDelegated(boolean delegated) {
        isDelegated = delegated;
    }

    public String getDelegationStartDate() {
        return delegationStartDate;
    }

    public void setDelegationStartDate(String delegationStartDate) {
        this.delegationStartDate = delegationStartDate;
    }

    public String getDelegationEndDate() {
        return delegationEndDate;
    }

    public void setDelegationEndDate(String delegationEndDate) {
        this.delegationEndDate = delegationEndDate;
    }
}

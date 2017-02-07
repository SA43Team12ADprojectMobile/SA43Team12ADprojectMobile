package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class Employee implements Parcelable{
    public String EmployeeID;
    public String DepartmentName;
    public String Name;
    public String Position ;
    public String Number ;
    public String EmailAddress ;
    public String IsDelegated ;
    public String DelegationStartDate;
    public String DelegationEndDate ;

    public Employee() {
    }

    public Employee(String employeeID, String departmentName, String name, String position, String number, String emailAddress, String isDelegated, String delegationStartDate, String delegationEndDate) {
        EmployeeID = employeeID;
        DepartmentName = departmentName;
        Name = name;
        Position = position;
        Number = number;
        EmailAddress = emailAddress;
        IsDelegated = isDelegated;
        DelegationStartDate = delegationStartDate;
        DelegationEndDate = delegationEndDate;
    }

    protected Employee(Parcel in) {
        EmployeeID = in.readString();
        DepartmentName = in.readString();
        Name = in.readString();
        Position = in.readString();
        Number = in.readString();
        EmailAddress = in.readString();
        IsDelegated = in.readString();
        DelegationStartDate = in.readString();
        DelegationEndDate = in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getIsDelegated() {
        return IsDelegated;
    }

    public void setIsDelegated(String isDelegated) {
        IsDelegated = isDelegated;
    }

    public String getDelegationStartDate() {
        return DelegationStartDate;
    }

    public void setDelegationStartDate(String delegationStartDate) {
        DelegationStartDate = delegationStartDate;
    }

    public String getDelegationEndDate() {
        return DelegationEndDate;
    }

    public void setDelegationEndDate(String delegationEndDate) {
        DelegationEndDate = delegationEndDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(EmployeeID);
        dest.writeString(DepartmentName);
        dest.writeString(Name);
        dest.writeString(Position);
        dest.writeString(Number);
        dest.writeString(EmailAddress);
        dest.writeString(IsDelegated);
        dest.writeString(DelegationStartDate);
        dest.writeString(DelegationEndDate);
    }
}

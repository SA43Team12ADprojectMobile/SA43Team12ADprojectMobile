package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/2/2.
 */

public class DelegateEmployee implements Parcelable{
    public String EmployeeID;
    public String Password;
    public String DepartmentID;
    public String Name;
    public String Position ;
    public String IsDelegated ;
    public String DelegationStartDate;
    public String DelegationEndDate ;
    public String Number;
    public String EmailAddress;

    public DelegateEmployee() {
    }

    protected DelegateEmployee(Parcel in) {
        EmployeeID = in.readString();
        Password = in.readString();
        DepartmentID = in.readString();
        Name = in.readString();
        Position = in.readString();
        IsDelegated = in.readString();
        DelegationStartDate = in.readString();
        DelegationEndDate = in.readString();
        Number = in.readString();
        EmailAddress = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(EmployeeID);
        dest.writeString(Password);
        dest.writeString(DepartmentID);
        dest.writeString(Name);
        dest.writeString(Position);
        dest.writeString(IsDelegated);
        dest.writeString(DelegationStartDate);
        dest.writeString(DelegationEndDate);
        dest.writeString(Number);
        dest.writeString(EmailAddress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DelegateEmployee> CREATOR = new Creator<DelegateEmployee>() {
        @Override
        public DelegateEmployee createFromParcel(Parcel in) {
            return new DelegateEmployee(in);
        }

        @Override
        public DelegateEmployee[] newArray(int size) {
            return new DelegateEmployee[size];
        }
    };

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
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

    public DelegateEmployee(String employeeID, String password, String departmentID, String name, String position, String isDelegated, String delegationStartDate, String delegationEndDate, String number, String emailAddress) {

        EmployeeID = employeeID;
        Password = password;
        DepartmentID = departmentID;
        Name = name;
        Position = position;
        IsDelegated = isDelegated;
        DelegationStartDate = delegationStartDate;
        DelegationEndDate = delegationEndDate;
        Number = number;
        EmailAddress = emailAddress;
    }
}

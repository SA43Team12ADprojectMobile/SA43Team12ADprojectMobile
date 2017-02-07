package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class User implements Parcelable {
    public String UserId ;
    public String Password ;

    public User(String userId, String password) {
        UserId = userId;
        Password = password;
    }

    public User() {
    }

    protected User(Parcel in) {
        UserId = in.readString();
        Password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(UserId);
        dest.writeString(Password);
    }
}

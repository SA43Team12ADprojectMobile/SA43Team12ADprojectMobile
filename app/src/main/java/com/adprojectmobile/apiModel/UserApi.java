package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class UserApi implements Parcelable {
    public String UserId ;
    public String Password ;

    public UserApi(String userId, String password) {
        UserId = userId;
        Password = password;
    }

    public UserApi() {
    }

    protected UserApi(Parcel in) {
        UserId = in.readString();
        Password = in.readString();
    }

    public static final Creator<UserApi> CREATOR = new Creator<UserApi>() {
        @Override
        public UserApi createFromParcel(Parcel in) {
            return new UserApi(in);
        }

        @Override
        public UserApi[] newArray(int size) {
            return new UserApi[size];
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

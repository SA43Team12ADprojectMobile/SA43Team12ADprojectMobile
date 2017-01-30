package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class RequisitionItemApi implements Parcelable{
    public String ItemName ;
    public String Quantity ;

    public RequisitionItemApi() {
    }

    public RequisitionItemApi(String itemName, String quantity) {
        ItemName = itemName;
        Quantity = quantity;
    }

    protected RequisitionItemApi(Parcel in) {
        ItemName = in.readString();
        Quantity = in.readString();
    }

    public static final Creator<RequisitionItemApi> CREATOR = new Creator<RequisitionItemApi>() {
        @Override
        public RequisitionItemApi createFromParcel(Parcel in) {
            return new RequisitionItemApi(in);
        }

        @Override
        public RequisitionItemApi[] newArray(int size) {
            return new RequisitionItemApi[size];
        }
    };

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ItemName);
        dest.writeString(Quantity);
    }
}

package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class AdjustmentItemApi implements Parcelable{
    public String Id ;
    public String PhotoFileName;
    public String Description ;

    public String ReorderLevel;
    public String ReorderQuantity ;
    public String BinNo ;

    public String UnitOfMeasure ;

    public String IsInInventory ;

    public String CategoryID ;

    public String CategoryName ;

    public AdjustmentItemApi() {
    }

    public AdjustmentItemApi(String id, String photoFileName, String description, String reorderLevel, String reorderQuantity, String binNo, String unitOfMeasure, String isInInventory, String categoryID, String categoryName) {
        Id = id;
        PhotoFileName = photoFileName;
        Description = description;
        ReorderLevel = reorderLevel;
        ReorderQuantity = reorderQuantity;
        BinNo = binNo;
        UnitOfMeasure = unitOfMeasure;
        IsInInventory = isInInventory;
        CategoryID = categoryID;
        CategoryName = categoryName;
    }

    protected AdjustmentItemApi(Parcel in) {
        Id = in.readString();
        PhotoFileName = in.readString();
        Description = in.readString();
        ReorderLevel = in.readString();
        ReorderQuantity = in.readString();
        BinNo = in.readString();
        UnitOfMeasure = in.readString();
        IsInInventory = in.readString();
        CategoryID = in.readString();
        CategoryName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(PhotoFileName);
        dest.writeString(Description);
        dest.writeString(ReorderLevel);
        dest.writeString(ReorderQuantity);
        dest.writeString(BinNo);
        dest.writeString(UnitOfMeasure);
        dest.writeString(IsInInventory);
        dest.writeString(CategoryID);
        dest.writeString(CategoryName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AdjustmentItemApi> CREATOR = new Creator<AdjustmentItemApi>() {
        @Override
        public AdjustmentItemApi createFromParcel(Parcel in) {
            return new AdjustmentItemApi(in);
        }

        @Override
        public AdjustmentItemApi[] newArray(int size) {
            return new AdjustmentItemApi[size];
        }
    };

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPhotoFileName() {
        return PhotoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        PhotoFileName = photoFileName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(String reorderLevel) {
        ReorderLevel = reorderLevel;
    }

    public String getReorderQuantity() {
        return ReorderQuantity;
    }

    public void setReorderQuantity(String reorderQuantity) {
        ReorderQuantity = reorderQuantity;
    }

    public String getBinNo() {
        return BinNo;
    }

    public void setBinNo(String binNo) {
        BinNo = binNo;
    }

    public String getUnitOfMeasure() {
        return UnitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        UnitOfMeasure = unitOfMeasure;
    }

    public String getIsInInventory() {
        return IsInInventory;
    }

    public void setIsInInventory(String isInInventory) {
        IsInInventory = isInInventory;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}

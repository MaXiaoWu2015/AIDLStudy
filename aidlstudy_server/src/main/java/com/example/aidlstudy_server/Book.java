package com.example.aidlstudy_server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maxiaowu on 16/7/10.
 */
public class Book implements Parcelable{
    private String name;
    private int id;
    private String category;

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book(String name, int id,String category) {
        this.name = name;
        this.id = id;
        this.category=category;
    }

    private Book(Parcel source) {
        this.id=source.readInt();
        this.name=source.readString();
        this.category=source.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(category);
    }




}

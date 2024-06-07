package com.faradilla.dewikajii;

import android.os.Parcel;
import android.os.Parcelable;


public class CardViewItem implements Parcelable {
    private String judul;
    private String keterangan;
    private String imageUri;

    public CardViewItem(String judul, String keterangan, String imageUri) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.imageUri = imageUri;
    }

    protected CardViewItem(Parcel in) {
        judul = in.readString();
        keterangan = in.readString();
        imageUri = in.readString();
    }

    public static final Creator<CardViewItem> CREATOR = new Creator<CardViewItem>() {
        @Override
        public CardViewItem createFromParcel(Parcel in) {
            return new CardViewItem(in);
        }

        @Override
        public CardViewItem[] newArray(int size) {
            return new CardViewItem[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(keterangan);
        dest.writeString(imageUri);
    }



}


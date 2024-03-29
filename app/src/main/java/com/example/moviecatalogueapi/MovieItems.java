package com.example.moviecatalogueapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

public class MovieItems implements Parcelable {
    private int id;
    private String name, date, score, overview, photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    MovieItems(JSONObject object){
        try {
            int id = object.getInt("id");
            String name = object.getString("title");
            String date = object.getString("release_date");
            String score = object.getString("vote_average");
            String overview = object.getString("overview");
            String photo = object.getString("poster_path");

            this.id = id;
            this.name = name;
            this.date = date;
            this.score = score;
            this.overview = overview;
            this.photo = photo;

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public MovieItems(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(score);
        dest.writeString(overview);
        dest.writeString(photo);
    }

    protected MovieItems(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.date = in.readString();
        this.score = in.readString();
        this.overview = in.readString();
        this.photo = in.readString();
    }

    public static final Creator<MovieItems> CREATOR = new Creator<MovieItems>() {
        @Override
        public MovieItems createFromParcel(Parcel in) {
            return new MovieItems(in);
        }

        @Override
        public MovieItems[] newArray(int size) {
            return new MovieItems[size];
        }
    };
}

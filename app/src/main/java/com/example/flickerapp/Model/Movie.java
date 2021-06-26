package com.example.flickerapp.Model;

import java.util.ArrayList;

public class Movie extends  ItemType {

    String title;
    int year;
    ArrayList<String> cast;
    ArrayList<String> genre;
    int rating;
    Boolean isPictureLoaded = false;

    public  Movie(String loader) {
        this.title = "";
        this.year = 0;
        this.cast = new ArrayList<>();
        this.genre = new ArrayList<>();
        this.rating = 0;
        this.viewType = ItemStates.LOADER;
    }

    public Movie(String title, int year, ArrayList<String> cast, ArrayList<String> genre, int rating) {
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genre = genre;
        this.rating = rating;
        this.viewType = ItemStates.DATA;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public Boolean getPictureLoaded() {
        return isPictureLoaded;
    }

    public void setPictureLoaded(Boolean pictureLoaded) {
        isPictureLoaded = pictureLoaded;
    }
}

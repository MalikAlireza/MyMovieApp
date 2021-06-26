package com.example.flickerapp.Model;

import java.util.ArrayList;

public class Movie {
    String title;
    int year;
    ArrayList<String> cast;
    ArrayList<String> genre;
    int rating;

    public Movie(String title, int year, ArrayList<String> cast, ArrayList<String> genre, int rating) {
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genre = genre;
        this.rating = rating;
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


//    "title": "(500) Days of Summer",
//            "year": 2009,
//            "cast": [
//            "Joseph Gordon-Levitt",
//            "Zooey Deschanel"
//            ],
//            "genres": [
//            "Romance",
//            "Comedy"
//            ],
//            "rating": 1
}

package com.example.flickerapp.Utilities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flickerapp.Model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public AppCompatActivity appCompatActivity;
    public List<Movie> moviesList = new ArrayList<Movie>();

    public FileReader(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public List<Movie> readJSONFileContent() {
        try {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray moviesArray = object.getJSONArray("movies");
            for (int i = 0; i < moviesArray.length(); i++) {
                JSONObject object1 = moviesArray.getJSONObject(i);
                String title = object1.getString("title");
                int year = object1.getInt("year");
                JSONArray castArray = object1.getJSONArray("cast");
                ArrayList castList = new ArrayList<>();
                for (int k = 0; k < castArray.length(); k++) {
                    castList.add(castArray.getString(k));
                }

                JSONArray genresArray = object1.getJSONArray("genres");
                ArrayList genresList = new ArrayList<>();
                for (int k = 0; k < genresArray.length(); k++) {
                    genresList.add(genresArray.getString(k));
                }
                int rating = object1.getInt("rating");
                Movie movie = new Movie(title, year, castList, genresList, rating);
                moviesList.add(movie);
            }

        } catch (JSONException e) {
            LoggerHelper.loggerHelper.printLog(this.getClass(), "Exception while reading the file is as follows" + e.getMessage());
        }

        return moviesList;
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = appCompatActivity.getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            LoggerHelper.loggerHelper.printLog(this.getClass(), "Exception while reading the file is as follows" + ex.getMessage());
            return null;
        }
        return json;
    }


}

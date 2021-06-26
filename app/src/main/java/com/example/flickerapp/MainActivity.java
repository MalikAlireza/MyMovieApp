package com.example.flickerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.flickerapp.Model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> list_movies;
    ArrayList<String> castList;
    ArrayList<String> genresList;
    RecyclerView rv_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_movies = (RecyclerView)findViewById(R.id.recyclerView);


        try {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            Log.d("",""+object);
            JSONArray moviesArray = object.getJSONArray("movies");
            list_movies = new ArrayList<>();
            for(int i = 0; i<moviesArray.length();i++){
                JSONObject object1 = moviesArray.getJSONObject(i);
                String title = object1.getString("title");
                int year = object1.getInt("year");
                JSONArray castArray = object1.getJSONArray("cast");
                castList = new ArrayList<>();
                for(int k=0;k<castArray.length();k++){
                    castList.add(castArray.getString(k));

                }

                JSONArray genresArray = object1.getJSONArray("genres");
                genresList = new ArrayList<>();
                for(int k=0;k<genresArray.length();k++){
                    genresList.add(genresArray.getString(k));

                }
                int rating = object1.getInt("rating");
                Movie movie = new Movie(title,year,castList,genresList,rating);
                list_movies.add(movie);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

Log.d("",""+list_movies);



        MovieAdapter adapter = new MovieAdapter(list_movies);
        rv_movies.setHasFixedSize(true);
       rv_movies.setLayoutManager(new LinearLayoutManager(this));
       // rv_movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        rv_movies.setAdapter(adapter);
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
package com.example.flickerapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.flickerapp.Model.Movie;
import com.example.flickerapp.MovieAdapter;
import com.example.flickerapp.R;
import com.example.flickerapp.Repositry.APICall;
import com.example.flickerapp.Utilities.LoggerHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.flickerapp.Utilities.FileReader;
import com.example.flickerapp.Utilities.Paginator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    List<Movie> list_movies = new ArrayList<Movie>();
    RecyclerView rv_movies;
    FileReader fileReader;
    Paginator  paginator;
    MovieAdapter adapter = new MovieAdapter(list_movies, this);
    Boolean lockOnLoad = false;

    APICall apiCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_movies = (RecyclerView) findViewById(R.id.recyclerView);
        rv_movies.setAdapter(adapter);
        rv_movies.setHasFixedSize(true);
        rv_movies.setLayoutManager(new LinearLayoutManager(this));
        fileReader = new FileReader(this);
        paginator = new Paginator(this.fileReader.readJSONFileContent(),10);
        this.list_movies.addAll(this.paginator.next(0));
        adapter.notifyDataSetChanged();
        this.addListener();

        apiCall=new APICall(this,"car");
    }

     void addListener(){
          this.rv_movies.addOnScrollListener(new RecyclerView.OnScrollListener() {
              @Override
              public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                  super.onScrollStateChanged(recyclerView, newState);

                  if (!recyclerView.canScrollVertically(1)) {
                       LoggerHelper.loggerHelper.printLog(this.getClass(), "Reached to the end");
                       if(!lockOnLoad){
                           lockOnLoad = true;
                           loadMoreItems();
                       }
                  }
              }
          });
     }

     void loadMoreItems(){
         this.list_movies.addAll(this.paginator.next(this.list_movies.size() > 0 ? ( this.list_movies.size() - 1 ) : 0));
         adapter.notifyDataSetChanged();
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                  lockOnLoad = false;
             }
         } , 2000);
     }



}
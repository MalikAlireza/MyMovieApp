package com.example.flickerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flickerapp.Model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private ArrayList<Movie> listdata;

    // RecyclerView recyclerView;
    public MovieAdapter(ArrayList<Movie> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie myListData = listdata.get(position);
        holder.textView_title.setText(myListData.getTitle());
        holder.textView_year.setText(""+myListData.getYear());
        holder.ratingBar.setProgress(myListData.getRating());


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView_title;
        public TextView textView_year;
        AppCompatRatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.movieImage);
            this.textView_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.textView_year = (TextView) itemView.findViewById(R.id.tv_year);
            this.ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.rating);

        }
    }
}

package com.example.flickerapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;
import com.example.flickerapp.Model.Movie;
import com.example.flickerapp.Utilities.LoggerHelper;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public List<Movie> listdata;
    public AppCompatActivity context;


    public MovieAdapter(List<Movie> listdata, AppCompatActivity context) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie myListData = listdata.get(position);
        holder.textView_title.setText(myListData.getTitle());
        holder.textView_year.setText("" + myListData.getYear());
        holder.ratingBar.setProgress(myListData.getRating());
        holder.castsList.removeAllViews();
        for (String castV : myListData.getCast()) {
            View castView = (this.context.getLayoutInflater()).inflate(R.layout.cast_item, null);
            holder.castsList.addView(castView);
            castView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            TextView castName = (TextView) castView.findViewById(R.id.castName);
            castName.setText(castV);
        }

        if (!myListData.getPictureLoaded())
            holder.imageContainer.startShimmer();
        else
            holder.imageContainer.stopShimmer();

    }


    @Override
    public int getItemCount() {
        LoggerHelper.loggerHelper.printLog(this.getClass(), "The count is as follows " + this.listdata.size());
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView_title;
        public TextView textView_year;
        public LinearLayout castsList;
        AppCompatRatingBar ratingBar;
        public ShimmerFrameLayout imageContainer;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.movieImage);
            this.textView_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.textView_year = (TextView) itemView.findViewById(R.id.tv_year);
            this.ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.rating);
            this.castsList = (LinearLayout) itemView.findViewById(R.id.castContainer);
            this.imageContainer = (ShimmerFrameLayout) itemView.findViewById(R.id.moviewImageShimmer);
        }
    }
}

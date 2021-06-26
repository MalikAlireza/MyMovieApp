package com.example.flickerapp.Utilities;

import com.example.flickerapp.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public  class Paginator {

    public List<Movie> mainMoviesList = new ArrayList<Movie>();
    public List<Movie> searchableList = new ArrayList<Movie>();
    private int perPageItems = 10;
    private int totalItems = 0;
    public int totalPages = 0;
    public int currentPage = 0;

    public Paginator(List<Movie> mainMoviesList, int perPageItems) {
        this.mainMoviesList = mainMoviesList;
        this.perPageItems = perPageItems;
        this.currentPage = 0;
        this.totalItems = this.mainMoviesList.size();
        this.totalPages = (int) (this.totalItems / this.perPageItems);
    }

    public Paginator(List<Movie> mainMoviesList, int perPageItems, int totalItems) {
        this.mainMoviesList = mainMoviesList;
        this.perPageItems = perPageItems;
        this.totalItems = totalItems;
        this.totalPages = (int) (this.totalItems / this.perPageItems);
    }

    public Boolean canLoadMore() {
        return currentPage < totalPages;
    }

    public List<Movie> getMoviewsFromIndex(int offset) {
        List<Movie> movies = new ArrayList<Movie>();
        if (offset < this.mainMoviesList.size()) {
            int moreItemsToLoad = (offset + perPageItems);
            if (moreItemsToLoad > this.mainMoviesList.size()) {
                moreItemsToLoad = offset + (this.mainMoviesList.size() - offset);
            }
            for (int i = offset; i < (offset + perPageItems); i++) {
                movies.add(this.mainMoviesList.get(i));
            }
        }
        return movies;
    }

    public List<Movie> next(int currentIndex){
         LoggerHelper.loggerHelper.printLog(getClass(), "Movies size is as follows "+currentIndex);
         List<Movie> movies = new ArrayList<Movie>();
         if(this.canLoadMore()){
             this.currentPage ++;
             movies = this.getMoviewsFromIndex(currentIndex);
         }
         return  movies;
    }

}


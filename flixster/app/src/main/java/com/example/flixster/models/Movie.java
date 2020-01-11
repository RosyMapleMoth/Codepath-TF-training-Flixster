package com.example.flixster.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;

@Parcel
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;
    String basePath = "https://image.tmdb.org/t/p/";

    // this should be grabbed by the API configure and then parsed from poster_ paths sizes
    String bestPosterImageSize = "w342";

    public Movie() {};


    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");

    }

    public static List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++)
        {
            movies.add(new Movie(jsonArray.getJSONObject(i)));
            Log.d("Movies","Added movie : " + movies.get(i).title);
        }
        return movies;
    }

    public String getPosterPath() {
        return basePath + bestPosterImageSize + posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() { return  basePath + bestPosterImageSize + backdropPath; }
}

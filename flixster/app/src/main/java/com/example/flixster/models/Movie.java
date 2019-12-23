package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {


    String posterPath;
    String title;
    String overview;
    final static String basePath = "https://image.tmdb.org/t/p/";

    // this should be grabbed by the API configure and then parsed from poster_ paths sizes
    String bestPosterImageSize = "w342";



    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");

    }

    public static List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Movie> movies= new ArrayList<>();
        for (int i = 0; i < movies.size(); i++)
        {
            movies.add(new Movie(jsonArray.getJSONObject(i)));
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
}

package com.example.flixster.models;

import android.util.Log;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;

import okhttp3.Headers;

@Parcel
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;
    String basePath = "https://image.tmdb.org/t/p/";
    String movieID;
    double voteAverage;
    String MovieQuarry = "https://api.themoviedb.org/3/movie/%s/videos?api_key=%s";
    String youTubeId = "";
    static final String TAG = "Movie Object";


    // this should be grabbed by the API configure and then parsed from poster_ paths sizes
    String bestPosterImageSize = "w342";

    public Movie() {};


    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        voteAverage = jsonObject.getDouble("vote_average");
        movieID = Integer.toString(jsonObject.getInt("id"));

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

    public String getId() { return movieID; }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() { return voteAverage; }

    public String getYouTubeId() { return youTubeId; }

    public String getBackdropPath() { return  basePath + bestPosterImageSize + backdropPath; }
}

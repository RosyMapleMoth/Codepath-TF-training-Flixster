package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import okhttp3.Headers;

public class MovieTrailerActivity extends YouTubeBaseActivity {

    String MovieQuarry = "https://api.themoviedb.org/3/movie/%s/videos?api_key=%s";
    Movie movie;
    static final String TAG = "MovieTrailerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_trailer);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(MovieQuarry, movie.getId(), getResources().getString(R.string.MovieDbKey )), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess : " + String.format(MovieQuarry, movie.getId(), getResources().getString(R.string.MovieDbKey )));
                JSONObject jsonObject = json.jsonObject;
                final String videoId;
                try
                {
                    JSONArray results = jsonObject.getJSONArray("results");
                    if (results.length() <= 0)
                    {
                        videoId = "DH3ItsuvtQg";
                        Log.i(TAG, "No trailers listed on MovieDB");
                    }
                    else if (results.getJSONObject(0).getString("site").equals("YouTube"))
                    {
                        videoId = results.getJSONObject(0).getString("key");
                        Log.i(TAG, "youtube trailer found");

                    }
                    else
                    {
                        videoId = "DH3ItsuvtQg";
                        Log.i(TAG, "Trailer not found at first video in Json");
                    }

                    // resolve the player view from the layout
                    YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.player);

                    // initialize with API key stored in secrets.xml
                    playerView.initialize(getString(R.string.YoutubeKey), new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {
                            // do any work here to cue video, play video, etc.

                            final String vidIdFinal = videoId;

                            youTubePlayer.cueVideo(vidIdFinal);
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                            // log the error
                            Log.e("MovieTrailerActivity", "Error initializing YouTube player");
                        }
                    });


                }
                catch (JSONException e)
                {
                    Log.e(TAG, "JsonArray exception", e);
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "HTTP connection refused : " + String.format(MovieQuarry, movie.getId(), getResources().getString(R.string.YoutubeKey )));
            }
        });
    }
}
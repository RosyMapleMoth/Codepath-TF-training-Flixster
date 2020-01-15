package com.example.flixster;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.databinding.DataBindingUtil;
        import androidx.databinding.ViewDataBinding;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;
        import com.codepath.asynchttpclient.AsyncHttpClient;
        import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
        import com.example.flixster.databinding.ActivityMovieDetailsBinding;
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

        import static com.facebook.stetho.inspector.network.ResponseHandlingInputStream.TAG;

public class MovieDetailsActivity extends YouTubeBaseActivity {


    public static final String TAG = "MovieDetailsActivity";
    Movie movie;
    TextView tvTitle, tvOverview;
    RatingBar rbVoteAverage;
    ImageView ivBackDrop;
    private ActivityMovieDetailsBinding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Starting Detail activity for '%s'", movie.getTitle()));


        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

        tvTitle = binding.tvTitle;
        tvOverview = binding.tvOverview;
        rbVoteAverage = binding.rbVoteAverage;
        ivBackDrop = binding.ivBackdrop;

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        Glide.with(this).load(movie.getBackdropPath("w1280")).placeholder(R.drawable.ic_placeholder_foreground).into(ivBackDrop);


        ivBackDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetailsActivity.this, MovieTrailerActivity.class);

                intent.putExtra(Movie.class.getSimpleName(), Parcels.wrap(movie));

                MovieDetailsActivity.this.startActivity(intent);
            }
        });

        float votingAvg = ((float) movie.getVoteAverage());

        rbVoteAverage.setRating(votingAvg = votingAvg > 0 ? votingAvg / 2.0f : votingAvg);


    }



}

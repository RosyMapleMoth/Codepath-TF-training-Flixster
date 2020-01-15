package com.example.flixster.adaptors;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixster.MainActivity;
import com.example.flixster.MovieDetailsActivity;
import com.example.flixster.MovieTrailerActivity;
import com.example.flixster.PopularMovieDetailsActivity;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.parceler.Parcels;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.ViewHolder>
{

    Context context;
    List<Movie> movies;



    public MovieAdaptor(Context context, List<Movie> movies, Activity a)
    {
        this.context = context;
        this.movies = movies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Log.d("Movie adaptor", "onBind");
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView tvTitle;
        TextView tvDiscription;
        ImageView ivPoster;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDiscription = itemView.findViewById(R.id.tvDiscription);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            itemView.setOnClickListener(this);
        }

        public void bind(Movie movie)
        {
            tvTitle.setText(movie.getTitle());
            tvDiscription.setText(movie.getOverview());
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                Glide.with(context).load(movie.getBackdropPath()).placeholder(R.drawable.ic_placeholder_foreground).override(350, 342).centerCrop().transform(new RoundedCornersTransformation(30 , 10)).into(ivPoster);

            }
            else
            {
                Glide.with(context).load(movie.getPosterPath()).placeholder(R.drawable.ic_placeholder_foreground).override(120, 342).centerCrop().transform(new RoundedCornersTransformation(30 , 10)).into(ivPoster);

            }
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION)
            {


                Movie movie = movies.get(position);

                if (movie.getVoteAverage() >= 8)
                {
                    Intent intent = new Intent(context, PopularMovieDetailsActivity.class);

                    intent.putExtra(Movie.class.getSimpleName(), Parcels.wrap(movie));

                    context.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(context, MovieDetailsActivity.class);

                    intent.putExtra(Movie.class.getSimpleName(), Parcels.wrap(movie));

                    context.startActivity(intent);
                }
            }
        }
    }


}

package com.example.flixster.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.ViewHolder>
{

    Context context;
    List<Movie> movies;

    public MovieAdaptor(Context context, List<Movie> movies)
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
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView tvTitle;
        TextView tvDiscription;
        ImageView ivPoster;



        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDiscription = itemView.findViewById(R.id.tvDiscription);
            tvTitle = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie)
        {
            tvTitle.setText(movie.getTitle());
            tvDiscription.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    }


}

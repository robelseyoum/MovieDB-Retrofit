package com.robelseyoum3.getpopularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robelseyoum3.getpopularmovies.model.MovieDBModel;
import com.robelseyoum3.getpopularmovies.model.Result;
import com.squareup.picasso.Picasso;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.MovieViewHolder> {

    private MovieDBModel movieDBModel;
    private onMovieClickListener listener;


    public MovieAdaptor(MovieDBModel movieDBModel, onMovieClickListener listener) {
        this.movieDBModel = movieDBModel;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_layout,parent,false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

       /// Result popularMovie = movieDBModel.getResults().get(position);
        // getResults().get(position).getTitle());
      //holder.tvTitle.setText(popularMovie.getTitle());

        holder.bind(movieDBModel, listener);

        holder.tvTitle.setText(movieDBModel.getResults().get(position).getTitle());
        holder.tvOverview.setText(movieDBModel.getResults().get(position).getOverview());
        holder.ratingBar.setRating(movieDBModel.getResults().get(position).getVoteAverage().floatValue());

        Picasso.get().load("https://image.tmdb.org/t/p/w185"+movieDBModel.getResults().get(position).getPosterPath()).into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return movieDBModel.getResults().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvOverview;
        private ImageView coverImage;
        private RatingBar ratingBar;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvOverview = itemView.findViewById(R.id.tv_overview);
            this.coverImage = itemView.findViewById(R.id.tv_image);
            this.ratingBar = itemView.findViewById(R.id.rb_vote);
        }

        public void bind(final MovieDBModel movieID, final onMovieClickListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMovieClicked(movieID.getResults().get(getAdapterPosition()).getId());
                }
            });

        }
    }

    public interface onMovieClickListener {

        void onMovieClicked(int movieID); //this send the click info to the acitivity

    }

}

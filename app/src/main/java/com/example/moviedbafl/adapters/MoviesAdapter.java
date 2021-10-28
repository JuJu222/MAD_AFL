package com.example.moviedbafl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedbafl.R;
import com.example.moviedbafl.helpers.Const;
import com.example.moviedbafl.models.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    Context context;
    private List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList;

    public void setNowPlayingUpcomingList(List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList) {
        this.nowPlayingUpcomingList = nowPlayingUpcomingList;
    }

    public MoviesAdapter(Context context, List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList) {
        this.context = context;
        this.nowPlayingUpcomingList = nowPlayingUpcomingList;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent, false);
        return new MoviesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movie.NowPlayingUpcoming.Results result = nowPlayingUpcomingList.get(position);
        holder.cardNowPlayingTitleTextView.setText(result.getTitle());
        holder.cardNowPlayingOverviewTextView.setText(result.getOverview());
        holder.cardNowPlayingReleaseDateTextView.setText(result.getRelease_date().substring(0, 4));
        Glide.with(context).load(Const.IMG_URL + result.getPoster_path()).into(holder.cardNowPlayingImageView);
        Glide.with(context).load(Const.IMG_URL + result.getBackdrop_path()).into(holder.cardNowPlayingBackgroundImageView);
    }

    @Override
    public int getItemCount() {
        return nowPlayingUpcomingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardNowPlayingImageView;
        ImageView cardNowPlayingBackgroundImageView;
        TextView cardNowPlayingTitleTextView;
        TextView cardNowPlayingOverviewTextView;
        TextView cardNowPlayingReleaseDateTextView;
        CardView nowPlayingCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardNowPlayingImageView = itemView.findViewById(R.id.cardNowPlayingImageView);
            cardNowPlayingBackgroundImageView = itemView.findViewById(R.id.cardNowPlayingBackgroundImageView);
            cardNowPlayingTitleTextView = itemView.findViewById(R.id.cardNowPlayingTitleTextView);
            cardNowPlayingOverviewTextView = itemView.findViewById(R.id.cardNowPlayingOverviewTextView);
            cardNowPlayingReleaseDateTextView = itemView.findViewById(R.id.cardNowPlayingReleaseDateTextView);
            nowPlayingCardView = itemView.findViewById(R.id.nowPlayingCardView);
        }
    }
}

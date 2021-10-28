package com.example.moviedbafl.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedbafl.R;
import com.example.moviedbafl.helpers.Const;
import com.example.moviedbafl.models.Movie;

import java.util.List;

public class RecommendationsAdapter extends RecyclerView.Adapter<RecommendationsAdapter.ViewHolder> {
    Context context;
    private List<Movie.Recommendations.Results> recommendationsList;

    public RecommendationsAdapter(Context context, List<Movie.Recommendations.Results> recommendationsList) {
        this.context = context;
        this.recommendationsList = recommendationsList;
    }

    @NonNull
    @Override
    public RecommendationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent, false);
        return new RecommendationsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationsAdapter.ViewHolder holder, int position) {
        Movie.Recommendations.Results result = recommendationsList.get(position);
        holder.cardNowPlayingTitleTextView.setText(result.getTitle());
        holder.cardNowPlayingOverviewTextView.setText(result.getOverview());
        holder.cardNowPlayingReleaseDateTextView.setText(result.getRelease_date().substring(0, 4));
        Glide.with(context).load(Const.IMG_URL + result.getPoster_path()).into(holder.cardNowPlayingImageView);
        Glide.with(context).load(Const.IMG_URL + result.getBackdrop_path()).into(holder.cardNowPlayingBackgroundImageView);

        holder.nowPlayingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("movieId", result.getId());
                Navigation.findNavController(view).navigate(R.id.action_movieDetailsFragment_self, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommendationsList.size();
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

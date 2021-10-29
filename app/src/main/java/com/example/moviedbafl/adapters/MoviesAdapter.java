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

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = 2;
    private boolean isLoading = false;
    Context context;
    private List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList;
    String headerText;

    public void setNowPlayingUpcomingList(List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList) {
        this.nowPlayingUpcomingList = nowPlayingUpcomingList;
    }

    public MoviesAdapter(Context context, List<Movie.NowPlayingUpcoming.Results> nowPlayingUpcomingList, String headerText) {
        this.context = context;
        this.nowPlayingUpcomingList = nowPlayingUpcomingList;
        this.headerText = headerText;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent, false);
            return new ViewHolderItem(view);
        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_now_playing, parent, false);
            return new MoviesAdapter.ViewHolderHeader(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_progress_bar, parent, false);
            return new MoviesAdapter.ViewHolderFooter(view);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderItem) {
            ViewHolderItem viewHolder = (ViewHolderItem) holder;
            Movie.NowPlayingUpcoming.Results result = nowPlayingUpcomingList.get(position - 1);
            viewHolder.cardNowPlayingTitleTextView.setText(result.getTitle());
            viewHolder.cardNowPlayingOverviewTextView.setText(result.getOverview());
            viewHolder.cardNowPlayingReleaseDateTextView.setText(result.getRelease_date().substring(0, 4));
            Glide.with(context).load(Const.IMG_URL + result.getPoster_path()).into(viewHolder.cardNowPlayingImageView);
            Glide.with(context).load(Const.IMG_URL + result.getBackdrop_path()).into(viewHolder.cardNowPlayingBackgroundImageView);
        } else if (holder instanceof ViewHolderHeader) {
            ViewHolderHeader viewHolder = (ViewHolderHeader) holder;
            viewHolder.headerNowPlayingTextView.setText(headerText);
        }
    }

    @Override
    public int getItemCount() {
        if (!isLoading) {
            return nowPlayingUpcomingList.size() + 1;
        }
        return nowPlayingUpcomingList.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
         }else if(position == nowPlayingUpcomingList.size() + 1) {
            return TYPE_FOOTER;
        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void setIsLoading(boolean isLoading){
        this.isLoading = isLoading;
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {
        ImageView cardNowPlayingImageView;
        ImageView cardNowPlayingBackgroundImageView;
        TextView cardNowPlayingTitleTextView;
        TextView cardNowPlayingOverviewTextView;
        TextView cardNowPlayingReleaseDateTextView;
        CardView nowPlayingCardView;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);

            cardNowPlayingImageView = itemView.findViewById(R.id.cardNowPlayingImageView);
            cardNowPlayingBackgroundImageView = itemView.findViewById(R.id.cardNowPlayingBackgroundImageView);
            cardNowPlayingTitleTextView = itemView.findViewById(R.id.cardNowPlayingTitleTextView);
            cardNowPlayingOverviewTextView = itemView.findViewById(R.id.cardNowPlayingOverviewTextView);
            cardNowPlayingReleaseDateTextView = itemView.findViewById(R.id.cardNowPlayingReleaseDateTextView);
            nowPlayingCardView = itemView.findViewById(R.id.nowPlayingCardView);
        }
    }

    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        TextView headerNowPlayingTextView;

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);

            headerNowPlayingTextView = itemView.findViewById(R.id.headerNowPlayingTextView);
        }

        public void setHeaderText(String text){
            headerNowPlayingTextView.setText(text);
        }
    }

    public class ViewHolderFooter extends RecyclerView.ViewHolder {

        public ViewHolderFooter(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.moviedbafl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedbafl.R;
import com.example.moviedbafl.helpers.Const;
import com.example.moviedbafl.models.Movie;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.ViewHolder> {
    Context context;
    private List<Movie.Credits.Crew> crewList;

    public CrewAdapter(Context context, List<Movie.Credits.Crew> crewList) {
        this.context = context;
        this.crewList = crewList;
    }

    @NonNull
    @Override
    public CrewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_crew, parent, false);
        return new CrewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewAdapter.ViewHolder holder, int position) {
        Movie.Credits.Crew crew = crewList.get(position);
        if (crew.getProfile_path() != null) {
            Glide.with(context).load(Const.IMG_URL + crew.getProfile_path()).into(holder.cardCrewImageView);
        }
        holder.cardCrewNameTextView.setText(crew.getName());
        holder.cardCrewJobTextView.setText(crew.getJob());
        holder.cardCrewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, crew.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardCrewImageView;
        TextView cardCrewNameTextView;
        TextView cardCrewJobTextView;
        CardView cardCrewCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardCrewImageView = itemView.findViewById(R.id.cardCrewImageView);
            cardCrewNameTextView = itemView.findViewById(R.id.cardCrewNameTextView);
            cardCrewJobTextView = itemView.findViewById(R.id.cardCrewJobTextView);
            cardCrewCardView = itemView.findViewById(R.id.cardCrewCardView);
        }
    }
}

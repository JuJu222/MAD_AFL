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

public class CastsAdapter extends RecyclerView.Adapter<CastsAdapter.ViewHolder> {
    Context context;
    private List<Movie.Credits.Cast> castList;

    public CastsAdapter(Context context, List<Movie.Credits.Cast> castList) {
        this.context = context;
        this.castList = castList;
    }

    @NonNull
    @Override
    public CastsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cast, parent, false);
        return new CastsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastsAdapter.ViewHolder holder, int position) {
        Movie.Credits.Cast cast = castList.get(position);
        if (cast.getProfile_path() != null) {
            Glide.with(context).load(Const.IMG_URL + cast.getProfile_path()).into(holder.cardCastImageView);
        }
        holder.cardCastNameTextView.setText(cast.getName());
        holder.cardCastCharacterTextView.setText(cast.getCharacter());
        holder.cardCastCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, cast.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardCastImageView;
        TextView cardCastNameTextView;
        TextView cardCastCharacterTextView;
        CardView cardCastCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardCastImageView = itemView.findViewById(R.id.cardCastImageView);
            cardCastNameTextView = itemView.findViewById(R.id.cardCastNameTextView);
            cardCastCharacterTextView = itemView.findViewById(R.id.cardCastCharacterTextView);
            cardCastCardView = itemView.findViewById(R.id.cardCastCardView);
        }
    }
}

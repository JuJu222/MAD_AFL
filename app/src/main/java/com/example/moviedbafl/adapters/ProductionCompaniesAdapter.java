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

public class ProductionCompaniesAdapter extends RecyclerView.Adapter<ProductionCompaniesAdapter.ViewHolder> {
    Context context;
    private List<Movie.Details.ProductionCompanies> productionCompaniesList;

    public ProductionCompaniesAdapter(Context context, List<Movie.Details.ProductionCompanies> productionCompaniesList) {
        this.context = context;
        this.productionCompaniesList = productionCompaniesList;
    }

    @NonNull
    @Override
    public ProductionCompaniesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_production_company, parent, false);
        return new ProductionCompaniesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionCompaniesAdapter.ViewHolder holder, int position) {
        Movie.Details.ProductionCompanies productionCompany = productionCompaniesList.get(position);
        if (productionCompany.getLogo_path() != null) {
            Glide.with(context).load(Const.IMG_URL + productionCompany.getLogo_path()).into(holder.cardProductionCompanyImageView);
        }
        holder.cardProductionCompanyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, productionCompany.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productionCompaniesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardProductionCompanyImageView;
        CardView cardProductionCompanyCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardProductionCompanyImageView = itemView.findViewById(R.id.cardProductionCompanyImageView);
            cardProductionCompanyCardView = itemView.findViewById(R.id.cardProductionCompanyCardView);
        }
    }
}

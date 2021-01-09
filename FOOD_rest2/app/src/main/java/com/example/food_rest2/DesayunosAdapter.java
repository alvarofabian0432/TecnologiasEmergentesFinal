package com.example.food_rest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_rest2.model.Platillo;

import java.util.List;

public class DesayunosAdapter extends RecyclerView.Adapter<DesayunosAdapter.PopularViewHolder> {


    private Context context;
    private List<Platillo> desayunosList;

    public DesayunosAdapter(Context context, List<Platillo> desayunosList) {
        this.context = context;
        this.desayunosList = desayunosList;
    }

    @NonNull
    @Override
    public DesayunosAdapter.PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.desayuno_recycler_items, parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesayunosAdapter.PopularViewHolder holder, int position) {

        holder.desayunoName.setText(desayunosList.get(position).getNombre());
        Glide.with(context).load(desayunosList.get(position)).into(holder.desayunoImage);

    }

    @Override
    public int getItemCount() {
        return desayunosList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder{
        
        ImageView desayunoImage;
        TextView desayunoName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            desayunoName = itemView.findViewById(R.id.desayunos_name);
            desayunoImage = itemView.findViewById(R.id.desayuno_image);
        }
    }
}

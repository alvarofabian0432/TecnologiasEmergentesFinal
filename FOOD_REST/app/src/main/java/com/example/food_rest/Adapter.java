package com.example.food_rest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Plato> platos;

    public Adapter(Context ctx, List<Plato> platos){
        this.inflater = LayoutInflater.from(ctx);
        this.platos = platos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.platoNombre.setText(platos.get(position).getNombre());
        holder.platoDescripcion.setText(platos.get(position).getDescripcion());
        String precioDou = Double.toString(platos.get(position).getPrecio());
        holder.platoPrecio.setText(precioDou);
        Picasso.get().load(platos.get(position).getFotoURL()).into(holder.platoImage);

    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView platoNombre, platoDescripcion, platoPrecio;
        ImageView platoImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            platoNombre=itemView.findViewById(R.id.post_nombre);
            platoDescripcion=itemView.findViewById(R.id.post_descripcion);
            platoPrecio=itemView.findViewById(R.id.post_precio);
            platoImage=itemView.findViewById(R.id.post_Image);
        }
    }
}

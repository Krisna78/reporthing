package com.example.belajar_intent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptercard extends RecyclerView.Adapter<Adaptercard.ViewHolder> {

    Context context;
    private ArrayList<cardmodel> Cardmodel;

    public Adaptercard(Context context, ArrayList<cardmodel> cardmodel) {
        this.context = context;
        this.Cardmodel = cardmodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(Cardmodel.get(position).getNamanama());
        holder.imageView.setImageResource(Cardmodel.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return Cardmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textnama);
            imageView = itemView.findViewById(R.id.logo);
        }
    }
}

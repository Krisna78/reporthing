package com.example.reporthing.Students;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;

import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.HolderData> {
    List<String> listdata;
    LayoutInflater inflater;
    public SemesterAdapter(Context context,List<String> listdata) {
        this.listdata = listdata;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_list_semester,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        public HolderData(@NonNull View itemView) {
            super(itemView);
        }
    }
}

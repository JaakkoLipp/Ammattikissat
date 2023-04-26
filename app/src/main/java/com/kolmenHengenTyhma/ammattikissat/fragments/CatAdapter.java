package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.R;

import java.util.HashMap;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder>{
    private HashMap<Integer, Cat> catStorageList;


    public CatAdapter(HashMap<Integer, Cat> catStorageList) {

        this.catStorageList = catStorageList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                                                        // TODO: cat_view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_view, parent, false);
        return new CatViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        holder.currHP.setVisibility(View.VISIBLE);
                //(cat.currHP/cat.MaxHP)*100
        holder.currHP.setProgress(50);
        holder.catTypeText.setText("Temp Test");
    }

    @Override
    public int getItemCount() {
        return catStorageList.size();
    }
}

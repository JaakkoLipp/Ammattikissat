package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmenHengenTyhma.ammattikissat.R;


public class CatViewHolder extends RecyclerView.ViewHolder {
    ProgressBar currHP;
    TextView catTypeText;
    ImageView catPic;
    public CatViewHolder(@NonNull View cat_View) {
        super(cat_View);
        catPic = cat_View.findViewById(R.id.catPic);
        catTypeText = cat_View.findViewById(R.id.catTypeText);
        currHP = cat_View.findViewById(R.id.currHPBar);
    }
}

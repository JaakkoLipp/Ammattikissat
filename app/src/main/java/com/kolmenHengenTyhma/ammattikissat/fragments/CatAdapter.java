package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmenHengenTyhma.ammattikissat.CarMan;
import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.ElectricianMan;
import com.kolmenHengenTyhma.ammattikissat.LogisticsMan;
import com.kolmenHengenTyhma.ammattikissat.PipeMan;
import com.kolmenHengenTyhma.ammattikissat.ProfessionalSchool;
import com.kolmenHengenTyhma.ammattikissat.R;
import com.kolmenHengenTyhma.ammattikissat.RaksaMan;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder>{
    private ArrayList<Cat> catStorageList;
    private int selectedItemPosition = RecyclerView.NO_POSITION;

    public CatAdapter(ArrayList<Cat> catStorageList) {
        this.catStorageList = catStorageList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_view, parent, false);
        return new CatViewHolder(view);
    }
    public void updateList(ArrayList<Cat> catList){
        this.catStorageList = catList;
    }
    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        if (position == selectedItemPosition) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.selection));
        } else {
            holder.itemView.setBackgroundColor(Color.rgb(56, 58, 64));
        }
        holder.currHP.setVisibility(View.VISIBLE);
        holder.currHP.setProgress(catStorageList.get(position).getCurrHPinPercentage());
        System.out.println(catStorageList.get(position).getCurrHPinPercentage());
        String Type="";
        // if replacer
        Type = catStorageList.get(position).getName();
        holder.catPic.setImageResource(catStorageList.get(position).getCatPic());

        holder.catTypeText.setText(Type);
        holder.colourText.setText(catStorageList.get(position).getColour());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previousSelectedItemPosition = selectedItemPosition;
                selectedItemPosition = holder.getAdapterPosition();
                notifyItemChanged(previousSelectedItemPosition);
                notifyItemChanged(selectedItemPosition);
                int position = holder.getAdapterPosition();
                Cat clickedCat = catStorageList.get(position);
                String message;
                message = "Valittu Kissa: "+catStorageList.get(position).getName();;
                Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
                ProfessionalSchool.getInstance().setSelectedCatPos(selectedItemPosition);
                System.out.println(ProfessionalSchool.getInstance().getSelectedCatPos());
            }
        });
    }
    @Override
    public int getItemCount() {
        return catStorageList.size();
    }
}

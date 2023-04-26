package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kolmenHengenTyhma.ammattikissat.CarMan;
import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.ElectricianMan;
import com.kolmenHengenTyhma.ammattikissat.LogisticsMan;
import com.kolmenHengenTyhma.ammattikissat.PipeMan;
import com.kolmenHengenTyhma.ammattikissat.R;
import com.kolmenHengenTyhma.ammattikissat.RaksaMan;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder>{
    private ArrayList<Cat> catStorageList;


    public CatAdapter(ArrayList<Cat> catStorageList) {
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
        holder.currHP.setProgress(catStorageList.get(position).getCurrHPinPercentage());
        System.out.println(catStorageList.get(position).getCurrHPinPercentage());
        String Type="";
        // idk i guess this works
        if (catStorageList.get(position) instanceof ElectricianMan){
            Type = "Sähkökissa";
            holder.catPic.setImageResource(R.drawable.sahkissa_nobg);
        } else if (catStorageList.get(position) instanceof PipeMan) {
            Type = "LVI-kissa";
            holder.catPic.setImageResource(R.drawable.putkissa_nobg);
        } else if (catStorageList.get(position) instanceof CarMan) {
            Type = "Autokissa";
            holder.catPic.setImageResource(R.drawable.autokissa_nobg);
        } else if (catStorageList.get(position) instanceof LogisticsMan) {
            Type = "Logistiikkakissa";
            holder.catPic.setImageResource(R.drawable.logiskissa_nobg);
        } else if (catStorageList.get(position) instanceof RaksaMan) {
            Type = "Raksakissa";
            holder.catPic.setImageResource(R.drawable.raksakissa_nobg);
        } else {
            Type = "TöiKissa";
        }
        holder.catTypeText.setText(Type);
        holder.colourText.setText(catStorageList.get(position).getColour());

    }

    @Override
    public int getItemCount() {
        return catStorageList.size();
    }
}

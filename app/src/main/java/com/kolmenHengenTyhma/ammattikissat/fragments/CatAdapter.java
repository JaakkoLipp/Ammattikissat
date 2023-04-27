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
                                                                        // TODO: cat_view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_view, parent, false);
        return new CatViewHolder(view);
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
                // idk bro it is what it is
                if (catStorageList.get(position) instanceof ElectricianMan){
                    message = "Valittu Kissa: Sähkökissa";
                } else if (catStorageList.get(position) instanceof PipeMan) {
                    message = "Valittu Kissa: LVI-Kissa";
                } else if (catStorageList.get(position) instanceof CarMan) {
                    message = "Valittu Kissa: Autokissa";
                } else if (catStorageList.get(position) instanceof LogisticsMan) {
                    message = "Valittu Kissa: Logistiikkakissa";
                } else if (catStorageList.get(position) instanceof RaksaMan) {
                    message = "Valittu Kissa: Raksakissa";
                } else {
                    message = "Valittu Kissa: TöiKissa";
                }
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

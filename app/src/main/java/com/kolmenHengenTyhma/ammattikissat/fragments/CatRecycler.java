package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.ProfessionalSchool;
import com.kolmenHengenTyhma.ammattikissat.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatRecycler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatRecycler extends Fragment {
    private RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Cat> CatList;
    private int prevListLenght;
    private CatAdapter CatAdapt;
    private Context context;
    public CatRecycler() {
        // Required empty public constructor
    }
    //Onresume resolves unupdating recycler
    @Override
    public void onResume() {

        super.onResume();
        // Update the contents of the fragment's views or data here
        CatAdapt.notifyItemChanged(ProfessionalSchool.getInstance().getSelectedCatPos());
        // new cat -> refresh recycler, data:
        HashMap<Integer, Cat> catStorageList = ProfessionalSchool.getInstance().getCatStorageList();
        CatList = new ArrayList<Cat>(catStorageList.values());
        System.out.println(CatList);
        //logic
        if(ProfessionalSchool.getInstance().getCatListLen() > prevListLenght){
            CatAdapt.updateList(CatList);
            CatAdapt.notifyItemInserted(CatList.size()-1);
            prevListLenght =ProfessionalSchool.getInstance().getCatListLen();
        }
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CatRecycler.
     */
    // TODO: Rename and change types and number of parameters
    public static CatRecycler newInstance(String param1, String param2) {
        CatRecycler fragment = new CatRecycler();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat_recycler, container, false);
        recyclerView = view.findViewById(R.id.CatRecyclerView);
        prevListLenght = ProfessionalSchool.getInstance().getCatListLen();
        HashMap<Integer, Cat> catStorageList = ProfessionalSchool.getInstance().getCatStorageList();
        CatList = new ArrayList<Cat>(catStorageList.values());
        CatAdapt = new CatAdapter(CatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(CatAdapt);
        context = getActivity().getApplicationContext();
        // issue of skill spölves
        ProfessionalSchool.getInstance().loadCats(context);
        return view;
    }
}
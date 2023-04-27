package com.kolmenHengenTyhma.ammattikissat.fragments;

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

    public CatRecycler() {
        // Required empty public constructor
    }
    //Onresume resolves unupdating recycler?
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
        //TODO: Pass Hashmap to fragment then pass to view holder then to adapter
        HashMap<Integer, Cat> catStorageList = ProfessionalSchool.getInstance().getCatStorageList();
        CatList = new ArrayList<Cat>(catStorageList.values());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CatAdapter(CatList));
        return view;
    }
}
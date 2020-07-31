package com.example.beonight;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Klubovi extends Fragment {
    View v;
    private RecyclerView myrecycleview;
    private List<Pregled> listPregled;
    public Klubovi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v  =  inflater.inflate(R.layout.fragment_klubovi, container, false);

        myrecycleview = (RecyclerView)v.findViewById(R.id.recycleViewPregledi);
        RecycleViewAdpater recycleViewAdpater = new RecycleViewAdpater(getContext(),listPregled);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recycleViewAdpater);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPregled = PregledApi.getKlubovi();
    }
}

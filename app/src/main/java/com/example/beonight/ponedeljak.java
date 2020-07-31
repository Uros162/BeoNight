package com.example.beonight;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ponedeljak extends Fragment {
    View v;
    private RecyclerView myrecycleview;
    private List<Pregled> listPregled;
    public ponedeljak() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v =  inflater.inflate(R.layout.fragment_ponedeljak, container, false);

        RecyclerView myrecycleview = (RecyclerView)v.findViewById(R.id.recycleViewPregledi);
        RecycleViewAdpater recycleViewAdpater = new RecycleViewAdpater(getContext(),listPregled);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recycleViewAdpater);




        return v;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPregled = PregledApi.getPregledListPonedeljak();


    }
}

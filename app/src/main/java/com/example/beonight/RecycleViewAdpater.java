package com.example.beonight;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdpater extends RecyclerView.Adapter<RecycleViewAdpater.MyViewHolder> {

    Context myContext;
    List<Pregled> pregledi;

    public RecycleViewAdpater(Context myContext, List<Pregled> pregledi) {
        this.myContext = myContext;
        this.pregledi = pregledi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(myContext).inflate(R.layout.pregledview,parent,false);
        MyViewHolder  vHolder = new MyViewHolder(v);
        return  vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ime.setText(pregledi.get(position).getIme());
        holder.radnoVreme.setText(pregledi.get(position).getRadnoVreme());
        holder.slika.setImageResource(pregledi.get(position).getSlika());

    }

    @Override
    public int getItemCount() {
        return pregledi.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView ime;
        private TextView radnoVreme;
        private ImageView slika;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ime = (TextView) itemView.findViewById(R.id.IdPregled);
            radnoVreme = (TextView) itemView.findViewById(R.id.radnoVremeId);
            slika = (ImageView) itemView.findViewById(R.id.pregledID);

        }
    }
}

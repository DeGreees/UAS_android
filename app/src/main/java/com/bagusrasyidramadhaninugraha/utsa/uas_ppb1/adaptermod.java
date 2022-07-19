package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class adaptermod extends RecyclerView.Adapter<adaptermod.ViewHolder> {

    private ArrayList<String> fotomod = new ArrayList<>();
    private ArrayList<String> NamaMod = new ArrayList<>();
    private ArrayList<String> HargaMod = new ArrayList<>();
    private Context context;

    public adaptermod(ArrayList<String> fotomod, ArrayList<String> namaMod, ArrayList<String> hargaMod, Context context) {
        this.fotomod = fotomod;
        NamaMod = namaMod;
        HargaMod = hargaMod;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowmods, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(fotomod.get(position)).into(holder.imageViewGbrMod);

        holder.textViewMainTitle.setText(NamaMod.get(position));
        holder.textViewSubTitle.setText(HargaMod.get(position));
        holder.imageViewGbrMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), hexohm.class);
                v.getContext().startActivity(i);
            }
        });

    }
    

    @Override
    public int getItemCount() {
        return NamaMod.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageViewGbrMod;
        TextView textViewMainTitle, textViewSubTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewGbrMod = itemView.findViewById(R.id.gbrmod);
            textViewMainTitle = itemView.findViewById(R.id.rawtitlemod);
            textViewSubTitle = itemView.findViewById(R.id.rawsubmods);
        }
    }
}

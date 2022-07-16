package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import android.content.Context;
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
    private Context context;

    public adaptermod(ArrayList<String> fotomod, ArrayList<String> namaMod, Context context) {
        this.fotomod = fotomod;
        NamaMod = namaMod;
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
        }
    }
}

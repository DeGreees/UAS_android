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

public class adapterliquid extends RecyclerView.Adapter<adapterliquid.ViewHolder> {

    private ArrayList<String> fotoliquid = new ArrayList<>();
    private ArrayList<String> namaliquid = new ArrayList<>();
    private Context context;

    public adapterliquid(ArrayList<String> fotoliquid, ArrayList<String> namaLiquid, Context context) {
        this.fotoliquid = fotoliquid;
        namaliquid = namaLiquid;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowliquid, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(fotoliquid.get(position)).into(holder.imageViewGbrLiquid);

        holder.textViewMainTitle.setText(namaliquid.get(position));
    }

    @Override
    public int getItemCount() {
        return namaliquid.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageViewGbrLiquid;
        TextView textViewMainTitle, textViewSubTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewGbrLiquid = itemView.findViewById(R.id.gbrliquid);
            textViewMainTitle = itemView.findViewById(R.id.rawtitleliquid);
        }
    }
}

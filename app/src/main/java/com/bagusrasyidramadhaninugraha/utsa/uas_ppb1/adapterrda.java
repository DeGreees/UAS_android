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

public class adapterrda extends RecyclerView.Adapter<adapterrda.ViewHolder> {

    private ArrayList<String> fotorda = new ArrayList<>();
    private ArrayList<String> namarda = new ArrayList<>();
    private ArrayList<String> hargarda = new ArrayList<>();
    private Context context;

    public adapterrda(ArrayList<String> fotorda, ArrayList<String> namaRda, ArrayList<String> hargaRda, Context context) {
        this.fotorda = fotorda;
        namarda = namaRda;
        hargarda = hargaRda;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowrda, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(fotorda.get(position)).into(holder.imageViewGbrRda);

        holder.textViewMainTitle.setText(namarda.get(position));
        holder.textViewSubTitle.setText(hargarda.get(position));
        holder.imageViewGbrRda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), reload.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namarda.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageViewGbrRda;
        TextView textViewMainTitle, textViewSubTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewGbrRda = itemView.findViewById(R.id.gbrrda);
            textViewMainTitle = itemView.findViewById(R.id.rawtitlerda);
            textViewSubTitle = itemView.findViewById(R.id.rawsubrda);
        }
    }
}

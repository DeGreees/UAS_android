package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class rda extends AppCompatActivity {

    private ArrayList<String> gambarrda = new ArrayList<>();
    private ArrayList<String> namarda = new ArrayList<>();
    private ArrayList<String> hargarda = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rda);
        getDataFromDataRda();

    }
    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.listrda);
        adapterrda adapter = new adapterrda(gambarrda, namarda,hargarda, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromDataRda(){
        gambarrda.add("data:image/jpeg;base64,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");
        namarda.add("RELOAD");
        hargarda.add("Rp 900.000");

        gambarrda.add("data:image/jpeg;base64,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");
        namarda.add("ALEXA");
        hargarda.add("Rp 450.000");

        gambarrda.add("https://cf.shopee.co.id/file/ff6634998ac87033f09367fef83309ae");
        namarda.add("HELLEBAST");
        hargarda.add("Rp 380.000");

        gambarrda.add("https://versedvaper.com/wp-content/uploads/2022/05/Damnvape-Nitrous-RDA-500x500-1.png");
        namarda.add("NITROUS");
        hargarda.add("Rp 370.000");

        gambarrda.add("https://cf.shopee.co.id/file/2478def188df1542762bb7b67c048ece");
        namarda.add("ZEUS");
        hargarda.add("Rp 500.000");


        prosesRecyclerViewAdapter();
    }
}
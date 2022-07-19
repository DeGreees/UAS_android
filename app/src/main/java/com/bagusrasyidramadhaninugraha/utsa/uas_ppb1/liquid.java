package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import android.os.Bundle;

public class liquid extends AppCompatActivity {
    private ArrayList<String> gambarliquid = new ArrayList<>();
    private ArrayList<String> namaliquid = new ArrayList<>();
    private ArrayList<String> hargaliquid = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid);
        getDataFromDataLiquid();
    }
    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.listliquid);
        adapterliquid adapter = new adapterliquid(gambarliquid, namaliquid, hargaliquid, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getDataFromDataLiquid(){
        gambarliquid.add("https://images.tokopedia.net/img/cache/500-square/VqbcmM/2020/11/19/767aaecb-1e03-4b14-ab9c-b366d3325137.png");
        namaliquid.add("ATHENA");
        hargaliquid.add("160.000");

        gambarliquid.add("https://images.tokopedia.net/img/cache/500-square/product-1/2020/8/13/18523401/18523401_5f97a1e8-1c5d-443f-949c-7747f3c0d4c3_700_700");
        namaliquid.add("FREYA");
        hargaliquid.add("180.000");

        gambarliquid.add("https://images.tokopedia.net/img/cache/500-square/product-1/2020/4/8/batch-upload/batch-upload_c8bd2adf-bdd1-44a4-8867-f4d5ccb6f506");
        namaliquid.add("LAKLEY");
        hargaliquid.add("175.000");

        gambarliquid.add("https://images.tokopedia.net/img/cache/700/product-1/2020/4/22/89163823/89163823_edaff491-7048-4306-a5be-117cdca251a6_500_500");
        namaliquid.add("LUNA");
        hargaliquid.add("180.000");

        gambarliquid.add("https://s1.bukalapak.com/img/15846164692/large/data.jpeg.webp");
        namaliquid.add("MINUS TWO");
        hargaliquid.add("125.000");


        prosesRecyclerViewAdapter();
    }
}
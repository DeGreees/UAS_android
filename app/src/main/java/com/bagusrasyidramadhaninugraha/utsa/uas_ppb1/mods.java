package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class mods extends AppCompatActivity {

    private ArrayList<String> gambarmod = new ArrayList<>();
    private ArrayList<String> namamod = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mods);

        getDataFromDataMod();

    }
    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.listmod);
        adaptermod adapter = new adaptermod(gambarmod, namamod, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromDataMod(){
        gambarmod.add("https://inkuiri.net/o/large/https%2Fs1.bukalapak.com%2Fimg%2F69250711501%2Flarge%2F164575674_797c638c_b995_4995_a700_4792b2445c0f_700_700292450.png");
        namamod.add("HEXOHM V3");

        gambarmod.add("https://www.augvape.com/wp-content/uploads/2019/10/augvape_druga_foxy_150w_box_mod_side.webp_.jpg");
        namamod.add("DRUGA FOXY");

        gambarmod.add("https://images.tokopedia.net/img/cache/500-square/hDjmkQ/2020/7/23/f2e6fce2-fc0d-43f3-ad6c-2ad469608563.jpg");
        namamod.add("PANDA");

        gambarmod.add("https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/5/19/f15a0025-b962-4572-a8bb-d6cbc5616a81.jpg");
        namamod.add("R234");

        gambarmod.add("https://images.tokopedia.net/img/cache/500-square/VqbcmM/2021/12/10/16ae0123-6b07-4778-b759-cb7cf8f73a59.jpg");
        namamod.add("THELEMA");


        prosesRecyclerViewAdapter();
    }
}
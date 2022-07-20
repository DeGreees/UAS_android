package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class freya extends AppCompatActivity {
    Button button;
    EditText editnama, editalamat, editbarang, editpesanliquid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freya);
        editnama = findViewById(R.id.namplgliquid2);
        editalamat = findViewById(R.id.alamatplgliquid2);
        editbarang = findViewById(R.id.jmlbrgliquid2);
        editpesanliquid1 = findViewById(R.id.editpesanliquid2);
        button = findViewById(R.id.btnkirimliquid2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesan = editnama.getText().toString();
                String pesan2 = editalamat.getText().toString();
                String pesan3 = editbarang.getText().toString();
                String pesan4 = editpesanliquid1.getText().toString();
                String semuapesan = "Nama: " + pesan + "\n" + "Alamat: " + pesan2 + "\n"
                      +  "Barang: " + pesan3 + "\n" + "Pesan Kepada Penjual: " + pesan4;
                Intent kirimwa = new Intent(Intent.ACTION_SEND);
                kirimwa.setType("text/plain");
                kirimwa.putExtra(Intent.EXTRA_TEXT, semuapesan);
                kirimwa.putExtra("jid", "6282141988172" + "@a.whatsapp.net");
                kirimwa.setPackage("com.whatsapp");
                startActivity(kirimwa);
            }
        });

    }
}
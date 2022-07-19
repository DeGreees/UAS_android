package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class reload extends AppCompatActivity {
    Button button;
    EditText editnama, editalamat, editbarang, editpesanrda1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reload);
        editnama = findViewById(R.id.namplgrda1);
        editalamat = findViewById(R.id.alamatplgrda1);
        editbarang = findViewById(R.id.jmlbrgrda1);
        editpesanrda1 = findViewById(R.id.editpesanrda1);

        button = findViewById(R.id.btnkirimrda1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesan = editnama.getText().toString();
                String pesan2 = editalamat.getText().toString();
                String pesan3 = editbarang.getText().toString();
                String pesan4 = editpesanrda1.getText().toString();

                String semuapesan = "Nama: " + pesan + "\n" + "Alamat: " + pesan2 + "\n"
                      +  "Barang: " + pesan3 + "\n" + "Pesan Kepada Penjual: " + pesan4;
                Intent kirimwa = new Intent(Intent.ACTION_SEND);
                kirimwa.setType("text/plain");
                kirimwa.putExtra(Intent.EXTRA_TEXT, semuapesan);


                kirimwa.putExtra("jid", "082141988172" + "@a.whatsapp.net");
                kirimwa.setPackage("com.whatsapp");
                startActivity(kirimwa);
            }
        });
    }
}
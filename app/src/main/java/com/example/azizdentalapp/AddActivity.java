package com.example.azizdentalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText edNama, edUmur, edTelepon, edKeluhan;
    Button btn_simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edNama = findViewById(R.id.edNama);
        edUmur = findViewById(R.id.edUmur);
        edTelepon = findViewById(R.id.edTelepon);
        edKeluhan = findViewById(R.id.edKeluhan);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = edNama.getText().toString();
                String getUmur = edUmur.getText().toString();
                String getTelepon = edTelepon.getText().toString();
                String getKeluhan = edKeluhan.getText().toString();

                if (getNama.isEmpty()) {
                    edNama.setError("Nama Tidak boleh kosong");
                } else if (getUmur.isEmpty()) {
                    edUmur.setError("Umur Tidak boleh kosong");
                } else if (getTelepon.isEmpty()) {
                    edTelepon.setError("Telepon Tidak boleh kosong");
                } else if (getKeluhan.isEmpty()) {
                    edKeluhan.setError("Keluhan belum diisi");
                } else {
                    database.child("pasien").push().setValue(new ModelPasien(getNama, getUmur, getTelepon, getKeluhan)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(AddActivity.this, "Data berhasil disimpan !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddActivity.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddActivity.this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
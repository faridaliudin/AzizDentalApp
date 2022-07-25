package com.example.azizdentalapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {

    String nama, umur, telepon, keluhan, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogForm(String nama, String umur, String telepon, String keluhan, String key, String pilih) {
        this.nama = nama;
        this.umur = umur;
        this.telepon = telepon;
        this.keluhan = keluhan;
        this.key = key;
        this.pilih = pilih;
    }
    TextView tnama, tumur,ttelepon, tkeluhan;
    Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_add, container, false);
        tnama = view.findViewById(R.id.edNama);
        tumur = view.findViewById(R.id.edUmur);
        ttelepon = view.findViewById(R.id.edTelepon);
        tkeluhan = view.findViewById(R.id.edKeluhan);
        btn_simpan = view.findViewById(R.id.btn_simpan);

        tnama.setText(nama);
        tumur.setText(umur);
        ttelepon.setText(telepon);
        tkeluhan.setText(keluhan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = tnama.getText().toString();
                String aumur = tumur.getText().toString();
                String atelepon = ttelepon.getText().toString();
                String akeluhan = tkeluhan.getText().toString();
                if (pilih.equals("Ubah")) {
                    database.child("pasien").child(key).setValue(new ModelPasien(nama, aumur, atelepon, akeluhan)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Berhasil di Update", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Gagal mengupdate data!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}

package com.example.azizdentalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView cardBlog, cardAdd;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardBlog = (CardView) findViewById(R.id.cardBlog);
        cardAdd = (CardView) findViewById(R.id.cardAdd);

        cardBlog.setOnClickListener(this);
        cardAdd.setOnClickListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null){
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        }
//    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.cardBlog:
                i = new Intent(this, BlogActivity.class);
                startActivity(i);
                break;

            case R.id.cardAdd:
                i = new Intent(this, AddActivity.class);
                startActivity(i);
                break;
        }

    }

//    Button btnLogOut, btnForm;
//    FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnLogOut = findViewById(R.id.btnLogout);
//        btnForm = findViewById(R.id.btnForm);
//        mAuth = FirebaseAuth.getInstance();
//
//        btnLogOut.setOnClickListener(view ->{
//            mAuth.signOut();
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        });
//
//        btnForm.setOnClickListener(view ->{
//            startActivity(new Intent(MainActivity.this, HomeActivity.class));
//        });
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null){
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        }
//    }
}
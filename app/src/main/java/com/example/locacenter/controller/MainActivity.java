package com.example.locacenter.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.locacenter.R;
import com.example.locacenter.controller.exibir.Exibir;
import com.example.locacenter.model.BancoController;
import com.example.locacenter.model.DAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciaActivityExibir(View v){
        Intent myIntent = new Intent(this, Exibir.class);
        startActivity(myIntent);


    }


}
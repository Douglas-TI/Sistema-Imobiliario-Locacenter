package com.example.locacenter.controller.exibir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.locacenter.R;
import com.example.locacenter.model.BancoController;
import com.example.locacenter.model.DAO;

import java.util.ArrayList;
import java.util.List;

public class Exibir extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        populaBotoesScrollViewCasa();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populaBotoesScrollViewCasa();
    }

    public void populaBotoesScrollViewCasa(){
        LinearLayout ll = findViewById(R.id.llCasas);
        ll.removeAllViews();
        BancoController bancoController = new BancoController(getBaseContext());
        List<Casa> casa = new ArrayList<>();
        casa = bancoController.selectTabelaCasa();

        int i = 0;
        do {

            String rua = casa.get(i).getRua();
            int numero = casa.get(i).getNumero();
            int cep = casa.get(i).getCep();
            String hidrometro = casa.get(i).getHidrometro();
            String matricula = casa.get(i).getMatricula();

            criaBotoesScrollViewCasa(rua, "a");

            i++;

        } while (i < casa.size());
    }

    public void adicionar(View v){
        Intent myIntent = new Intent(this, AddCasaOuInquelino.class);
        startActivity(myIntent);
    }

    public void criaBotoesScrollViewCasa(String rua, String hidrometro){
        Button myButton = new Button(this);
        myButton.setText(rua);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("teste", "OK!!!");
            }
        });

        LinearLayout ll = findViewById(R.id.llCasas);
        LinearLayout.LayoutParams lp =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
    }
}
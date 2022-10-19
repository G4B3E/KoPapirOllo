package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView KepEmber,KepGep;
    private TextView Eredmeny;
    private int Emberpont, Geppont;
    private int ember;
    private Button ButtonKo,ButtonPapir,ButtonOllo;
    private AlertDialog.Builder builderjatekVege;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ButtonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KepEmber.setImageResource(R.drawable.rock);
                ember = 0;
                GepRandom();
            }
        });
        ButtonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KepEmber.setImageResource(R.drawable.paper);
                ember = 1;
                GepRandom();
            }
        });
        ButtonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KepEmber.setImageResource(R.drawable.scissors);
                ember = 2;
                GepRandom();
            }
        });

    }
    private void init(){
        KepEmber = findViewById(R.id.KepEmber);
        KepGep = findViewById(R.id.KepGep);
        Eredmeny = findViewById(R.id.Eredmeny);
        ButtonKo = findViewById(R.id.ButtonKo);
        ButtonPapir = findViewById(R.id.ButtonPapir);
        ButtonOllo = findViewById(R.id.ButtonOllo);
        Emberpont = 0;
        Geppont = 0;


        builderjatekVege = new AlertDialog.Builder(MainActivity.this);
        builderjatekVege.setCancelable(false)
                .setTitle("Nyert / Vesztett")
                .setMessage("Szeretne e új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Emberpont = 0;
                        Geppont = 0;
                        Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
                    }
                })
                .create();

    }
    private void GepRandom(){
        final int random = new Random().nextInt(3);

        switch (random){
            case 0:
                KepGep.setImageResource(R.drawable.rock);
                break;
            case 1:
                KepGep.setImageResource(R.drawable.paper);
                break;
            case 2:
                KepGep.setImageResource(R.drawable.scissors);
                break;
        }
        if ((ember == 0) && (random == 1)){
            Geppont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        else if ((ember == 1) && (random == 0)){
            Emberpont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        else if ((ember == 1) && (random == 2)){
            Geppont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        else if ((ember == 2) && (random == 1)){
            Emberpont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        else if ((ember == 0) && (random == 2)){
            Emberpont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        else if ((ember == 2) && (random == 0)){
            Geppont++;
            Eredmeny.setText("Eredmeny:Ember " + Emberpont + " Gep:" + Geppont);
        }
        if (Emberpont == 3) {
            builderjatekVege.setTitle("Nyertél").create();
            builderjatekVege.show();
        } else if (Geppont ==3) {
            builderjatekVege.setTitle("Vesztettél").create();
            builderjatekVege.show();
        }

    }

}




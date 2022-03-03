package com.teste.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressCircle, progressReta;
    private int carregar = 0;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressCircle = findViewById(R.id.progressCircle);
        progressReta = findViewById(R.id.progressReta);
        progressCircle.setVisibility(View.GONE);


    }

    public  void carrega (){

        carregar = this.carregar + 1 ;
        progressReta.setProgress(carregar);
        progressCircle.setVisibility(View.VISIBLE);
        if (this.carregar == 10){
            progressCircle.setVisibility(View.GONE);
        }

    }

    public void alert (View view){

        //instanciando
        AlertDialog.Builder dialog = new AlertDialog.Builder(this );

        dialog.setTitle("APP CLONACARTÂO");
        dialog.setMessage("Deseja instalar?");

        // Açoes

        dialog.setPositiveButton(
                "Sim", new  DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Executando", Toast.LENGTH_SHORT).show();
                        carrega();

                    }


                }

        );

        dialog.setNegativeButton(
                "Não", new  DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Não foi possivel executar", Toast.LENGTH_SHORT).show();
                    }
                }

        );



        dialog.create();
        dialog.show();



    }
}
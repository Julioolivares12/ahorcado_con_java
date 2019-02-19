package com.example.lab3.myapplication;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables de button, edittext textview
    private EditText  edtletra,edtE,edtT,edtP,edtS,edt1;
    private TextView tvahorcado;

    //variables para juego
    String frase="ETPS1";
    int cantFallos=0;
    String ahorcado="";
    int aciertos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtletra = findViewById(R.id.edtletra);
        edtE = findViewById(R.id.edtE);
        edtT = findViewById(R.id.edtT);
        edtP = findViewById(R.id.edtP);
        edtS = findViewById(R.id.edtS);
        edt1 = findViewById(R.id.edt1);

        tvahorcado = findViewById(R.id.tvhaorcado);

        Button btnvalidar = findViewById(R.id.btnvalidar);

        btnvalidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letra = edtletra.getText().toString().trim();
                //este if utiliza el metodo y segun lo que retorne ejecutara las siguientes instrucciones
                Log.d("variable",letra);
                boolean existe = validar(letra);

                if (existe){
                    Toast.makeText(MainActivity.this,"encontrada",Toast.LENGTH_SHORT).show();
                    Log.d("validar ",String.valueOf(validar(letra)));
                    if (letra.equals("E") || letra.equals("e")){
                        edtE.setText("E");
                        edtletra.setText("");
                        aciertos +=1;
                    }else if (letra.equals("T") || letra.equals("t")){
                        edtT.setText("T");
                        edtletra.setText("");
                        aciertos +=1;
                    }else if (letra.equals("P")|| letra.equals("p")){
                        edtP.setText("P");
                        edtletra.setText("");
                        aciertos +=1;
                    }else if (letra.equals("S")|| letra.equals("s")){
                        edtS.setText("S");
                        edtletra.setText("");
                        aciertos +=1;
                    }
                    else if (letra.equals("1")){
                        edt1.setText("1");
                        edtletra.setText("");
                        aciertos +=1;
                    }
                   /*
                   *  switch (letra){
                        case "E":
                            edtE.setText("E");
                            edtletra.setText("");
                            aciertos +=1;
                            break;
                        case "T":
                            edtT.setText("T");
                            edtletra.setText("");
                            aciertos +=1;
                            break;
                        case "P":
                            edtP.setText("P");
                            edtletra.setText("");
                            aciertos +=1;
                            break;
                        case "S":
                            edtS.setText("S");
                            edtletra.setText("");
                            aciertos +=1;
                            break;
                        case "1":
                            edt1.setText("1");
                            edtletra.setText("");
                            aciertos +=1;
                            break;
                    }*/
                }
                else {
                    cantFallos +=1;
                    switch (cantFallos){
                        case 1:
                            ahorcado = "a";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 2:
                            ahorcado = ahorcado+"h";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 3:
                            ahorcado = ahorcado + "o";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 4:
                            ahorcado= ahorcado +"r";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 5:
                            ahorcado = ahorcado+"c";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 6:
                            ahorcado = ahorcado+"a";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 7:
                            ahorcado = ahorcado+"d";
                            tvahorcado.setText(ahorcado);
                            break;
                        case 8:
                            ahorcado= ahorcado+"o";
                            tvahorcado.setText(ahorcado);
                            break;
                    }
                }
                if (cantFallos == 8){
                    Toast.makeText(MainActivity.this,"perdiste",Toast.LENGTH_SHORT).show();


                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("quieres jugar otra vez?")
                            .setTitle("Perdiste")
                            .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    cantFallos =0;
                                    aciertos =0;
                                    tvahorcado.setText("jugango");
                                    edtletra.setText(" ");
                                    edtE.setText("");
                                    edtT.setText("");
                                    edtP.setText("");
                                    edtS.setText("");
                                    edt1.setText("");
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.exit(0);
                                }
                            });
                    edtletra.setText(" ");
                }else if(aciertos==5){
                    Toast.makeText(getApplicationContext(),"Felicidades Ganaste",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setIcon(R.drawable.ic_launcher_background)
                            .setTitle("Ganaste")
                            .setMessage("quieres jugar otra vez?")
                            .setPositiveButton("si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    cantFallos =0;
                                    aciertos =0;
                                    tvahorcado.setText("jugango");
                                    edtletra.setText(" ");
                                    edtE.setText("");
                                    edtT.setText("");
                                    edtP.setText("");
                                    edtS.setText("");
                                    edt1.setText("");
                                }
                            }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    });
                    AlertDialog dialog =builder.create();
                    dialog.show();
                }
                edtletra.setText(" ");
            }
        });
    }
    public boolean validar(String v){
        //verifica si la letra ingresada esta en la palabra secreta
        return frase.contains(v);
    }
}

package br.com.javacomcafe.mediaescolar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnPrimeiroBimestre;
    Button btnSegundoBimestre;
    Button btnTerceiroBimestre;
    Button btnQuartoBimestre;
    Button btnResultadoFinal;
    EditText editMateria;




    boolean primeiroBimestre,
            segundoBimestre,
            terceiroBimestre,
            quartoBimestre;

    String situacaoAtualPrimeiroBimestre;
    String materiaPrimeiroBimestre;
    double notaProvaPrimeiroBimestre;
    double notaTrabalhoPrimeiroBimestre;
    double mediaPrimeiroBimestre;

    String situacaoAtualSegundoBimestre;
    String materiaSegundoBimestre;
    double notaProvaSegundoBimestre;
    double notaTrabalhoSegundoBimestre;
    double mediaSegundoBimestre;

    String situacaoAtualTerceiroBimestre;
    String materiaTerceiroBimestre;
    double notaProvaTerceiroBimestre;
    double notaTrabalhoTerceiroBimestre;
    double mediaTerceiroBimestre;

    String situacaoAtualQuartoBimestre;
    String materiaQuartoBimestre;
    double notaProvaQuartoBimestre;
    double notaTrabalhoQuartoBimestre;
    double mediaQuartoBimestre;

double mediaFinal;



public static final String NOME_SHARED_PREFER="mediaEscolarPref";


@Override
public void onResume(){

    super.onResume();

lerSharedPreferences();
visualizarResultado();



}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPrimeiroBimestre = findViewById(R.id.btnPrimeiroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnResultadoFinal = findViewById(R.id.btnResultadoFinal);
        editMateria = findViewById(R.id.editMateria);

        clearSharedPreferences();


        btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this,PrimeiroBimestreActivity.class);

                startActivity(proximaTela);

            }
        });


        btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this,SegundoBimestreActivity.class);

                startActivity(proximaTela);

            }
        });



        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent proximaTela = new Intent(MainActivity.this,TerceiroBimestreActivity.class);

                startActivity(proximaTela);


            }
        });



        btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent proximaTela = new Intent(MainActivity.this,QuartoBimestreActivity.class);

                startActivity(proximaTela);


            }
        });


        btnResultadoFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Resultado", Toast.LENGTH_SHORT).show();



            }
        });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Limpando dados", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                clearSharedPreferences();
            }
        });



        visualizarResultado();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void lerSharedPreferences(){


        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER,0);

        primeiroBimestre = mediaEscolarPref.getBoolean("primeiroBimestre", false);
        situacaoAtualPrimeiroBimestre = mediaEscolarPref.getString("txtSituacaoFinal","");
       materiaPrimeiroBimestre = mediaEscolarPref.getString("materia","");
       mediaPrimeiroBimestre = Double.parseDouble(mediaEscolarPref.getString("media", "0.0"));
        notaProvaPrimeiroBimestre = Double.parseDouble(mediaEscolarPref.getString("notaProva","0.0"));
        notaTrabalhoPrimeiroBimestre = Double.parseDouble(mediaEscolarPref.getString("notaTrabalho", "0.0"));


        segundoBimestre = mediaEscolarPref.getBoolean("segundoBimestre", false);
        situacaoAtualSegundoBimestre = mediaEscolarPref.getString("txtSituacaoFinal","");
        materiaSegundoBimestre = mediaEscolarPref.getString("materia","");
        mediaSegundoBimestre = Double.parseDouble(mediaEscolarPref.getString("media", "0.0"));
        notaProvaSegundoBimestre = Double.parseDouble(mediaEscolarPref.getString("notaProva","0.0"));
        notaTrabalhoSegundoBimestre = Double.parseDouble(mediaEscolarPref.getString("notaTrabalho", "0.0"));


        terceiroBimestre = mediaEscolarPref.getBoolean("terceiroBimestre", false);
        situacaoAtualTerceiroBimestre = mediaEscolarPref.getString("txtSituacaoFinal","");
        materiaTerceiroBimestre = mediaEscolarPref.getString("materia","");
        mediaTerceiroBimestre = Double.parseDouble(mediaEscolarPref.getString("media", "0.0"));
        notaProvaTerceiroBimestre = Double.parseDouble(mediaEscolarPref.getString("notaProva","0.0"));
        notaTrabalhoTerceiroBimestre = Double.parseDouble(mediaEscolarPref.getString("notaTrabalho", "0.0"));



        quartoBimestre = mediaEscolarPref.getBoolean("quartoBimestre", false);
        situacaoAtualQuartoBimestre = mediaEscolarPref.getString("txtSituacaoFinal","");
        materiaQuartoBimestre = mediaEscolarPref.getString("materia","");
        mediaQuartoBimestre = Double.parseDouble(mediaEscolarPref.getString("media", "0.0"));
        notaProvaQuartoBimestre = Double.parseDouble(mediaEscolarPref.getString("notaProva","0.0"));
        notaTrabalhoQuartoBimestre = Double.parseDouble(mediaEscolarPref.getString("notaTrabalho", "0.0"));
    }



    public void visualizarResultado(){


    if (primeiroBimestre){

        btnPrimeiroBimestre.setText(materiaPrimeiroBimestre + " - 1º Bimestre - " + situacaoAtualPrimeiroBimestre + " " + mediaPrimeiroBimestre);
        btnPrimeiroBimestre.setEnabled(false);
        btnSegundoBimestre.setEnabled(true);

    }


        if (segundoBimestre){

            btnSegundoBimestre.setText(materiaSegundoBimestre + " - 2º Bimestre - " + situacaoAtualSegundoBimestre + " " + mediaSegundoBimestre);
            btnSegundoBimestre.setEnabled(false);
            btnTerceiroBimestre.setEnabled(true);

        }



        if (terceiroBimestre){

            btnTerceiroBimestre.setText(materiaTerceiroBimestre + " - 3º Bimestre - " + situacaoAtualTerceiroBimestre + " " + mediaTerceiroBimestre);
            btnTerceiroBimestre.setEnabled(false);
            btnQuartoBimestre.setEnabled(true);

        }


        if (quartoBimestre){

            btnQuartoBimestre.setText(materiaQuartoBimestre + " - 4º Bimestre - " + situacaoAtualQuartoBimestre + " " + mediaQuartoBimestre);
            btnQuartoBimestre.setEnabled(false);
            btnResultadoFinal.setEnabled(true);

            mediaFinal = 0;

            mediaFinal += mediaPrimeiroBimestre;
            mediaFinal += mediaSegundoBimestre;
            mediaFinal += mediaTerceiroBimestre;
            mediaFinal += mediaQuartoBimestre;

            mediaFinal = mediaFinal / 4;

            String mensagemFinal ="";

            if ((mediaPrimeiroBimestre >= 7)
                    && (mediaSegundoBimestre >= 7)
                    && (mediaTerceiroBimestre >=7)
                    && (mediaQuartoBimestre >= 7)){

                mensagemFinal = mediaFinal >=7 ? "Aprovado com nota Final" + mediaFinal :
                        "Reprovado com nota Final" + mediaFinal;

            }else
            {

                mensagemFinal = "Reprovado por matéria com Media Final " + mediaFinal;
            }


            btnResultadoFinal.setText(mensagemFinal);

        }


    }

    public void clearSharedPreferences(){

    SharedPreferences mediaEscolarPref = getSharedPreferences(MainActivity.NOME_SHARED_PREFER,0);

    SharedPreferences.Editor editor = mediaEscolarPref.edit();
    editor.clear();
    editor.commit();
    clearMenu();


    }


    public void clearMenu(){

    btnPrimeiroBimestre.setEnabled(true);
    btnSegundoBimestre.setEnabled(false);
    btnTerceiroBimestre.setEnabled(false);
    btnQuartoBimestre.setEnabled(false);
    btnResultadoFinal.setEnabled(false);

    btnPrimeiroBimestre.setText("1º Bimestre");
    btnSegundoBimestre.setText("2º Bimestre");
    btnTerceiroBimestre.setText("3º Bimestre");
    btnQuartoBimestre.setText("4º Bimestre");
    btnResultadoFinal.setText("Resultado Final");


    }



}

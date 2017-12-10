package koldur.losversados;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

import koldur.losversados.dao.DAOContent;
import koldur.losversados.dao.DAO_Factory;

public class HighActivity extends AppCompatActivity {
    private HashMap<Integer,String> listaRet = new HashMap<Integer,String>();
    private HashMap<Integer,String> listaVer = new HashMap<Integer,String>();
    Button verdad, ret;
    TextView title, descr, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        leerArchivoRetHigh();
        leerArchivoVerdHigh();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        verdad = (Button)findViewById(R.id.Verdad);
        ret = (Button)findViewById(R.id.Reto);
        title = (TextView)findViewById(R.id.Title);
        descr = (TextView)findViewById(R.id.Descrip);
        id = (TextView)findViewById(R.id.identificador);

        ret.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(listaRet.size());
                title.setText("RETO");
                descr.setText(listaRet.get(randomNumber));
                id.setText(Integer.toString(randomNumber));

                title.refreshDrawableState();
                descr.refreshDrawableState();
                id.refreshDrawableState();
            }
        });
        verdad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(listaVer.size());
                title.setText("VERDAD");
                descr.setText(listaVer.get(randomNumber));
                id.setText(Integer.toString(randomNumber));

                title.refreshDrawableState();
                descr.refreshDrawableState();
                id.refreshDrawableState();
            }
        });
    }

    private void leerArchivoRetHigh(){

        SharedPreferences sh = getSharedPreferences(getString(R.string.DA_COnfiguration_file), Context.MODE_PRIVATE);
        Boolean ext = sh.getBoolean("rhighexpl",false);

        DAOContent dao = DAO_Factory.getInstance();
        listaRet = dao.getHighDare(this.getResources(), ext);

    }
    private void leerArchivoVerdHigh(){
        DAOContent dao = DAO_Factory.getInstance();
        listaVer = dao.getHighTruth(this.getResources());
    }

}

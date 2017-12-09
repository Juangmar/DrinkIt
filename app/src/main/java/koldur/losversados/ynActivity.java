package koldur.losversados;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Juan on 07/04/2017.
 */

public class ynActivity extends AppCompatActivity {

    private HashMap<Integer,String> lista = new HashMap<Integer,String>();

    Button siguiente;
    TextView title, descr, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        leerArchivoYN();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yn);

        siguiente = (Button)findViewById(R.id.siguiente);
        descr = (TextView)findViewById(R.id.DescripYN);
        id = (TextView)findViewById(R.id.identificadorYN);

        siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(lista.size());
                descr.setText(lista.get(randomNumber));
                id.setText(Integer.toString(randomNumber));

                descr.refreshDrawableState();
                id.refreshDrawableState();
            }
        });
    }

    private void leerArchivoYN(){

        DAOContent dao = DAO_Factory.getInstance();
        lista = dao.getAllYoNunca(this.getResources());
    }

    public String btoString( InputStream inputStream ) throws IOException
    {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ( (len=inputStream.read(bytes))>0 )
        {
            b.write(bytes,0,len);
        }
        return new String( b.toByteArray(),"UTF8");
    }
}

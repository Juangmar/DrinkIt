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

public class LowActivity extends AppCompatActivity {
    private HashMap<Integer,String> listaRet = new HashMap<Integer,String>();
    private HashMap<Integer,String> listaVer = new HashMap<Integer,String>();
    Button verdad, ret;
    TextView title, descr, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        leerArchivoRetHigh(listaRet);
        leerArchivoVerdHigh(listaVer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low);

        verdad = (Button)findViewById(R.id.VerdadLow);
        ret = (Button)findViewById(R.id.RetoLow);
        title = (TextView)findViewById(R.id.TitleLow);
        descr = (TextView)findViewById(R.id.DescripLow);
        id = (TextView)findViewById(R.id.identificadorLow);

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

    private void leerArchivoRetHigh(HashMap lista){

        InputStream inputStream = null;
        String text;
        String[] lines;
        try{
            inputStream = this.getResources().openRawResource(R.raw.retlowfile);
            text = btoString(inputStream);
            lines = text.split("\n");
            for (int i = 0; i < lines.length; i++){
                String linea[] = lines[i].split(";");
                lista.put(i,linea[2]);
            }
        }catch (IOException e){
            // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
        } finally{
            try{
                inputStream.close();
            }catch(IOException e){
                // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
            }
        }
    }
    private void leerArchivoVerdHigh(HashMap lista){

        InputStream inputStream = null;
        String text;
        String[] lines;
        try{
            inputStream = this.getResources().openRawResource(R.raw.verdlowfile);
            text = btoString(inputStream);
            lines = text.split("\n");
            for (int i = 0; i < lines.length; i++){
                String linea[] = lines[i].split(";");
                lista.put(i,linea[2]);
            }
        }catch (IOException e){
            // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
        } finally{
            try{
                inputStream.close();
            }catch(IOException e){
                // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
            }
        }
    }
    public String btoString( InputStream inputStream ) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0) {
            b.write(bytes, 0, len);
        }
        return new String(b.toByteArray(), "UTF8");
    }
}
